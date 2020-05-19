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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Ticket}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ticket
 * @generated
 */
public class TicketWrapper
	extends BaseModelWrapper<Ticket> implements ModelWrapper<Ticket>, Ticket {

	public TicketWrapper(Ticket ticket) {
		super(ticket);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("videoEntryId", getVideoEntryId());
		attributes.put("status", getStatus());
		attributes.put("purchaseTime", getPurchaseTime());
		attributes.put("soldTime", getSoldTime());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long videoEntryId = (Long)attributes.get("videoEntryId");

		if (videoEntryId != null) {
			setVideoEntryId(videoEntryId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date purchaseTime = (Date)attributes.get("purchaseTime");

		if (purchaseTime != null) {
			setPurchaseTime(purchaseTime);
		}

		Date soldTime = (Date)attributes.get("soldTime");

		if (soldTime != null) {
			setSoldTime(soldTime);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	 * Returns the created date of this ticket.
	 *
	 * @return the created date of this ticket
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this ticket.
	 *
	 * @return the ID of this ticket
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this ticket.
	 *
	 * @return the primary key of this ticket
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchase time of this ticket.
	 *
	 * @return the purchase time of this ticket
	 */
	@Override
	public Date getPurchaseTime() {
		return model.getPurchaseTime();
	}

	/**
	 * Returns the sold time of this ticket.
	 *
	 * @return the sold time of this ticket
	 */
	@Override
	public Date getSoldTime() {
		return model.getSoldTime();
	}

	/**
	 * Returns the status of this ticket.
	 *
	 * @return the status of this ticket
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this ticket.
	 *
	 * @return the user ID of this ticket
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this ticket.
	 *
	 * @return the user uuid of this ticket
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the video entry ID of this ticket.
	 *
	 * @return the video entry ID of this ticket
	 */
	@Override
	public long getVideoEntryId() {
		return model.getVideoEntryId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created date of this ticket.
	 *
	 * @param createdDate the created date of this ticket
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this ticket.
	 *
	 * @param id the ID of this ticket
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this ticket.
	 *
	 * @param primaryKey the primary key of this ticket
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchase time of this ticket.
	 *
	 * @param purchaseTime the purchase time of this ticket
	 */
	@Override
	public void setPurchaseTime(Date purchaseTime) {
		model.setPurchaseTime(purchaseTime);
	}

	/**
	 * Sets the sold time of this ticket.
	 *
	 * @param soldTime the sold time of this ticket
	 */
	@Override
	public void setSoldTime(Date soldTime) {
		model.setSoldTime(soldTime);
	}

	/**
	 * Sets the status of this ticket.
	 *
	 * @param status the status of this ticket
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this ticket.
	 *
	 * @param userId the user ID of this ticket
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this ticket.
	 *
	 * @param userUuid the user uuid of this ticket
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the video entry ID of this ticket.
	 *
	 * @param videoEntryId the video entry ID of this ticket
	 */
	@Override
	public void setVideoEntryId(long videoEntryId) {
		model.setVideoEntryId(videoEntryId);
	}

	@Override
	protected TicketWrapper wrap(Ticket ticket) {
		return new TicketWrapper(ticket);
	}

}