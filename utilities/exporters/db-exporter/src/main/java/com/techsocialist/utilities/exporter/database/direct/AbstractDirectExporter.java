package com.techsocialist.utilities.exporter.database.direct;

import com.techsocialist.utilities.exporter.database.DirectExporter;
import com.techsocialist.utilities.exporter.database.ExIm;

public abstract class AbstractDirectExporter implements DirectExporter {

	protected ExIm source;
	
	protected ExIm target;

	public void setSource(ExIm source) {
		this.source = source;
	}

	public ExIm getSource() {
		return this.source;
	}

	public void setTarget(ExIm target) {
		this.target = target;
	}

	public ExIm getTarget() {
		return this.target;
	}
}