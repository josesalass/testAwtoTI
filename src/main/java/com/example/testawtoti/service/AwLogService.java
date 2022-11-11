package com.example.testawtoti.service;

import com.example.testawtoti.model.request.CreateLogRequest;
import com.example.testawtoti.model.response.CreateLogResponse;
import com.example.testawtoti.model.response.DatosLog;

import java.util.List;

public interface AwLogService {

    public CreateLogResponse saveLog(CreateLogRequest tripRequest);
    public List<DatosLog> searchLogsByHashtagId(Integer hashtagId);
}
