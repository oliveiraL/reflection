package reflection;

import java.lang.reflect.Modifier;

public class DemaisFuncionalidades {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classe = Class.forName("models.Pessoa");

        System.out.println("Modificador de acesso");

        int modificador = classe.getModifiers();
        System.out.println("Privado: " + Modifier.isPrivate(modificador));
        System.out.println("Público: " + Modifier.isPublic(modificador));
        System.out.println("Protegido: " + Modifier.isProtected(modificador));
        System.out.println("\n-------------------------\n");

        System.out.println("Pacote da classe");
        System.out.println(classe.getPackage());
        System.out.println("\n-------------------------\n");

        System.out.println("SuperClasse");
        System.out.println(classe.getSuperclass());
        System.out.println("\n-------------------------\n");

        System.out.println("Interfaces implementadas pela classe");
        System.out.println(classe.getInterfaces());
        System.out.println("\n-------------------------\n");

    }
}
