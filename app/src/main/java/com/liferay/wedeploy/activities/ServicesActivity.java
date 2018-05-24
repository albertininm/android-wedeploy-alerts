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

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.interfaces.ServicesView;
import com.liferay.wedeploy.adapters.ServiceAdapter;
import com.liferay.wedeploy.model.Service;
import com.liferay.wedeploy.presenters.ServicesPresenter;
import com.liferay.wedeploy.util.KeysConstants;
import java.util.List;

/**
 * @author Albertinin Mourato
 */
public class ServicesActivity extends AppCompatActivity implements ServicesView, ServiceAdapter.ServiceAdapterListener {

	private RecyclerView recyclerView;
	private List<Service> services;
	private TextView servicesHeaderTextView;
	private ServicesPresenter presenter;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_services);
		presenter = new ServicesPresenter();
		presenter.bind(this);
		presenter.onCreate();
		recyclerView = findViewById(R.id.recycleView);
		recyclerView.setHasFixedSize(true);
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		servicesHeaderTextView = findViewById(R.id.servicesHeader);
	}

	protected void onStart() {
		super.onStart();
		presenter.onStart();
	}

	protected void onDestroy() {
		presenter.unbind();
		super.onDestroy();
	}

	public void onClick(int position, View v) {
		Service service = services.get(position);
		// TODO Ask for confirmation
		presenter.restartServiceButtonClick(service);
	}

	public void renderServices(List<Service> services) {
		this.services = services;
		ServiceAdapter serviceAdapter = new ServiceAdapter(services, this);
		servicesHeaderTextView.setText(services.size() + " Services");
		recyclerView.setAdapter(serviceAdapter);
		serviceAdapter.notifyDataSetChanged();
	}

	public String getProjectId() {
		Bundle bundle = getIntent().getExtras();
		return bundle.getString(KeysConstants.PROJECT_ID);
	}

	public void showRestarServiceResult(boolean failed) {
		if (failed) {
			Snackbar.make(recyclerView, "Something wrong happened. Please try again!", Snackbar.LENGTH_LONG).show();
		} else {
			Snackbar.make(recyclerView, "Your service is being restarted!", Snackbar.LENGTH_LONG).show();
		}
	}
}