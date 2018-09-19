package com.liferay.wedeploy.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation


/**
 * @author Albertinin Santos
 */

class ResizeAnimation (val view: View, val targetHeight: Int, val startHeight: Int): Animation() {


    override fun applyTransformation(interpolatedTime: Float, t: Transformation){
        val newHeight = (startHeight + targetHeight * interpolatedTime).toInt()
        view.layoutParams.height = newHeight
        view.requestLayout()
    }

    override fun willChangeBounds(): Boolean {
        return true
    }
}