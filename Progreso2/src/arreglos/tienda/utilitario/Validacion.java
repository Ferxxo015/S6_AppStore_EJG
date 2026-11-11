package arreglos.tienda.utilitario;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje){
        String dato;
        do{
            System.out.println(mensaje+" : ");
            dato = sc.nextLine();
        }while(dato == null || dato.trim().isEmpty());
        return dato;
    }


    public static int leerEntero(String mensaje){
        int dato = -1;
        do {
            try {
                System.out.println(mensaje + " : ");
                dato = Integer.parseInt(sc.nextLine());
                if (dato < 0) {
                    System.out.println("No se permiten números negativos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
                dato = -1;
            }
        } while (dato < 0);
        return dato;
    }

    public static double leerDouble(String mensaje){
        double dato = -1;
        do {
            try {
                System.out.println(mensaje + " : ");
                dato = Double.parseDouble(sc.nextLine());
                if (dato < 0) {
                    System.out.println("No se permiten números negativos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número decimal válido.");
                dato = -1;
            }
        } while (dato < 0);
        return dato;
    }




}
