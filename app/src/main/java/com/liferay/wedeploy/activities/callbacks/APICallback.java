package com.liferay.wedeploy.activities.callbacks;

/**
 * @author Albertinin Santos
 */
public interface APICallback<T> {
	void onSuccess(T response);
}
