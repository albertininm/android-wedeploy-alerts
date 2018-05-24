package com.liferay.wedeploy.enums;

import com.liferay.wedeploy.R;

/**
 * @author Albertinin Santos
 */
public enum CustomBarStateEnum {

	LOGIN_ERROR_VISIBLE_STATE(R.color.snack_bar_login_error_color, R.string.the_provided_credentials_are_invalid,
		R.drawable.cancel_icon_bar, R.dimen.custom_error_bar_height),

	LOGIN_ERROR_HIDEN_STATE(R.color.snack_bar_login_error_color, R.string.the_provided_credentials_are_invalid,
		R.drawable.cancel_icon_bar, R.dimen.custom_error_bar_height_negative),

	FORGOT_PASSWORD_VISIBLE_STATE(R.color.snack_bar_forgot_password_color,
		R.string.your_password_reset_email_has_been_sent, R.drawable.cancel_icon_bar, R.dimen.custom_error_bar_height),

	FORGOT_PASSWORD_HIDEN_STATE(R.color.snack_bar_forgot_password_color,
		R.string.your_password_reset_email_has_been_sent, R.drawable.cancel_icon_bar,
		R.dimen.custom_error_bar_height_negative);

	public int backgroundColor;
	public int text;
	public int closeBarIcon;
	public int animationHeight;

	CustomBarStateEnum(int backgroundColor, int text, int closeBarIcon, int animationHeight) {
		this.backgroundColor = backgroundColor;
		this.text = text;
		this.closeBarIcon = closeBarIcon;
		this.animationHeight = animationHeight;
	}

}
