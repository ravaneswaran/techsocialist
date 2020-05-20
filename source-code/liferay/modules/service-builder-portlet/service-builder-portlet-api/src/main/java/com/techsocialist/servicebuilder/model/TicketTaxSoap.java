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
public class TicketTaxSoap implements Serializable {

	public static TicketTaxSoap toSoapModel(TicketTax model) {
		TicketTaxSoap soapModel = new TicketTaxSoap();

		soapModel.setId(model.getId());
		soapModel.setPercent(model.getPercent());
		soapModel.setEnabled(model.isEnabled());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TicketTaxSoap[] toSoapModels(TicketTax[] models) {
		TicketTaxSoap[] soapModels = new TicketTaxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketTaxSoap[][] toSoapModels(TicketTax[][] models) {
		TicketTaxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketTaxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketTaxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketTaxSoap[] toSoapModels(List<TicketTax> models) {
		List<TicketTaxSoap> soapModels = new ArrayList<TicketTaxSoap>(
			models.size());

		for (TicketTax model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketTaxSoap[soapModels.size()]);
	}

	public TicketTaxSoap() {
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

	public long getPercent() {
		return _percent;
	}

	public void setPercent(long percent) {
		_percent = percent;
	}

	public boolean getEnabled() {
		return _enabled;
	}

	public boolean isEnabled() {
		return _enabled;
	}

	public void setEnabled(boolean enabled) {
		_enabled = enabled;
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
	private long _percent;
	private boolean _enabled;
	private String _createdBy;
	private String _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;

}