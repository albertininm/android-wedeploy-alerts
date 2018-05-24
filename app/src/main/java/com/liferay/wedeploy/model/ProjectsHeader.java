package com.liferay.wedeploy.model;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Albertinin Santos
 */
public class ProjectsHeader {
	public String headerText;
	public CircleImageView userPhoto;

	public ProjectsHeader() {
	}

	public String getHeaderText() {
		return this.headerText;
	}

	public CircleImageView getUserPhoto() {
		return this.userPhoto;
	}
}
