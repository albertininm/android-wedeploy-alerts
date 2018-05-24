package com.liferay.wedeploy.enums;

import android.view.View;
import com.liferay.wedeploy.R;

/**
 * @author Albertinin Santos
 */
public enum LoginFieldStateEnum {

	EMAIL_VALID_STATE(R.drawable.input_background, View.GONE, R.string.the_email_is_required), EMAIL_INVALID_STATE(
		R.drawable.input_background_error, View.VISIBLE, R.string.the_provided_email_is_not_valid), EMAIL_EMPTY_STATE(
		R.drawable.input_background_error, View.VISIBLE, R.string.the_email_is_required), PASSWORD_VALID_STATE(
		R.drawable.input_background, View.GONE, 0), PASSWORD_EMPTY_STATE(R.drawable.input_background_error,
		View.VISIBLE, 0);

	public int background;
	public int visibility;
	public int text;

	LoginFieldStateEnum(int background, int visibility, int text) {
		this.background = background;
		this.visibility = visibility;
		this.text = text;
	}
}

