package com.liferay.wedeploy.interactors;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.wedeploy.activities.callbacks.APICallback;
import com.liferay.wedeploy.model.Project;
import com.liferay.wedeploy.util.APIClient;
import com.liferay.wedeploy.util.Constants;
import com.wedeploy.android.Callback;
import com.wedeploy.android.auth.Authorization;
import com.wedeploy.android.auth.TokenAuthorization;
import com.wedeploy.android.transport.Response;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Albertinin Santos
 */
public class LoadProjectsInteractor {

	public void execute(String token, APICallback<List<Project>> apiCallback) {

		Authorization authorization = new TokenAuthorization(token);

		APIClient.load(authorization, Constants.PATH_PROJECT, new Callback() {
			public void onSuccess(Response response) {
				apiCallback.onSuccess(jsonToList(response.getBody()));
			}

			public void onFailure(Exception e) {
				Log.e("error", e.getMessage());
			}
		});
	}

	private List<Project> jsonToList(String json) {
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Project>>() {
		}.getType();

		return gson.fromJson(json, listType);
	}
}
