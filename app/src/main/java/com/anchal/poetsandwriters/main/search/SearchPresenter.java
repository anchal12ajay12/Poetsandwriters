

package com.anchal.poetsandwriters.main.search;

import android.app.Activity;

import com.anchal.poetsandwriters.main.base.BasePresenter;



class SearchPresenter extends BasePresenter<SearchView> {

    private String currentUserId;
    private Activity activity;

    SearchPresenter(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void search(String query) {

    }
}
