package com.liferay.wedeploy.presenters;

import android.util.Patterns;
import com.liferay.wedeploy.activities.ForgotPasswordActivity;
import com.liferay.wedeploy.enums.CustomBarStateEnum;
import com.liferay.wedeploy.enums.LoginFieldStateEnum;
import com.liferay.wedeploy.enums.ProgressBarStateEnum;
import com.liferay.wedeploy.interactors.ForgotPasswordInteractor;
import com.wedeploy.android.Callback;
import com.wedeploy.android.transport.Response;

/**
 * @author Albertinin Santos
 */
public class ForgotPasswordActivityPresenter extends Presenter<ForgotPasswordActivity> {

	public void sendPasswordResetEmail(String email) {
		if (hasCorrectFields(email)) {
			view.setButtonClickable(false);
			view.setEmailState(LoginFieldStateEnum.EMAIL_VALID_STATE);
			view.setProgressBarState(ProgressBarStateEnum.PROGRESS_BAR_VISIBLE);

			new ForgotPasswordInteractor().execute(email, new Callback() {

				public void onSuccess(Response response) {
					view.setProgressBarState(ProgressBarStateEnum.PROGRESS_BAR_HIDEN);
					showInfoBarCondition();
				}

				public void onFailure(Exception e) {
					view.setProgressBarState(ProgressBarStateEnum.PROGRESS_BAR_HIDEN);
				}
			});
		} else {
			verifyFieldEmail(view.getEmail());
		}
	}

	public void showInfoBarCondition() {
		if (view.isErrorBarVisible()) return;
		view.setErrorBarState(CustomBarStateEnum.FORGOT_PASSWORD_VISIBLE_STATE, () -> view.setInfoBarVisibility(true));
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

	public boolean hasCorrectFields(String email) {
		return isValidEmail(email);
	}
}
