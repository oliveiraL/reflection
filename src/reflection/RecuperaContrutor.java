package reflection;

import java.lang.reflect.Constructor;

public class RecuperaContrutor {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classe = Class.forName("models.Pessoa");

        Constructor<?>[] construtores = classe.getDeclaredConstructors();

        for (Constructor<?> construtor : construtores) {
            System.out.println(construtor);
        }
    }
}
