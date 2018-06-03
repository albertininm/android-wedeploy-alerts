
package android.databinding;
import com.liferay.wedeploy.BR;
class DataBinderMapperImpl extends android.databinding.DataBinderMapper {
    public DataBinderMapperImpl() {
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.liferay.wedeploy.R.layout.activity_forgot_password:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_forgot_password_0".equals(tag)) {
                            return new com.liferay.wedeploy.databinding.ActivityForgotPasswordBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_forgot_password is invalid. Received: " + tag);
                }
                case com.liferay.wedeploy.R.layout.activity_main:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_main_0".equals(tag)) {
                            return new com.liferay.wedeploy.databinding.ActivityMainBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
                }
                case com.liferay.wedeploy.R.layout.activity_services:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_services_0".equals(tag)) {
                            return new com.liferay.wedeploy.databinding.ActivityServicesBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_services is invalid. Received: " + tag);
                }
                case com.liferay.wedeploy.R.layout.row_layout_project:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/row_layout_project_0".equals(tag)) {
                            return new com.liferay.wedeploy.databinding.RowLayoutProjectBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for row_layout_project is invalid. Received: " + tag);
                }
                case com.liferay.wedeploy.R.layout.activity_projects:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_projects_0".equals(tag)) {
                            return new com.liferay.wedeploy.databinding.ActivityProjectsBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_projects is invalid. Received: " + tag);
                }
                case com.liferay.wedeploy.R.layout.activity_sign_in_with_email:
 {
                        final Object tag = view.getTag();
                        if(tag == null) throw new java.lang.RuntimeException("view must have a tag");
                    if ("layout/activity_sign_in_with_email_0".equals(tag)) {
                            return new com.liferay.wedeploy.databinding.ActivitySignInWithEmailBinding(bindingComponent, view);
                    }
                        throw new java.lang.IllegalArgumentException("The tag for activity_sign_in_with_email is invalid. Received: " + tag);
                }
        }
        return null;
    }
    @Override
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    @Override
    public int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1775435517: {
                if(tag.equals("layout/activity_forgot_password_0")) {
                    return com.liferay.wedeploy.R.layout.activity_forgot_password;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.liferay.wedeploy.R.layout.activity_main;
                }
                break;
            }
            case -2136617638: {
                if(tag.equals("layout/activity_services_0")) {
                    return com.liferay.wedeploy.R.layout.activity_services;
                }
                break;
            }
            case 1077832511: {
                if(tag.equals("layout/row_layout_project_0")) {
                    return com.liferay.wedeploy.R.layout.row_layout_project;
                }
                break;
            }
            case 1913142902: {
                if(tag.equals("layout/activity_projects_0")) {
                    return com.liferay.wedeploy.R.layout.activity_projects;
                }
                break;
            }
            case 43834167: {
                if(tag.equals("layout/activity_sign_in_with_email_0")) {
                    return com.liferay.wedeploy.R.layout.activity_sign_in_with_email;
                }
                break;
            }
        }
        return 0;
    }
    @Override
    public String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"};
    }
}