package com.dk.lombok.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @autor kevin.dai
 * @Date 2018/10/19
 */
public class Student extends User{

    @Getter
    @Setter
    private String number;

}
