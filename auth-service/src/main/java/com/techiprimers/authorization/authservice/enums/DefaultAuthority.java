package com.techiprimers.authorization.authservice.enums;

public enum DefaultAuthority {

    CREATE("CREATE"),
    VIEW("VIEW"),
    UPDATE("UPDATE"),
    APPROVE("APPROVE"),
    CLOSE("CLOSE"),
    PAGE("PAGE");

    private String authorityName;

    DefaultAuthority(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
