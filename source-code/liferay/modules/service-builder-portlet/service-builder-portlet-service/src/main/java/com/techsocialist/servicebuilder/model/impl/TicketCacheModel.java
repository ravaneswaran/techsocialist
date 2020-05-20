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

import com.techsocialist.servicebuilder.model.Ticket;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ticket in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketCacheModel implements CacheModel<Ticket>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketCacheModel)) {
			return false;
		}

		TicketCacheModel ticketCacheModel = (TicketCacheModel)obj;

		if (id == ticketCacheModel.id) {
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
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", ticketPriceId=");
		sb.append(ticketPriceId);
		sb.append(", ticketTaxId=");
		sb.append(ticketTaxId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", purchaseTime=");
		sb.append(purchaseTime);
		sb.append(", soldTime=");
		sb.append(soldTime);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ticket toEntityModel() {
		TicketImpl ticketImpl = new TicketImpl();

		ticketImpl.setId(id);
		ticketImpl.setUserId(userId);
		ticketImpl.setVideoId(videoId);
		ticketImpl.setTicketPriceId(ticketPriceId);
		ticketImpl.setTicketTaxId(ticketTaxId);

		if (status == null) {
			ticketImpl.setStatus("");
		}
		else {
			ticketImpl.setStatus(status);
		}

		if (purchaseTime == Long.MIN_VALUE) {
			ticketImpl.setPurchaseTime(null);
		}
		else {
			ticketImpl.setPurchaseTime(new Date(purchaseTime));
		}

		if (soldTime == Long.MIN_VALUE) {
			ticketImpl.setSoldTime(null);
		}
		else {
			ticketImpl.setSoldTime(new Date(soldTime));
		}

		if (createdDate == Long.MIN_VALUE) {
			ticketImpl.setCreatedDate(null);
		}
		else {
			ticketImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketImpl.setModifiedDate(null);
		}
		else {
			ticketImpl.setModifiedDate(new Date(modifiedDate));
		}

		ticketImpl.resetOriginalValues();

		return ticketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		userId = objectInput.readLong();

		videoId = objectInput.readLong();

		ticketPriceId = objectInput.readLong();

		ticketTaxId = objectInput.readLong();
		status = objectInput.readUTF();
		purchaseTime = objectInput.readLong();
		soldTime = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(videoId);

		objectOutput.writeLong(ticketPriceId);

		objectOutput.writeLong(ticketTaxId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(purchaseTime);
		objectOutput.writeLong(soldTime);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public long userId;
	public long videoId;
	public long ticketPriceId;
	public long ticketTaxId;
	public String status;
	public long purchaseTime;
	public long soldTime;
	public long createdDate;
	public long modifiedDate;

}