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

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.interfaces.ProjectView;
import com.liferay.wedeploy.adapters.GenericAdapter;
import com.liferay.wedeploy.databinding.ActivityProjectsBinding;
import com.liferay.wedeploy.enums.ProjectListStateEnum;
import com.liferay.wedeploy.model.ProjectsHeader;
import com.liferay.wedeploy.presenters.ProjectsActivityPresenter;
import com.liferay.wedeploy.util.LoadProfilePhoto;
import com.liferay.wedeploy.util.ResizeAnimation;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Albertinin Mourato
 */
public class ProjectsActivity extends AppCompatActivity implements ProjectView {

	private ProjectsActivityPresenter presenter = new ProjectsActivityPresenter();
	private ActivityProjectsBinding binding;
	private GenericAdapter adapter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter.bind(this);
		presenter.onCreate();
		binding = DataBindingUtil.setContentView(this, R.layout.activity_projects);
		binding.recycleView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setAutoMeasureEnabled(true);
		binding.recycleView.setLayoutManager(layoutManager);
		binding.recycleView.setNestedScrollingEnabled(false);
		loadProfilePhoto();
		setListeners();
	}

	protected void onStart() {
		super.onStart();
		presenter.bind(this);
		presenter.onStart();
	}

	protected void onStop() {
		presenter.onStop();
		super.onStop();
	}

	protected void onDestroy() {
		presenter.unbind();
		super.onDestroy();
	}

	public void setListeners() {
		Button openConsole = binding.noProjectsView.findViewById(R.id.open_console_button);
		openConsole.setOnClickListener(view -> {
			presenter.openConsole();
		});

		binding.unhealthyProjectBar.findViewById(R.id.dismiss_unhealthy_bar).setOnClickListener(view -> {
			hideUnhealthyProjectBar();
		});



		binding.noProjectsView.findViewById(R.id.profile_image).setOnClickListener(view -> {
			Log.d("clicked", "Clicked");
			LayoutInflater factory = LayoutInflater.from(this);
			final View deleteDialogView = factory.inflate(R.layout.log_out_dialog_layout, null);
			final AlertDialog logoutDialog = new AlertDialog.Builder(this).create();
			logoutDialog.setView(deleteDialogView);
			logoutDialog.show();
		});

	}

	public void renderProjects(List projects) {
		ProjectsHeader header = new ProjectsHeader();
		ArrayList list = new ArrayList(projects);
		Collections.sort(list);
		list.add(0, header);
		adapter = new GenericAdapter(this, list);
		binding.recycleView.setAdapter(adapter);
	}

	public void setListOfProjects(ProjectListStateEnum state) {
		binding.projectsList.setVisibility(state.listOfProjectsState);
		binding.noProjectsView.setVisibility(state.noProjectViewState);
	}

	public void loadProfilePhoto() {
		CircleImageView imageView = binding.noProjectsView.findViewById(R.id.profile_image);
		LoadProfilePhoto.load(imageView);
	}

	public void showUnhealthyProjectBar(long qtd) {
		TextView textView = binding.unhealthyProjectBar.findViewById(R.id.unhealthy_project_title_bar);
		textView.setText(qtd + " projects are unhealthy.");
		getWindow().setStatusBarColor(getColor(R.color.red_error_color));
		binding.unhealthyProjectBar.setVisibility(View.VISIBLE);
	}

	public void hideUnhealthyProjectBar() {
		binding.unhealthyProjectBar.animate()
			.translationY(-binding.unhealthyProjectBar.getHeight())
			.setDuration(500)
			.withEndAction(() -> {
				getWindow().setStatusBarColor(getColor(R.color.status_bar_color_grey));
			});
		binding.recycleView.animate().translationY(-binding.unhealthyProjectBar.getHeight()).setDuration(500);
		ResizeAnimation resizeAnimation =
			new ResizeAnimation(binding.recycleView, binding.unhealthyProjectBar.getHeight(),
				binding.recycleView.getHeight());
		resizeAnimation.setDuration(500);
		binding.recycleView.startAnimation(resizeAnimation);
		binding.recycleView.setAdapter(adapter);
	}
}
