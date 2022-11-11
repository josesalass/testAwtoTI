package com.example.testawtoti.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "aw_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwLogEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", length = 11)
    private Integer awLogId;

    @OneToMany(mappedBy = "logEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<AwHashtagLogs> logs;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "host")
    private String host;

    @Column(name = "details")
    private String details;

    public AwLogEntity(Timestamp creationDate, String host, String details) {
        this.creationDate = creationDate;
        this.host = host;
        this.details = details;
    }

}
