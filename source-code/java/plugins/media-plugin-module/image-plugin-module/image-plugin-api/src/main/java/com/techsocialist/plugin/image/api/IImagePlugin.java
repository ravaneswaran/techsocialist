package com.techsocialist.plugin.image.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

public interface IImagePlugin {

    public IImagePlugin setImage(String filePath);

    public IImagePlugin setImage(URL url);

    public IImagePlugin setImage(File file);

    public File saveImage(ImageType imageType, BufferedImage image) throws IOException;

    public String getImageResolution() throws IOException;

    public BufferedImage createThumbnail() throws IOException;

    public BufferedImage createIcon();

    public BufferedImage clearBackground() throws IOException, InterruptedException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applyGreyScaleFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applyNegativeFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applySepiaFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applyRedFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applyGreenFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applyBlueFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applySelfieFilter() throws IOException;

    //source : https://data-flair.training/blogs/convert-colored-image/
    public BufferedImage applyWaterMark(String waterMark) throws IOException;

    //source : http://www.java2s.com/Code/Java/2D-Graphics-GUI/BlurringaBufferedImage.htm
    public BufferedImage applyBlurFilter() throws IOException;

    public BufferedImage applySharpBlurFilter() throws IOException;



}
