package com.liferay.wedeploy.util

import android.content.Context
import android.content.SharedPreferences


/**
 * @author Albertinin Santos
 */

class PreferencesUtil {
    companion object {

        fun getStringByToken(context: Context, key: String): String {
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(Constants.WEDEPLOY, Context.MODE_PRIVATE)
            return sharedPreferences.getString(key, "")
        }

        fun saveStringByToken(context: Context, key: String, value: String){
            val sharedPreferences: SharedPreferences = context.getSharedPreferences(Constants.WEDEPLOY, Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit();

            editor.putString(key, value)
            editor.commit()
        }
    }
}