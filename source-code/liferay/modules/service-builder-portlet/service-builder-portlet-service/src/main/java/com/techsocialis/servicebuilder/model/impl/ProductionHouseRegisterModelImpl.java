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

package com.techsocialis.servicebuilder.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.techsocialis.servicebuilder.model.ProductionHouseRegister;
import com.techsocialis.servicebuilder.model.ProductionHouseRegisterModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProductionHouseRegister service. Represents a row in the &quot;production_house_register&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProductionHouseRegisterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductionHouseRegisterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouseRegisterImpl
 * @generated
 */
public class ProductionHouseRegisterModelImpl
	extends BaseModelImpl<ProductionHouseRegister>
	implements ProductionHouseRegisterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a production house register model instance should use the <code>ProductionHouseRegister</code> interface instead.
	 */
	public static final String TABLE_NAME = "production_house_register";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"name", Types.VARCHAR}, {"cin", Types.VARCHAR},
		{"landline", Types.VARCHAR}, {"websiteUrl", Types.VARCHAR},
		{"addressLine1", Types.VARCHAR}, {"addressLine2", Types.VARCHAR},
		{"addressLine3", Types.VARCHAR}, {"place", Types.VARCHAR},
		{"state_", Types.VARCHAR}, {"country", Types.VARCHAR},
		{"pincode", Types.VARCHAR}, {"status", Types.VARCHAR},
		{"contactPersonName", Types.VARCHAR},
		{"contactPersonMobile", Types.VARCHAR},
		{"contactPersonEmail", Types.VARCHAR}, {"userName", Types.VARCHAR},
		{"password_", Types.VARCHAR}, {"createdBy", Types.VARCHAR},
		{"modifiedBy", Types.VARCHAR}, {"createdDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cin", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("landline", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("websiteUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addressLine1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addressLine2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("addressLine3", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("place", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("country", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("pincode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonMobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("contactPersonEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("modifiedBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table production_house_register (id_ LONG not null primary key,name VARCHAR(75) null,cin VARCHAR(75) null,landline VARCHAR(75) null,websiteUrl VARCHAR(75) null,addressLine1 VARCHAR(75) null,addressLine2 VARCHAR(75) null,addressLine3 VARCHAR(75) null,place VARCHAR(75) null,state_ VARCHAR(75) null,country VARCHAR(75) null,pincode VARCHAR(75) null,status VARCHAR(75) null,contactPersonName VARCHAR(75) null,contactPersonMobile VARCHAR(75) null,contactPersonEmail VARCHAR(75) null,userName VARCHAR(75) null,password_ VARCHAR(75) null,createdBy VARCHAR(75) null,modifiedBy VARCHAR(75) null,createdDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table production_house_register";

	public static final String ORDER_BY_JPQL =
		" ORDER BY productionHouseRegister.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY production_house_register.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public ProductionHouseRegisterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProductionHouseRegister.class;
	}

	@Override
	public String getModelClassName() {
		return ProductionHouseRegister.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProductionHouseRegister, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProductionHouseRegister, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductionHouseRegister, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProductionHouseRegister)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProductionHouseRegister, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProductionHouseRegister, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProductionHouseRegister)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProductionHouseRegister, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProductionHouseRegister, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProductionHouseRegister>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProductionHouseRegister.class.getClassLoader(),
			ProductionHouseRegister.class, ModelWrapper.class);

		try {
			Constructor<ProductionHouseRegister> constructor =
				(Constructor<ProductionHouseRegister>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ProductionHouseRegister, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<ProductionHouseRegister, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProductionHouseRegister, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ProductionHouseRegister, Object>>();
		Map<String, BiConsumer<ProductionHouseRegister, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<ProductionHouseRegister, ?>>();

		attributeGetterFunctions.put("id", ProductionHouseRegister::getId);
		attributeSetterBiConsumers.put(
			"id",
			(BiConsumer<ProductionHouseRegister, Long>)
				ProductionHouseRegister::setId);
		attributeGetterFunctions.put("name", ProductionHouseRegister::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setName);
		attributeGetterFunctions.put("cin", ProductionHouseRegister::getCin);
		attributeSetterBiConsumers.put(
			"cin",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setCin);
		attributeGetterFunctions.put(
			"landline", ProductionHouseRegister::getLandline);
		attributeSetterBiConsumers.put(
			"landline",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setLandline);
		attributeGetterFunctions.put(
			"websiteUrl", ProductionHouseRegister::getWebsiteUrl);
		attributeSetterBiConsumers.put(
			"websiteUrl",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setWebsiteUrl);
		attributeGetterFunctions.put(
			"addressLine1", ProductionHouseRegister::getAddressLine1);
		attributeSetterBiConsumers.put(
			"addressLine1",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setAddressLine1);
		attributeGetterFunctions.put(
			"addressLine2", ProductionHouseRegister::getAddressLine2);
		attributeSetterBiConsumers.put(
			"addressLine2",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setAddressLine2);
		attributeGetterFunctions.put(
			"addressLine3", ProductionHouseRegister::getAddressLine3);
		attributeSetterBiConsumers.put(
			"addressLine3",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setAddressLine3);
		attributeGetterFunctions.put(
			"place", ProductionHouseRegister::getPlace);
		attributeSetterBiConsumers.put(
			"place",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setPlace);
		attributeGetterFunctions.put(
			"state", ProductionHouseRegister::getState);
		attributeSetterBiConsumers.put(
			"state",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setState);
		attributeGetterFunctions.put(
			"country", ProductionHouseRegister::getCountry);
		attributeSetterBiConsumers.put(
			"country",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setCountry);
		attributeGetterFunctions.put(
			"pincode", ProductionHouseRegister::getPincode);
		attributeSetterBiConsumers.put(
			"pincode",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setPincode);
		attributeGetterFunctions.put(
			"status", ProductionHouseRegister::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setStatus);
		attributeGetterFunctions.put(
			"contactPersonName", ProductionHouseRegister::getContactPersonName);
		attributeSetterBiConsumers.put(
			"contactPersonName",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setContactPersonName);
		attributeGetterFunctions.put(
			"contactPersonMobile",
			ProductionHouseRegister::getContactPersonMobile);
		attributeSetterBiConsumers.put(
			"contactPersonMobile",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setContactPersonMobile);
		attributeGetterFunctions.put(
			"contactPersonEmail",
			ProductionHouseRegister::getContactPersonEmail);
		attributeSetterBiConsumers.put(
			"contactPersonEmail",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setContactPersonEmail);
		attributeGetterFunctions.put(
			"userName", ProductionHouseRegister::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setUserName);
		attributeGetterFunctions.put(
			"password", ProductionHouseRegister::getPassword);
		attributeSetterBiConsumers.put(
			"password",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setPassword);
		attributeGetterFunctions.put(
			"createdBy", ProductionHouseRegister::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setCreatedBy);
		attributeGetterFunctions.put(
			"modifiedBy", ProductionHouseRegister::getModifiedBy);
		attributeSetterBiConsumers.put(
			"modifiedBy",
			(BiConsumer<ProductionHouseRegister, String>)
				ProductionHouseRegister::setModifiedBy);
		attributeGetterFunctions.put(
			"createdDate", ProductionHouseRegister::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<ProductionHouseRegister, Date>)
				ProductionHouseRegister::setCreatedDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProductionHouseRegister::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProductionHouseRegister, Date>)
				ProductionHouseRegister::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getCin() {
		if (_cin == null) {
			return "";
		}
		else {
			return _cin;
		}
	}

	@Override
	public void setCin(String cin) {
		_cin = cin;
	}

	@Override
	public String getLandline() {
		if (_landline == null) {
			return "";
		}
		else {
			return _landline;
		}
	}

	@Override
	public void setLandline(String landline) {
		_landline = landline;
	}

	@Override
	public String getWebsiteUrl() {
		if (_websiteUrl == null) {
			return "";
		}
		else {
			return _websiteUrl;
		}
	}

	@Override
	public void setWebsiteUrl(String websiteUrl) {
		_websiteUrl = websiteUrl;
	}

	@Override
	public String getAddressLine1() {
		if (_addressLine1 == null) {
			return "";
		}
		else {
			return _addressLine1;
		}
	}

	@Override
	public void setAddressLine1(String addressLine1) {
		_addressLine1 = addressLine1;
	}

	@Override
	public String getAddressLine2() {
		if (_addressLine2 == null) {
			return "";
		}
		else {
			return _addressLine2;
		}
	}

	@Override
	public void setAddressLine2(String addressLine2) {
		_addressLine2 = addressLine2;
	}

	@Override
	public String getAddressLine3() {
		if (_addressLine3 == null) {
			return "";
		}
		else {
			return _addressLine3;
		}
	}

	@Override
	public void setAddressLine3(String addressLine3) {
		_addressLine3 = addressLine3;
	}

	@Override
	public String getPlace() {
		if (_place == null) {
			return "";
		}
		else {
			return _place;
		}
	}

	@Override
	public void setPlace(String place) {
		_place = place;
	}

	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@Override
	public String getCountry() {
		if (_country == null) {
			return "";
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_country = country;
	}

	@Override
	public String getPincode() {
		if (_pincode == null) {
			return "";
		}
		else {
			return _pincode;
		}
	}

	@Override
	public void setPincode(String pincode) {
		_pincode = pincode;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@Override
	public String getContactPersonName() {
		if (_contactPersonName == null) {
			return "";
		}
		else {
			return _contactPersonName;
		}
	}

	@Override
	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	@Override
	public String getContactPersonMobile() {
		if (_contactPersonMobile == null) {
			return "";
		}
		else {
			return _contactPersonMobile;
		}
	}

	@Override
	public void setContactPersonMobile(String contactPersonMobile) {
		_contactPersonMobile = contactPersonMobile;
	}

	@Override
	public String getContactPersonEmail() {
		if (_contactPersonEmail == null) {
			return "";
		}
		else {
			return _contactPersonEmail;
		}
	}

	@Override
	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		_password = password;
	}

	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return "";
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	@Override
	public String getModifiedBy() {
		if (_modifiedBy == null) {
			return "";
		}
		else {
			return _modifiedBy;
		}
	}

	@Override
	public void setModifiedBy(String modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, ProductionHouseRegister.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProductionHouseRegister toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProductionHouseRegister>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProductionHouseRegisterImpl productionHouseRegisterImpl =
			new ProductionHouseRegisterImpl();

		productionHouseRegisterImpl.setId(getId());
		productionHouseRegisterImpl.setName(getName());
		productionHouseRegisterImpl.setCin(getCin());
		productionHouseRegisterImpl.setLandline(getLandline());
		productionHouseRegisterImpl.setWebsiteUrl(getWebsiteUrl());
		productionHouseRegisterImpl.setAddressLine1(getAddressLine1());
		productionHouseRegisterImpl.setAddressLine2(getAddressLine2());
		productionHouseRegisterImpl.setAddressLine3(getAddressLine3());
		productionHouseRegisterImpl.setPlace(getPlace());
		productionHouseRegisterImpl.setState(getState());
		productionHouseRegisterImpl.setCountry(getCountry());
		productionHouseRegisterImpl.setPincode(getPincode());
		productionHouseRegisterImpl.setStatus(getStatus());
		productionHouseRegisterImpl.setContactPersonName(
			getContactPersonName());
		productionHouseRegisterImpl.setContactPersonMobile(
			getContactPersonMobile());
		productionHouseRegisterImpl.setContactPersonEmail(
			getContactPersonEmail());
		productionHouseRegisterImpl.setUserName(getUserName());
		productionHouseRegisterImpl.setPassword(getPassword());
		productionHouseRegisterImpl.setCreatedBy(getCreatedBy());
		productionHouseRegisterImpl.setModifiedBy(getModifiedBy());
		productionHouseRegisterImpl.setCreatedDate(getCreatedDate());
		productionHouseRegisterImpl.setModifiedDate(getModifiedDate());

		productionHouseRegisterImpl.resetOriginalValues();

		return productionHouseRegisterImpl;
	}

	@Override
	public int compareTo(ProductionHouseRegister productionHouseRegister) {
		long primaryKey = productionHouseRegister.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductionHouseRegister)) {
			return false;
		}

		ProductionHouseRegister productionHouseRegister =
			(ProductionHouseRegister)obj;

		long primaryKey = productionHouseRegister.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ProductionHouseRegister> toCacheModel() {
		ProductionHouseRegisterCacheModel productionHouseRegisterCacheModel =
			new ProductionHouseRegisterCacheModel();

		productionHouseRegisterCacheModel.id = getId();

		productionHouseRegisterCacheModel.name = getName();

		String name = productionHouseRegisterCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			productionHouseRegisterCacheModel.name = null;
		}

		productionHouseRegisterCacheModel.cin = getCin();

		String cin = productionHouseRegisterCacheModel.cin;

		if ((cin != null) && (cin.length() == 0)) {
			productionHouseRegisterCacheModel.cin = null;
		}

		productionHouseRegisterCacheModel.landline = getLandline();

		String landline = productionHouseRegisterCacheModel.landline;

		if ((landline != null) && (landline.length() == 0)) {
			productionHouseRegisterCacheModel.landline = null;
		}

		productionHouseRegisterCacheModel.websiteUrl = getWebsiteUrl();

		String websiteUrl = productionHouseRegisterCacheModel.websiteUrl;

		if ((websiteUrl != null) && (websiteUrl.length() == 0)) {
			productionHouseRegisterCacheModel.websiteUrl = null;
		}

		productionHouseRegisterCacheModel.addressLine1 = getAddressLine1();

		String addressLine1 = productionHouseRegisterCacheModel.addressLine1;

		if ((addressLine1 != null) && (addressLine1.length() == 0)) {
			productionHouseRegisterCacheModel.addressLine1 = null;
		}

		productionHouseRegisterCacheModel.addressLine2 = getAddressLine2();

		String addressLine2 = productionHouseRegisterCacheModel.addressLine2;

		if ((addressLine2 != null) && (addressLine2.length() == 0)) {
			productionHouseRegisterCacheModel.addressLine2 = null;
		}

		productionHouseRegisterCacheModel.addressLine3 = getAddressLine3();

		String addressLine3 = productionHouseRegisterCacheModel.addressLine3;

		if ((addressLine3 != null) && (addressLine3.length() == 0)) {
			productionHouseRegisterCacheModel.addressLine3 = null;
		}

		productionHouseRegisterCacheModel.place = getPlace();

		String place = productionHouseRegisterCacheModel.place;

		if ((place != null) && (place.length() == 0)) {
			productionHouseRegisterCacheModel.place = null;
		}

		productionHouseRegisterCacheModel.state = getState();

		String state = productionHouseRegisterCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			productionHouseRegisterCacheModel.state = null;
		}

		productionHouseRegisterCacheModel.country = getCountry();

		String country = productionHouseRegisterCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			productionHouseRegisterCacheModel.country = null;
		}

		productionHouseRegisterCacheModel.pincode = getPincode();

		String pincode = productionHouseRegisterCacheModel.pincode;

		if ((pincode != null) && (pincode.length() == 0)) {
			productionHouseRegisterCacheModel.pincode = null;
		}

		productionHouseRegisterCacheModel.status = getStatus();

		String status = productionHouseRegisterCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			productionHouseRegisterCacheModel.status = null;
		}

		productionHouseRegisterCacheModel.contactPersonName =
			getContactPersonName();

		String contactPersonName =
			productionHouseRegisterCacheModel.contactPersonName;

		if ((contactPersonName != null) && (contactPersonName.length() == 0)) {
			productionHouseRegisterCacheModel.contactPersonName = null;
		}

		productionHouseRegisterCacheModel.contactPersonMobile =
			getContactPersonMobile();

		String contactPersonMobile =
			productionHouseRegisterCacheModel.contactPersonMobile;

		if ((contactPersonMobile != null) &&
			(contactPersonMobile.length() == 0)) {

			productionHouseRegisterCacheModel.contactPersonMobile = null;
		}

		productionHouseRegisterCacheModel.contactPersonEmail =
			getContactPersonEmail();

		String contactPersonEmail =
			productionHouseRegisterCacheModel.contactPersonEmail;

		if ((contactPersonEmail != null) &&
			(contactPersonEmail.length() == 0)) {

			productionHouseRegisterCacheModel.contactPersonEmail = null;
		}

		productionHouseRegisterCacheModel.userName = getUserName();

		String userName = productionHouseRegisterCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			productionHouseRegisterCacheModel.userName = null;
		}

		productionHouseRegisterCacheModel.password = getPassword();

		String password = productionHouseRegisterCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			productionHouseRegisterCacheModel.password = null;
		}

		productionHouseRegisterCacheModel.createdBy = getCreatedBy();

		String createdBy = productionHouseRegisterCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			productionHouseRegisterCacheModel.createdBy = null;
		}

		productionHouseRegisterCacheModel.modifiedBy = getModifiedBy();

		String modifiedBy = productionHouseRegisterCacheModel.modifiedBy;

		if ((modifiedBy != null) && (modifiedBy.length() == 0)) {
			productionHouseRegisterCacheModel.modifiedBy = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			productionHouseRegisterCacheModel.createdDate =
				createdDate.getTime();
		}
		else {
			productionHouseRegisterCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productionHouseRegisterCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			productionHouseRegisterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return productionHouseRegisterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProductionHouseRegister, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProductionHouseRegister, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductionHouseRegister, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((ProductionHouseRegister)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ProductionHouseRegister, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProductionHouseRegister, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProductionHouseRegister, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((ProductionHouseRegister)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, ProductionHouseRegister>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _id;
	private String _name;
	private String _cin;
	private String _landline;
	private String _websiteUrl;
	private String _addressLine1;
	private String _addressLine2;
	private String _addressLine3;
	private String _place;
	private String _state;
	private String _country;
	private String _pincode;
	private String _status;
	private String _contactPersonName;
	private String _contactPersonMobile;
	private String _contactPersonEmail;
	private String _userName;
	private String _password;
	private String _createdBy;
	private String _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private ProductionHouseRegister _escapedModel;

}