package com.example.demo.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Validated
@Document(collection = "meta_data")
public class MetaData implements Serializable {

    private static final long serialVersionUID = 5429102480452608904L;

    private String callerService;

    private String callerServiceReferenceId;

    private JobType jobType;

    private ContextStatus status;

    private boolean isLocked = false;

    private OcsError ocsError;

    private String lastModified;

    private String deeplink;

    private String lastTransferToDms;

    @NotNull
    @Version
    private long version;

    @NotNull
    private List<String> involvedSystems = new ArrayList<>();

}
