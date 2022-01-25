package com.telerik.rest

import com.telerik.jpa.Course
import com.telerik.service.CourseService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
class CourseController {

  @Autowired
  CourseService courseService

  @GetMapping("/course/{id}")
  Course getCourseById(@PathVariable('id') Long id) {
    log.info("Getting Course by id")
    courseService.getCourseById(id)
  }

  @GetMapping("/course/title/{title}")
  Course getCourseByTitle(@PathVariable ('title') String title) {
    courseService.getCourseByTitle(title)
  }

  @GetMapping("/course/list")
  List<Course> getAllCourses() {
    courseService.getAllCourses()
  }

  @PostMapping("/course")
  Course addCourse(Course course) {
    courseService.saveCourse(course)
  }

  @PutMapping("/course")
  Course updateCourse(Course course) {
    courseService.saveCourse(course)
  }


}
