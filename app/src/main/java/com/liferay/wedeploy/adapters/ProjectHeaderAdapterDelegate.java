package com.liferay.wedeploy.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.holders.ProjectsHeaderViewHolder;
import com.liferay.wedeploy.model.ProjectsHeader;
import com.liferay.wedeploy.util.LoadProfilePhoto;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/**
 * @author Albertinin Santos
 */
public class ProjectHeaderAdapterDelegate extends AdapterDelegate<List> {

	public LayoutInflater inflater;

	public ProjectHeaderAdapterDelegate(Activity activity) {
		inflater = activity.getLayoutInflater();
	}

	@Override
	protected boolean isForViewType(@NonNull List items, int position) {
		return items.get(position) instanceof ProjectsHeader;
	}

	@NonNull
	@Override
	protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
		return new ProjectsHeaderViewHolder(inflater.inflate(R.layout.row_project_header, parent, false));
	}

	@Override
	protected void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder,
		@NonNull List payloads) {

		ProjectsHeader header = (ProjectsHeader) items.get(position);

		CircleImageView profilePhoto = ((ProjectsHeaderViewHolder) holder).getUserPhoto();

		LoadProfilePhoto.load(profilePhoto);
	}
}
