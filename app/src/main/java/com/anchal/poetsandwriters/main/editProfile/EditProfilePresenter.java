

package com.anchal.poetsandwriters.main.editProfile;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.anchal.poetsandwriters.R;
import com.anchal.poetsandwriters.main.base.BaseView;
import com.anchal.poetsandwriters.main.pickImageBase.PickImagePresenter;
import com.anchal.poetsandwriters.managers.ProfileManager;
import com.anchal.poetsandwriters.managers.listeners.OnObjectChangedListenerSimple;
import com.anchal.poetsandwriters.model.Profile;
import com.anchal.poetsandwriters.utils.ValidationUtil;



public class EditProfilePresenter<V extends EditProfileView> extends PickImagePresenter<V> {

    protected Profile profile;
    protected ProfileManager profileManager;

    protected EditProfilePresenter(Context context) {
        super(context);
        profileManager = ProfileManager.getInstance(context.getApplicationContext());

    }

    public void loadProfile() {
        ifViewAttached(BaseView::showProgress);
        profileManager.getProfileSingleValue(getCurrentUserId(), new OnObjectChangedListenerSimple<Profile>() {
            @Override
            public void onObjectChanged(Profile obj) {
                profile = obj;
                ifViewAttached(view -> {
                    if (profile != null) {
                        view.setName(profile.getUsername());

                        if (profile.getPhotoUrl() != null) {
                            view.setProfilePhoto(profile.getPhotoUrl());
                        }
                    }

                    view.hideProgress();
                    view.setNameError(null);
                });
            }
        });
    }

    public void attemptCreateProfile(Uri imageUri) {
        if (checkInternetConnection()) {
            ifViewAttached(view -> {
                view.setNameError(null);

                String name = view.getNameText().trim();
                boolean cancel = false;

                if (TextUtils.isEmpty(name)) {
                    view.setNameError(context.getString(R.string.error_field_required));
                    cancel = true;
                } else if (!ValidationUtil.isNameValid(name)) {
                    view.setNameError(context.getString(R.string.error_profile_name_length));
                    cancel = true;
                }

                if (!cancel) {
                    view.showProgress();
                    profile.setUsername(name);
                    createOrUpdateProfile(imageUri);
                }
            });
        }
    }

    private void createOrUpdateProfile(Uri imageUri) {
        profileManager.createOrUpdateProfile(profile, imageUri, success -> {
            ifViewAttached(view -> {
                view.hideProgress();
                if (success) {
                    onProfileUpdatedSuccessfully();
                } else {
                    view.showSnackBar(R.string.error_fail_create_profile);
                }
            });
        });
    }

    protected void onProfileUpdatedSuccessfully() {
        ifViewAttached(BaseView::finish);
    }

}
