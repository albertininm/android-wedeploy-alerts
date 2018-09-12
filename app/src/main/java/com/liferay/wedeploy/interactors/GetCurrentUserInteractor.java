package com.liferay.wedeploy.interactors;

import android.content.Context;
import android.util.Log;
import com.liferay.wedeploy.util.APIClient;
import com.liferay.wedeploy.util.KeysConstants;
import com.liferay.wedeploy.util.PreferencesUtil;
import com.wedeploy.android.Callback;
import com.wedeploy.android.auth.Authorization;
import com.wedeploy.android.auth.TokenAuthorization;
import com.wedeploy.android.transport.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Albertinin Santos
 */
public class GetCurrentUserInteractor {

	public void execute(Context context, String token, Callback callback) {

		Authorization authorization = new TokenAuthorization(token);

		PreferencesUtil.Companion.saveStringByToken(context, KeysConstants.TOKEN, authorization.getToken());
		APIClient.Companion.getCurrentUser(authorization, new Callback() {

			public void onSuccess(Response response) {
				getCurrentUserSuccess(context, response);
				callback.onSuccess(response);
			}

			public void onFailure(Exception e) {
				Log.e("error", e.getMessage());
			}
		});
	}

	private void getCurrentUserSuccess(Context context, Response response) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(response.getBody());
			PreferencesUtil.Companion.saveStringByToken(context, KeysConstants.PHOTO_URL,
				jsonObject.getString(KeysConstants.PHOTO_URL));
		} catch (JSONException e) {
			Log.e("error", e.getMessage());
		}
	}
}
