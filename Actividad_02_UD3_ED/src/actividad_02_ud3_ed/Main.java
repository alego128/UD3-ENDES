/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad_02_ud3_ed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Main contiene el programa principal que interactúa con la clase CCuenta,
 * permitiendo realizar operaciones bancarias como ingresar y retirar dinero.
 * A través de un menú de opciones, el usuario puede seleccionar la operación a realizar
 * y el programa ejecuta la operación correspondiente sobre una cuenta.
 * 
 * El programa también maneja excepciones relacionadas con las operaciones bancarias
 * y muestra el saldo final de la cuenta después de finalizar la ejecución.
 * 
 * @author Alego
 */
public class Main {
    
    //BufferedReader para leer entradas desde la consola
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Método principal que ejecuta el programa. Muestra un menú de opciones y permite
     * al usuario realizar operaciones sobre una cuenta (ingresar, retirar o finalizar).
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        // Crear una cuenta de ejemplo con saldo inicial y tipo de interés
        CCuenta cuenta1;
        double saldoActual;
        int opcion = 0;
        cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);

        // Bucle para mostrar el menú y ejecutar operaciones hasta que el usuario decida finalizar
        do {
            try {
                // Mostrar menú de operaciones
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                
                // Leer la opción seleccionada por el usuario
                opcion = Integer.parseInt(dato.readLine());
                
                // Realizar la operación según la opción seleccionada
                if (opcion == 1) {
                    System.out.println("¿Cuánto desea ingresar?: ");
                    float ingresar = Integer.parseInt(dato.readLine());
                    operativa_cuenta(cuenta1, ingresar, opcion);
                } else if (opcion == 2) {
                    System.out.println("¿Cuánto desea retirar?: ");
                    float retirar = Integer.parseInt(dato.readLine());
                    operativa_cuenta(cuenta1, retirar, opcion);
                } else if (opcion == 3) {
                    System.out.println("Finalizamos la ejecución");
                } else {
                    System.err.println("Opción errónea");
                }
            } catch (IOException ex) {
                // Manejar excepciones de entrada/salida
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 3);

        // Obtener el saldo final y mostrarlo
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es " + saldoActual);
    }

    /**
     * Realiza la operación bancaria (ingreso o retiro) sobre la cuenta.
     * 
     * @param cuenta1 La cuenta sobre la que se realiza la operación.
     * @param cantidad La cantidad de dinero a ingresar o retirar.
     * @param opcion La opción seleccionada por el usuario (1 para ingresar, 2 para retirar).
     */
    public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
        if (opcion == 2) { // Si la opción es retirar
            try {
                // Intentar retirar el dinero de la cuenta
                cuenta1.retirar(cantidad);
            } catch (Exception e) {
                // Si ocurre un error, mostrar mensaje de fallo
                System.out.print("Fallo al retirar");
            }
        } else if (opcion == 1) { // Si la opción es ingresar
            try {
                // Intentar ingresar el dinero en la cuenta
                System.out.println("Ingreso en cuenta");
                cuenta1.ingresar(cantidad);
            } catch (Exception e) {
                // Si ocurre un error, mostrar mensaje de fallo
                System.out.print("Fallo al ingresar");
            }
        }
    }
}
