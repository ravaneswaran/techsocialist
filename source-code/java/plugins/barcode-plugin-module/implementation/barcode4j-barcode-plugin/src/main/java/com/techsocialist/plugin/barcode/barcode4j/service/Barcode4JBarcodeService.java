package com.techsocialist.plugin.barcode.barcode4j.service;

import com.techsocialist.plugin.barcode.service.api.IBarcode4JBarcodeService;
import com.techsocialist.plugin.barcode.service.impl.AbstractBarcodeService;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.impl.codabar.CodabarBean;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.impl.datamatrix.SymbolShapeHint;
import org.krysalis.barcode4j.impl.fourstate.RoyalMailCBCBean;
import org.krysalis.barcode4j.impl.fourstate.USPSIntelligentMailBean;
import org.krysalis.barcode4j.impl.int2of5.ITF14Bean;
import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;
import org.krysalis.barcode4j.impl.postnet.POSTNETBean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.impl.upcean.EAN8Bean;
import org.krysalis.barcode4j.impl.upcean.UPCABean;
import org.krysalis.barcode4j.impl.upcean.UPCEBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Barcode4JBarcodeService extends AbstractBarcodeService implements IBarcode4JBarcodeService {

    private static final int BAR_CODE_DPI = 300;

    @Override
    public String scanImage(BufferedImage bufferedImage) throws Exception {
        return null;
    }

    private BufferedImage createBarcodeImage(String data, AbstractBarcodeBean barcodeBean) throws IOException {
        barcodeBean.setModuleWidth(UnitConv.in2mm(1.0f / BAR_CODE_DPI));

        BitmapCanvasProvider canvas = new BitmapCanvasProvider(BAR_CODE_DPI, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeBean.generateBarcode(canvas, data);
        BufferedImage bufferedImage = canvas.getBufferedImage();
        canvas.finish();

        return bufferedImage;
    }

    @Override
    public BufferedImage createImage(String data) throws Exception {
        return this.createEAN13Image(data);
    }

    @Override
    public BufferedImage createCodabarImage(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new CodabarBean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createCode128Image(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new Code128Bean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createCode39Image(String data) throws IOException {
        Code39Bean code39Bean = new Code39Bean();
        code39Bean.setWideFactor(3);
        return createBarcodeImage(data, code39Bean);
    }

    @Override
    public BufferedImage createDataMatrixRectangleImage(String data) throws IOException {
        DataMatrixBean dataMatrixBean = new DataMatrixBean();
        dataMatrixBean.setShape(SymbolShapeHint.FORCE_RECTANGLE);
        return createBarcodeImage(data, dataMatrixBean);
    }

    @Override
    public BufferedImage createDataMatrixSquareImage(String data) throws IOException {
        DataMatrixBean dataMatrixBean = new DataMatrixBean();
        dataMatrixBean.setShape(SymbolShapeHint.FORCE_SQUARE);
        return createBarcodeImage(data, dataMatrixBean);
    }

    @Override
    public BufferedImage createEAN13Image(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new EAN13Bean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createEAN8Image(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new EAN8Bean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createITF14Image(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new ITF14Bean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createInterleaved2Of5Image(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new Interleaved2Of5Bean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createPDF417Image(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new PDF417Bean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createPOSTNETImage(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new POSTNETBean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createRoyalMailCBCImage(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new RoyalMailCBCBean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createUPCAImage(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new UPCABean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createUPCEImage(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new UPCEBean();
        return createBarcodeImage(data, barcodeBean);
    }

    @Override
    public BufferedImage createUSPSIntelligentMailImage(String data) throws IOException {
        AbstractBarcodeBean barcodeBean = new USPSIntelligentMailBean();
        return createBarcodeImage(data, barcodeBean);
    }
}
