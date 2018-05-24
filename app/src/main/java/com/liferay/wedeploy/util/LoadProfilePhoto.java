package com.liferay.wedeploy.util;

import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Albertinin Santos
 */
public class LoadProfilePhoto {
	public static void load(CircleImageView photo) {

		Glide.with(photo.getContext())
			.load(PreferencesUtil.getStringByToken(photo.getContext(), KeysConstants.PHOTO_URL))
			.into(photo);
	}
}
