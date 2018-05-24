package com.liferay.wedeploy.databinding;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityForgotPasswordBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_layout, 1);
        sViewsWithIds.put(R.id.toolbar, 2);
        sViewsWithIds.put(R.id.linear_layout, 3);
        sViewsWithIds.put(R.id.custom_error_bar, 4);
        sViewsWithIds.put(R.id.custom_error_bar_text, 5);
        sViewsWithIds.put(R.id.linear_layout_email, 6);
        sViewsWithIds.put(R.id.etEmailLayout, 7);
        sViewsWithIds.put(R.id.email_edit_text, 8);
        sViewsWithIds.put(R.id.email_error_text_view, 9);
        sViewsWithIds.put(R.id.reset_password_button, 10);
        sViewsWithIds.put(R.id.progress_bar, 11);
    }
    // views
    @NonNull
    public final android.support.design.widget.AppBarLayout appBarLayout;
    @NonNull
    public final android.support.design.widget.CoordinatorLayout coordinatorLayout;
    @NonNull
    public final android.widget.LinearLayout customErrorBar;
    @NonNull
    public final android.widget.TextView customErrorBarText;
    @NonNull
    public final android.widget.EditText emailEditText;
    @NonNull
    public final android.widget.TextView emailErrorTextView;
    @NonNull
    public final android.support.design.widget.TextInputLayout etEmailLayout;
    @NonNull
    public final android.widget.LinearLayout linearLayout;
    @NonNull
    public final android.widget.LinearLayout linearLayoutEmail;
    @NonNull
    public final android.widget.ProgressBar progressBar;
    @NonNull
    public final android.widget.Button resetPasswordButton;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityForgotPasswordBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.appBarLayout = (android.support.design.widget.AppBarLayout) bindings[1];
        this.coordinatorLayout = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.coordinatorLayout.setTag(null);
        this.customErrorBar = (android.widget.LinearLayout) bindings[4];
        this.customErrorBarText = (android.widget.TextView) bindings[5];
        this.emailEditText = (android.widget.EditText) bindings[8];
        this.emailErrorTextView = (android.widget.TextView) bindings[9];
        this.etEmailLayout = (android.support.design.widget.TextInputLayout) bindings[7];
        this.linearLayout = (android.widget.LinearLayout) bindings[3];
        this.linearLayoutEmail = (android.widget.LinearLayout) bindings[6];
        this.progressBar = (android.widget.ProgressBar) bindings[11];
        this.resetPasswordButton = (android.widget.Button) bindings[10];
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[2];
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
    public static ActivityForgotPasswordBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityForgotPasswordBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityForgotPasswordBinding>inflate(inflater, com.liferay.wedeploy.R.layout.activity_forgot_password, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityForgotPasswordBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityForgotPasswordBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.liferay.wedeploy.R.layout.activity_forgot_password, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityForgotPasswordBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityForgotPasswordBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_forgot_password_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityForgotPasswordBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}