package com.example.testawtoti.service.Impl;

import com.example.testawtoti.exceptions.NoHashtagFoundException;
import com.example.testawtoti.model.AwHashtagEntity;
import com.example.testawtoti.model.request.UpdateHashtagRequest;
import com.example.testawtoti.repository.AwHashtagRepository;
import com.example.testawtoti.service.AwHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AwHashtagServiceImpl implements AwHashtagService {

    @Autowired
    private AwHashtagRepository hashtagRepository;

    public AwHashtagEntity createHashtag(String descripcion){
            AwHashtagEntity hashtag = new AwHashtagEntity(descripcion);
            if(searchHashtagIfExistsByDescription(hashtag.getDescription())==null){
                AwHashtagEntity hashtagEntity = hashtagRepository.save(hashtag);
                return hashtagEntity;
            }else{
                return searchHashtagIfExistsByDescription(hashtag.getDescription());
            }

    }

    public AwHashtagEntity searchHashtagIfExistsByDescription(String description){
        AwHashtagEntity hashtags;
        hashtags = hashtagRepository.findByDescription(description);
        System.out.println("hashtag " + hashtags);
        if(hashtags!=null){
            return hashtags;
        }else{
            return null;
        }
    }

    public String updateHashtag(UpdateHashtagRequest request) {
            AwHashtagEntity existingHashtag = hashtagRepository.findById(request.getId()).orElse(null);
            if (existingHashtag==null){
                throw new NoHashtagFoundException("Hashtag with id "+ request.getId()+ " doesn't exist");
            }else{
                existingHashtag.setDescription(request.getDescription());
                hashtagRepository.save(existingHashtag);
                return  "Hashtag description updated succesfully";
            }
    }

}
