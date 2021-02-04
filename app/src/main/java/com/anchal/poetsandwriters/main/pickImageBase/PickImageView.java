

package com.anchal.poetsandwriters.main.pickImageBase;

import android.net.Uri;

import com.anchal.poetsandwriters.main.base.BaseView;



public interface PickImageView extends BaseView {
    void hideLocalProgress();

    void loadImageToImageView(Uri imageUri);
}
