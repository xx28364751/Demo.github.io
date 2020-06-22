package com.example.demo.Entity;

public class Menu {
    private int menu_id;
    private String menu_href;
    private String menu_title;
    private int menu_role;
    private String menu_remark;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_href() {
        return menu_href;
    }

    public void setMenu_href(String menu_href) {
        this.menu_href = menu_href;
    }

    public String getMenu_title() {
        return menu_title;
    }

    public void setMenu_title(String menu_title) {
        this.menu_title = menu_title;
    }

    public int getMenu_role() {
        return menu_role;
    }

    public void setMenu_role(int menu_role) {
        this.menu_role = menu_role;
    }

    public String getMenu_remark() {
        return menu_remark;
    }

    public void setMenu_remark(String menu_remark) {
        this.menu_remark = menu_remark;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_href='" + menu_href + '\'' +
                ", menu_title='" + menu_title + '\'' +
                ", menu_role=" + menu_role +
                ", menu_remark='" + menu_remark + '\'' +
                '}';
    }
}
