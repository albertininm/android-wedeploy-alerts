package com.liferay.wedeploy.activities.interfaces;

import com.liferay.wedeploy.enums.CustomBarStateEnum;
import com.liferay.wedeploy.enums.LoginFieldStateEnum;
import com.liferay.wedeploy.enums.ProgressBarStateEnum;

/**
 * @author Albertinin Santos
 */
public interface ForgotPasswordView {
	void setEmailState(LoginFieldStateEnum state);

	boolean isErrorBarVisible();

	void setInfoBarVisibility(boolean bool);

	void setErrorBarState(CustomBarStateEnum state, Runnable runnable);

	void setProgressBarState(ProgressBarStateEnum state);

	String getEmail();

	void setButtonClickable(boolean bool);
}
