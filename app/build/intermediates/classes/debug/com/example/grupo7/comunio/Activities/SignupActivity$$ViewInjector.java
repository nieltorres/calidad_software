// Generated code from Butter Knife. Do not modify!
package com.example.grupo7.comunio.Activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SignupActivity$$ViewInjector<T extends com.example.grupo7.comunio.Activities.SignupActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558509, "field '_emailText'");
    target._emailText = finder.castView(view, 2131558509, "field '_emailText'");
    view = finder.findRequiredView(source, 2131558510, "field '_passwordText'");
    target._passwordText = finder.castView(view, 2131558510, "field '_passwordText'");
    view = finder.findRequiredView(source, 2131558520, "field '_passwordTextConfirm'");
    target._passwordTextConfirm = finder.castView(view, 2131558520, "field '_passwordTextConfirm'");
    view = finder.findRequiredView(source, 2131558521, "field '_signupButton'");
    target._signupButton = finder.castView(view, 2131558521, "field '_signupButton'");
    view = finder.findRequiredView(source, 2131558522, "field '_loginLink'");
    target._loginLink = finder.castView(view, 2131558522, "field '_loginLink'");
  }

  @Override public void reset(T target) {
    target._emailText = null;
    target._passwordText = null;
    target._passwordTextConfirm = null;
    target._signupButton = null;
    target._loginLink = null;
  }
}
