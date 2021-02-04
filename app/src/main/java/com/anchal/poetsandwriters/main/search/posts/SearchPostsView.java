

package com.anchal.poetsandwriters.main.search.posts;

import com.anchal.poetsandwriters.main.base.BaseFragmentView;
import com.anchal.poetsandwriters.model.Post;

import java.util.List;


public interface SearchPostsView extends BaseFragmentView {
    void onSearchResultsReady(List<Post> posts);
    void showLocalProgress();
    void hideLocalProgress();
    void showEmptyListLayout();
}
