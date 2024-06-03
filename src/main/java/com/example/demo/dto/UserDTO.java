package com.example.demo.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private int userAge;
    private String userHp;
    private String userRole;
    private LocalDate rDate;
}
