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

package com.techsocialist.servicebuilder.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.techsocialist.servicebuilder.model.ProductionHouse;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductionHouse in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductionHouseCacheModel
	implements CacheModel<ProductionHouse>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductionHouseCacheModel)) {
			return false;
		}

		ProductionHouseCacheModel productionHouseCacheModel =
			(ProductionHouseCacheModel)obj;

		if (id == productionHouseCacheModel.id) {
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
		StringBundler sb = new StringBundler(49);

		sb.append("{id=");
		sb.append(id);
		sb.append(", userId=");
		sb.append(userId);
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
		sb.append(", contactPersonFirstName=");
		sb.append(contactPersonFirstName);
		sb.append(", contactPersonLastNameName=");
		sb.append(contactPersonLastNameName);
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
	public ProductionHouse toEntityModel() {
		ProductionHouseImpl productionHouseImpl = new ProductionHouseImpl();

		productionHouseImpl.setId(id);
		productionHouseImpl.setUserId(userId);

		if (name == null) {
			productionHouseImpl.setName("");
		}
		else {
			productionHouseImpl.setName(name);
		}

		if (cin == null) {
			productionHouseImpl.setCin("");
		}
		else {
			productionHouseImpl.setCin(cin);
		}

		if (landline == null) {
			productionHouseImpl.setLandline("");
		}
		else {
			productionHouseImpl.setLandline(landline);
		}

		if (websiteUrl == null) {
			productionHouseImpl.setWebsiteUrl("");
		}
		else {
			productionHouseImpl.setWebsiteUrl(websiteUrl);
		}

		if (addressLine1 == null) {
			productionHouseImpl.setAddressLine1("");
		}
		else {
			productionHouseImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			productionHouseImpl.setAddressLine2("");
		}
		else {
			productionHouseImpl.setAddressLine2(addressLine2);
		}

		if (addressLine3 == null) {
			productionHouseImpl.setAddressLine3("");
		}
		else {
			productionHouseImpl.setAddressLine3(addressLine3);
		}

		if (place == null) {
			productionHouseImpl.setPlace("");
		}
		else {
			productionHouseImpl.setPlace(place);
		}

		if (state == null) {
			productionHouseImpl.setState("");
		}
		else {
			productionHouseImpl.setState(state);
		}

		if (country == null) {
			productionHouseImpl.setCountry("");
		}
		else {
			productionHouseImpl.setCountry(country);
		}

		if (pincode == null) {
			productionHouseImpl.setPincode("");
		}
		else {
			productionHouseImpl.setPincode(pincode);
		}

		if (status == null) {
			productionHouseImpl.setStatus("");
		}
		else {
			productionHouseImpl.setStatus(status);
		}

		if (contactPersonFirstName == null) {
			productionHouseImpl.setContactPersonFirstName("");
		}
		else {
			productionHouseImpl.setContactPersonFirstName(
				contactPersonFirstName);
		}

		if (contactPersonLastNameName == null) {
			productionHouseImpl.setContactPersonLastNameName("");
		}
		else {
			productionHouseImpl.setContactPersonLastNameName(
				contactPersonLastNameName);
		}

		if (contactPersonMobile == null) {
			productionHouseImpl.setContactPersonMobile("");
		}
		else {
			productionHouseImpl.setContactPersonMobile(contactPersonMobile);
		}

		if (contactPersonEmail == null) {
			productionHouseImpl.setContactPersonEmail("");
		}
		else {
			productionHouseImpl.setContactPersonEmail(contactPersonEmail);
		}

		if (userName == null) {
			productionHouseImpl.setUserName("");
		}
		else {
			productionHouseImpl.setUserName(userName);
		}

		if (password == null) {
			productionHouseImpl.setPassword("");
		}
		else {
			productionHouseImpl.setPassword(password);
		}

		if (createdBy == null) {
			productionHouseImpl.setCreatedBy("");
		}
		else {
			productionHouseImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			productionHouseImpl.setModifiedBy("");
		}
		else {
			productionHouseImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			productionHouseImpl.setCreatedDate(null);
		}
		else {
			productionHouseImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productionHouseImpl.setModifiedDate(null);
		}
		else {
			productionHouseImpl.setModifiedDate(new Date(modifiedDate));
		}

		productionHouseImpl.resetOriginalValues();

		return productionHouseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		userId = objectInput.readLong();
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
		contactPersonFirstName = objectInput.readUTF();
		contactPersonLastNameName = objectInput.readUTF();
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

		objectOutput.writeLong(userId);

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

		if (contactPersonFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonFirstName);
		}

		if (contactPersonLastNameName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactPersonLastNameName);
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
	public long userId;
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
	public String contactPersonFirstName;
	public String contactPersonLastNameName;
	public String contactPersonMobile;
	public String contactPersonEmail;
	public String userName;
	public String password;
	public String createdBy;
	public String modifiedBy;
	public long createdDate;
	public long modifiedDate;

}