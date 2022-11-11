package com.example.testawtoti.model.response;

import java.sql.Timestamp;

public interface DatosLog {
    Integer getId();
    Timestamp getcreation_date();
    String getHost();
    String getDetails();
}
