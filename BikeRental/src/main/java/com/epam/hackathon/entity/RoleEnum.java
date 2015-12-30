package com.epam.hackathon.entity;

public  enum RoleEnum {

    USER(2), ADMIN(1);

    public int getRoleId() {
        return roleId;
    }

    private int roleId;

    RoleEnum(int i) {
        roleId = i;
    }


}
