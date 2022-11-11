package com.example.testawtoti.service;

import com.example.testawtoti.model.AwLogEntity;
import com.example.testawtoti.model.request.CreateLogRequest;
import com.example.testawtoti.model.request.GetLogsByHashtagIdRequest;
import com.example.testawtoti.model.response.CreateLogResponse;
import com.example.testawtoti.model.response.DatosLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AwLogService {

    public CreateLogResponse saveLog(CreateLogRequest tripRequest);
    public List<DatosLog> searchLogsByHashtagId(Integer hashtagId);
}
