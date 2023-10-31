package com.example.demo.repository;


import java.util.Arrays;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OcsErrorCode {
    OCS_0806("0806"),
    OCS_0003("0003"),
    INTERNAL_JOB_ALREADY_TRANSFERRED("9001"),
    INTERNAL_JOB_LOCKED_BY_DMS("9002"),
    INVALID_PAYLOAD_ERROR_CODE("1801", "Exception that is thrown when a validation error of the incoming XML request " +
            "message. The exeption reason is provided."),
    INVALID_SERVICE_VERSION_ERROR_CODE_V24("1802"),
    INVALID_FIN_AND_REGISTRATION_NUMBER_ERROR_CODE("0009"),
    OCS_INTERNAL_TIMEOUT("0808"),
    DMS_AUTHORIZATION_ERROR_CODE("1804"),
    STRUCTURE_VALIDATION_ERROR_CODE("1801"),
    INCOMPATIBLE_SERVICE_VERSION_ERROR_CODE("1802"),
    INVALID_OPERATION_EXCEPTION("1811"),
    SRS_COMMUNICATION_ERROR_CODE("0807"),
    SRS_COMMUNICATION_TIMEOUT("0809", "!DMS Timeout Response Exception. Please try again later."),
    PERSISTENT_LINE_NOT_ACTIVE("0811", "!DMS Connection Exception. Please contact your DMS administrator to check your" +
            " DMS connection to XENTRY Portal."),
    MESSAGE_SIZE_ERROR_CODE("0813"),
    FIN_VIN_CANNOT_BE_CHANGED("0006", "FIN or VIN not consistent. "),
    DIVISION_DOES_NOT_MATCH_COMPANY_TYPE("DIVISION_DOES_NOT_MATCH_COMPANY_TYPE"),
    THE_RESOURCE_THAT_IS_BEING_ACCESSED_IS_LOCKED("0423", "The order is currently locked in XENTRY Portal. A transfer " +
            "to the DMS has already taken place. Please check if you can edit the order in your DMS and close the " +
            "order in XENTRY"),
    CUSTOMER_CONCERN_CLASSIFICATION_ERROR("0806","Customer Concern Classification not correct."),
    XRS_COMMUNICATION_ERROR("XRS_COMMUNICATION_ERROR");

    private String value;
    private String errorText;

    OcsErrorCode(String value) {
        this.value = value;
    }

    OcsErrorCode(String value, String errorText) {
        this(value);
        this.errorText = errorText;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OcsErrorCode fromValue(final String value) {
        return Arrays.stream(OcsErrorCode.values())
                .filter(err -> Objects.equals(String.valueOf(err.getValue()), value))
                .findFirst()
                .orElse(null);
    }

    /**
     * @return the errorText
     */
    public String getErrorText() {
        return errorText;
    }

}
