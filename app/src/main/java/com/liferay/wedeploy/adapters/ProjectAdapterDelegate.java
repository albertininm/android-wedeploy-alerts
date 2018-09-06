package com.liferay.wedeploy.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.holders.ProjectViewHolder;
import com.liferay.wedeploy.model.Project;
import com.liferay.wedeploy.util.Constants;
import java.util.List;

/**
 * @author Albertinin Santos
 */
public class ProjectAdapterDelegate extends AdapterDelegate<List> {

	private LayoutInflater inflater;

	public ProjectAdapterDelegate(Activity activity) {
		inflater = activity.getLayoutInflater();
	}

	protected boolean isForViewType(@NonNull List items, int position) {
		return items.get(position) instanceof Project;
	}

	@NonNull
	@Override
	protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
		return new ProjectViewHolder(inflater.inflate(R.layout.row_layout_project, parent, false));
	}

	@Override
	protected void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder,
		@NonNull List<Object> payloads) {

		final Project project = (Project) items.get(position);

		ImageView projectHealthIconView = ((ProjectViewHolder) holder).getProjectHealthImageView();
		TextView projectHealthText = ((ProjectViewHolder) holder).getProjectHealthTextView();
		TextView projectIdTextView = ((ProjectViewHolder) holder).getProjectIdTextView();

		String health = project.getHealth();

		if (health.equals(Constants.HEALTHY)) {
			projectHealthIconView.setImageResource(R.drawable.healthy_icon);
			projectHealthText.setText(R.string.healthy);
		} else if (health.equals(Constants.UNHEALTHY)) {
			projectHealthIconView.setImageResource(R.drawable.unhealthy_icon);
			projectHealthText.setText(R.string.unhealthy);
		} else {
			projectHealthIconView.setImageResource(R.drawable.none_icon);
			projectHealthText.setText(R.string.none);
		}
		projectIdTextView.setText(project.getProjectId());
	}
}
