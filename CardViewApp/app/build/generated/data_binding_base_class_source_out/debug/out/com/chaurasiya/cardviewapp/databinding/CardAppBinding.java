// Generated by view binder compiler. Do not edit!
package com.chaurasiya.cardviewapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaurasiya.cardviewapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardAppBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView count;

  @NonNull
  public final ImageView thumbnail;

  @NonNull
  public final TextView title;

  private CardAppBinding(@NonNull LinearLayout rootView, @NonNull CardView cardView,
      @NonNull TextView count, @NonNull ImageView thumbnail, @NonNull TextView title) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.count = count;
    this.thumbnail = thumbnail;
    this.title = title;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CardAppBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardAppBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_app, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardAppBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.count;
      TextView count = ViewBindings.findChildViewById(rootView, id);
      if (count == null) {
        break missingId;
      }

      id = R.id.thumbnail;
      ImageView thumbnail = ViewBindings.findChildViewById(rootView, id);
      if (thumbnail == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      return new CardAppBinding((LinearLayout) rootView, cardView, count, thumbnail, title);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}