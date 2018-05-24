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

package com.liferay.wedeploy.activities.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.adapters.ServiceAdapter;

/**
 * @author Victor Oliveira
 */
public class ServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

	private ServiceAdapter.ServiceAdapterListener listener;

	private ImageView restartServiceImageView;
	private ImageView serviceHealthImageView;
	private TextView serviceIdTextView;
	private ImageView serviceTypeImageView;

	public ServiceViewHolder(View itemView, ServiceAdapter.ServiceAdapterListener listener) {

		super(itemView);

		this.listener = listener;

		serviceIdTextView = itemView.findViewById(R.id.serviceId);
		serviceHealthImageView = itemView.findViewById(R.id.serviceHealth);
		restartServiceImageView = itemView.findViewById(R.id.serviceRestart);
		serviceTypeImageView = itemView.findViewById(R.id.serviceType);
		restartServiceImageView.setOnClickListener(this);
	}

	public ImageView getRestartServiceImageView() {
		return restartServiceImageView;
	}

	public ImageView getServiceHealthImageView() {
		return serviceHealthImageView;
	}

	public TextView getServiceIdTextView() {
		return serviceIdTextView;
	}

	public ImageView getServiceTypeImageView() {
		return serviceTypeImageView;
	}

	public void onClick(View view) {
		listener.onClick(getAdapterPosition(), view);
	}
}