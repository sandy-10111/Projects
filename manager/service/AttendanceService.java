package com.system.manager.service;
import com.system.manager.entity.Attendance;
import com.system.manager.entity.Student;
import com.system.manager.repository.AttendanceRepository;
import com.system.manager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public boolean markAttendance(String cardId, LocalDateTime dateTime) {
        boolean attendanceAdded = false;
        Student student = studentRepository.findByCardId(cardId);
        if (student != null) {
            Attendance attendance = new Attendance();
            attendance.setDateTime(dateTime);
            attendance.setStudent(student);
            attendanceRepository.save(attendance);
            attendanceAdded = true;

        } else {
            // Handle case where student with given cardId is not found
            throw new RuntimeException("Student not found with cardId: " + cardId);
        }
        return attendanceAdded;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }
}

