package com.techsocialist.utilities.barcodes.bc4j;

import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.impl.datamatrix.SymbolShapeHint;

import java.io.File;
import java.io.IOException;

/**
 * @author Ravaneswaran Chinnasamy
 *
 */
public class BC4JDataMatrixSquareBarcodeMaker extends AbstractBC4JBarcodeMaker{

	@Override
	public File create(String data, String directoryPath)
			throws IOException {
		DataMatrixBean dataMatrixBean = new DataMatrixBean();
		dataMatrixBean.setShape(SymbolShapeHint.FORCE_SQUARE);
		return this.getFile(dataMatrixBean, data, directoryPath);
	}

}
