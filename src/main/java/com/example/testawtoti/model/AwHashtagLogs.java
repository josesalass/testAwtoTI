package com.example.testawtoti.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aw_hashtag_log")
public class AwHashtagLogs {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;


    @ManyToOne
    @JoinColumn(name = "hashtag_id", referencedColumnName="id")
    AwHashtagEntity hashTagEntity;

    @ManyToOne
    @JoinColumn(name = "log_id", referencedColumnName = "id")
    AwLogEntity logEntity;

    public AwHashtagLogs(AwHashtagEntity hashTagEntity, AwLogEntity logEntity) {
        this.hashTagEntity = hashTagEntity;
        this.logEntity = logEntity;
    }
}
