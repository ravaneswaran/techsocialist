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

import com.techsocialist.servicebuilder.model.ProductionHouseEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductionHouseEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductionHouseEntryCacheModel
	implements CacheModel<ProductionHouseEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductionHouseEntryCacheModel)) {
			return false;
		}

		ProductionHouseEntryCacheModel productionHouseEntryCacheModel =
			(ProductionHouseEntryCacheModel)obj;

		if (id == productionHouseEntryCacheModel.id) {
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
	public ProductionHouseEntry toEntityModel() {
		ProductionHouseEntryImpl productionHouseEntryImpl =
			new ProductionHouseEntryImpl();

		productionHouseEntryImpl.setId(id);
		productionHouseEntryImpl.setUserId(userId);

		if (name == null) {
			productionHouseEntryImpl.setName("");
		}
		else {
			productionHouseEntryImpl.setName(name);
		}

		if (cin == null) {
			productionHouseEntryImpl.setCin("");
		}
		else {
			productionHouseEntryImpl.setCin(cin);
		}

		if (landline == null) {
			productionHouseEntryImpl.setLandline("");
		}
		else {
			productionHouseEntryImpl.setLandline(landline);
		}

		if (websiteUrl == null) {
			productionHouseEntryImpl.setWebsiteUrl("");
		}
		else {
			productionHouseEntryImpl.setWebsiteUrl(websiteUrl);
		}

		if (addressLine1 == null) {
			productionHouseEntryImpl.setAddressLine1("");
		}
		else {
			productionHouseEntryImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			productionHouseEntryImpl.setAddressLine2("");
		}
		else {
			productionHouseEntryImpl.setAddressLine2(addressLine2);
		}

		if (addressLine3 == null) {
			productionHouseEntryImpl.setAddressLine3("");
		}
		else {
			productionHouseEntryImpl.setAddressLine3(addressLine3);
		}

		if (place == null) {
			productionHouseEntryImpl.setPlace("");
		}
		else {
			productionHouseEntryImpl.setPlace(place);
		}

		if (state == null) {
			productionHouseEntryImpl.setState("");
		}
		else {
			productionHouseEntryImpl.setState(state);
		}

		if (country == null) {
			productionHouseEntryImpl.setCountry("");
		}
		else {
			productionHouseEntryImpl.setCountry(country);
		}

		if (pincode == null) {
			productionHouseEntryImpl.setPincode("");
		}
		else {
			productionHouseEntryImpl.setPincode(pincode);
		}

		if (status == null) {
			productionHouseEntryImpl.setStatus("");
		}
		else {
			productionHouseEntryImpl.setStatus(status);
		}

		if (contactPersonFirstName == null) {
			productionHouseEntryImpl.setContactPersonFirstName("");
		}
		else {
			productionHouseEntryImpl.setContactPersonFirstName(
				contactPersonFirstName);
		}

		if (contactPersonLastNameName == null) {
			productionHouseEntryImpl.setContactPersonLastNameName("");
		}
		else {
			productionHouseEntryImpl.setContactPersonLastNameName(
				contactPersonLastNameName);
		}

		if (contactPersonMobile == null) {
			productionHouseEntryImpl.setContactPersonMobile("");
		}
		else {
			productionHouseEntryImpl.setContactPersonMobile(
				contactPersonMobile);
		}

		if (contactPersonEmail == null) {
			productionHouseEntryImpl.setContactPersonEmail("");
		}
		else {
			productionHouseEntryImpl.setContactPersonEmail(contactPersonEmail);
		}

		if (userName == null) {
			productionHouseEntryImpl.setUserName("");
		}
		else {
			productionHouseEntryImpl.setUserName(userName);
		}

		if (password == null) {
			productionHouseEntryImpl.setPassword("");
		}
		else {
			productionHouseEntryImpl.setPassword(password);
		}

		if (createdBy == null) {
			productionHouseEntryImpl.setCreatedBy("");
		}
		else {
			productionHouseEntryImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			productionHouseEntryImpl.setModifiedBy("");
		}
		else {
			productionHouseEntryImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			productionHouseEntryImpl.setCreatedDate(null);
		}
		else {
			productionHouseEntryImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productionHouseEntryImpl.setModifiedDate(null);
		}
		else {
			productionHouseEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		productionHouseEntryImpl.resetOriginalValues();

		return productionHouseEntryImpl;
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