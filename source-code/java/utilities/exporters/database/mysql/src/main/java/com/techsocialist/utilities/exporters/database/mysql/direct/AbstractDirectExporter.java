package com.techsocialist.utilities.exporters.database.mysql.direct;


import com.techsocialist.utilities.exporters.database.api.DirectExporter;
import com.techsocialist.utilities.exporters.database.api.ExIm;

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