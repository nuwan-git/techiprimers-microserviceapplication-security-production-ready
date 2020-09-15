package com.techiprimers.authorization.authservice.enums;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Status {

    DELETED(0,"Deleted"),
    OPEN(1,"Open"),
    Active(2, "Active"),
    Inactive(3, "Inactive");

    private final Integer statusSeq;
    private final String status;


    Status(Integer statusSeq, String status) {
        this.statusSeq = statusSeq;
        this.status = status;
    }

    public Integer getStatusSeq() {
        return statusSeq;
    }

    public String getStatus() {
        return status;
    }

    public static Status findOne(Integer statusSeq) {

        return Arrays.stream(Status.values())
                .filter(x-> x.statusSeq.equals(statusSeq))
                .findFirst()
                .orElse(null);
    }
}
