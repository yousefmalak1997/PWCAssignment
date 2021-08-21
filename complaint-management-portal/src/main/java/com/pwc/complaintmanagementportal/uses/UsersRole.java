package com.pwc.complaintmanagementportal.uses;

public enum UsersRole {

    USER("USER"),
    ADMIN("ADMIN");

    private final String enumName;

    UsersRole(String enumName) {
        this.enumName = enumName;
    }

    public String getEnumName() {
        return enumName;
    }
}
