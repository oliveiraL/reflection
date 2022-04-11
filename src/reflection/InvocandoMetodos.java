package reflection;

import models.Pessoa;
import utils.CPFUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocandoMetodos {
    public static void main(String[] args) throws ClassNotFoundException {
        Pessoa pessoa = new Pessoa( "Danilo", "55566633352", "teste@teste.com");
        CPFUtil cpfUtil = new CPFUtil();
        try {
//            Class<?> classe = Class.forName("models.Pessoa");
//
//            Method metodo = classe.getMethod("cpfFormatado");
//
//            Object resultado = metodo.invoke(pessoa);
//
//            System.out.println("Método sem parâmetro:" + resultado);

            Class<?> classe2 = Class.forName("utils.CPFUtil");
//            Method metodo = classe.getMethod("cpfFormatado");
            //Método com parâmetro
            Method metodo = classe2.getMethod("formater", String.class);

            Object[] parametros = new Object[1];
            parametros[0] = "22244456602";
            Object resultado = metodo.invoke(cpfUtil, parametros);

            System.out.println("Método com parâmetro: " + resultado);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
