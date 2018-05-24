package com.liferay.wedeploy.activities.holders;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.activities.MainActivity;
import com.liferay.wedeploy.util.KeysConstants;
import com.liferay.wedeploy.util.PreferencesUtil;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Albertinin Santos
 */
public class ProjectsHeaderViewHolder extends RecyclerView.ViewHolder {

	public TextView projectTextHeader;
	public CircleImageView userPhoto;

	public ProjectsHeaderViewHolder(View itemView) {
		super(itemView);
		projectTextHeader = itemView.findViewById(R.id.project_text_header);
		userPhoto = itemView.findViewById(R.id.profile_image);

		userPhoto.setOnClickListener(view -> {
			Log.d("clicked", "Clicked");
			LayoutInflater factory = LayoutInflater.from(userPhoto.getContext());
			View logoutDialogView = factory.inflate(R.layout.log_out_dialog_layout, null);
			AlertDialog logoutDialog = new AlertDialog.Builder(userPhoto.getContext()).create();
			//logoutDialog.setView(logoutDialogView);

			logoutDialog.setTitle(logoutDialog.getContext().getResources().getString(R.string.log_out));
			logoutDialog.setMessage(logoutDialog.getContext().getResources().getString(R.string.alert_dialog_text));
			logoutDialog.setButton(AlertDialog.BUTTON_POSITIVE, logoutDialog.getContext().getResources().getString(R.string.logout), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					PreferencesUtil.saveStringByToken(view.getContext(), KeysConstants.TOKEN, "");
					PreferencesUtil.saveStringByToken(view.getContext(), KeysConstants.PHOTO_URL, "");
					Intent intent = new Intent(view.getContext(), MainActivity.class);
					intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
					view.getContext().startActivity(intent);
				}
			});

			logoutDialog.setButton(AlertDialog.BUTTON_NEGATIVE, logoutDialog.getContext().getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
			});

			logoutDialog.show();
		});

	}

	public TextView getProjectTextHeader() {
		return projectTextHeader;
	}

	public CircleImageView getUserPhoto() {
		return this.userPhoto;
	}
}
