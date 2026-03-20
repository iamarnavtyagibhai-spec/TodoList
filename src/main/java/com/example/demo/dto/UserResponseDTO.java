package com.example.demo.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {

    private String id;
    private String name;
    private String email;
    private Instant createdAt;
    

}
