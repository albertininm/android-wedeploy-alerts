package com.liferay.wedeploy.util

import android.app.Activity
import com.wedeploy.android.Callback
import com.wedeploy.android.WeDeploy
import com.wedeploy.android.auth.Authorization
import com.wedeploy.android.auth.ProviderAuthorization


/**
 * @author Albertinin Santos
 */

class APIClient {

    companion object {

        val weDeploy : WeDeploy = WeDeploy.Builder().build()

        fun signIn(email: String, password: String, callback: Callback){
            weDeploy.url(Constants.API_URL)
                .path("login")
                .form("email", email)
                .form("password", password)
                .post()
                .execute(callback)
        }

        fun signInWithProvider(activity: Activity, providerAuthorization: ProviderAuthorization){
            weDeploy.auth(Constants.API_URL).signIn(activity, providerAuthorization)
        }

        fun restartService(authorization: Authorization, path: String, callback: Callback){
            weDeploy.url(Constants.API_URL)
                .authorization(authorization)
                .path(path)
                .form("email", "sometext")
                .post()
                .execute(callback)
        }

        fun loadProjects(authorization: Authorization, path: String, callback: Callback){
            weDeploy.url(Constants.API_URL)
                .authorization(authorization)
                .path(path)
                .get()
                .execute(callback)
        }

        fun getCurrentUser(authorization: Authorization, callback: Callback){
            weDeploy.url(Constants.API_URL)
                .path("user")
                .authorization(authorization)
                .get()
                .execute(callback)
        }

        fun forgotPassword(email: String, callback: Callback) {
            weDeploy.url(Constants.API_URL)
                .path("user/recover")
                .form("email", email)
                .param("email", email)
                .post()
                .execute(callback)
        }
    }
}
