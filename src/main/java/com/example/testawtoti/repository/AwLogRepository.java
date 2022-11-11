package com.example.testawtoti.repository;

import com.example.testawtoti.model.AwLogEntity;
import com.example.testawtoti.model.query.FindLogsByHashtagQuery;
import com.example.testawtoti.model.request.GetLogsByHashtagIdRequest;
import com.example.testawtoti.model.response.DatosLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AwLogRepository extends JpaRepository<AwLogEntity, Integer> {

    @Query(value = FindLogsByHashtagQuery.LOGS_BY_hASHTAG + "WHERE aw_hashtag.id = :hashTagId", nativeQuery = true)
    List<DatosLog> findLogsByHashtag(int hashTagId);
}
