package com.liferay.wedeploy.databinding;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RowLayoutProjectBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.project_id_text_view, 1);
        sViewsWithIds.put(R.id.project_health_image_view, 2);
        sViewsWithIds.put(R.id.project_health_text_view, 3);
    }
    // views
    @NonNull
    public final android.widget.ImageView projectHealthImageView;
    @NonNull
    public final android.widget.TextView projectHealthTextView;
    @NonNull
    public final android.widget.TextView projectIdTextView;
    @NonNull
    public final android.widget.LinearLayout projectItem;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RowLayoutProjectBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.projectHealthImageView = (android.widget.ImageView) bindings[2];
        this.projectHealthTextView = (android.widget.TextView) bindings[3];
        this.projectIdTextView = (android.widget.TextView) bindings[1];
        this.projectItem = (android.widget.LinearLayout) bindings[0];
        this.projectItem.setTag(null);
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
    public static RowLayoutProjectBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static RowLayoutProjectBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<RowLayoutProjectBinding>inflate(inflater, com.liferay.wedeploy.R.layout.row_layout_project, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static RowLayoutProjectBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static RowLayoutProjectBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.liferay.wedeploy.R.layout.row_layout_project, null, false), bindingComponent);
    }
    @NonNull
    public static RowLayoutProjectBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static RowLayoutProjectBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/row_layout_project_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new RowLayoutProjectBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}