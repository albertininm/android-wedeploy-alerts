package com.liferay.wedeploy.interactors;

import android.app.Activity;
import com.liferay.wedeploy.util.APIClient;
import com.liferay.wedeploy.util.Constants;
import com.wedeploy.android.auth.ProviderAuthorization;

/**
 * @author Albertinin Santos
 */
public class SignInWithProviderInteractor {

	public void execute(Activity activity, ProviderAuthorization.Provider provider, String providerScope) {
		APIClient.Companion.signInWithProvider(activity, getProviderAuthorization(provider, providerScope));
	}

	private ProviderAuthorization getProviderAuthorization(ProviderAuthorization.Provider provider,
		String providerScope) {

		return new ProviderAuthorization.Builder().redirectUri(Constants.REDIRECT_URI)
			.provider(provider)
			.providerScope(providerScope)
			.build();
	}
}
