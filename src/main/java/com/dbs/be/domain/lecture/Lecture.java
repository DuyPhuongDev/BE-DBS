package com.dbs.be.domain.lecture;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecture")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Lecture {
    @Id
    @Column(name = "lecture_id")
    private String id;

    private String title;

    private String Video;
    private String duration;

}
