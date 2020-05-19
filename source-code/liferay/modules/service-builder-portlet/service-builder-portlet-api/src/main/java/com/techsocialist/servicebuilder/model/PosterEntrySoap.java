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
public class PosterEntrySoap implements Serializable {

	public static PosterEntrySoap toSoapModel(PosterEntry model) {
		PosterEntrySoap soapModel = new PosterEntrySoap();

		soapModel.setId(model.getId());
		soapModel.setVideoEntryId(model.getVideoEntryId());
		soapModel.setName(model.getName());
		soapModel.setContent(model.getContent());
		soapModel.setType(model.getType());
		soapModel.setStatus(model.getStatus());
		soapModel.setPublishDateTime(model.getPublishDateTime());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static PosterEntrySoap[] toSoapModels(PosterEntry[] models) {
		PosterEntrySoap[] soapModels = new PosterEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PosterEntrySoap[][] toSoapModels(PosterEntry[][] models) {
		PosterEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PosterEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PosterEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PosterEntrySoap[] toSoapModels(List<PosterEntry> models) {
		List<PosterEntrySoap> soapModels = new ArrayList<PosterEntrySoap>(
			models.size());

		for (PosterEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PosterEntrySoap[soapModels.size()]);
	}

	public PosterEntrySoap() {
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

	public long getVideoEntryId() {
		return _videoEntryId;
	}

	public void setVideoEntryId(long videoEntryId) {
		_videoEntryId = videoEntryId;
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

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _id;
	private long _videoEntryId;
	private String _name;
	private Blob _content;
	private String _type;
	private String _status;
	private long _publishDateTime;
	private String _createdBy;
	private String _modifiedBy;
	private Date _modifiedDate;
	private Date _createdDate;

}