package com.example.demo_reflection.api;

import com.example.demo_reflection.dto.FieldResponse;
import com.example.demo_reflection.dto.Info;
import com.example.demo_reflection.dto.InfoResponse;
import com.example.demo_reflection.dto.MethodResponse;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class GenericApi {

    private ArrayList<Object> objects = new ArrayList<>();

    @GetMapping("listInfo")
    public InfoResponse listInfo(@RequestParam("class") String classeParam) throws ClassNotFoundException {
        Class<?> classe = Class.forName(classeParam);
        return new InfoResponse(
                Arrays.stream(classe.getDeclaredConstructors()).map(Constructor::toString).toList(),

                Arrays.stream(classe.getDeclaredMethods()).map(Method::toString).toList(),

                Arrays.stream(classe.getDeclaredFields()).map(field ->
                        new FieldResponse(
                                field.getName(),
                                field.getType().getName(),
                                Modifier.toString(field.getModifiers()
                        ))).toList()
        );
    }

    @PostMapping("/create")
    public Object create(@RequestBody() Info classeInfo) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> classe = Class.forName(classeInfo.classe());
        Object obj = null;
        if (classeInfo.parameters() == null || classeInfo.parameters().isEmpty()) {
            obj = classe.getConstructor().newInstance();
        } else {
            Class<?>[] classes = new Class[classeInfo.parameters().size()];

            for (int i = 0; i < classeInfo.parameters().size(); i++){
                classes[i] = Class.forName(classeInfo.parameters().get(i));
            }
            obj = classe.getConstructor(classes).newInstance(classeInfo.values());
        }
        objects.add(obj);
        return obj;

    }
}
