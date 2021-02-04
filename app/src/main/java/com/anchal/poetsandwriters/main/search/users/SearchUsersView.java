package com.anchal.poetsandwriters.main.search.users;

import com.anchal.poetsandwriters.main.base.BaseFragmentView;
import com.anchal.poetsandwriters.model.Profile;

import java.util.List;


public interface SearchUsersView extends BaseFragmentView {
    void onSearchResultsReady(List<Profile> profiles);

    void showLocalProgress();

    void hideLocalProgress();

    void showEmptyListLayout();

    void updateSelectedItem();
}
