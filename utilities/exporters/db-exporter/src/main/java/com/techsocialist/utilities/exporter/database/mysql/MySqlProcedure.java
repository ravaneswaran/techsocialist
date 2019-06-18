package com.techsocialist.utilities.exporter.database.mysql;

import com.techsocialist.utilities.exporter.database.Procedure;

public class MySqlProcedure implements Procedure{
	
	private String name;
	
	private String type;
	
	private String definer;
	
	private String createdDate;
	
	private String modifiedDate;
	
	private String securityType;
	
	private String comment;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public void setDefiner(String definer) {
		this.definer = definer;
	}

	public String getDefiner() {
		return this.definer;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedDate() {
		return this.createdDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedDate() {
		return this.modifiedDate;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getSecurityType() {
		return this.securityType;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return this.comment;
	}
}
