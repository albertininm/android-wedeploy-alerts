package com.liferay.wedeploy.util;

import android.app.Activity;
import android.util.Log;
import com.wedeploy.android.Callback;
import com.wedeploy.android.WeDeploy;
import com.wedeploy.android.auth.Authorization;
import com.wedeploy.android.auth.ProviderAuthorization;

/**
 * @author Albertinin Santos
 */
public class APIClient {
	private static WeDeploy weDeploy = new WeDeploy.Builder().build();

	public static void signIn(String email, String password, Callback callback) {
		weDeploy.url(Constants.API_URL)
			.path("login")
			.form("email", email)
			.form("password", password)
			.post()
			.execute(callback);
	}

	public static void signInWithProvider(Activity activity, ProviderAuthorization providerAuthorization) {
		Log.d("provider ", providerAuthorization.getAuthUrl()
			+ " "
			+ providerAuthorization.getProviderScope()
			+ " "
			+ providerAuthorization.getRedirectUri());
		weDeploy.auth(Constants.API_URL).signIn(activity, providerAuthorization);
	}

	public static void restartService(Authorization authorization, String path, Callback callback) {
		weDeploy.url(Constants.API_URL)
			.authorization(authorization)
			.path(path)
			.form("email", "sometext")
			.post()
			.execute(callback);
	}

	public static void load(Authorization authorization, String path, Callback callback) {
		weDeploy.url(Constants.API_URL).authorization(authorization).path(path).get().execute(callback);
	}

	public static void getCurrentUser(Authorization authorization, Callback callback) {
		weDeploy.url(Constants.API_URL).authorization(authorization).path("user").get().execute(callback);
	}

	public static void forgotPassword(String email, Callback callback) {
		weDeploy.url(Constants.API_URL)
			.path("user/recover")
			.form("email", email)
			.param("email", email)
			.post()
			.execute(callback);
	}

	public static void signOut(){

	}
}
