package com.techsocialist.plugin.image.api;

import java.awt.image.BufferedImage;

public interface IImagePlugin {

    public BufferedImage createThumnail();

    public BufferedImage createIcon();
}
