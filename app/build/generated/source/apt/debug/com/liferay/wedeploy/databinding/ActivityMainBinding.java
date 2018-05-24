package com.liferay.wedeploy.databinding;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.logo_layout, 1);
        sViewsWithIds.put(R.id.logo, 2);
        sViewsWithIds.put(R.id.text_title, 3);
        sViewsWithIds.put(R.id.mainText, 4);
        sViewsWithIds.put(R.id.mail, 5);
        sViewsWithIds.put(R.id.github, 6);
        sViewsWithIds.put(R.id.google, 7);
    }
    // views
    @NonNull
    public final android.widget.ImageButton github;
    @NonNull
    public final android.widget.ImageButton google;
    @NonNull
    public final android.widget.ImageView logo;
    @NonNull
    public final android.widget.LinearLayout logoLayout;
    @NonNull
    public final android.widget.Button mail;
    @NonNull
    public final android.widget.TextView mainText;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.TextView textTitle;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.github = (android.widget.ImageButton) bindings[6];
        this.google = (android.widget.ImageButton) bindings[7];
        this.logo = (android.widget.ImageView) bindings[2];
        this.logoLayout = (android.widget.LinearLayout) bindings[1];
        this.mail = (android.widget.Button) bindings[5];
        this.mainText = (android.widget.TextView) bindings[4];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textTitle = (android.widget.TextView) bindings[3];
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
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.liferay.wedeploy.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.liferay.wedeploy.R.layout.activity_main, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}