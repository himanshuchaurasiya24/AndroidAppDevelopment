// Generated by view binder compiler. Do not edit!
package com.chaurasiya.cardviewapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaurasiya.cardviewapp.R;
import java.lang.Override;

public final class ContentScrollingBinding implements ViewBinding {
  @NonNull
  private final View rootView;

  /**
   * This binding is not available in all configurations.
   * <p>
   * Present:
   * <ul>
   *   <li>layout/</li>
   * </ul>
   *
   * Absent:
   * <ul>
   *   <li>layout-w1240dp/</li>
   *   <li>layout-w936dp/</li>
   * </ul>
   */
  @Nullable
  public final RecyclerView recyclerView;

  private ContentScrollingBinding(@NonNull View rootView, @Nullable RecyclerView recyclerView) {
    this.rootView = rootView;
    this.recyclerView = recyclerView;
  }

  @Override
  @NonNull
  public View getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentScrollingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentScrollingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_scrolling, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentScrollingBinding bind(@NonNull View rootView) {
    RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, R.id.recyclerView);

    return new ContentScrollingBinding(rootView, recyclerView);
  }
}
