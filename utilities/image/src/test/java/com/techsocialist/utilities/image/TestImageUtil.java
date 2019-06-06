package com.techsocialist.utilities.image;

import com.techsocialist.utilities.image.api.IImageUtil;
import com.techsocialist.utilities.image.impl.ImageUtil;
import junit.framework.TestCase;
import org.junit.Assert;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * Created by ravaneswaran on 7/22/17.
 */
public class TestImageUtil extends TestCase {

    private IImageUtil imageUtil = new ImageUtil();

    private static final String IMAGE_FILE = "/home/ravaneswaran/workspace/intellij/tech-socialist/utilities/image/src/test/resources/test-image.jpg";

    public void testInstance(){
        Assert.assertTrue(this.imageUtil instanceof IImageUtil);
    }

    public void testImageToByteArray_String() throws IOException {

        byte[] imageAsBytes = this.imageUtil.toByteArray(IMAGE_FILE);

        Assert.assertNotNull(imageAsBytes);
        Assert.assertTrue(imageAsBytes.length > 0);
    }

    public void testImageToByteArray_File() throws IOException {
        File file = new File(IMAGE_FILE);
        byte[] imageAsBytes = this.imageUtil.toByteArray(file);

        Assert.assertNotNull(imageAsBytes);
        Assert.assertTrue(imageAsBytes.length > 0);
    }

    public void testImageToByteArray_URL() throws IOException {
        URL fileUrl = new URL("file://"+IMAGE_FILE);
        byte[] imageAsBytes = this.imageUtil.toByteArray(fileUrl);

        Assert.assertNotNull(imageAsBytes);
        Assert.assertTrue(imageAsBytes.length > 0);
    }

    public void testImageToByteArray_InputStream() throws IOException {
        File file = new File(IMAGE_FILE);
        InputStream is = new FileInputStream(file);
        byte[] imageAsBytes = this.imageUtil.toByteArray(is);

        Assert.assertNotNull(imageAsBytes);
        Assert.assertTrue(imageAsBytes.length > 0);
    }

    public void testByteArrayToFile() throws IOException {
        byte[] imageAsBytes = this.imageUtil.toByteArray(IMAGE_FILE);

        File fileObj = this.imageUtil.toFileObj(imageAsBytes);

        Assert.assertNotNull(fileObj);
    }

    public void testToBufferedImage() throws IOException {
        byte[] imageAsBytes = this.imageUtil.toByteArray(IMAGE_FILE);
        BufferedImage bufferedImage = this.imageUtil.toBufferedImage(imageAsBytes);
        Assert.assertNotNull(bufferedImage);
    }

    public void testToThumbnail() throws IOException {
        byte[] imageAsBytes = this.imageUtil.toByteArray(IMAGE_FILE);
        BufferedImage thumbnail = this.imageUtil.toThumbnail(imageAsBytes);
        Assert.assertNotNull(thumbnail);
    }

    public void testToFile_BufferedImage() throws IOException {
        byte[] imageAsBytes = this.imageUtil.toByteArray(IMAGE_FILE);
        BufferedImage thumbnail = this.imageUtil.toThumbnail(imageAsBytes);
        File fileObj = this.imageUtil.toFileObj(thumbnail);
        Assert.assertNotNull(fileObj);
    }
}
