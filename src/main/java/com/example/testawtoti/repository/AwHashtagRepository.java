package com.example.testawtoti.repository;

import com.example.testawtoti.model.AwHashtagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwHashtagRepository extends JpaRepository<AwHashtagEntity, Integer> {
    AwHashtagEntity findByDescription(String description);
}
