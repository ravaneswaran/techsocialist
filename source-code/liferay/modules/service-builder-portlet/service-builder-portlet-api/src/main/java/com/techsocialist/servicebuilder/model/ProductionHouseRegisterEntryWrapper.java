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
 * This class is a wrapper for {@link ProductionHouseRegisterEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterEntry
 * @generated
 */
public class ProductionHouseRegisterEntryWrapper
	extends BaseModelWrapper<ProductionHouseRegisterEntry>
	implements ModelWrapper<ProductionHouseRegisterEntry>,
			   ProductionHouseRegisterEntry {

	public ProductionHouseRegisterEntryWrapper(
		ProductionHouseRegisterEntry productionHouseRegisterEntry) {

		super(productionHouseRegisterEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("cin", getCin());
		attributes.put("landline", getLandline());
		attributes.put("websiteUrl", getWebsiteUrl());
		attributes.put("addressLine1", getAddressLine1());
		attributes.put("addressLine2", getAddressLine2());
		attributes.put("addressLine3", getAddressLine3());
		attributes.put("place", getPlace());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("pincode", getPincode());
		attributes.put("status", getStatus());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonMobile", getContactPersonMobile());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("userName", getUserName());
		attributes.put("password", getPassword());
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String cin = (String)attributes.get("cin");

		if (cin != null) {
			setCin(cin);
		}

		String landline = (String)attributes.get("landline");

		if (landline != null) {
			setLandline(landline);
		}

		String websiteUrl = (String)attributes.get("websiteUrl");

		if (websiteUrl != null) {
			setWebsiteUrl(websiteUrl);
		}

		String addressLine1 = (String)attributes.get("addressLine1");

		if (addressLine1 != null) {
			setAddressLine1(addressLine1);
		}

		String addressLine2 = (String)attributes.get("addressLine2");

		if (addressLine2 != null) {
			setAddressLine2(addressLine2);
		}

		String addressLine3 = (String)attributes.get("addressLine3");

		if (addressLine3 != null) {
			setAddressLine3(addressLine3);
		}

		String place = (String)attributes.get("place");

		if (place != null) {
			setPlace(place);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String pincode = (String)attributes.get("pincode");

		if (pincode != null) {
			setPincode(pincode);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonMobile = (String)attributes.get(
			"contactPersonMobile");

		if (contactPersonMobile != null) {
			setContactPersonMobile(contactPersonMobile);
		}

		String contactPersonEmail = (String)attributes.get(
			"contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
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
	 * Returns the address line1 of this production house register entry.
	 *
	 * @return the address line1 of this production house register entry
	 */
	@Override
	public String getAddressLine1() {
		return model.getAddressLine1();
	}

	/**
	 * Returns the address line2 of this production house register entry.
	 *
	 * @return the address line2 of this production house register entry
	 */
	@Override
	public String getAddressLine2() {
		return model.getAddressLine2();
	}

	/**
	 * Returns the address line3 of this production house register entry.
	 *
	 * @return the address line3 of this production house register entry
	 */
	@Override
	public String getAddressLine3() {
		return model.getAddressLine3();
	}

	/**
	 * Returns the cin of this production house register entry.
	 *
	 * @return the cin of this production house register entry
	 */
	@Override
	public String getCin() {
		return model.getCin();
	}

	/**
	 * Returns the contact person email of this production house register entry.
	 *
	 * @return the contact person email of this production house register entry
	 */
	@Override
	public String getContactPersonEmail() {
		return model.getContactPersonEmail();
	}

	/**
	 * Returns the contact person mobile of this production house register entry.
	 *
	 * @return the contact person mobile of this production house register entry
	 */
	@Override
	public String getContactPersonMobile() {
		return model.getContactPersonMobile();
	}

	/**
	 * Returns the contact person name of this production house register entry.
	 *
	 * @return the contact person name of this production house register entry
	 */
	@Override
	public String getContactPersonName() {
		return model.getContactPersonName();
	}

	/**
	 * Returns the country of this production house register entry.
	 *
	 * @return the country of this production house register entry
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the created by of this production house register entry.
	 *
	 * @return the created by of this production house register entry
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this production house register entry.
	 *
	 * @return the created date of this production house register entry
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this production house register entry.
	 *
	 * @return the ID of this production house register entry
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the landline of this production house register entry.
	 *
	 * @return the landline of this production house register entry
	 */
	@Override
	public String getLandline() {
		return model.getLandline();
	}

	/**
	 * Returns the modified by of this production house register entry.
	 *
	 * @return the modified by of this production house register entry
	 */
	@Override
	public String getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this production house register entry.
	 *
	 * @return the modified date of this production house register entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this production house register entry.
	 *
	 * @return the name of this production house register entry
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the password of this production house register entry.
	 *
	 * @return the password of this production house register entry
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the pincode of this production house register entry.
	 *
	 * @return the pincode of this production house register entry
	 */
	@Override
	public String getPincode() {
		return model.getPincode();
	}

	/**
	 * Returns the place of this production house register entry.
	 *
	 * @return the place of this production house register entry
	 */
	@Override
	public String getPlace() {
		return model.getPlace();
	}

	/**
	 * Returns the primary key of this production house register entry.
	 *
	 * @return the primary key of this production house register entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state of this production house register entry.
	 *
	 * @return the state of this production house register entry
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the status of this production house register entry.
	 *
	 * @return the status of this production house register entry
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user name of this production house register entry.
	 *
	 * @return the user name of this production house register entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the website url of this production house register entry.
	 *
	 * @return the website url of this production house register entry
	 */
	@Override
	public String getWebsiteUrl() {
		return model.getWebsiteUrl();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address line1 of this production house register entry.
	 *
	 * @param addressLine1 the address line1 of this production house register entry
	 */
	@Override
	public void setAddressLine1(String addressLine1) {
		model.setAddressLine1(addressLine1);
	}

	/**
	 * Sets the address line2 of this production house register entry.
	 *
	 * @param addressLine2 the address line2 of this production house register entry
	 */
	@Override
	public void setAddressLine2(String addressLine2) {
		model.setAddressLine2(addressLine2);
	}

	/**
	 * Sets the address line3 of this production house register entry.
	 *
	 * @param addressLine3 the address line3 of this production house register entry
	 */
	@Override
	public void setAddressLine3(String addressLine3) {
		model.setAddressLine3(addressLine3);
	}

	/**
	 * Sets the cin of this production house register entry.
	 *
	 * @param cin the cin of this production house register entry
	 */
	@Override
	public void setCin(String cin) {
		model.setCin(cin);
	}

	/**
	 * Sets the contact person email of this production house register entry.
	 *
	 * @param contactPersonEmail the contact person email of this production house register entry
	 */
	@Override
	public void setContactPersonEmail(String contactPersonEmail) {
		model.setContactPersonEmail(contactPersonEmail);
	}

	/**
	 * Sets the contact person mobile of this production house register entry.
	 *
	 * @param contactPersonMobile the contact person mobile of this production house register entry
	 */
	@Override
	public void setContactPersonMobile(String contactPersonMobile) {
		model.setContactPersonMobile(contactPersonMobile);
	}

	/**
	 * Sets the contact person name of this production house register entry.
	 *
	 * @param contactPersonName the contact person name of this production house register entry
	 */
	@Override
	public void setContactPersonName(String contactPersonName) {
		model.setContactPersonName(contactPersonName);
	}

	/**
	 * Sets the country of this production house register entry.
	 *
	 * @param country the country of this production house register entry
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the created by of this production house register entry.
	 *
	 * @param createdBy the created by of this production house register entry
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this production house register entry.
	 *
	 * @param createdDate the created date of this production house register entry
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this production house register entry.
	 *
	 * @param id the ID of this production house register entry
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the landline of this production house register entry.
	 *
	 * @param landline the landline of this production house register entry
	 */
	@Override
	public void setLandline(String landline) {
		model.setLandline(landline);
	}

	/**
	 * Sets the modified by of this production house register entry.
	 *
	 * @param modifiedBy the modified by of this production house register entry
	 */
	@Override
	public void setModifiedBy(String modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this production house register entry.
	 *
	 * @param modifiedDate the modified date of this production house register entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this production house register entry.
	 *
	 * @param name the name of this production house register entry
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the password of this production house register entry.
	 *
	 * @param password the password of this production house register entry
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the pincode of this production house register entry.
	 *
	 * @param pincode the pincode of this production house register entry
	 */
	@Override
	public void setPincode(String pincode) {
		model.setPincode(pincode);
	}

	/**
	 * Sets the place of this production house register entry.
	 *
	 * @param place the place of this production house register entry
	 */
	@Override
	public void setPlace(String place) {
		model.setPlace(place);
	}

	/**
	 * Sets the primary key of this production house register entry.
	 *
	 * @param primaryKey the primary key of this production house register entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state of this production house register entry.
	 *
	 * @param state the state of this production house register entry
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the status of this production house register entry.
	 *
	 * @param status the status of this production house register entry
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user name of this production house register entry.
	 *
	 * @param userName the user name of this production house register entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the website url of this production house register entry.
	 *
	 * @param websiteUrl the website url of this production house register entry
	 */
	@Override
	public void setWebsiteUrl(String websiteUrl) {
		model.setWebsiteUrl(websiteUrl);
	}

	@Override
	protected ProductionHouseRegisterEntryWrapper wrap(
		ProductionHouseRegisterEntry productionHouseRegisterEntry) {

		return new ProductionHouseRegisterEntryWrapper(
			productionHouseRegisterEntry);
	}

}