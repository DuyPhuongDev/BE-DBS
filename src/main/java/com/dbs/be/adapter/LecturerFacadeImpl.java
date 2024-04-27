package com.dbs.be.adapter;

import com.dbs.be.domain.user.Lecturer;
import com.dbs.be.dto.LecturerDTO;
import com.dbs.be.port.facade.LecturerFacade;
import com.dbs.be.port.repository.LecturerRepository;
import com.dbs.be.rest.request.UpsertLecturerRequest;
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
    public void deleteLecturer(String lecturerId) {
        Optional<Lecturer> optionalLecturer = lecturerRepository.findById(lecturerId);
        if (optionalLecturer.isPresent()){
            lecturerRepository.deleteById(lecturerId);
        }else throw new RuntimeException("lecturer cannot found!\n");
    }
}
