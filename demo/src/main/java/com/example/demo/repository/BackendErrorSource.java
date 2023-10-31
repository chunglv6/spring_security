package com.example.demo.repository;

import java.util.Arrays;

public enum BackendErrorSource {
    SRS, DMS, OCS, XRS, XJS, UNKNOWN;

    public static BackendErrorSource getBackendSource(String source) {
        return Arrays.stream(BackendErrorSource.values()).filter(o -> o.name().equals(source)).findFirst().orElse(UNKNOWN);
    }
}