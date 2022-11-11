package com.example.testawtoti.controllers;

import com.example.testawtoti.model.request.CreateLogRequest;
import com.example.testawtoti.model.request.UpdateHashtagRequest;
import com.example.testawtoti.model.response.CreateLogResponse;
import com.example.testawtoti.model.response.DatosLog;
import com.example.testawtoti.service.AwHashtagService;
import com.example.testawtoti.service.AwLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<DatosLog>> searchLogsByHashtagId(@PathVariable int hashtagId ){
        return new ResponseEntity<>(logService.searchLogsByHashtagId(hashtagId),HttpStatus.OK);
    }

    @PostMapping("/logs")
    public ResponseEntity<CreateLogResponse> createLog(@RequestBody CreateLogRequest request) {
        return new ResponseEntity<>(logService.saveLog(request), HttpStatus.CREATED);
    }

    @PutMapping("/hashtags")
    public ResponseEntity<String> updateHashtagDescription(@RequestBody UpdateHashtagRequest request) {
        return new ResponseEntity<>(hashtagService.updateHashtag(request), HttpStatus.OK) ;
    }
}
