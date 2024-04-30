package com.dbs.be.domain.roadmap;

import com.dbs.be.domain.user.Lecturer;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Road_map")
public class RoadMap {
    @Id
    @Column(name = "ID")
    private String id;

    private String target;
    @ManyToOne
    @JoinColumn(name = "ID_lecturer")
    private Lecturer lecturer;
}
