

package com.anchal.poetsandwriters.managers.listeners;

import com.anchal.poetsandwriters.model.Post;

public interface OnPostChangedListener {
    public void onObjectChanged(Post obj);

    public void onError(String errorText);
}
