package com.example.demo_reflection.dto;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public record InfoResponse(
        List<String> constructors,
       List<String> methods,
        List<FieldResponse> fields
) {
}
