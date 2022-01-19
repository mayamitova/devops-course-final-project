package com.telerik.rest

import com.telerik.jpa.Course
import com.telerik.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CourseController {

  @Autowired
  CourseService courseService

  @GetMapping("/course/{id}")
  Course getUserById(@PathVariable('id') Long id) {
    courseService.getCourseById(id)
  }

  @GetMapping("/course/title/{title}")
  Course getUserByLogin(@PathVariable ('title') String title) {
    courseService.getCourseByTitle(title)
  }
}
