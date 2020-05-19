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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Poster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Poster
 * @generated
 */
public class PosterWrapper
	extends BaseModelWrapper<Poster> implements ModelWrapper<Poster>, Poster {

	public PosterWrapper(Poster poster) {
		super(poster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("productionHouseId", getProductionHouseId());
		attributes.put("name", getName());
		attributes.put("content", getContent());
		attributes.put("type", getType());
		attributes.put("status", getStatus());
		attributes.put("publishDateTime", getPublishDateTime());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long productionHouseId = (Long)attributes.get("productionHouseId");

		if (productionHouseId != null) {
			setProductionHouseId(productionHouseId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Blob content = (Blob)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long publishDateTime = (Long)attributes.get("publishDateTime");

		if (publishDateTime != null) {
			setPublishDateTime(publishDateTime);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	 * Returns the content of this poster.
	 *
	 * @return the content of this poster
	 */
	@Override
	public Blob getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by of this poster.
	 *
	 * @return the created by of this poster
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this poster.
	 *
	 * @return the created date of this poster
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this poster.
	 *
	 * @return the ID of this poster
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified by of this poster.
	 *
	 * @return the modified by of this poster
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this poster.
	 *
	 * @return the modified date of this poster
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this poster.
	 *
	 * @return the name of this poster
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this poster.
	 *
	 * @return the primary key of this poster
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the production house ID of this poster.
	 *
	 * @return the production house ID of this poster
	 */
	@Override
	public long getProductionHouseId() {
		return model.getProductionHouseId();
	}

	/**
	 * Returns the publish date time of this poster.
	 *
	 * @return the publish date time of this poster
	 */
	@Override
	public long getPublishDateTime() {
		return model.getPublishDateTime();
	}

	/**
	 * Returns the status of this poster.
	 *
	 * @return the status of this poster
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this poster.
	 *
	 * @return the type of this poster
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the content of this poster.
	 *
	 * @param content the content of this poster
	 */
	@Override
	public void setContent(Blob content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by of this poster.
	 *
	 * @param createdBy the created by of this poster
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this poster.
	 *
	 * @param createdDate the created date of this poster
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this poster.
	 *
	 * @param id the ID of this poster
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified by of this poster.
	 *
	 * @param modifiedBy the modified by of this poster
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this poster.
	 *
	 * @param modifiedDate the modified date of this poster
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this poster.
	 *
	 * @param name the name of this poster
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this poster.
	 *
	 * @param primaryKey the primary key of this poster
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the production house ID of this poster.
	 *
	 * @param productionHouseId the production house ID of this poster
	 */
	@Override
	public void setProductionHouseId(long productionHouseId) {
		model.setProductionHouseId(productionHouseId);
	}

	/**
	 * Sets the publish date time of this poster.
	 *
	 * @param publishDateTime the publish date time of this poster
	 */
	@Override
	public void setPublishDateTime(long publishDateTime) {
		model.setPublishDateTime(publishDateTime);
	}

	/**
	 * Sets the status of this poster.
	 *
	 * @param status the status of this poster
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this poster.
	 *
	 * @param type the type of this poster
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected PosterWrapper wrap(Poster poster) {
		return new PosterWrapper(poster);
	}

}