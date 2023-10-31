package com.example.demo.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Data
@Validated
@NoArgsConstructor
@Document(collection = "context_header")
public class ContextHeader implements Serializable {

    private static final long serialVersionUID = -3619312841851463927L;

    @NotNull
    private MTT mtt;

    @NotNull
    private Footprint creator;

    @NotNull
    private Footprint owner;

    @NotNull
    private Footprint lastUpdate;

    private String orderId;

    private String outletId;

    private String daimlerUserId;

    public Footprint getCreator() {
        if (creator == null) {
            creator = new Footprint();
        }
        return creator;
    }

    public MTT getMtt() {
        if (mtt == null) {
            mtt = MTT.generateMTT("OCS");
        }
        return mtt;
    }
}
