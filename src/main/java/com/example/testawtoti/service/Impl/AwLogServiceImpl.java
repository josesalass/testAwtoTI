package com.example.testawtoti.service.Impl;


import com.example.testawtoti.model.AwHashtagEntity;
import com.example.testawtoti.model.AwHashtagLogs;
import com.example.testawtoti.model.AwLogEntity;
import com.example.testawtoti.model.request.CreateLogRequest;
import com.example.testawtoti.model.request.GetLogsByHashtagIdRequest;
import com.example.testawtoti.model.response.CreateLogResponse;
import com.example.testawtoti.model.response.DatosLog;
import com.example.testawtoti.repository.AwHashtagRepository;
import com.example.testawtoti.repository.AwHastagLogsRepository;
import com.example.testawtoti.repository.AwLogRepository;
import com.example.testawtoti.service.AwHashtagService;
import com.example.testawtoti.service.AwLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AwLogServiceImpl implements AwLogService {

    @Autowired
    private AwLogRepository awLogRepository;

    @Autowired
    private AwHashtagRepository hashtagRepository;

    @Autowired
    private AwHastagLogsRepository hashtagLogsRepository;

    @Autowired
    private AwHashtagService hashtagService;

    public CreateLogResponse saveLog(CreateLogRequest logRequest){
         Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

        AwLogEntity awLog =  new AwLogEntity(createdAt,logRequest.getHost(),logRequest.getDetails());
        awLogRepository.save(awLog);


        for (int i=0;i<logRequest.getHashtags().size();i++) {
            AwHashtagEntity hashtagEntity = hashtagService.createHashtag(logRequest.getHashtags().get(i));
            System.out.println(hashtagEntity);
            AwHashtagLogs hashtagLog = new AwHashtagLogs(hashtagEntity, awLog);
            hashtagLogsRepository.save(hashtagLog);
        }
        CreateLogResponse response = new CreateLogResponse("AwLog saved Succesfully");
        return response;
    }

    public List<DatosLog> searchLogsByHashtagId(Integer hashtagId){
        System.out.println(hashtagId);
            return awLogRepository.findLogsByHashtag(hashtagId);
    }

}
