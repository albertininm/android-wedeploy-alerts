package com.liferay.wedeploy.databinding;
import com.liferay.wedeploy.R;
import com.liferay.wedeploy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignInWithEmailBinding extends android.databinding.ViewDataBinding  {

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
        sViewsWithIds.put(R.id.custom_error_bar_close_icon, 6);
        sViewsWithIds.put(R.id.linear_layout_email, 7);
        sViewsWithIds.put(R.id.etEmailLayout, 8);
        sViewsWithIds.put(R.id.email_edit_text, 9);
        sViewsWithIds.put(R.id.email_error_text_view, 10);
        sViewsWithIds.put(R.id.forgot_password, 11);
        sViewsWithIds.put(R.id.etPasswordLayout, 12);
        sViewsWithIds.put(R.id.password_edit_text, 13);
        sViewsWithIds.put(R.id.password_error_text_view, 14);
        sViewsWithIds.put(R.id.login_button, 15);
        sViewsWithIds.put(R.id.progress_bar, 16);
    }
    // views
    @NonNull
    public final android.support.design.widget.AppBarLayout appBarLayout;
    @NonNull
    public final android.support.design.widget.CoordinatorLayout coordinatorLayout;
    @NonNull
    public final android.widget.LinearLayout customErrorBar;
    @NonNull
    public final android.widget.ImageButton customErrorBarCloseIcon;
    @NonNull
    public final android.widget.TextView customErrorBarText;
    @NonNull
    public final android.widget.EditText emailEditText;
    @NonNull
    public final android.widget.TextView emailErrorTextView;
    @NonNull
    public final android.support.design.widget.TextInputLayout etEmailLayout;
    @NonNull
    public final android.support.design.widget.TextInputLayout etPasswordLayout;
    @NonNull
    public final android.widget.TextView forgotPassword;
    @NonNull
    public final android.widget.LinearLayout linearLayout;
    @NonNull
    public final android.widget.LinearLayout linearLayoutEmail;
    @NonNull
    public final android.widget.Button loginButton;
    @NonNull
    public final android.widget.EditText passwordEditText;
    @NonNull
    public final android.widget.TextView passwordErrorTextView;
    @NonNull
    public final android.widget.ProgressBar progressBar;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignInWithEmailBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds);
        this.appBarLayout = (android.support.design.widget.AppBarLayout) bindings[1];
        this.coordinatorLayout = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.coordinatorLayout.setTag(null);
        this.customErrorBar = (android.widget.LinearLayout) bindings[4];
        this.customErrorBarCloseIcon = (android.widget.ImageButton) bindings[6];
        this.customErrorBarText = (android.widget.TextView) bindings[5];
        this.emailEditText = (android.widget.EditText) bindings[9];
        this.emailErrorTextView = (android.widget.TextView) bindings[10];
        this.etEmailLayout = (android.support.design.widget.TextInputLayout) bindings[8];
        this.etPasswordLayout = (android.support.design.widget.TextInputLayout) bindings[12];
        this.forgotPassword = (android.widget.TextView) bindings[11];
        this.linearLayout = (android.widget.LinearLayout) bindings[3];
        this.linearLayoutEmail = (android.widget.LinearLayout) bindings[7];
        this.loginButton = (android.widget.Button) bindings[15];
        this.passwordEditText = (android.widget.EditText) bindings[13];
        this.passwordErrorTextView = (android.widget.TextView) bindings[14];
        this.progressBar = (android.widget.ProgressBar) bindings[16];
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
    public static ActivitySignInWithEmailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySignInWithEmailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivitySignInWithEmailBinding>inflate(inflater, com.liferay.wedeploy.R.layout.activity_sign_in_with_email, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivitySignInWithEmailBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySignInWithEmailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.liferay.wedeploy.R.layout.activity_sign_in_with_email, null, false), bindingComponent);
    }
    @NonNull
    public static ActivitySignInWithEmailBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySignInWithEmailBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_sign_in_with_email_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivitySignInWithEmailBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}