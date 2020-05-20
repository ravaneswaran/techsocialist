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
 * This class is a wrapper for {@link TicketPrice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketPrice
 * @generated
 */
public class TicketPriceWrapper
	extends BaseModelWrapper<TicketPrice>
	implements ModelWrapper<TicketPrice>, TicketPrice {

	public TicketPriceWrapper(TicketPrice ticketPrice) {
		super(ticketPrice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("price", getPrice());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the created by of this ticket price.
	 *
	 * @return the created by of this ticket price
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this ticket price.
	 *
	 * @return the created date of this ticket price
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this ticket price.
	 *
	 * @return the ID of this ticket price
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified by of this ticket price.
	 *
	 * @return the modified by of this ticket price
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this ticket price.
	 *
	 * @return the modified date of this ticket price
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the price of this ticket price.
	 *
	 * @return the price of this ticket price
	 */
	@Override
	public long getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this ticket price.
	 *
	 * @return the primary key of this ticket price
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created by of this ticket price.
	 *
	 * @param createdBy the created by of this ticket price
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this ticket price.
	 *
	 * @param createdDate the created date of this ticket price
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this ticket price.
	 *
	 * @param id the ID of this ticket price
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified by of this ticket price.
	 *
	 * @param modifiedBy the modified by of this ticket price
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this ticket price.
	 *
	 * @param modifiedDate the modified date of this ticket price
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the price of this ticket price.
	 *
	 * @param price the price of this ticket price
	 */
	@Override
	public void setPrice(long price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this ticket price.
	 *
	 * @param primaryKey the primary key of this ticket price
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected TicketPriceWrapper wrap(TicketPrice ticketPrice) {
		return new TicketPriceWrapper(ticketPrice);
	}

}