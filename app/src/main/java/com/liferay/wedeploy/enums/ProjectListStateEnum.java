package com.liferay.wedeploy.enums;

import android.view.View;

/**
 * @author Albertinin Santos
 */
public enum ProjectListStateEnum {

	NO_PROJECT_STATE(View.VISIBLE, View.GONE), HAS_PROJECT_STATE(View.GONE, View.VISIBLE);

	public int listOfProjectsState;
	public int noProjectViewState;

	ProjectListStateEnum(int noProjectViewState, int listOfProjectsState) {

		this.listOfProjectsState = listOfProjectsState;
		this.noProjectViewState = noProjectViewState;
	}
}
