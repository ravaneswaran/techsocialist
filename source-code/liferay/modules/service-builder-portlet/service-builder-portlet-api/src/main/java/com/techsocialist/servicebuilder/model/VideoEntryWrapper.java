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
 * This class is a wrapper for {@link VideoEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoEntry
 * @generated
 */
public class VideoEntryWrapper
	extends BaseModelWrapper<VideoEntry>
	implements ModelWrapper<VideoEntry>, VideoEntry {

	public VideoEntryWrapper(VideoEntry videoEntry) {
		super(videoEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("productionHouseEntryId", getProductionHouseEntryId());
		attributes.put("content", getContent());
		attributes.put("type", getType());
		attributes.put("status", getStatus());
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

		Long productionHouseEntryId = (Long)attributes.get(
			"productionHouseEntryId");

		if (productionHouseEntryId != null) {
			setProductionHouseEntryId(productionHouseEntryId);
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
	 * Returns the content of this video entry.
	 *
	 * @return the content of this video entry
	 */
	@Override
	public Blob getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by of this video entry.
	 *
	 * @return the created by of this video entry
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this video entry.
	 *
	 * @return the created date of this video entry
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this video entry.
	 *
	 * @return the ID of this video entry
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified by of this video entry.
	 *
	 * @return the modified by of this video entry
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this video entry.
	 *
	 * @return the modified date of this video entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this video entry.
	 *
	 * @return the primary key of this video entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the production house entry ID of this video entry.
	 *
	 * @return the production house entry ID of this video entry
	 */
	@Override
	public long getProductionHouseEntryId() {
		return model.getProductionHouseEntryId();
	}

	/**
	 * Returns the status of this video entry.
	 *
	 * @return the status of this video entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this video entry.
	 *
	 * @return the type of this video entry
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
	 * Sets the content of this video entry.
	 *
	 * @param content the content of this video entry
	 */
	@Override
	public void setContent(Blob content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by of this video entry.
	 *
	 * @param createdBy the created by of this video entry
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this video entry.
	 *
	 * @param createdDate the created date of this video entry
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this video entry.
	 *
	 * @param id the ID of this video entry
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified by of this video entry.
	 *
	 * @param modifiedBy the modified by of this video entry
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this video entry.
	 *
	 * @param modifiedDate the modified date of this video entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this video entry.
	 *
	 * @param primaryKey the primary key of this video entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the production house entry ID of this video entry.
	 *
	 * @param productionHouseEntryId the production house entry ID of this video entry
	 */
	@Override
	public void setProductionHouseEntryId(long productionHouseEntryId) {
		model.setProductionHouseEntryId(productionHouseEntryId);
	}

	/**
	 * Sets the status of this video entry.
	 *
	 * @param status the status of this video entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this video entry.
	 *
	 * @param type the type of this video entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected VideoEntryWrapper wrap(VideoEntry videoEntry) {
		return new VideoEntryWrapper(videoEntry);
	}

}