package com.system.manager.controller;
import com.system.manager.DTO.AttendanceRequest;
import com.system.manager.DTO.AttendanceResponse;
import com.system.manager.entity.Student;
import com.system.manager.repository.StudentRepository;
import com.system.manager.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/attendance")
    public ResponseEntity<AttendanceResponse> markAttendance(@RequestBody AttendanceRequest request) {
        Student student = studentRepository.findByCardId(request.getCardId());
        boolean attendanceAdded = false;
        try {
            attendanceAdded = attendanceService.markAttendance(request.getCardId(), request.getDateTime());
        }
        catch (Exception ex) {
            attendanceAdded = false;
        }
        if (attendanceAdded) {
            // Return HTTP 200 OK with success JSON response
            AttendanceResponse response = new AttendanceResponse("Attendance added successfully", "Success", student.getName(), 200);
            return ResponseEntity.ok(response);
        } else {
            // Return HTTP 500 Internal Server Error with error message
            AttendanceResponse response = new AttendanceResponse("Attendance added successfully", "Failure", "", 404);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

