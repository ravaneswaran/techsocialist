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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the banner column in ProductionHouse.
 *
 * @author Brian Wing Shun Chan
 * @see ProductionHouse
 * @generated
 */
public class ProductionHouseBannerBlobModel {

	public ProductionHouseBannerBlobModel() {
	}

	public ProductionHouseBannerBlobModel(long id) {
		_id = id;
	}

	public ProductionHouseBannerBlobModel(long id, Blob bannerBlob) {
		_id = id;
		_bannerBlob = bannerBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getBannerBlob() {
		return _bannerBlob;
	}

	public void setBannerBlob(Blob bannerBlob) {
		_bannerBlob = bannerBlob;
	}

	private long _id;
	private Blob _bannerBlob;

}