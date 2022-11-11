package com.example.testawtoti.controllers;

import com.example.testawtoti.model.AwHashtagEntity;
import com.example.testawtoti.model.AwLogEntity;
import com.example.testawtoti.model.request.CreateLogRequest;
import com.example.testawtoti.model.request.GetLogsByHashtagIdRequest;
import com.example.testawtoti.model.request.UpdateHashtagRequest;
import com.example.testawtoti.model.response.CreateLogResponse;
import com.example.testawtoti.model.response.DatosLog;
import com.example.testawtoti.service.AwHashtagService;
import com.example.testawtoti.service.AwLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HashtagLogsController {

    @Autowired
    private AwLogService logService;

    @Autowired
    private AwHashtagService hashtagService;


    @GetMapping("/logs/hashtag/{hashtagId}")
    public List<DatosLog> searchLogsByHashtagId(@PathVariable int hashtagId ){
        System.out.println(hashtagId);
        return logService.searchLogsByHashtagId(hashtagId);
    }

    @PostMapping("/logs")
    public ResponseEntity<CreateLogResponse> createLog(@RequestBody CreateLogRequest request) {
        return ResponseEntity.ok(logService.saveLog(request));
    }

    @PutMapping("/hashtags")
    public String updateHashtagDescription(@RequestBody UpdateHashtagRequest request) {
        return hashtagService.updateHashtag(request);
    }
}
