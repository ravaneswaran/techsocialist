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
        graphics.drawString(waterMark, bufferedImage.getWidth()/5,
                bufferedImage.getHeight()/3);

        graphics.dispose();

        return resultImage;
    }

    @Override
    public BufferedImage applyBlurFilter(String waterMark) throws IOException {
        BufferedImage bufferedImage = this.toBufferedImage(this.toByteArray(this.imageFile));

        Kernel kernel = new Kernel(3, 3, new float[] { 1f / 9f, 1f / 9f, 1f / 9f,
                1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f, 1f / 9f });
        BufferedImageOp op = new ConvolveOp(kernel);
        return  op.filter(bufferedImage, null);
    }

    @Override
    public String getImageResolution() throws IOException {

        BufferedImage bufferedImage = ImageIO.read(this.imageFile);
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        return String.format("%s x %s", width, height);
    }
}
