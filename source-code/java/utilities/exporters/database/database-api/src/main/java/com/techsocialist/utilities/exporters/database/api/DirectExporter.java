package com.techsocialist.utilities.exporters.database.api;

public interface DirectExporter extends Exporter {

    public void setSource(ExIm source);

    public void setTarget(ExIm target);

    public ExIm getSource();

    public ExIm getTarget();
}
