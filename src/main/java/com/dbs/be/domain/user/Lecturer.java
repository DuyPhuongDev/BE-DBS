package com.dbs.be.domain.user;

import com.dbs.be.domain.course.Course;
import com.dbs.be.domain.roadmap.RoadMap;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lecturer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer extends User{
    private String degree;
    private String major;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RoadMap> roadMaps;

    public Lecturer(String id, String username, String password, String email, String phoneNumber, String fullName, String gender, Date bdate, String addr, String degree, String major) {
        super(id, username, password, email, phoneNumber, fullName, gender, bdate, addr);
        this.degree = degree;
        this.major = major;
    }
}
