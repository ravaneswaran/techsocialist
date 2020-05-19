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
public class ProductionHouseSoap implements Serializable {

	public static ProductionHouseSoap toSoapModel(ProductionHouse model) {
		ProductionHouseSoap soapModel = new ProductionHouseSoap();

		soapModel.setId(model.getId());
		soapModel.setUserId(model.getUserId());
		soapModel.setName(model.getName());
		soapModel.setCin(model.getCin());
		soapModel.setLogo(model.getLogo());
		soapModel.setBanner(model.getBanner());
		soapModel.setLandline(model.getLandline());
		soapModel.setWebsiteUrl(model.getWebsiteUrl());
		soapModel.setAddressLine1(model.getAddressLine1());
		soapModel.setAddressLine2(model.getAddressLine2());
		soapModel.setAddressLine3(model.getAddressLine3());
		soapModel.setPlace(model.getPlace());
		soapModel.setState(model.getState());
		soapModel.setCountry(model.getCountry());
		soapModel.setPincode(model.getPincode());
		soapModel.setStatus(model.getStatus());
		soapModel.setContactPersonFirstName(model.getContactPersonFirstName());
		soapModel.setContactPersonLastNameName(
			model.getContactPersonLastNameName());
		soapModel.setContactPersonMobile(model.getContactPersonMobile());
		soapModel.setContactPersonEmail(model.getContactPersonEmail());
		soapModel.setUserName(model.getUserName());
		soapModel.setPassword(model.getPassword());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProductionHouseSoap[] toSoapModels(ProductionHouse[] models) {
		ProductionHouseSoap[] soapModels =
			new ProductionHouseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductionHouseSoap[][] toSoapModels(
		ProductionHouse[][] models) {

		ProductionHouseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProductionHouseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductionHouseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductionHouseSoap[] toSoapModels(
		List<ProductionHouse> models) {

		List<ProductionHouseSoap> soapModels =
			new ArrayList<ProductionHouseSoap>(models.size());

		for (ProductionHouse model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductionHouseSoap[soapModels.size()]);
	}

	public ProductionHouseSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCin() {
		return _cin;
	}

	public void setCin(String cin) {
		_cin = cin;
	}

	public Blob getLogo() {
		return _logo;
	}

	public void setLogo(Blob logo) {
		_logo = logo;
	}

	public Blob getBanner() {
		return _banner;
	}

	public void setBanner(Blob banner) {
		_banner = banner;
	}

	public String getLandline() {
		return _landline;
	}

	public void setLandline(String landline) {
		_landline = landline;
	}

	public String getWebsiteUrl() {
		return _websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		_websiteUrl = websiteUrl;
	}

	public String getAddressLine1() {
		return _addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		_addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return _addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		_addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return _addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		_addressLine3 = addressLine3;
	}

	public String getPlace() {
		return _place;
	}

	public void setPlace(String place) {
		_place = place;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getPincode() {
		return _pincode;
	}

	public void setPincode(String pincode) {
		_pincode = pincode;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getContactPersonFirstName() {
		return _contactPersonFirstName;
	}

	public void setContactPersonFirstName(String contactPersonFirstName) {
		_contactPersonFirstName = contactPersonFirstName;
	}

	public String getContactPersonLastNameName() {
		return _contactPersonLastNameName;
	}

	public void setContactPersonLastNameName(String contactPersonLastNameName) {
		_contactPersonLastNameName = contactPersonLastNameName;
	}

	public String getContactPersonMobile() {
		return _contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		_contactPersonMobile = contactPersonMobile;
	}

	public String getContactPersonEmail() {
		return _contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
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
	private long _userId;
	private String _name;
	private String _cin;
	private Blob _logo;
	private Blob _banner;
	private String _landline;
	private String _websiteUrl;
	private String _addressLine1;
	private String _addressLine2;
	private String _addressLine3;
	private String _place;
	private String _state;
	private String _country;
	private String _pincode;
	private String _status;
	private String _contactPersonFirstName;
	private String _contactPersonLastNameName;
	private String _contactPersonMobile;
	private String _contactPersonEmail;
	private String _userName;
	private String _password;
	private String _createdBy;
	private String _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;

}