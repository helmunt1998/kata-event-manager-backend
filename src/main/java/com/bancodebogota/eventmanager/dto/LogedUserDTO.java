package com.bancodebogota.eventmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LogedUserDTO {

    private String token;
    private long expiresIn;

}
