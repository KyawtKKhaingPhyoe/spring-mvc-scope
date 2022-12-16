package com.example.springmvcscope.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
@Data
public class SessionScopeBean {

    private Integer value;

}
