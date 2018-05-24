package com.liferay.wedeploy.activities.interfaces;

/**
 * @author Albertinin Santos
 */
public interface OAuthView {

	void closeAndOpenNext();

	String getToken();

	void closeCurrentActivity();
}