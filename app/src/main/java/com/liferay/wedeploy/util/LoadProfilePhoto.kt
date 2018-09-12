package com.liferay.wedeploy.util

import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView


/**
 * @author Albertinin Santos
 */

class LoadProfilePhoto {
    companion object {

        fun load(photo: CircleImageView) {
            Glide.with(photo.context)
                .load(PreferencesUtil.getStringByToken(photo.context, KeysConstants.PHOTO_URL))
                .into(photo)
        }
    }
}