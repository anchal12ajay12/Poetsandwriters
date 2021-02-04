package com.anchal.poetsandwriters.adapters.holders;

import android.view.View;

import com.anchal.poetsandwriters.main.base.BaseActivity;
import com.anchal.poetsandwriters.managers.listeners.OnPostChangedListener;
import com.anchal.poetsandwriters.model.FollowingPost;
import com.anchal.poetsandwriters.model.Post;
import com.anchal.poetsandwriters.utils.LogUtil;


public class FollowPostViewHolder extends PostViewHolder {


    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity) {
        super(view, onClickListener, activity);
    }

    public FollowPostViewHolder(View view, OnClickListener onClickListener, BaseActivity activity, boolean isAuthorNeeded) {
        super(view, onClickListener, activity, isAuthorNeeded);
    }

    public void bindData(FollowingPost followingPost) {
        postManager.getSinglePostValue(followingPost.getPostId(), new OnPostChangedListener() {
            @Override
            public void onObjectChanged(Post obj) {
                bindData(obj);
            }

            @Override
            public void onError(String errorText) {
                LogUtil.logError(TAG, "bindData", new RuntimeException(errorText));
            }
        });
    }

}
