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

import com.techsocialist.servicebuilder.model.Poster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Poster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PosterCacheModel implements CacheModel<Poster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PosterCacheModel)) {
			return false;
		}

		PosterCacheModel posterCacheModel = (PosterCacheModel)obj;

		if (id == posterCacheModel.id) {
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
		StringBundler sb = new StringBundler(21);

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
		sb.append(", publishDateTime=");
		sb.append(publishDateTime);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Poster toEntityModel() {
		PosterImpl posterImpl = new PosterImpl();

		posterImpl.setId(id);
		posterImpl.setProductionHouseId(productionHouseId);

		if (name == null) {
			posterImpl.setName("");
		}
		else {
			posterImpl.setName(name);
		}

		if (type == null) {
			posterImpl.setType("");
		}
		else {
			posterImpl.setType(type);
		}

		if (status == null) {
			posterImpl.setStatus("");
		}
		else {
			posterImpl.setStatus(status);
		}

		posterImpl.setPublishDateTime(publishDateTime);

		if (createdBy == null) {
			posterImpl.setCreatedBy("");
		}
		else {
			posterImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			posterImpl.setModifiedBy("");
		}
		else {
			posterImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			posterImpl.setModifiedDate(null);
		}
		else {
			posterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (createdDate == Long.MIN_VALUE) {
			posterImpl.setCreatedDate(null);
		}
		else {
			posterImpl.setCreatedDate(new Date(createdDate));
		}

		posterImpl.resetOriginalValues();

		return posterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		productionHouseId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		status = objectInput.readUTF();

		publishDateTime = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		createdDate = objectInput.readLong();
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

		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(createdDate);
	}

	public long id;
	public long productionHouseId;
	public String name;
	public String type;
	public String status;
	public long publishDateTime;
	public String createdBy;
	public String modifiedBy;
	public long modifiedDate;
	public long createdDate;

}