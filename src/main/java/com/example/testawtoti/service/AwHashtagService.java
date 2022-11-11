package com.example.testawtoti.service;

import com.example.testawtoti.model.AwHashtagEntity;
import com.example.testawtoti.model.request.UpdateHashtagRequest;

public interface AwHashtagService {
    public AwHashtagEntity createHashtag(String descripcion);
    public AwHashtagEntity searchHashtagIfExistsByDescription(String description);

    public String updateHashtag(UpdateHashtagRequest request);
}
