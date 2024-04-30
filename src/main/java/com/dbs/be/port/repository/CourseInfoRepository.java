package com.dbs.be.port.repository;

import com.dbs.be.domain.view.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM dbo.getCourseByLecturer(:lecturerId) ")
    List<CourseInfo> getCourseByLecturer(@Param("lecturerId") String lecturerId);
}
