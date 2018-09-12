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

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.interfaces.MainActivityView;
import com.liferay.wedeploy.databinding.ActivityMainBinding;
import com.liferay.wedeploy.presenters.MainActivityPresenter;
import com.liferay.wedeploy.util.KeysConstants;
import com.liferay.wedeploy.util.PreferencesUtil;

/**
 * @author Albertinin Mourato
 */
public class MainActivity extends AppCompatActivity implements MainActivityView {
	private ActivityMainBinding binding;
	private MainActivityPresenter presenter = new MainActivityPresenter();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
		presenter.bind(this);
		presenter.onCreate();
		setListeners();
	}

	protected void onDestroy() {
		presenter.unbind();
		super.onDestroy();
	}

	public void closeAndOpenProjects() {
		finish();
		startActivity(new Intent(getApplicationContext(), ProjectsActivity.class));
	}

	public void closeAndOpenSignInWithEmail() {
		Intent intent = new Intent(this, SignInWithEmailActivity.class);
		startActivity(intent);
	}

	public void setListeners() {

		//Log in with github
		binding.github.setOnClickListener(view -> presenter.loginWithGithubProvider());

		//Log in with google
		binding.google.setOnClickListener(view -> presenter.loginWithGoogleProvider());

		//Log in with email
		binding.mail.setOnClickListener(view -> presenter.signInWithEmailAndPassword());
	}

	public boolean isLogged() {
		return !PreferencesUtil.Companion.getStringByToken(getApplicationContext(), KeysConstants.TOKEN).isEmpty();
	}
}