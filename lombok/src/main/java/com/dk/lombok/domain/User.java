package com.dk.lombok.domain;

import lombok.*;

/**
 * @autor kevin.dai
 * @Date 2018/10/18
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String name;

    private int age;

    private boolean isAdmin;

}
