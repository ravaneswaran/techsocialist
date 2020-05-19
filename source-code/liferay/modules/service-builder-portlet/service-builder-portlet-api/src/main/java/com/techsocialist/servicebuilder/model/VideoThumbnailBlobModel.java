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
 * The Blob model class for lazy loading the thumbnail column in Video.
 *
 * @author Brian Wing Shun Chan
 * @see Video
 * @generated
 */
public class VideoThumbnailBlobModel {

	public VideoThumbnailBlobModel() {
	}

	public VideoThumbnailBlobModel(long id) {
		_id = id;
	}

	public VideoThumbnailBlobModel(long id, Blob thumbnailBlob) {
		_id = id;
		_thumbnailBlob = thumbnailBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getThumbnailBlob() {
		return _thumbnailBlob;
	}

	public void setThumbnailBlob(Blob thumbnailBlob) {
		_thumbnailBlob = thumbnailBlob;
	}

	private long _id;
	private Blob _thumbnailBlob;

}