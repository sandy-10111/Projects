package com.system.manager.controller;


import com.system.manager.entity.Attendance;
import com.system.manager.entity.Student;
import com.system.manager.service.AttendanceService;
import com.system.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        List<Student> students = studentService.getAllStudents();
        List<Attendance> attendances = attendanceService.getAllAttendances();

        model.addAttribute("students", students);
        model.addAttribute("attendances", attendances);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String cardId = authentication.getName(); // Assuming cardId is used as username for authentication

        return "welcome";
    }
}

