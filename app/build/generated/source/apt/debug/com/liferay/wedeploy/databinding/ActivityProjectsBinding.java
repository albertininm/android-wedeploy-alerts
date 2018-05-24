package com.liferay.wedeploy.databinding;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityProjectsBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.no_projects_view, 2);
        sViewsWithIds.put(R.id.unhealthy_project_bar, 3);
        sViewsWithIds.put(R.id.recycleView, 4);
    }
    // views
    @NonNull
    public final android.support.design.widget.CoordinatorLayout coordinatorLayout;
    @Nullable
    public final android.view.View noProjectsView;
    @NonNull
    public final android.widget.LinearLayout projectsList;
    @NonNull
    public final android.support.v7.widget.RecyclerView recycleView;
    @Nullable
    public final android.view.View unhealthyProjectBar;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityProjectsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.coordinatorLayout = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.coordinatorLayout.setTag(null);
        this.noProjectsView = (android.view.View) bindings[2];
        this.projectsList = (android.widget.LinearLayout) bindings[1];
        this.projectsList.setTag(null);
        this.recycleView = (android.support.v7.widget.RecyclerView) bindings[4];
        this.unhealthyProjectBar = (android.view.View) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityProjectsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityProjectsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityProjectsBinding>inflate(inflater, com.liferay.wedeploy.R.layout.activity_projects, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityProjectsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityProjectsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.liferay.wedeploy.R.layout.activity_projects, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityProjectsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityProjectsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_projects_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityProjectsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}