package com.example.demo_reflection.dto;

import java.util.List;

public record Info(
        String classe,
        List<String> parameters,
        Object[] values

){}
