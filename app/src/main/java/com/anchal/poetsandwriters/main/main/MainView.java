

package com.anchal.poetsandwriters.main.main;

import android.view.View;

import com.anchal.poetsandwriters.main.base.BaseView;
import com.anchal.poetsandwriters.model.Post;



public interface MainView extends BaseView {
    void openCreatePostActivity();
    void hideCounterView();
    void openPostDetailsActivity(Post post, View v);
    void showFloatButtonRelatedSnackBar(int messageId);
    void openProfileActivity(String userId, View view);
    void refreshPostList();
    void removePost();
    void updatePost();
    void showCounterView(int count);
}
