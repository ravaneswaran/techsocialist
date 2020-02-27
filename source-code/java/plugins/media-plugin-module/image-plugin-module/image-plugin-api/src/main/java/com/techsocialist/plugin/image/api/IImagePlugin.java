package com.techsocialist.plugin.image.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface IImagePlugin {

    public IImagePlugin setImage(String filePath);

    public IImagePlugin setImage(URL url);

    public IImagePlugin setImage(File file);

    public File saveImage(ImageType imageType, BufferedImage image) throws IOException;

    public String getImageResolution() throws IOException;

    public BufferedImage createThumbnail() throws IOException;

    public BufferedImage createIcon();

    public BufferedImage clearBackground() throws IOException, InterruptedException;

    public BufferedImage applyGreyScaleFilter() throws IOException;



}
