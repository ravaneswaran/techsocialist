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

package com.techsocialis.servicebuilder.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.techsocialis.servicebuilder.model.ProductionHouseRegister;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductionHouseRegister in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductionHouseRegisterCacheModel
	implements CacheModel<ProductionHouseRegister>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductionHouseRegisterCacheModel)) {
			return false;
		}

		ProductionHouseRegisterCacheModel productionHouseRegisterCacheModel =
			(ProductionHouseRegisterCacheModel)obj;

		if (id == productionHouseRegisterCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", cin=");
		sb.append(cin);
		sb.append(", landline=");
		sb.append(landline);
		sb.append(", websiteUrl=");
		sb.append(websiteUrl);
		sb.append(", addressLine1=");
		sb.append(addressLine1);
		sb.append(", addressLine2=");
		sb.append(addressLine2);
		sb.append(", addressLine3=");
		sb.append(addressLine3);
		sb.append(", place=");
		sb.append(place);
		sb.append(", state=");
		sb.append(state);
		sb.append(", country=");
		sb.append(country);
		sb.append(", pincode=");
		sb.append(pincode);
		sb.append(", status=");
		sb.append(status);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonMobile=");
		sb.append(contactPersonMobile);
		sb.append(", contactPersonEmail=");
		sb.append(contactPersonEmail);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", password=");
		sb.append(password);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductionHouseRegister toEntityModel() {
		ProductionHouseRegisterImpl productionHouseRegisterImpl =
			new ProductionHouseRegisterImpl();

		productionHouseRegisterImpl.setId(id);

		if (name == null) {
			productionHouseRegisterImpl.setName("");
		}
		else {
			productionHouseRegisterImpl.setName(name);
		}

		if (cin == null) {
			productionHouseRegisterImpl.setCin("");
		}
		else {
			productionHouseRegisterImpl.setCin(cin);
		}

		if (landline == null) {
			productionHouseRegisterImpl.setLandline("");
		}
		else {
			productionHouseRegisterImpl.setLandline(landline);
		}

		if (websiteUrl == null) {
			productionHouseRegisterImpl.setWebsiteUrl("");
		}
		else {
			productionHouseRegisterImpl.setWebsiteUrl(websiteUrl);
		}

		if (addressLine1 == null) {
			productionHouseRegisterImpl.setAddressLine1("");
		}
		else {
			productionHouseRegisterImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			productionHouseRegisterImpl.setAddressLine2("");
		}
		else {
			productionHouseRegisterImpl.setAddressLine2(addressLine2);
		}

		if (addressLine3 == null) {
			productionHouseRegisterImpl.setAddressLine3("");
		}
		else {
			productionHouseRegisterImpl.setAddressLine3(addressLine3);
		}

		if (place == null) {
			productionHouseRegisterImpl.setPlace("");
		}
		else {
			productionHouseRegisterImpl.setPlace(place);
		}

		if (state == null) {
			productionHouseRegisterImpl.setState("");
		}
		else {
			productionHouseRegisterImpl.setState(state);
		}

		if (country == null) {
			productionHouseRegisterImpl.setCountry("");
		}
		else {
			productionHouseRegisterImpl.setCountry(country);
		}

		if (pincode == null) {
			productionHouseRegisterImpl.setPincode("");
		}
		else {
			productionHouseRegisterImpl.setPincode(pincode);
		}

		if (status == null) {
			productionHouseRegisterImpl.setStatus("");
		}
		else {
			productionHouseRegisterImpl.setStatus(status);
		}

		if (contactPersonName == null) {
			productionHouseRegisterImpl.setContactPersonName("");
		}
		else {
			productionHouseRegisterImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonMobile == null) {
			productionHouseRegisterImpl.setContactPersonMobile("");
		}
		else {
			productionHouseRegisterImpl.setContactPersonMobile(
				contactPersonMobile);
		}

		if (contactPersonEmail == null) {
			productionHouseRegisterImpl.setContactPersonEmail("");
		}
		else {
			productionHouseRegisterImpl.setContactPersonEmail(
				contactPersonEmail);
		}

		if (userName == null) {
			productionHouseRegisterImpl.setUserName("");
		}
		else {
			productionHouseRegisterImpl.setUserName(userName);
		}

		if (password == null) {
			productionHouseRegisterImpl.setPassword("");
		}
		else {
			productionHouseRegisterImpl.setPassword(password);
		}

		if (createdBy == null) {
			productionHouseRegisterImpl.setCreatedBy("");
		}
		else {
			productionHouseRegisterImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			productionHouseRegisterImpl.setModifiedBy("");
		}
		else {
			productionHouseRegisterImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			productionHouseRegisterImpl.setCreatedDate(null);
		}
		else {
			productionHouseRegisterImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productionHouseRegisterImpl.setModifiedDate(null);
		}
		else {
			productionHouseRegisterImpl.setModifiedDate(new Date(modifiedDate));
		}

		productionHouseRegisterImpl.resetOriginalValues();

		return productionHouseRegisterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		cin = objectInput.readUTF();
		landline = objectInput.readUTF();
		websiteUrl = objectInput.readUTF();
		addressLine1 = objectInput.readUTF();
		addressLine2 = objectInput.readUTF();
		addressLine3 = objectInput.readUTF();
		place = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
		pincode = objectInput.readUTF();
		status = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonMobile = objectInput.readUTF();
		contactPersonEmail = objectInput.readUTF();
		userName = objectInput.readUTF();
		password = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (cin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cin);
		}

		if (landline == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(landline);
		}

		if (websiteUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(websiteUrl);
		}

		if (addressLine1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine1);
		}

		if (addressLine2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine2);
		}

		if (addressLine3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressLine3);
		}

		if (place == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(place);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (pincode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pincode);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonMobile);
		}

		if (contactPersonEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonEmail);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (modifiedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public String name;
	public String cin;
	public String landline;
	public String websiteUrl;
	public String addressLine1;
	public String addressLine2;
	public String addressLine3;
	public String place;
	public String state;
	public String country;
	public String pincode;
	public String status;
	public String contactPersonName;
	public String contactPersonMobile;
	public String contactPersonEmail;
	public String userName;
	public String password;
	public String createdBy;
	public String modifiedBy;
	public long createdDate;
	public long modifiedDate;

}