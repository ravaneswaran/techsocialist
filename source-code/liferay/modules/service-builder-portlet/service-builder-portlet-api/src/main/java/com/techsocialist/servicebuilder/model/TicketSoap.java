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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketSoap implements Serializable {

	public static TicketSoap toSoapModel(Ticket model) {
		TicketSoap soapModel = new TicketSoap();

		soapModel.setId(model.getId());
		soapModel.setUserId(model.getUserId());
		soapModel.setVideoEntryId(model.getVideoEntryId());
		soapModel.setStatus(model.getStatus());
		soapModel.setPurchaseTime(model.getPurchaseTime());
		soapModel.setSoldTime(model.getSoldTime());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static TicketSoap[] toSoapModels(Ticket[] models) {
		TicketSoap[] soapModels = new TicketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketSoap[][] toSoapModels(Ticket[][] models) {
		TicketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketSoap[] toSoapModels(List<Ticket> models) {
		List<TicketSoap> soapModels = new ArrayList<TicketSoap>(models.size());

		for (Ticket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketSoap[soapModels.size()]);
	}

	public TicketSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getVideoEntryId() {
		return _videoEntryId;
	}

	public void setVideoEntryId(long videoEntryId) {
		_videoEntryId = videoEntryId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getPurchaseTime() {
		return _purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		_purchaseTime = purchaseTime;
	}

	public Date getSoldTime() {
		return _soldTime;
	}

	public void setSoldTime(Date soldTime) {
		_soldTime = soldTime;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _id;
	private long _userId;
	private long _videoEntryId;
	private String _status;
	private Date _purchaseTime;
	private Date _soldTime;
	private Date _createdDate;

}