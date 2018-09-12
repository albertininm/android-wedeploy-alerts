package com.liferay.wedeploy.interactors;

import com.liferay.wedeploy.util.APIClient;
import com.wedeploy.android.Callback;

/**
 * @author Albertinin Santos
 */
public class ForgotPasswordInteractor {

	public void execute(String email, Callback callback) {
		APIClient.Companion.forgotPassword(email, callback);
	}
}
