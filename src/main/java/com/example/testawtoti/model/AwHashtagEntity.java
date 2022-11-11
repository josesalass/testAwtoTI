package com.example.testawtoti.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table (name = "aw_hashtag")
@Getter
@Setter
@NoArgsConstructor
public class AwHashtagEntity {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", length = 11)
    private Integer awHashtagId;

    @OneToMany(mappedBy = "hashTagEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<AwHashtagLogs> hashtags;

    @Column(name = "description", length = 50)
    private String description;

    public AwHashtagEntity(String description) {
        this.description = description;
    }
}
