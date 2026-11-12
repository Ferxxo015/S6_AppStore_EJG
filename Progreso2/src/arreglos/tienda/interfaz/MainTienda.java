package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;
import arreglos.tienda.utilitario.Validacion;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static AppStore tienda = new AppStore();
    private static Scanner sc = new Scanner(System.in);

    static void main() {
        int opc;
       tienda.cargarDatos();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{
                    ingresarJuegos();
                }break;
                case 2:{
                    imprimirInformacion();
                }break;
                case 3:{
                    buscarJuego();
                }break;
                case 4:{
                    comprar();
                }break;
                case 5:{
                    vender();
                }break;
                case 6:{
                    juegoMasVendido();
                }break;
                case 7:{
                    System.out.println("Gracias");
                }break;
                default:
                    System.out.println("No es una opción válida");
            }

       }while(opc != 7 || opc<0);
    }

    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuegos() {
        System.out.println("*******Ingreso de datos********");

        String nombre = Validacion.leerString("Ingrese el nombre / no se aceptan nulos ni espacios en blanco");
        String categoria = Validacion.leerString("Ingrese la categoria / no se aceptan nulos ni espacios en blanco");
        int tamanio = Validacion.leerEntero("Ingrese el tamanio");
        double precio = Validacion.leerDouble("Ingrese el precio");
        int licenciasDisponibles = Validacion.leerEntero("Ingrese el stock inicial");

        if (tienda.adicionarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "El juego se ha agregado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No fue posible agregar el juego");
        }
    }

    public static void imprimirInformacion() {
        Juego juegos[] = tienda.getJuegos();
        if (tienda.getIndice() == -1) {
            System.out.println("No existen juegos aún");
        } else {
            for (int i = 0; i <= tienda.getIndice(); i++) {
                System.out.println(juegos[i]);
            }
        }
    }


    public static void vender(){
        String nombre;
        int cantidad;
        nombre = Validacion.leerString("Ingrese el nombre del juego (No nulo ni en blanco)");
        System.out.print("Ingrese la cantidad: ");
        cantidad = Integer.parseInt(sc.nextLine());
        double valorPago = tienda.vender(nombre,cantidad);
        if(valorPago != 0){
            JOptionPane.showMessageDialog(null,"Juego: "+nombre+"\nCantidad: "+cantidad+
                    "Valor a cancelar: "+valorPago);
        }else{
            JOptionPane.showMessageDialog(null,"No fue posible vender el juego "+nombre);
        }

    }

    public static void buscarJuego() {
        String nombre = Validacion.leerString("Ingrese el nombre del juego a buscar");
        Juego juego = tienda.buscarJuego(nombre);
        if (juego != null) {
            System.out.println(juego);
        } else {
            System.out.println("El juego no se encuentra registrado.");
        }
    }

    public static void comprar() {
        String nombre = Validacion.leerString("Ingrese el nombre del juego a comprar");
        int cantidad = Validacion.leerEntero("Ingrese la cantidad a comprar");
        if (tienda.comprar(nombre, cantidad)) {
            JOptionPane.showMessageDialog(null, "Compra registrada con éxito para: " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la compra del juego " + nombre);
        }
    }

    public static void juegoMasVendido() {
        String masVendido = tienda.masVendido();
        if (masVendido != null) {
            JOptionPane.showMessageDialog(null, "El juego más vendido es:\n" + masVendido);
        } else {
            System.out.println("No hay datos suficientes o ventas registradas.");
        }
    }





}
