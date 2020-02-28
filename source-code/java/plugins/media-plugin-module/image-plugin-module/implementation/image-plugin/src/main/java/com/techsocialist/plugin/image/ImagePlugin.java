package com.techsocialist.plugin.image;

import com.techsocialist.plugin.image.api.IImagePlugin;
import com.techsocialist.plugin.image.api.ImageFormat;
import com.techsocialist.plugin.image.api.ImageType;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.Kernel;
import java.awt.image.PixelGrabber;
import java.awt.image.RGBImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ImagePlugin implements IImagePlugin {

    private File imageFile;

    private byte[] toByteArray(InputStream inputStream) throws IOException {
        BufferedImage originalImage = ImageIO.read(inputStream);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, ImageFormat.PNG.toString().toLowerCase(), baos);
        baos.flush();
        byte[] imageAsBytes = baos.toByteArray();
        baos.close();
        return imageAsBytes;
    }

    private BufferedImage toBufferedImage(byte[] imageAsBytes) throws IOException {
        return ImageIO.read(new ByteArrayInputStream(imageAsBytes));
    }

    private byte[] toByteArray(File file) throws IOException {
        return this.toByteArray(new FileInputStream(file));
    }

    @Override
    public File saveImage(ImageType imageType, BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, ImageFormat.PNG.toString().toLowerCase(), baos);
        baos.flush();
        byte[] byteArray = baos.toByteArray();
        baos.close();
        File tempFile = File.createTempFile(String.format("%s-", imageType.toString().toLowerCase()), null, null);
        FileUtils.writeByteArrayToFile(tempFile, byteArray);

        return tempFile;
    }

    @Override
    public IImagePlugin setImage(String filePath) {
        this.setImage(new File(filePath));
        return this;
    }

    @Override
    public IImagePlugin setImage(URL url) {
        this.setImage(url.getFile());
        return this;
    }

    @Override
    public IImagePlugin setImage(File file) {
        this.imageFile = file;
        return this;
    }

    @Override
    public BufferedImage createThumbnail() throws IOException {
        BufferedImage originalBufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));
        int thumbnailWidth = 150;
        int widthToScale = 0;
        int heightToScale = 0;
        if (originalBufferedImage.getWidth() > originalBufferedImage.getHeight()) {
            heightToScale = (int) (1.1 * thumbnailWidth);
            widthToScale = (int) ((heightToScale * 1.0) / originalBufferedImage.getHeight()
                    * originalBufferedImage.getWidth());
        } else {
            widthToScale = (int) (1.1 * thumbnailWidth);
            heightToScale = (int) ((widthToScale * 1.0) / originalBufferedImage.getWidth()
                    * originalBufferedImage.getHeight());
        }

        BufferedImage resizedImage = new BufferedImage(widthToScale,
                heightToScale, originalBufferedImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalBufferedImage, 0, 0, widthToScale, heightToScale, null);
        g.dispose();

        int x = (resizedImage.getWidth() - thumbnailWidth) / 2;
        int y = (resizedImage.getHeight() - thumbnailWidth) / 2;

        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Width of new thumbnail is bigger than original image");
        }

        return resizedImage.getSubimage(x, y, thumbnailWidth, thumbnailWidth);
    }

    @Override
    public BufferedImage createIcon() {
        return null;
    }

    @Override
    public BufferedImage clearBackground() throws IOException, InterruptedException {
        BufferedImage originalBufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));
        int tolerance = 99;
        int temp = tolerance * (0xFF000000 | 0xFF000000) / 100;
        final int toleranceRGB = Math.abs(temp);
        final ImageFilter filter = new RGBImageFilter() {
            // The color we are looking for (white)... Alpha bits are set to opaque
            public int markerRGBFrom = (new Color(0, 50, 77).getRGB() | 0xFF000000) - toleranceRGB;
            public int markerRGBTo = (new Color(200, 200, 255).getRGB() | 0xFF000000) + toleranceRGB;

            public final int filterRGB(final int x, final int y, final int rgb) {
                if ((rgb | 0xFF000000) >= markerRGBFrom && (rgb | 0xFF000000) <= markerRGBTo) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // Nothing to do
                    return rgb;
                }
            }
        };
        final ImageProducer imageProducer = new FilteredImageSource(originalBufferedImage.getSource(), filter);

        PixelGrabber pg = new PixelGrabber(imageProducer, 0, 0, -1, -1, null, 0,
                0);
        pg.grabPixels();

        BufferedImage bufferedImage = new BufferedImage(pg.getWidth(), pg.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        bufferedImage.setRGB(0, 0, pg.getWidth(), pg.getHeight(),
                (int[]) pg.getPixels(), 0, pg.getWidth());

        return bufferedImage;

    }

    @Override
    public BufferedImage applyGreyScaleFilter() throws IOException {

        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImage.getRGB(x, y);
                int alpha = (p >> 24) & 0xff;
                int red = (p >> 16) & 0xff;
                int green = (p >> 8) & 0xff;
                int blue = p & 0xff;
                int avg = (red + green + blue) / 3;
                p = (alpha << 24) | (avg << 16) | (avg << 8) | avg;

                bufferedImage.setRGB(x, y, p);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applyNegativeFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImage.getRGB(x, y);
                int alpha = (p >> 24) & 0xff;
                int red = (p >> 16) & 0xff;
                int green = (p >> 8) & 0xff;
                int blue = p & 0xff;

                red = 255 - red;
                green = 255 - green;
                blue = 255 - blue;


                p = (alpha << 24) | (red << 16) | (green << 8) | blue;

                bufferedImage.setRGB(x, y, p);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applySepiaFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImage.getRGB(x, y);
                int alpha = (p >> 24) & 0xff;
                int red = (p >> 16) & 0xff;
                int green = (p >> 8) & 0xff;
                int blue = p & 0xff;

                int newRed = (int) (0.393 * red + 0.769 * green + 0.189 * blue);
                int newGreen = (int) (0.349 * red + 0.686 * green + 0.168 * blue);
                int newBlue = (int) (0.272 * red + 0.534 * green + 0.131 * blue);

                red = (newRed > 255) ? 255 : newRed;
                green = (newGreen > 255) ? 255 : newGreen;
                blue = (newBlue > 255) ? 255 : newBlue;

                p = (alpha << 24) | (red << 16) | (green << 8) | blue;

                bufferedImage.setRGB(x, y, p);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applyRedFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImage.getRGB(x, y);
                int alpha = (p >> 24) & 0xff;
                int red = (p >> 16) & 0xff;

                p = (alpha << 24) | (red << 16) | (0 << 8) | 0;

                bufferedImage.setRGB(x, y, p);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applyGreenFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImage.getRGB(x, y);
                int alpha = (p >> 24) & 0xff;
                int red = (p >> 16) & 0xff;

                p = (alpha << 24) | (red << 8) | (0 << 8) | 0;

                bufferedImage.setRGB(x, y, p);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applyBlueFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = bufferedImage.getRGB(x, y);
                int alpha = (p >> 24) & 0xff;
                int red = (p >> 16) & 0xff;

                p = (alpha << 24) | (red << 0) | (0 << 0) | 0;

                bufferedImage.setRGB(x, y, p);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applySelfieFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int imageType = bufferedImage.getColorModel().getColorSpace().getType();

        if (imageType != ColorSpace.TYPE_RGB) {
            throw new IllegalArgumentException();
        }

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        BufferedImage resultBufferedImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {
                int p = bufferedImage.getRGB(lx, y);
                resultBufferedImage.setRGB(rx, y, p);
            }
        }

        return resultBufferedImage;
    }

    @Override
    public BufferedImage applyWaterMark(String waterMark) throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        BufferedImage resultImage = new BufferedImage(bufferedImage.getWidth(),
                bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics graphics = resultImage.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.setFont(new Font("Arial", Font.PLAIN, 80));
        graphics.setColor(new Color(255, 0, 0, 40));
        graphics.drawString(waterMark, bufferedImage.getWidth() / 5,
                bufferedImage.getHeight() / 3);

        graphics.dispose();

        return resultImage;
    }

    @Override
    public BufferedImage applyBlurFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        Kernel kernel = new Kernel(3, 3, new float[]{1f / 9f, 1f / 9f, 1f / 9f,
                1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f});
        BufferedImageOp op = new ConvolveOp(kernel);
        return op.filter(bufferedImage, null);
    }

    @Override
    public BufferedImage applySharpBlurFilter() throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        Kernel kernel = new Kernel(3, 3, new float[]{-1, -1, -1, -1, 9, -1, -1,
                -1, -1});
        BufferedImageOp op = new ConvolveOp(kernel);
        return op.filter(bufferedImage, null);
    }

    @Override
    public BufferedImage applyGaussianBlurFilter() throws IOException {

        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        int[] filter = {1, 2, 1, 2, 4, 2, 1, 2, 1};
        int filterWidth = 9;

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();
        final int sum = IntStream.of(filter).sum();

        int[] input = bufferedImage.getRGB(0, 0, width, height, null, 0, width);
        int[] output = new int[input.length];

        final int pixelIndexOffset = width - filterWidth;
        final int centerOffsetX = filterWidth / 2;
        final int centerOffsetY = filter.length / filterWidth / 2;

        // apply filter
        for (int h = height - filter.length / filterWidth + 1, w = width - filterWidth + 1, y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int red = 0;
                int green = 0;
                int blue = 0;
                for (int filterIndex = 0, pixelIndex = y * width + x;
                     filterIndex < filter.length;
                     pixelIndex += pixelIndexOffset) {
                    for (int fx = 0; fx < filterWidth; fx++, pixelIndex++, filterIndex++) {
                        int col = input[pixelIndex];
                        int factor = filter[filterIndex];

                        // sum up color channels seperately
                        red += ((col >>> 16) & 0xFF) * factor;
                        green += ((col >>> 8) & 0xFF) * factor;
                        blue += (col & 0xFF) * factor;
                    }
                }
                red /= sum;
                green /= sum;
                blue /= sum;
                // combine channels with full opacity
                output[x + centerOffsetX + (y + centerOffsetY) * width] = (red << 16) | (green << 8) | blue | 0xFF000000;
            }
        }

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        result.setRGB(0, 0, width, height, output, 0, width);
        return result;
    }

    @Override
    public BufferedImage applyEmbossFilter() throws IOException {

        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int width = bufferedImage.getWidth();
        final int height = bufferedImage.getHeight();

        // Create a buffered image from the source image with a format that's compatible with the screen
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        GraphicsConfiguration graphicsConfiguration = graphicsDevice.getDefaultConfiguration();

        // If the source image has no alpha info use Transparency.OPAQUE instead
        BufferedImage image = graphicsConfiguration.createCompatibleImage(width, height, Transparency.BITMASK);

        // Copy image to buffered image
        Graphics graphics = image.createGraphics();

        // Paint the image onto the buffered image
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.dispose();

        // A 3x3 kernel that embosses an image
        Kernel kernel = new Kernel(3, 3,
                new float[]{
                        -2, 0, 0,
                        0, 1, 0,
                        0, 0, 2});

        BufferedImageOp op = new ConvolveOp(kernel);

        return op.filter(image, null);
    }

    @Override
    public BufferedImage applyPixelateFilter() throws IOException {

        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        final int pixelSize = 2;

        for (int width = 0; width < bufferedImage.getWidth(); width += pixelSize) {
            for (int height = 0; height < bufferedImage.getHeight(); height += pixelSize) {
                Color pixelColor = new Color(bufferedImage.getRGB(width, height));

                Graphics graphics = bufferedImage.getGraphics();
                graphics.setColor(pixelColor);
                graphics.fillRect(width, height, pixelSize, pixelSize);
            }
        }

        return bufferedImage;
    }

    @Override
    public BufferedImage applyMedianFilter() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(this.imageFile);

        Color[] pixel = new Color[9];
        int[] red = new int[9];
        int[] blue = new int[9];
        int[] green = new int[9];

        for (int width = 1; width < bufferedImage.getWidth() - 1; width++)

            for (int height = 1; height < bufferedImage.getHeight() - 1; height++) {

                pixel[0] = new Color(bufferedImage.getRGB(width - 1, height - 1));
                pixel[1] = new Color(bufferedImage.getRGB(width - 1, height));
                pixel[2] = new Color(bufferedImage.getRGB(width - 1, height + 1));
                pixel[3] = new Color(bufferedImage.getRGB(width, height + 1));
                pixel[4] = new Color(bufferedImage.getRGB(width + 1, height + 1));
                pixel[5] = new Color(bufferedImage.getRGB(width + 1, height));
                pixel[6] = new Color(bufferedImage.getRGB(width + 1, height - 1));
                pixel[7] = new Color(bufferedImage.getRGB(width, height - 1));
                pixel[8] = new Color(bufferedImage.getRGB(width, height));

                for (int k = 0; k < 9; k++) {
                    red[k] = pixel[k].getRed();
                    blue[k] = pixel[k].getBlue();
                    green[k] = pixel[k].getGreen();
                }

                Arrays.sort(red);
                Arrays.sort(green);
                Arrays.sort(blue);

                bufferedImage.setRGB(width, height, new Color(red[4], blue[4], green[4]).getRGB());
            }

        return bufferedImage;
    }

    @Override
    public BufferedImage applyPixelValueFilter() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(this.imageFile);

        int alpha = 255;
        int red = 100;
        int green = 150;
        int blue = 200;

        int p = (alpha << 24) | (red << 16) | (green << 8) | blue;

        bufferedImage.setRGB(0, 0, p);

        return bufferedImage;
    }


    @Override
    public String getImageResolution() throws IOException {

        BufferedImage bufferedImage = ImageIO.read(this.imageFile);
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        return String.format("%s x %s", width, height);
    }
}
