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

package com.liferay.wedeploy.activities;

import android.animation.AnimatorInflater;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.interfaces.SignInWithEmailView;
import com.liferay.wedeploy.databinding.ActivitySignInWithEmailBinding;
import com.liferay.wedeploy.enums.CustomBarStateEnum;
import com.liferay.wedeploy.enums.LoginFieldStateEnum;
import com.liferay.wedeploy.enums.ProgressBarStateEnum;
import com.liferay.wedeploy.presenters.SignInWithEmailActivityPresenter;

/**
 * @author Albertinin Mourato
 */
public class SignInWithEmailActivity extends AppCompatActivity implements SignInWithEmailView {
	public ActivitySignInWithEmailBinding binding;
	private boolean errorBarVisibility;
	private SignInWithEmailActivityPresenter presenter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_sign_in_with_email);

		binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in_with_email);

		binding.appBarLayout.setStateListAnimator(
			AnimatorInflater.loadStateListAnimator(this, R.drawable.app_bar_layout_shadow_selector));

		setSupportActionBar(binding.toolbar);

		presenter = new SignInWithEmailActivityPresenter();
		presenter.bind(this);
		setListeners();
		findViewById(R.id.toolbar).bringToFront();
	}

	public void setListeners() {

		binding.loginButton.setOnClickListener(view -> {
			presenter.login();
		});

		binding.customErrorBarCloseIcon.setOnClickListener(view -> presenter.hideErrorBarCondition());

		binding.emailEditText.setOnFocusChangeListener((view, hasFocus) -> {
			if (!hasFocus) presenter.verifyFieldEmail(binding.emailEditText.getText().toString());
		});

		binding.passwordEditText.setOnFocusChangeListener((view, hasFocus) -> {
			if (!hasFocus) presenter.verifyFieldPassword(binding.passwordEditText.getText().toString());
		});

		binding.forgotPassword.setOnClickListener(view -> {
			startActivity(new Intent(SignInWithEmailActivity.this, ForgotPasswordActivity.class));
		});
	}

	public String getEmail() {
		return binding.emailEditText.getText().toString();
	}

	public String getPassword() {
		return binding.passwordEditText.getText().toString();
	}

	public void closeAndOpenNext() {
		Intent intent = new Intent(getApplicationContext(), ProjectsActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}

	protected void onDestroy() {
		presenter.unbind();
		super.onDestroy();
	}

	public void setEmailState(LoginFieldStateEnum state) {
		binding.emailEditText.setBackground(getDrawable(state.background));
		binding.emailErrorTextView.setVisibility(state.visibility);
		binding.emailErrorTextView.setText(state.text);
	}

	public void setPasswordState(LoginFieldStateEnum state) {
		binding.passwordEditText.setBackground(getDrawable(state.background));
		binding.passwordErrorTextView.setVisibility(state.visibility);
	}

	public boolean isVisibleErrorBar() {
		return this.errorBarVisibility;
	}

	public void setErrorBarVisibility(boolean bool) {
		this.errorBarVisibility = bool;
	}

	public void setErrorBarState(CustomBarStateEnum state) {
		binding.linearLayout.animate().translationYBy(getResources().getDimension(state.animationHeight));
		binding.customErrorBar.setBackground(getDrawable(state.backgroundColor));
		binding.customErrorBarText.setText(state.text);
		binding.customErrorBarCloseIcon.setBackground(getDrawable(state.closeBarIcon));
	}

	public void setProgressBarState(ProgressBarStateEnum state) {
		binding.loginButton.setVisibility(state.progressBarButtonState);
		binding.progressBar.setVisibility(state.progressBarState);
	}
}