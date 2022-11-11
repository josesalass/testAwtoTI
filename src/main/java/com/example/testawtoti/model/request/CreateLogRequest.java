package com.example.testawtoti.model.request;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CreateLogRequest {
    private String host;
    private String details;
    private ArrayList<String> hashtags;
}
