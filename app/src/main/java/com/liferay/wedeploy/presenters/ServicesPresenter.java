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
import com.liferay.wedeploy.activities.interfaces.ServicesView;
import com.liferay.wedeploy.interactors.LoadServicesInteractor;
import com.liferay.wedeploy.interactors.RestartServiceInteractor;
import com.liferay.wedeploy.model.Service;
import com.liferay.wedeploy.util.KeysConstants;
import com.liferay.wedeploy.util.PreferencesUtil;
import com.wedeploy.android.Callback;
import com.wedeploy.android.transport.Response;

/**
 * @author Albertinin Santos
 */
public class ServicesPresenter extends Presenter<ServicesView> {

	private String token;

	public void onCreate() {
		//This is bad, ideally we would create an abstraction to not use the android SDK here
		token = PreferencesUtil.getStringByToken(((Activity) view).getApplicationContext(), KeysConstants.TOKEN);
		view.setToolbarTitle();
	}

	public void onStart() {
		String projectId = view.getProjectId();

		new LoadServicesInteractor().execute(token, projectId, services -> view.renderServices(services));
	}

	public void restartServiceButtonClick(Service service) {
		new RestartServiceInteractor().execute(token, service, new Callback() {

			public void onSuccess(Response response) {
				view.showRestarServiceResult(false);
			}

			public void onFailure(Exception e) {
				view.showRestarServiceResult(true);
			}
		});
	}
}
