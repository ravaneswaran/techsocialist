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
 * This class is a wrapper for {@link TicketTax}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketTax
 * @generated
 */
public class TicketTaxWrapper
	extends BaseModelWrapper<TicketTax>
	implements ModelWrapper<TicketTax>, TicketTax {

	public TicketTaxWrapper(TicketTax ticketTax) {
		super(ticketTax);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("percent", getPercent());
		attributes.put("enabled", isEnabled());
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

		Long percent = (Long)attributes.get("percent");

		if (percent != null) {
			setPercent(percent);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
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
	 * Returns the created by of this ticket tax.
	 *
	 * @return the created by of this ticket tax
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this ticket tax.
	 *
	 * @return the created date of this ticket tax
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the enabled of this ticket tax.
	 *
	 * @return the enabled of this ticket tax
	 */
	@Override
	public boolean getEnabled() {
		return model.getEnabled();
	}

	/**
	 * Returns the ID of this ticket tax.
	 *
	 * @return the ID of this ticket tax
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified by of this ticket tax.
	 *
	 * @return the modified by of this ticket tax
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this ticket tax.
	 *
	 * @return the modified date of this ticket tax
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the percent of this ticket tax.
	 *
	 * @return the percent of this ticket tax
	 */
	@Override
	public long getPercent() {
		return model.getPercent();
	}

	/**
	 * Returns the primary key of this ticket tax.
	 *
	 * @return the primary key of this ticket tax
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this ticket tax is enabled.
	 *
	 * @return <code>true</code> if this ticket tax is enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnabled() {
		return model.isEnabled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the created by of this ticket tax.
	 *
	 * @param createdBy the created by of this ticket tax
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this ticket tax.
	 *
	 * @param createdDate the created date of this ticket tax
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets whether this ticket tax is enabled.
	 *
	 * @param enabled the enabled of this ticket tax
	 */
	@Override
	public void setEnabled(boolean enabled) {
		model.setEnabled(enabled);
	}

	/**
	 * Sets the ID of this ticket tax.
	 *
	 * @param id the ID of this ticket tax
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified by of this ticket tax.
	 *
	 * @param modifiedBy the modified by of this ticket tax
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this ticket tax.
	 *
	 * @param modifiedDate the modified date of this ticket tax
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the percent of this ticket tax.
	 *
	 * @param percent the percent of this ticket tax
	 */
	@Override
	public void setPercent(long percent) {
		model.setPercent(percent);
	}

	/**
	 * Sets the primary key of this ticket tax.
	 *
	 * @param primaryKey the primary key of this ticket tax
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected TicketTaxWrapper wrap(TicketTax ticketTax) {
		return new TicketTaxWrapper(ticketTax);
	}

}