package com.pwc.complaintmanagementportal.complaint;

public enum ComplaintsStats {

    RESOLVED("RESOLVED"),
    PENDING("PENDING") ,
    DISMISSED("DISMISSED");

    private final String enumName;

    ComplaintsStats(String enumName) {
        this.enumName = enumName;
    }

    public String getEnumName() {
        return enumName;
    }
}
