/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.techsocialist.servicebuilder.model;

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VideoRegisterEntrySoap implements Serializable {

	public static VideoRegisterEntrySoap toSoapModel(VideoRegisterEntry model) {
		VideoRegisterEntrySoap soapModel = new VideoRegisterEntrySoap();

		soapModel.setId(model.getId());
		soapModel.setProductionHouseEntryId(model.getProductionHouseEntryId());
		soapModel.setContent(model.getContent());
		soapModel.setType(model.getType());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static VideoRegisterEntrySoap[] toSoapModels(
		VideoRegisterEntry[] models) {

		VideoRegisterEntrySoap[] soapModels =
			new VideoRegisterEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoRegisterEntrySoap[][] toSoapModels(
		VideoRegisterEntry[][] models) {

		VideoRegisterEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new VideoRegisterEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoRegisterEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoRegisterEntrySoap[] toSoapModels(
		List<VideoRegisterEntry> models) {

		List<VideoRegisterEntrySoap> soapModels =
			new ArrayList<VideoRegisterEntrySoap>(models.size());

		for (VideoRegisterEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new VideoRegisterEntrySoap[soapModels.size()]);
	}

	public VideoRegisterEntrySoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getProductionHouseEntryId() {
		return _productionHouseEntryId;
	}

	public void setProductionHouseEntryId(long productionHouseEntryId) {
		_productionHouseEntryId = productionHouseEntryId;
	}

	public Blob getContent() {
		return _content;
	}

	public void setContent(Blob content) {
		_content = content;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public String getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _id;
	private long _productionHouseEntryId;
	private Blob _content;
	private String _type;
	private String _status;
	private String _createdBy;
	private String _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;

}