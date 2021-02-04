

package com.anchal.poetsandwriters.model;


import com.anchal.poetsandwriters.enums.ItemType;

public interface LazyLoading {
    ItemType getItemType();
    void setItemType(ItemType itemType);
}
