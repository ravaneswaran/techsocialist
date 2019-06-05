package com.techsocialist.utilities.barcodes.bc4j;

import java.io.File;
import java.io.IOException;

import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.impl.datamatrix.SymbolShapeHint;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JDataMatrixRectangleBarcodeMaker extends AbstractBC4JBarcodeMaker{

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		DataMatrixBean dataMatrixBean = new DataMatrixBean();
		dataMatrixBean.setShape(SymbolShapeHint.FORCE_RECTANGLE);
		return this.getFile(dataMatrixBean, data, directoryPath);
	}

}
