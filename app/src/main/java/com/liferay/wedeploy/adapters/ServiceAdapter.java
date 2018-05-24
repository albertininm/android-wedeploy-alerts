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

package com.liferay.wedeploy.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.holders.ServiceViewHolder;
import com.liferay.wedeploy.model.Service;
import java.util.List;

/**
 * @author Albertinin Mourato
 */
public class ServiceAdapter extends RecyclerView.Adapter<ServiceViewHolder> {

	private ServiceAdapterListener listener;
	private List<Service> services;

	public ServiceAdapter(List<Service> services, ServiceAdapterListener listener) {
		this.services = services;
		this.listener = listener;
	}

	public int getItemCount() {
		return services.size();
	}

	public List<Service> getServices() {
		return services;
	}

	public void onBindViewHolder(ServiceViewHolder viewHolder, int i) {
		final Service service = services.get(i);

		ImageView serviceHealthImageView = viewHolder.getServiceHealthImageView();

		String health = service.getHealth();

		if (health.equals("healthy")) {
			serviceHealthImageView.setImageResource(R.drawable.taghealthy);
		} else if (health.equals("unhealthy")) {
			serviceHealthImageView.setImageResource(R.drawable.tagunhealthy);
		} else {
			serviceHealthImageView.setImageResource(R.drawable.tagnone);
		}

		ImageView serviceTypeImageView = viewHolder.getServiceTypeImageView();

		if (service.isType("hosting")) {
			serviceTypeImageView.setImageResource(R.drawable.avatarhosting);
		} else if (service.isType("data")) {
			serviceTypeImageView.setImageResource(R.drawable.avatardata);
		} else if (service.isType("auth")) {
			serviceTypeImageView.setImageResource(R.drawable.avatarauth);
		} else if (service.isType("ruby")) {
			serviceTypeImageView.setImageResource(R.drawable.avatarruby);
		} else if (service.isType("node")) {
			serviceTypeImageView.setImageResource(R.drawable.avatarnodejs);
		} else if (service.isType("java")) {
			serviceTypeImageView.setImageResource(R.drawable.avatarjava);
		} else if (service.isType("liferay")) {
			serviceTypeImageView.setImageResource(R.drawable.avatardxp);
		} else if (service.isType("mail")) {
			serviceTypeImageView.setImageResource(R.drawable.avataremail);
		} else {
			serviceTypeImageView.setImageResource(R.drawable.avatardocker);
		}

		TextView serviceIdTextView = viewHolder.getServiceIdTextView();

		serviceIdTextView.setText(service.getServiceId());

		ImageView restartServiceImageView = viewHolder.getRestartServiceImageView();

		restartServiceImageView.setImageResource(R.drawable.buttonrestart);
	}

	public ServiceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

		View v = layoutInflater.inflate(R.layout.row_layout_service, viewGroup, false);

		ServiceViewHolder viewHolder = new ServiceViewHolder(v, listener);

		return viewHolder;
	}

	public interface ServiceAdapterListener {

		void onClick(int position, View v);
	}
}