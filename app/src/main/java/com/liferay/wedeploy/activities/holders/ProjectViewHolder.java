package com.liferay.wedeploy.activities.holders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.ServicesActivity;
import com.liferay.wedeploy.util.KeysConstants;

/**
 * @author Albertinin Santos
 */
public class ProjectViewHolder extends RecyclerView.ViewHolder {
	public TextView projectsHealthTextView;
	public ImageView projectHealthImageView;
	public TextView projectIdTextView;

	public ProjectViewHolder(View itemView) {
		super(itemView);
		projectIdTextView = itemView.findViewById(R.id.project_id_text_view);
		projectsHealthTextView = itemView.findViewById(R.id.project_health_text_view);
		projectHealthImageView = itemView.findViewById(R.id.project_health_image_view);

		itemView.setOnClickListener(view -> {
			Intent intent = new Intent(view.getContext(), ServicesActivity.class);
			intent.putExtra(KeysConstants.PROJECT_ID, projectIdTextView.getText());
			view.getContext().startActivity(intent);
		});
	}

	public ImageView getProjectHealthImageView() {
		return projectHealthImageView;
	}

	public TextView getProjectIdTextView() {
		return projectIdTextView;
	}

	public TextView getProjectHealthTextView() {
		return projectsHealthTextView;
	}
}
