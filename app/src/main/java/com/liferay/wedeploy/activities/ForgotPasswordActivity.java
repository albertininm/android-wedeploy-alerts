package com.liferay.wedeploy.activities;

import android.animation.AnimatorInflater;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.interfaces.ForgotPasswordView;
import com.liferay.wedeploy.databinding.ActivityForgotPasswordBinding;
import com.liferay.wedeploy.enums.CustomBarStateEnum;
import com.liferay.wedeploy.enums.LoginFieldStateEnum;
import com.liferay.wedeploy.enums.ProgressBarStateEnum;
import com.liferay.wedeploy.presenters.ForgotPasswordActivityPresenter;

public class ForgotPasswordActivity extends AppCompatActivity implements ForgotPasswordView {

	public boolean infoBarVisibility;
	public ActivityForgotPasswordBinding binding;
	public ForgotPasswordActivityPresenter presenter = new ForgotPasswordActivityPresenter();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot_password);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password);

		binding.appBarLayout.setStateListAnimator(
			AnimatorInflater.loadStateListAnimator(this, R.drawable.app_bar_layout_shadow_selector));

		setSupportActionBar(binding.toolbar);

		setListeners();
	}

	public String getEmail() {
		return binding.emailEditText.getText().toString();
	}

	protected void onStart() {
		super.onStart();
		presenter.bind(this);
	}

	protected void onDestroy() {
		presenter.unbind();
		super.onDestroy();
	}

	public void setListeners() {
		binding.resetPasswordButton.setOnClickListener(
			v -> presenter.sendPasswordResetEmail(binding.emailEditText.getText().toString()));
	}

	public void setButtonClickable(boolean bool) {
		binding.resetPasswordButton.setClickable(bool);
	}

	public void setEmailState(LoginFieldStateEnum state) {
		binding.emailEditText.setBackground(getDrawable(state.background));
		binding.emailErrorTextView.setVisibility(state.visibility);
		binding.emailErrorTextView.setText(state.text);
	}

	public boolean isErrorBarVisible() {
		return this.infoBarVisibility;
	}

	public void setInfoBarVisibility(boolean bool) {
		this.infoBarVisibility = bool;
	}

	public void setErrorBarState(CustomBarStateEnum state, Runnable runnable) {
		binding.linearLayout.animate()
			.translationYBy(getResources().getDimension(state.animationHeight))
			.withEndAction(() -> {
				binding.linearLayout.animate()
					.setStartDelay(3000)
					.translationYBy(-getResources().getDimension(state.animationHeight))
					.withEndAction(() -> {
						binding.linearLayout.animate().setStartDelay(0);
						setButtonClickable(true);
						setInfoBarVisibility(false);
					});
			});
	}

	public void setProgressBarState(ProgressBarStateEnum state) {
		binding.resetPasswordButton.setVisibility(state.progressBarButtonState);
		binding.progressBar.setVisibility(state.progressBarState);
	}
}
