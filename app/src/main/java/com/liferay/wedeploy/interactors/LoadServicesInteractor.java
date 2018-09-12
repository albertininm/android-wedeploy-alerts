package com.liferay.wedeploy.interactors;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.wedeploy.activities.callbacks.APICallback;
import com.liferay.wedeploy.model.Service;
import com.liferay.wedeploy.util.APIClient;
import com.wedeploy.android.Callback;
import com.wedeploy.android.auth.Authorization;
import com.wedeploy.android.auth.TokenAuthorization;
import com.wedeploy.android.transport.Response;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Albertinin Santos
 */
public class LoadServicesInteractor {

	public void execute(String token, String projectId, APICallback<List<Service>> apiCallback) {

		Authorization authorization = new TokenAuthorization(token);

		APIClient.Companion.loadProjects(authorization, getPath(projectId), new Callback() {

			public void onSuccess(Response response) {
				apiCallback.onSuccess(jsonToList(response.getBody()));
			}

			public void onFailure(Exception e) {
				Log.e("error", e.getMessage());
			}
		});
	}

	private List<Service> jsonToList(String json) {

		Gson gson = new Gson();
		Type type = new TypeToken<List<Service>>() {
		}.getType();

		return gson.fromJson(json, type);
	}

	private String getPath(String projectId) {
		return "projects/" + projectId + "/services";
	}
}
