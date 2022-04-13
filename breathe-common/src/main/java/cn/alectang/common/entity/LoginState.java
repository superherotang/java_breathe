package cn.alectang.common.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class LoginState implements Serializable {

    private String token;

    private int states;
}
