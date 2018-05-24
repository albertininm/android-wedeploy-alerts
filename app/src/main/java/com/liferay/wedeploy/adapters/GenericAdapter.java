package com.liferay.wedeploy.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import java.util.List;

/**
 * @author Albertinin Santos
 */
public class GenericAdapter extends RecyclerView.Adapter {

	private AdapterDelegatesManager<List> delegatesManager;
	private List<Object> items;

	public GenericAdapter(Activity activity, List items) {
		this.items = items;

		delegatesManager = new AdapterDelegatesManager<>();

		delegatesManager.addDelegate(new ProjectAdapterDelegate(activity));
		delegatesManager.addDelegate(new ProjectHeaderAdapterDelegate(activity));
	}

	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return delegatesManager.onCreateViewHolder(parent, viewType);
	}

	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		delegatesManager.onBindViewHolder(items, position, holder);
	}

	public int getItemCount() {
		return items.size();
	}

	@Override
	public int getItemViewType(int position) {
		return delegatesManager.getItemViewType(items, position);
	}
}
