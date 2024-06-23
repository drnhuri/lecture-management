package com.springcamp.api.service.impl;

import com.springcamp.api.common.GeneralException;
import com.springcamp.api.entity.Lecture;
import com.springcamp.api.repository.LectureRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService implements com.springcamp.api.service.LectureService {

    private LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }


    @Override
    public Lecture save(Lecture lecture) {
        if (StringUtils.isEmpty(lecture.getName())) {
            throw new GeneralException("Name cannot be empty!");
        }
        if (lecture.getTeacher() == null) {
            throw new GeneralException("Teacher cannot be empty!");
        }
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture getById(Integer id) {
        return lectureRepository.findById(id).orElseThrow(()-> new GeneralException("Lecture Not Found!"));
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }
    @Override
    public Page<Lecture> getAll(Pageable pageable) {
        return lectureRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!lectureRepository.existsById(id)) {
            throw new GeneralException("Lecture Not Found!");
        }
        lectureRepository.deleteById(id);
    }
}