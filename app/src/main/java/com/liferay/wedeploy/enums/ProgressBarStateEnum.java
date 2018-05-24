package com.liferay.wedeploy.enums;

import android.view.View;

/**
 * @author Albertinin Santos
 */
public enum ProgressBarStateEnum {

	PROGRESS_BAR_VISIBLE(View.VISIBLE, View.GONE), PROGRESS_BAR_HIDEN(View.GONE, View.VISIBLE);

	public int progressBarState;
	public int progressBarButtonState;

	ProgressBarStateEnum(int progressBarState, int progressBarButtonState) {
		this.progressBarState = progressBarState;
		this.progressBarButtonState = progressBarButtonState;
	}
}
