import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static Map<String, String> diccionario = new HashMap<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        diccionario.put("Nico","Gerente");
        diccionario.put("Nara","Gata");
        diccionario.put("Gime","Jefa de obra");
        diccionario.put("Cata","Bebe");


        System.out.println("Bienvenido al sistema de diccionario!!");

        while (opcion != 6) {
            try {

                System.out.println("Ingrese una opción y presione enter" + '\n');
                System.out.println(
                                "1. Ingresar nueva palabra y significado\n" +
                                "2. Consultar significado de una palabra\n" +
                                "3. Eliminar una palabra del diccionario\n" +
                                "4. Contabilizar palabras contenidas en el diccionario\n" +
                                "5. Visualizar el diccionario completo\n" +
                                "6. Salir");

                opcion = in.nextInt();
                System.out.println('\n' + "Seleccionaste la opción " + opcion);
            } catch (Exception e) {
                System.out.println("La opcion debe ser un numero entero. Intente nuevamente" + '\n');
                in.nextLine();
            }

            switch (opcion) {
                case 1:
                    Agregar();
                    break;
                case 2:
                    Consultar();
                    break;
                case 3:
                    Eliminar();
                    break;
                case 4:
                    Contar();
                    break;
                case 5:
                    VerTodo();
                    break;
                case 6:
                    System.out.println('\n' + "Saliendo, hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente" + '\n');
                    break;
            }
        }
    }

    public static void Agregar() {
        String pal,sig,conf;
        System.out.println("Ingrese la palabra a anadir");
        in.nextLine();
        pal= in.nextLine();
        if (diccionario.containsKey(pal)) {
            System.out.println("La palabra ya existe, desea sobreescribir su significado?");
            System.out.println("Presione la tecla s para confirmar, o cualquier otra para abortar");
            //in.nextLine();
            conf = in.nextLine();
            if (conf.equals("s")) {
                System.out.println("Ingrese el nuevo significado");
                //in.nextLine();
                sig = in.nextLine();
                diccionario.put(pal, sig);
                System.out.println("ud. ha reescrito la palabra " + pal + "con el significado: " + diccionario.get(pal));
            } else{
                System.out.println("operacion cancelada");
            }
        } else {
            System.out.println("Ingrese el significado");
            //in.nextLine();
            sig = in.nextLine();
            diccionario.put(pal, sig);
            System.out.println("ud. ha ingresado la palabra " + pal);
        }
    }

    public static void Consultar() {
        String pal;
        System.out.println("Ingrese la palabra a buscar");
        in.nextLine();
        pal = in.nextLine();
        if (diccionario.containsKey(pal)) {
            System.out.println("El significado de la palabra " + pal + " es: " + diccionario.get(pal));
        } else {
            System.out.println("Esa palabra no esta en el diccionario");
        }
    }

    public static void Eliminar() {
        String pal,conf;
        System.out.println("Ingrese la palabra a eliminar");
        in.nextLine();
        pal= in.nextLine();
        if (diccionario.containsKey(pal)) {
            System.out.println("Esta seguro que desea eliminar la palabra " + pal);
            System.out.println("Presione la tecla s para confirmar, o cualquier otra para abortar");
            //in.nextLine();
            conf = in.nextLine();
            if (conf.equals("s")) {
                diccionario.remove(pal);
                System.out.println("ud. ha eliminado la palabra " + pal);
            } else{
                System.out.println("operacion cancelada");
            }
        } else {
            System.out.println("Esa palabra no esta en el diccionario" + '\n' + "Volviendo al menu");
        }
    }

    public static void Contar() {
        System.out.println("Este diccionario tiene " + diccionario.size() + " palabras");
    }

    public static void VerTodo() {
        int i = 1;
        System.out.println("A continuacion se lista todo el contenido del diccionario");
        for (Object key : diccionario.keySet()) {
            System.out.println(i + ": " + key + ": " + diccionario.get(key));
            i++;
        }
        System.out.println('\n');
    }
    
}

