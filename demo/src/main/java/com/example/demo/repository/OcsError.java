package com.example.demo.repository;



import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Data
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OcsError implements Serializable {

    private static final long serialVersionUID = -5196678330808007757L;

    private String jobDmsId;

    private Direction direction;

    private Operation operation;

    private Origin origin;

    private Location location;

    private String recommendation;

    private HttpStatus backendHTTPCode;

    private ResponseEntity backendErrorResponse;

    private String backendErrorRequest;

    private Severity severity;

    private String remediation;

    private BackendErrorSource backendErrorSource;

    private String timeFault;

    private String interfaceVersion;


    private String errorId = OcsErrorCode.OCS_0806.getValue();


    private String errorMessage = "";


    private String technicalDetails= "";


    private String description;


    private String xsfTicketId;


    private String instanaTraceId;


    private SystemName source;


    private SystemName target;


    private ErrorCategory errorCategory;

    public OcsError(String errorId, String errorMessage, SystemName source, SystemName target) {
        this(errorId, errorMessage);
        this.source = source;
        this.target = target;
    }

    public OcsError(String errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.instanaTraceId = createInstanaTraceId();
    }

    public OcsError(String errorId, String errorMessage, String technicalDetails) {
        this(errorId, errorMessage);
        this.technicalDetails = technicalDetails;
    }

    public OcsError(OcsErrorCode errorId, String errorMessage) {
        this.errorId = errorId.getValue();
        this.errorMessage = errorMessage;
        this.instanaTraceId = createInstanaTraceId();
    }

    public OcsError(OcsErrorCode errorId, String errorMessage, String technicalDetails) {
        this.errorId = errorId.getValue();
        this.errorMessage = errorMessage;
        this.technicalDetails = technicalDetails;
        this.instanaTraceId = createInstanaTraceId();
    }

    public OcsError(String errorMessage) {
        this.errorMessage = errorMessage;
        this.instanaTraceId = createInstanaTraceId();
    }

    private String createInstanaTraceId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes != null ? requestAttributes.getRequest() : null;
        String result;
        final String traceIdName = "X-INSTANA-T";
        if (request != null && request.getHeader(traceIdName) != null) {
            result = request.getHeader(traceIdName);
        } else {
            result = null;
        }
        return result;
    }

    public static final OcsError anonymize(OcsError ocsError) {
        if(ocsError == null) {
            return null;
        }
        ocsError.setErrorCategory(null);
        ocsError.setInstanaTraceId(null);
        ocsError.setSource(null);
        ocsError.setTarget(null);
        ocsError.setXsfTicketId(null);

        return ocsError;
    }
}
