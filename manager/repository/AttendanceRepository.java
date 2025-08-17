package com.system.manager.repository;
import com.system.manager.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // any custom query methods can be defined here
}
