package com.example.demo.controller;


import org.springframework.util.StreamUtils;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RequestResponseLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);

        chain.doFilter(request, responseWrapper);
        final byte[] originalData = responseWrapper.getContentAsByteArray();
        final int originalLength = responseWrapper.getContentSize();
        if (responseWrapper.getContentType() != "application/soap+xml") {
            final String newData = "<env:Envelope xmlns:env=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                    "\t<env:Header>\n" +
                    "\t\t<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" env:mustUnderstand=\"1\">\n" +
                    "\t\t\t<wsse:UsernameToken xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"XWSSGID-16783272424331246288825\">\n" +
                    "\t\t\t\t<wsse:Username>DSX_OCS_DEV3_1</wsse:Username>\n" +
                    "\t\t\t\t<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">xbqXNgqgw8</wsse:Password>\n" +
                    "\t\t\t</wsse:UsernameToken>\n" +
                    "\t\t</wsse:Security>\n" +
                    "\t</env:Header>\n" +
                    "\t<env:Body>\n" +
                    "\t\t<ns8:sendSyncDataRequest xmlns:Message=\"http://dms.ri.as.daimler.com/DMSService\" xmlns:ns10=\"http://com.daimler.retail.retacc/message/types/r1\" xmlns:ns11=\"http://com.daimler.retail.retacc/message/r1\" xmlns:ns12=\"http://com.daimler.retail.retacc/message/dms/r1\" xmlns:ns2=\"http://dms.ri.as.daimler.com/DMSService/types\" xmlns:ns3=\"http://dms.ri.as.daimler.com/DMSService/dms_sending\" xmlns:ns4=\"http://dms.ri.as.daimler.com/DMSService/xp_sending\" xmlns:ns8=\"http://stc.daimler.com/2009/08/DS/int\" xmlns:ns9=\"http://com.daimler.retail.retacc/message/asm/r1\" xmlns:stcds=\"http://stc.daimler.com/2009/08/DS\" xmlns:stcdsext=\"http://stc.daimler.com/2009/08/DS/ext\">\n" +
                    "\t\t\t<ns8:type>SERVICE_JOB_23</ns8:type>\n" +
                    "\t\t\t<ns8:operation>TransferJobToDms</ns8:operation>\n" +
                    "\t\t\t<ns8:externalSystemID>GS0001223</ns8:externalSystemID>\n" +
                    "\t\t\t<ns8:structuredData>\n" +
                    "\t\t\t\t<Message:Message>\n" +
                    "\t\t\t\t\t<Message:BusinessContext>\n" +
                    "\t\t\t\t\t\t<Message:DmsType>SuGDMSys</Message:DmsType>\n" +
                    "\t\t\t\t\t\t<Message:DmsVersion>18.1</Message:DmsVersion>\n" +
                    "\t\t\t\t\t\t<Message:ServiceVersion>2.4</Message:ServiceVersion>\n" +
                    "\t\t\t\t\t\t<Message:Type>REQUEST</Message:Type>\n" +
                    "\t\t\t\t\t</Message:BusinessContext>\n" +
                    "\t\t\t\t\t<Message:UserContext>\n" +
                    "\t\t\t\t\t\t<Message:DaimlerUserId>LEVANCH</Message:DaimlerUserId>\n" +
                    "\t\t\t\t\t\t<Message:UserLocale>en</Message:UserLocale>\n" +
                    "\t\t\t\t\t</Message:UserContext>\n" +
                    "\t\t\t\t\t<Message:ProcessContext>\n" +
                    "\t\t\t\t\t\t<Message:Timestamp>2023-03-09T02:02:13.365Z</Message:Timestamp>\n" +
                    "\t\t\t\t\t\t<Message:TrackingId>iWr1gzodFRNW</Message:TrackingId>\n" +
                    "\t\t\t\t\t</Message:ProcessContext>\n" +
                    "\t\t\t\t\t<Message:ServiceMessage>\n" +
                    "\t\t\t\t\t\t<Message:TransferJobToDmsRequest JobId=\"14855030\">\n" +
                    "\t\t\t\t\t\t\t<ns4:Job Currency=\"EUR\">\n" +
                    "\t\t\t\t\t\t\t\t<ns4:CustomerConcern Classification=\"Customer_Request\" ExternalId=\"7KbhT\" InternalId=\"hVNg\" Title=\"Te5jL8DdNbNniFGxdwL9\">\n" +
                    "\t\t\t\t\t\t\t\t\t<ns2:Notes CustomerStatement=\"oeltiXvra8xORr0zPny7P4An0wTriSLPFcQ9vcBPqPjgpIaYyEe6657oypiTK8veThzGieqId0bXBJ1RHWa202oAgWtc5hJGJ4Lb\"/>\n" +
                    "\t\t\t\t\t\t\t\t\t<ns2:WorkItem Description=\"OUImPHhDqdxxR6X3BVphOjJkEvMD1Mhj7KdDL64za3I9QabwhVUKV20223tVjCCmuyWpsvjtVGzuzrEH4tqCRxzFIwvifS7vKZxm\" EditType=\"Lock\" ExternalId=\"UKV4G\" InternalId=\"dIxt\" InvoiceCode=\"NA\" IsNegative=\"false\" Number=\"79345700\" Origin=\"Local\" PosNo=\"1\" Unit=\"AW\" Value=\"0.0\"/>\n" +
                    "\t\t\t\t\t\t\t\t</ns4:CustomerConcern>\n" +
                    "\t\t\t\t\t\t\t\t<ns4:ServiceMeasure Description=\"22P6490011 Tightness Rear\" ExternalId=\"\" InternalId=\"CaiLjO\" Selected=\"false\" Type=\"RECALL\">\n" +
                    "\t\t\t\t\t\t\t\t\t<ns2:DefectKey Code=\"*6490011*\"/>\n" +
                    "\t\t\t\t\t\t\t\t</ns4:ServiceMeasure>\n" +
                    "\t\t\t\t\t\t\t\t<ns4:Order OrderId=\"394619788\" PaymentMethod=\"E\" ReceptionDateTime=\"2023-02-27T09:30:30.000Z\" ReturnDateTime=\"2023-03-05T09:30:30.000Z\">\n" +
                    "\t\t\t\t\t\t\t\t\t<ns2:ServiceAdvisor Abbreviation=\"LEVANCH\" FirstName=\"Chung\" LastName=\"Le Van\"/>\n" +
                    "\t\t\t\t\t\t\t\t\t<ns2:Technician Abbreviation=\"SuMa\" FirstName=\"Super\" LastName=\"Man\"/>\n" +
                    "\t\t\t\t\t\t\t\t</ns4:Order>\n" +
                    "\t\t\t\t\t\t\t\t<ns4:Vehicle FinOrVin=\"WDD2050401F004773\" FirstRegistrationDate=\"2021-03-06Z\" OdometerReading=\"8149926\" OdometerUnit=\"km\" RegistrationNumber=\"KL-SS 1838\"/>\n" +
                    "\t\t\t\t\t\t\t\t<ns4:Customer CallbackFlag=\"false\" WaitingFlag=\"false\"/>\n" +
                    "\t\t\t\t\t\t\t</ns4:Job>\n" +
                    "\t\t\t\t\t\t</Message:TransferJobToDmsRequest>\n" +
                    "\t\t\t\t\t</Message:ServiceMessage>\n" +
                    "\t\t\t\t</Message:Message>\n" +
                    "\t\t\t</ns8:structuredData>\n" +
                    "\t\t\t<ns8:requestType>NOTIFICATION_REQUEST</ns8:requestType>\n" +
                    "\t\t</ns8:sendSyncDataRequest>\n" +
                    "\t</env:Body>\n" +
                    "</env:Envelope>";
            final int newLength = newData.length();
            response.setContentLength(newLength);
            response.setContentType("application/soap+xml");
            response.getOutputStream().write(newData.getBytes(StandardCharsets.UTF_8));
            response.flushBuffer();
        }else {
            response.setContentLength(originalLength);
            response.getOutputStream().write(originalData);
            response.flushBuffer();
        }


    }
}
