package reflection;

import java.lang.reflect.Field;

public class RecuperaAtributos {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classe = Class.forName("models.Pessoa");

        Field[] atributos = classe.getDeclaredFields();
//        Field[] atributos = classe.getFields();

        for (Field atributo : atributos) {
            System.out.println(atributo);
        }
    }
}
