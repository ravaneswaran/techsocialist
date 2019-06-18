package com.techsocialist.utilities.exporter.database;

public interface Procedure {
	
	public void setName(String name);

	public String getName();

	public void setType(String type);

	public String getType();

	public void setDefiner(String definer);

	public String getDefiner();

	public void setCreatedDate(String createdDate);

	public String getCreatedDate();

	public void setModifiedDate(String modifiedDate);

	public String getModifiedDate();

	public void setSecurityType(String securityType);

	public String getSecurityType();

	public void setComment(String comment);

	public String getComment();

}
