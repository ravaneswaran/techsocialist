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
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Video
 * @generated
 */
public class VideoWrapper
	extends BaseModelWrapper<Video> implements ModelWrapper<Video>, Video {

	public VideoWrapper(Video video) {
		super(video);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("userId", getUserId());
		attributes.put("productionHouseId", getProductionHouseId());
		attributes.put("name", getName());
		attributes.put("thumbnail", getThumbnail());
		attributes.put("content", getContent());
		attributes.put("type", getType());
		attributes.put("status", getStatus());
		attributes.put("ticketPrice", getTicketPrice());
		attributes.put("publishDateTime", getPublishDateTime());
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long productionHouseId = (Long)attributes.get("productionHouseId");

		if (productionHouseId != null) {
			setProductionHouseId(productionHouseId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Blob thumbnail = (Blob)attributes.get("thumbnail");

		if (thumbnail != null) {
			setThumbnail(thumbnail);
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

		Double ticketPrice = (Double)attributes.get("ticketPrice");

		if (ticketPrice != null) {
			setTicketPrice(ticketPrice);
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
	 * Returns the content of this video.
	 *
	 * @return the content of this video
	 */
	@Override
	public Blob getContent() {
		return model.getContent();
	}

	/**
	 * Returns the created by of this video.
	 *
	 * @return the created by of this video
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this video.
	 *
	 * @return the created date of this video
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this video.
	 *
	 * @return the ID of this video
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified by of this video.
	 *
	 * @return the modified by of this video
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this video.
	 *
	 * @return the modified date of this video
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this video.
	 *
	 * @return the name of this video
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the production house ID of this video.
	 *
	 * @return the production house ID of this video
	 */
	@Override
	public long getProductionHouseId() {
		return model.getProductionHouseId();
	}

	/**
	 * Returns the publish date time of this video.
	 *
	 * @return the publish date time of this video
	 */
	@Override
	public long getPublishDateTime() {
		return model.getPublishDateTime();
	}

	/**
	 * Returns the status of this video.
	 *
	 * @return the status of this video
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the thumbnail of this video.
	 *
	 * @return the thumbnail of this video
	 */
	@Override
	public Blob getThumbnail() {
		return model.getThumbnail();
	}

	/**
	 * Returns the ticket price of this video.
	 *
	 * @return the ticket price of this video
	 */
	@Override
	public double getTicketPrice() {
		return model.getTicketPrice();
	}

	/**
	 * Returns the type of this video.
	 *
	 * @return the type of this video
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this video.
	 *
	 * @return the user ID of this video
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this video.
	 *
	 * @return the user uuid of this video
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the content of this video.
	 *
	 * @param content the content of this video
	 */
	@Override
	public void setContent(Blob content) {
		model.setContent(content);
	}

	/**
	 * Sets the created by of this video.
	 *
	 * @param createdBy the created by of this video
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this video.
	 *
	 * @param createdDate the created date of this video
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this video.
	 *
	 * @param id the ID of this video
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified by of this video.
	 *
	 * @param modifiedBy the modified by of this video
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this video.
	 *
	 * @param modifiedDate the modified date of this video
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this video.
	 *
	 * @param name the name of this video
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the production house ID of this video.
	 *
	 * @param productionHouseId the production house ID of this video
	 */
	@Override
	public void setProductionHouseId(long productionHouseId) {
		model.setProductionHouseId(productionHouseId);
	}

	/**
	 * Sets the publish date time of this video.
	 *
	 * @param publishDateTime the publish date time of this video
	 */
	@Override
	public void setPublishDateTime(long publishDateTime) {
		model.setPublishDateTime(publishDateTime);
	}

	/**
	 * Sets the status of this video.
	 *
	 * @param status the status of this video
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the thumbnail of this video.
	 *
	 * @param thumbnail the thumbnail of this video
	 */
	@Override
	public void setThumbnail(Blob thumbnail) {
		model.setThumbnail(thumbnail);
	}

	/**
	 * Sets the ticket price of this video.
	 *
	 * @param ticketPrice the ticket price of this video
	 */
	@Override
	public void setTicketPrice(double ticketPrice) {
		model.setTicketPrice(ticketPrice);
	}

	/**
	 * Sets the type of this video.
	 *
	 * @param type the type of this video
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this video.
	 *
	 * @param userId the user ID of this video
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this video.
	 *
	 * @param userUuid the user uuid of this video
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected VideoWrapper wrap(Video video) {
		return new VideoWrapper(video);
	}

}