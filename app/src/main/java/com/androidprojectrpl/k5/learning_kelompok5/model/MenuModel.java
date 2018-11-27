package com.androidprojectrpl.k5.learning_kelompok5.model;

public class MenuModel {

    public String menuName, icon, header;
    public boolean hasChildren, isGroup;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren, String icon, String header) {

        this.menuName = menuName;
        this.icon = icon;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
        this.header = header;
    }
}
