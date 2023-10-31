package com.example.demo.repository;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mysema.query.annotations.QueryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Validated
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Slf4j
@QueryEntity
@Document(collection = "context")
public class Context extends DBData {

    private static final long serialVersionUID = -5930618687962175489L;


    @Id
    private String id;

    @NotNull
    private ContextType type;


    @NotNull
    private ContextHeader header;


    private Footprint creator;


    private Footprint lastUpdate;


    @NotNull
    private MetaData contextMetaData;


    private List<ContextLink> linkedContextList = new ArrayList<>();


    @NotNull
    @Size(min = 1)
    private List<LinkingInformation> linkingInformations = new ArrayList<>();

    private Display display;

    @NotNull
    private String vehicleType;


    private String ownerId;

    @Override
    public String toString() {
        String result = super.toString();

        final ObjectMapper mapper = new ObjectMapper();

        try {
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("Error while processing json: {}", e.getMessage());
        }
        return result;
    }

    public ContextHeader getHeader() {
        if (header == null) {
            header = new ContextHeader();
        }
        return header;
    }

    public MetaData getMetadata() {
        if (contextMetaData == null) {
            contextMetaData = new MetaData();
        }
        return contextMetaData;
    }
}
