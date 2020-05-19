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

import com.techsocialist.servicebuilder.model.ProductionHouseRegisterEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductionHouseRegisterEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductionHouseRegisterEntryCacheModel
	implements CacheModel<ProductionHouseRegisterEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductionHouseRegisterEntryCacheModel)) {
			return false;
		}

		ProductionHouseRegisterEntryCacheModel
			productionHouseRegisterEntryCacheModel =
				(ProductionHouseRegisterEntryCacheModel)obj;

		if (id == productionHouseRegisterEntryCacheModel.id) {
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
		StringBundler sb = new StringBundler(47);

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
	public ProductionHouseRegisterEntry toEntityModel() {
		ProductionHouseRegisterEntryImpl productionHouseRegisterEntryImpl =
			new ProductionHouseRegisterEntryImpl();

		productionHouseRegisterEntryImpl.setId(id);

		if (name == null) {
			productionHouseRegisterEntryImpl.setName("");
		}
		else {
			productionHouseRegisterEntryImpl.setName(name);
		}

		if (cin == null) {
			productionHouseRegisterEntryImpl.setCin("");
		}
		else {
			productionHouseRegisterEntryImpl.setCin(cin);
		}

		if (landline == null) {
			productionHouseRegisterEntryImpl.setLandline("");
		}
		else {
			productionHouseRegisterEntryImpl.setLandline(landline);
		}

		if (websiteUrl == null) {
			productionHouseRegisterEntryImpl.setWebsiteUrl("");
		}
		else {
			productionHouseRegisterEntryImpl.setWebsiteUrl(websiteUrl);
		}

		if (addressLine1 == null) {
			productionHouseRegisterEntryImpl.setAddressLine1("");
		}
		else {
			productionHouseRegisterEntryImpl.setAddressLine1(addressLine1);
		}

		if (addressLine2 == null) {
			productionHouseRegisterEntryImpl.setAddressLine2("");
		}
		else {
			productionHouseRegisterEntryImpl.setAddressLine2(addressLine2);
		}

		if (addressLine3 == null) {
			productionHouseRegisterEntryImpl.setAddressLine3("");
		}
		else {
			productionHouseRegisterEntryImpl.setAddressLine3(addressLine3);
		}

		if (place == null) {
			productionHouseRegisterEntryImpl.setPlace("");
		}
		else {
			productionHouseRegisterEntryImpl.setPlace(place);
		}

		if (state == null) {
			productionHouseRegisterEntryImpl.setState("");
		}
		else {
			productionHouseRegisterEntryImpl.setState(state);
		}

		if (country == null) {
			productionHouseRegisterEntryImpl.setCountry("");
		}
		else {
			productionHouseRegisterEntryImpl.setCountry(country);
		}

		if (pincode == null) {
			productionHouseRegisterEntryImpl.setPincode("");
		}
		else {
			productionHouseRegisterEntryImpl.setPincode(pincode);
		}

		if (status == null) {
			productionHouseRegisterEntryImpl.setStatus("");
		}
		else {
			productionHouseRegisterEntryImpl.setStatus(status);
		}

		if (contactPersonFirstName == null) {
			productionHouseRegisterEntryImpl.setContactPersonFirstName("");
		}
		else {
			productionHouseRegisterEntryImpl.setContactPersonFirstName(
				contactPersonFirstName);
		}

		if (contactPersonLastNameName == null) {
			productionHouseRegisterEntryImpl.setContactPersonLastNameName("");
		}
		else {
			productionHouseRegisterEntryImpl.setContactPersonLastNameName(
				contactPersonLastNameName);
		}

		if (contactPersonMobile == null) {
			productionHouseRegisterEntryImpl.setContactPersonMobile("");
		}
		else {
			productionHouseRegisterEntryImpl.setContactPersonMobile(
				contactPersonMobile);
		}

		if (contactPersonEmail == null) {
			productionHouseRegisterEntryImpl.setContactPersonEmail("");
		}
		else {
			productionHouseRegisterEntryImpl.setContactPersonEmail(
				contactPersonEmail);
		}

		if (userName == null) {
			productionHouseRegisterEntryImpl.setUserName("");
		}
		else {
			productionHouseRegisterEntryImpl.setUserName(userName);
		}

		if (password == null) {
			productionHouseRegisterEntryImpl.setPassword("");
		}
		else {
			productionHouseRegisterEntryImpl.setPassword(password);
		}

		if (createdBy == null) {
			productionHouseRegisterEntryImpl.setCreatedBy("");
		}
		else {
			productionHouseRegisterEntryImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			productionHouseRegisterEntryImpl.setModifiedBy("");
		}
		else {
			productionHouseRegisterEntryImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			productionHouseRegisterEntryImpl.setCreatedDate(null);
		}
		else {
			productionHouseRegisterEntryImpl.setCreatedDate(
				new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productionHouseRegisterEntryImpl.setModifiedDate(null);
		}
		else {
			productionHouseRegisterEntryImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		productionHouseRegisterEntryImpl.resetOriginalValues();

		return productionHouseRegisterEntryImpl;
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