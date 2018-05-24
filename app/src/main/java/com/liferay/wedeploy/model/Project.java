/*
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

import android.support.annotation.NonNull;
import com.liferay.wedeploy.util.Constants;

/**
 * @author Albertinin Mourato
 */
public class Project implements Comparable<Project> {

	private String health;
	private String projectId;

	private String masterToken;
	private String id;
	private String ownerId;

	public Project(String id, String projectId, String health, String masterToken, String ownerId) {
		this.id = id;
		this.projectId = projectId;
		this.health = health;
		this.masterToken = masterToken;
		this.ownerId = ownerId;
	}

	public String getId() {
		return projectId;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getHealth() {
		return health;
	}

	public boolean isHealthy() {
		return getHealth().equals(Constants.HEALTHY);
	}

	public boolean isUnhealthy() {
		return getHealth().equals(Constants.UNHEALTHY);
	}

	public String getMasterToken() {
		return masterToken;
	}

	public String getOwnerId() {
		return ownerId;
	}

	@Override
	public int compareTo(@NonNull Project o) {
		if (this.isUnhealthy()) {
			if (o.isUnhealthy()) return 0;
			return -1;
		}
		if (o.isUnhealthy()) {
			return 1;
		}
		return 0;
	}
}