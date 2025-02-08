package com.coursetracker.coursetracker.service;

import com.coursetracker.coursetracker.exception.CourseNotFoundException;
import com.coursetracker.coursetracker.model.Course;
import com.coursetracker.coursetracker.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new CourseNotFoundException(String.format("Course with id %s not found", id)));
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        getCourseById(id);
        return courseRepository.save(updatedCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
