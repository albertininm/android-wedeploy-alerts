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

package com.liferay.wedeploy.presenters;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.interfaces.ProjectView;
import com.liferay.wedeploy.enums.ProjectListStateEnum;
import com.liferay.wedeploy.interactors.LoadProjectsInteractor;
import com.liferay.wedeploy.model.Project;
import com.liferay.wedeploy.util.Constants;
import com.liferay.wedeploy.util.KeysConstants;
import com.liferay.wedeploy.util.PreferencesUtil;
import com.liferay.wedeploy.util.WeDeploySocket;
import java.util.List;

/**
 * @author Albertinin Santos
 */
public class ProjectsActivityPresenter extends Presenter<ProjectView> {

	private String token;
	private WeDeploySocket weDeploySocket;

	public void onCreate() {
		token = PreferencesUtil.getStringByToken(((Activity) view).getApplicationContext(), KeysConstants.TOKEN);
	}

	public void onStart() {
		getProjects();
		startSocket();
	}

	private void getProjects() {
		new LoadProjectsInteractor().execute(token, list -> {
			if (list.size() > 0) {
				view.renderProjects(list);
				view.setListOfProjects(ProjectListStateEnum.HAS_PROJECT_STATE);
				long unhealthyProjects = unHealthyCounter(list);
				Log.d("qtdUnhealthy", unhealthyProjects + "");
				if (unHealthyCounter(list) > 0) view.showUnhealthyProjectBar(unhealthyProjects);
			} else {
				view.setListOfProjects(ProjectListStateEnum.NO_PROJECT_STATE);
			}
		});
	}

	public long unHealthyCounter(List<Project> projects) {
		return projects.stream().filter(p -> p.getHealth().equals("unhealthy")).count();
	}

	public void onStop() {
		weDeploySocket.disconnect();
	}

	public void startSocket() {
		try {
			weDeploySocket = new WeDeploySocket(((Activity) view).getApplicationContext());
			weDeploySocket.onConnect(args -> {
				for (int i = 0; i < args.length; i++) {
					Log.i("connect", args[i].toString());
				}
			}).onDisconnect(args -> {
				for (int i = 0; i < args.length; i++) {
					Log.i("disconect", args[i].toString());
				}
			}).onChanges(args -> {
				for (int i = 0; i < args.length; i++) {
					Log.i("changes", args[i].toString());
				}
			}).connect();
		} catch (Exception e) {
			Log.e("error", e.getMessage());
		}
	}

	public void openConsole() {
		CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
		builder.setToolbarColor(((Activity) view).getColor(R.color.white));
		builder.setSecondaryToolbarColor(
			ContextCompat.getColor(((Activity) view).getApplicationContext(), R.color.colorPrimaryDark));

		Bitmap bitmap = BitmapFactory.decodeResource(((Activity) view).getResources(), R.drawable.arrow_left);
		builder.setCloseButtonIcon(bitmap);

		CustomTabsIntent customTabsIntent = builder.build();
		customTabsIntent.launchUrl(((Activity) view).getApplicationContext(), Uri.parse(Constants.CONSOLE_URL));
	}
}
