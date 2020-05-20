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

import com.techsocialist.servicebuilder.model.TicketPrice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketPrice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketPriceCacheModel
	implements CacheModel<TicketPrice>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketPriceCacheModel)) {
			return false;
		}

		TicketPriceCacheModel ticketPriceCacheModel =
			(TicketPriceCacheModel)obj;

		if (id == ticketPriceCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", price=");
		sb.append(price);
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
	public TicketPrice toEntityModel() {
		TicketPriceImpl ticketPriceImpl = new TicketPriceImpl();

		ticketPriceImpl.setId(id);
		ticketPriceImpl.setPrice(price);

		if (createdBy == null) {
			ticketPriceImpl.setCreatedBy("");
		}
		else {
			ticketPriceImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			ticketPriceImpl.setModifiedBy("");
		}
		else {
			ticketPriceImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			ticketPriceImpl.setCreatedDate(null);
		}
		else {
			ticketPriceImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketPriceImpl.setModifiedDate(null);
		}
		else {
			ticketPriceImpl.setModifiedDate(new Date(modifiedDate));
		}

		ticketPriceImpl.resetOriginalValues();

		return ticketPriceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		price = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(price);

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
	public long price;
	public String createdBy;
	public String modifiedBy;
	public long createdDate;
	public long modifiedDate;

}