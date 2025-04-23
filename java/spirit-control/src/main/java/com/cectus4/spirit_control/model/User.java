package com.cectus4.spirit_control;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String name;
    private int age;
    private Boolean gender;
    private String mail;

}
