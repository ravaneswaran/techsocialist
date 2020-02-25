package com.techsocialist.plugin.image.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public interface IImagePlugin {

    public IImagePlugin setFile(String filePath);

    public IImagePlugin setFile(URL url);

    public IImagePlugin setFile(File file);

    public File saveImage(ImageType imageType, BufferedImage image) throws IOException;

    public BufferedImage createThumnail() throws IOException;

    public BufferedImage createIcon();

    public BufferedImage clearBackground() throws IOException, InterruptedException;

}
