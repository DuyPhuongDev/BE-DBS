package com.dbs.be.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "lecture")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer extends User{
    private String degree;
    private String major;
}
