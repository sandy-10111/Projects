package com.system.manager.DTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AttendanceRequest {

    private String cardId;
    private LocalDateTime dateTime;

    // getters and setters
    // constructors
}

