

package com.anchal.poetsandwriters.main.editProfile;

import com.anchal.poetsandwriters.main.pickImageBase.PickImageView;



public interface EditProfileView extends PickImageView {
    void setName(String username);

    void setProfilePhoto(String photoUrl);

    String getNameText();

    void setNameError(String string);
}
