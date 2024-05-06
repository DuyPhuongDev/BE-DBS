package com.dbs.be.port.repository;

import com.dbs.be.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("SELECT c FROM Course c JOIN StudentCourse sc ON c.courseId=sc.course.courseId WHERE sc.student.id=:studentId")
    List<Course> findCoursesByStudentId(@Param("studentId") String studentId);

    Optional<Course> findByCourseId(String courseId);

    @Procedure(procedureName = "Course_student")
    List<Course> findCourseStudent(@Param("ID_student") String studentId);

    @Query("SELECT c FROM Course c JOIN StudentCourse sc ON c.courseId=sc.course.courseId WHERE sc.student.id=:studentId AND sc.course.courseId=:courseId")
    Course findCourseByCourseIdAndStudentId(@Param("studentId") String studentId,
                                            @Param("courseId") String courseId);

    @Query("SELECT DISTINCT c FROM Course c " +
            "LEFT JOIN c.studentCourses sc " +
            "WHERE (:lecturerId IS NULL OR c.lecturer.id = :lecturerId) " +
            "AND (sc.student.id = :studentId)" +
            "AND (:requiredLevel IS NULL OR c.requiredLevel = :requiredLevel) " +
            "AND (:priceFrom IS NULL OR c.price >= :priceFrom) " +
            "AND (:priceTo IS NULL OR c.price <= :priceTo) " +
            "AND (:progressFrom IS NULL OR sc.progress >= :progressFrom) " +
            "AND (:progressTo IS NULL OR sc.progress <= :progressTo) " +
            "ORDER BY " +
            "CASE WHEN :sortBy = 'ASC' THEN c.price END ASC, " +
            "CASE WHEN :sortBy = 'DESC' THEN c.price END DESC")
    List<Course> findCoursesByCriteriaAndSort(
            @Param("studentId") String studentId,
            @Param("lecturerId") String lecturerId,
            @Param("requiredLevel") String requiredLevel,
            @Param("priceFrom") Double priceFrom,
            @Param("priceTo") Double priceTo,
            @Param("progressFrom") Double progressFrom,
            @Param("progressTo") Double progressTo,
            @Param("sortBy") String sortBy
    );
        @Procedure(procedureName = "GetFilteredCourses")
        List<Course> filterCourse(@Param("lecturerId") String lecturerId,
                                @Param("requiredLevel") String requiredLevel,
                                @Param("topic") String topic,
                                @Param("priceFrom") Double priceFrom,
                                @Param("priceTo") Double priceTo,
                                @Param("sortBy") String sortBy);

}
