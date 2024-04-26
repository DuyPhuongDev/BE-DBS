package com.dbs.be.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@Getter
@Setter
public class Admin extends User{
}
