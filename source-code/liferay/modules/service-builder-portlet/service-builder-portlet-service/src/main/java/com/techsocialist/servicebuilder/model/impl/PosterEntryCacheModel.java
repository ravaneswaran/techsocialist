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

import com.techsocialist.servicebuilder.model.PosterEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PosterEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PosterEntryCacheModel
	implements CacheModel<PosterEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PosterEntryCacheModel)) {
			return false;
		}

		PosterEntryCacheModel posterEntryCacheModel =
			(PosterEntryCacheModel)obj;

		if (id == posterEntryCacheModel.id) {
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
		sb.append(", videoEntryId=");
		sb.append(videoEntryId);
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
	public PosterEntry toEntityModel() {
		PosterEntryImpl posterEntryImpl = new PosterEntryImpl();

		posterEntryImpl.setId(id);
		posterEntryImpl.setVideoEntryId(videoEntryId);

		if (name == null) {
			posterEntryImpl.setName("");
		}
		else {
			posterEntryImpl.setName(name);
		}

		if (type == null) {
			posterEntryImpl.setType("");
		}
		else {
			posterEntryImpl.setType(type);
		}

		if (status == null) {
			posterEntryImpl.setStatus("");
		}
		else {
			posterEntryImpl.setStatus(status);
		}

		posterEntryImpl.setPublishDateTime(publishDateTime);

		if (createdBy == null) {
			posterEntryImpl.setCreatedBy("");
		}
		else {
			posterEntryImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			posterEntryImpl.setModifiedBy("");
		}
		else {
			posterEntryImpl.setModifiedBy(modifiedBy);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			posterEntryImpl.setModifiedDate(null);
		}
		else {
			posterEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (createdDate == Long.MIN_VALUE) {
			posterEntryImpl.setCreatedDate(null);
		}
		else {
			posterEntryImpl.setCreatedDate(new Date(createdDate));
		}

		posterEntryImpl.resetOriginalValues();

		return posterEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		videoEntryId = objectInput.readLong();
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

		objectOutput.writeLong(videoEntryId);

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
	public long videoEntryId;
	public String name;
	public String type;
	public String status;
	public long publishDateTime;
	public String createdBy;
	public String modifiedBy;
	public long modifiedDate;
	public long createdDate;

}