/*
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * 3. Neither the name of Liferay, Inc. nor the names of its contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.liferay.wedeploy.presenters;

import android.app.Activity;
import android.util.Log;
import android.util.Patterns;
import com.liferay.wedeploy.activities.interfaces.SignInWithEmailView;
import com.liferay.wedeploy.enums.CustomBarStateEnum;
import com.liferay.wedeploy.enums.LoginFieldStateEnum;
import com.liferay.wedeploy.enums.ProgressBarStateEnum;
import com.liferay.wedeploy.interactors.SignInInteractor;
import com.wedeploy.android.Callback;
import com.wedeploy.android.transport.Response;

/**
 * @author Albertinin Santos
 */
public class SignInWithEmailActivityPresenter extends Presenter<SignInWithEmailView> {

	public void login() {
		String email = view.getEmail();
		String password = view.getPassword();

		if (hasCorrectFields(email, password)) {

			view.setEmailState(LoginFieldStateEnum.EMAIL_VALID_STATE);
			view.setPasswordState(LoginFieldStateEnum.PASSWORD_VALID_STATE);
			view.setProgressBarState(ProgressBarStateEnum.PROGRESS_BAR_VISIBLE);

			new SignInInteractor().execute(((Activity) view).getApplicationContext(), email, password, new Callback() {

				public void onSuccess(Response response) {
					view.closeAndOpenNext();
				}

				public void onFailure(Exception e) {
					Log.e("error", e.getMessage());
					view.setProgressBarState(ProgressBarStateEnum.PROGRESS_BAR_HIDEN);
					showErrorBarCondition();
				}
			});
		} else {
			verifyFieldEmail(view.getEmail());
			verifyFieldPassword(view.getPassword());
		}
	}

	public synchronized void showErrorBarCondition() {
		boolean temp = view.isVisibleErrorBar();

		if (!temp) {
			view.setErrorBarState(CustomBarStateEnum.LOGIN_ERROR_VISIBLE_STATE);
			view.setErrorBarVisibility(!temp);
		}
	}

	public void hideErrorBarCondition() {
		boolean temp = view.isVisibleErrorBar();
		if (temp) {
			view.setErrorBarState(CustomBarStateEnum.LOGIN_ERROR_HIDEN_STATE);
			view.setErrorBarVisibility(!temp);
		}
	}

	public void verifyFieldEmail(String email) {

		if (email.equals("")) {
			view.setEmailState(LoginFieldStateEnum.EMAIL_EMPTY_STATE);
		} else {
			setEmailNotEmptyState(email);
		}
	}

	public void setEmailNotEmptyState(String email) {
		if (email.length() > 0) {
			if (isValidEmail(email)) {
				view.setEmailState(LoginFieldStateEnum.EMAIL_VALID_STATE);
			} else {
				view.setEmailState(LoginFieldStateEnum.EMAIL_INVALID_STATE);
			}
		}
	}

	public boolean isValidEmail(String email) {
		return Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	public void verifyFieldPassword(String password) {

		if (password.equals("")) {
			view.setPasswordState(LoginFieldStateEnum.PASSWORD_EMPTY_STATE);
		} else {
			view.setPasswordState(LoginFieldStateEnum.PASSWORD_VALID_STATE);
		}
	}

	public boolean hasCorrectFields(String email, String password) {
		return (isValidEmail(email)) && (password.length() > 0);
	}
}
