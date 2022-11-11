package com.example.testawtoti.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetLogsByHashtagIdRequest {
    private Integer id;
    private Timestamp creationDate;
    private String host;
    private String details;

}
