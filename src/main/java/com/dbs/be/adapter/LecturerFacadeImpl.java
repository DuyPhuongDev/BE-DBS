package com.dbs.be.adapter;

import com.dbs.be.domain.user.Lecturer;
import com.dbs.be.domain.view.CourseInfo;
import com.dbs.be.dto.CourseInfoDTO;
import com.dbs.be.dto.LecturerDTO;
import com.dbs.be.port.facade.LecturerFacade;
import com.dbs.be.port.repository.CourseInfoRepository;
import com.dbs.be.port.repository.LecturerRepository;
import com.dbs.be.port.repository.UserRepository;
import com.dbs.be.rest.request.UpsertLecturerRequest;
import com.dbs.be.rest.response.CourseInfoResponse;
import com.dbs.be.rest.response.LecturerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LecturerFacadeImpl implements LecturerFacade {
    private final LecturerRepository lecturerRepository;
    private final CourseInfoRepository courseInfoRepository;
    private final UserRepository userRepository;
    @Override
    public List<LecturerResponse> getAllLecturerSortByName() {
        List<Lecturer> lecturers = lecturerRepository.findAllByOrderByFullNameAsc();
        if (lecturers.isEmpty()) return new ArrayList<>();
        return lecturers.stream().map(LecturerDTO::fromDomain).map(LecturerResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public void saveLecturer(UpsertLecturerRequest request) {
        userRepository.insertUser(
                request.getLecturerId(),
                request.getUserName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getPassword(),
                "lecturer",
                request.getFullName(),
                request.getGender(),
                request.getBdate(),
                request.getAddr(),
                request.getDegree(),
                request.getMajor()
        );
    }

    @Override
    public void updateLecturer(String lecturerId, UpsertLecturerRequest request) {
        userRepository.updateUser(
                request.getLecturerId(),
                request.getUserName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getPassword(),
                request.getFullName(),
                request.getGender(),
                request.getBdate(),
                request.getAddr(),
                request.getDegree(),
                request.getMajor(),
                "lecturer"
        );
    }

    @Override
    public void deleteLecturer(String lecturerId) {
        userRepository.deleteUser(lecturerId);
    }

    @Override
    public List<CourseInfoResponse> getCourse(String lecturerId) {
        List<CourseInfo> courseInfos = courseInfoRepository.getCourseByLecturer(lecturerId);
        if(courseInfos.isEmpty()) throw new RuntimeException("cannot found");
        return courseInfos.stream().map(CourseInfoDTO::fromDomain).map(CourseInfoResponse::toResponse).collect(Collectors.toList());
    }
}
