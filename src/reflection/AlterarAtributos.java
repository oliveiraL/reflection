package reflection;

import models.Pessoa;

import java.lang.reflect.Field;

public class AlterarAtributos {

    public static void main(String[] args) throws ClassNotFoundException {
        Pessoa pessoa = new Pessoa("Danilo", "55566633352", "teste@teste");

        System.out.println(pessoa.getCpf());
        Class<?> classe = Class.forName("models.Pessoa");

        try {
            Field cpf = classe.getDeclaredField("cpf");
            cpf.setAccessible(true);
            cpf.set(pessoa, "12345678910");

            System.out.println("Novo valor do atributo: " + pessoa.getCpf());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
