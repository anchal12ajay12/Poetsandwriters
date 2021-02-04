

package com.anchal.poetsandwriters.managers.listeners;

import com.anchal.poetsandwriters.model.PostListResult;

public interface OnPostListChangedListener<Post> {

    public void onListChanged(PostListResult result);

    void onCanceled(String message);
}
