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
public class VideoEntrySoap implements Serializable {

	public static VideoEntrySoap toSoapModel(VideoEntry model) {
		VideoEntrySoap soapModel = new VideoEntrySoap();

		soapModel.setId(model.getId());
		soapModel.setProductionHouseEntryId(model.getProductionHouseEntryId());
		soapModel.setName(model.getName());
		soapModel.setContent(model.getContent());
		soapModel.setType(model.getType());
		soapModel.setStatus(model.getStatus());
		soapModel.setPublishDateTime(model.getPublishDateTime());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static VideoEntrySoap[] toSoapModels(VideoEntry[] models) {
		VideoEntrySoap[] soapModels = new VideoEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoEntrySoap[][] toSoapModels(VideoEntry[][] models) {
		VideoEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoEntrySoap[] toSoapModels(List<VideoEntry> models) {
		List<VideoEntrySoap> soapModels = new ArrayList<VideoEntrySoap>(
			models.size());

		for (VideoEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoEntrySoap[soapModels.size()]);
	}

	public VideoEntrySoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public long getPublishDateTime() {
		return _publishDateTime;
	}

	public void setPublishDateTime(long publishDateTime) {
		_publishDateTime = publishDateTime;
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
	private String _name;
	private Blob _content;
	private String _type;
	private String _status;
	private long _publishDateTime;
	private String _createdBy;
	private String _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;

}