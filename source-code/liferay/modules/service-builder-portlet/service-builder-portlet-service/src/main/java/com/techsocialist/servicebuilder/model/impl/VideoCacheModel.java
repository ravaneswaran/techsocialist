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

import com.techsocialist.servicebuilder.model.Video;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Video in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VideoCacheModel implements CacheModel<Video>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoCacheModel)) {
			return false;
		}

		VideoCacheModel videoCacheModel = (VideoCacheModel)obj;

		if (id == videoCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", productionHouseId=");
		sb.append(productionHouseId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append(", ticketPrice=");
		sb.append(ticketPrice);
		sb.append(", publishDateTime=");
		sb.append(publishDateTime);
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
	public Video toEntityModel() {
		VideoImpl videoImpl = new VideoImpl();

		videoImpl.setId(id);
		videoImpl.setProductionHouseId(productionHouseId);

		if (name == null) {
			videoImpl.setName("");
		}
		else {
			videoImpl.setName(name);
		}

		if (type == null) {
			videoImpl.setType("");
		}
		else {
			videoImpl.setType(type);
		}

		if (status == null) {
			videoImpl.setStatus("");
		}
		else {
			videoImpl.setStatus(status);
		}

		videoImpl.setTicketPrice(ticketPrice);
		videoImpl.setPublishDateTime(publishDateTime);

		if (createdBy == null) {
			videoImpl.setCreatedBy("");
		}
		else {
			videoImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			videoImpl.setModifiedBy("");
		}
		else {
			videoImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			videoImpl.setCreatedDate(null);
		}
		else {
			videoImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoImpl.setModifiedDate(null);
		}
		else {
			videoImpl.setModifiedDate(new Date(modifiedDate));
		}

		videoImpl.resetOriginalValues();

		return videoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		productionHouseId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		status = objectInput.readUTF();

		ticketPrice = objectInput.readDouble();

		publishDateTime = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(productionHouseId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeDouble(ticketPrice);

		objectOutput.writeLong(publishDateTime);

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
	public long productionHouseId;
	public String name;
	public String type;
	public String status;
	public double ticketPrice;
	public long publishDateTime;
	public String createdBy;
	public String modifiedBy;
	public long createdDate;
	public long modifiedDate;

}