/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Liferay, Inc. nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.liferay.wedeploy.model;

/**
 * @author Albertinin Mourato
 */
public class Service {



	private String health;
	private String id;
	private String serviceId;
	private String imageHint;
	private String projectId;
	private String recipeType;
	private String image;

	public Service(String id, String serviceId, String projectId, String health, String imageHint, String recipeType,
		String image) {
		this.id = id;
		this.health = health;
		this.imageHint = imageHint;
		this.projectId = projectId;
		this.recipeType = recipeType;
		this.image = image;
		this.serviceId = serviceId;
	}

	public String getHealth() {
		return health;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageHint() {
		return imageHint;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public String getImage() {
		return image;
	}

	public String getServiceId() {
		return serviceId;
	}

	public boolean isType(String type) {
		if (image != null && image.contains(type)) {
			return true;
		}

		if (imageHint != null && imageHint.contains(type)) {
			return true;
		}

		if (recipeType != null && recipeType.contains(type)) {
			return true;
		}

		return false;
	}
}