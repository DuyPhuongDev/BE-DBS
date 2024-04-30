package com.dbs.be.adapter;

import com.dbs.be.domain.user.Lecturer;
import com.dbs.be.domain.view.CourseInfo;
import com.dbs.be.dto.CourseInfoDTO;
import com.dbs.be.dto.LecturerDTO;
import com.dbs.be.port.facade.LecturerFacade;
import com.dbs.be.port.repository.CourseInfoRepository;
import com.dbs.be.port.repository.LecturerRepository;
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
    @Override
    public List<LecturerResponse> getAllLecturerSortByName() {
        List<Lecturer> lecturers = lecturerRepository.findAllByOrderByFullNameAsc();
        if (lecturers.isEmpty()) return new ArrayList<>();
        return lecturers.stream().map(LecturerDTO::fromDomain).map(LecturerResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public void saveLecturer(UpsertLecturerRequest request) {
        Lecturer lecturer = new  Lecturer(
                request.getLecturerId(),
                request.getUserName(),
                request.getPassword(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getFullName(),
                request.getGender(),
                request.getBdate(),
                request.getAddr(),
                request.getDegree(),
                request.getMajor()
                );
        lecturerRepository.save(lecturer);
    }

    @Override
    public void updateLecturer(String lecturerId, UpsertLecturerRequest request) {
        Optional<Lecturer> optionalLecturer = lecturerRepository.findById(lecturerId);
        if (optionalLecturer.isPresent()){
            Lecturer lecturer = optionalLecturer.get();
            if (request.getUserName()!=null) lecturer.setUsername(request.getUserName());
            if(request.getPassword()!=null) lecturer.setPassword(request.getPassword());
            if(request.getEmail()!=null) lecturer.setEmail(request.getEmail());
            if(request.getPhoneNumber()!=null) lecturer.setPhoneNumber(request.getPhoneNumber());
            if(request.getFullName()!=null) lecturer.setFullName(request.getFullName());
            if(request.getGender()!=null) lecturer.setGender(request.getGender());
            if(request.getBdate()!=null) lecturer.setBdate(request.getBdate());
            if(request.getAddr()!=null) lecturer.setAddr(request.getAddr());
            if(request.getDegree()!=null) lecturer.setDegree(request.getDegree());
            if(request.getMajor()!=null) lecturer.setMajor(request.getMajor());
            lecturerRepository.save(lecturer);
        }else throw new RuntimeException("lecturer not found!\n");
    }

    @Override
    public void deleteLecturer(String lecturerId) {
        Optional<Lecturer> optionalLecturer = lecturerRepository.findById(lecturerId);
        if (optionalLecturer.isPresent()){
            lecturerRepository.deleteById(lecturerId);
        }else throw new RuntimeException("lecturer cannot found!\n");
    }

    @Override
    public List<CourseInfoResponse> getCourse(String lecturerId) {
        List<CourseInfo> courseInfos = courseInfoRepository.getCourseByLecturer(lecturerId);
        if(courseInfos.isEmpty()) throw new RuntimeException("cannot found");
        return courseInfos.stream().map(CourseInfoDTO::fromDomain).map(CourseInfoResponse::toResponse).collect(Collectors.toList());
    }
}
