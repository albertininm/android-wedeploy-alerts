package com.liferay.wedeploy.interactors;

import com.liferay.wedeploy.model.Service;
import com.liferay.wedeploy.util.APIClient;
import com.wedeploy.android.Callback;
import com.wedeploy.android.auth.Authorization;
import com.wedeploy.android.auth.TokenAuthorization;

/**
 * @author Albertinin Santos
 */
public class RestartServiceInteractor {

	private static String getPath(Service service) {
		return "projects/" + service.getProjectId() + "/services/" + service.getServiceId() + "/restart";
	}

	public void execute(String token, Service service, Callback callback) {

		Authorization authorization = new TokenAuthorization(token);

		APIClient.restartService(authorization, getPath(service), callback);
	}
}
