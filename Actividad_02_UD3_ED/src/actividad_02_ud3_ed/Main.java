/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_02_ud3_ed;

/**
 * Clase principal que permite realizar operaciones con una cuenta bancaria.
 * Permite al usuario ingresar, retirar dinero o finalizar la ejecución.
 * Utiliza la clase CCuenta para gestionar las operaciones.
 *
 * @author Alego
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    // Buffer para leer datos desde la entrada del usuario
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Método principal que gestiona el menú de operaciones bancarias.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        CCuenta cuenta1; // Objeto para gestionar la cuenta
        double saldoActual; // Variable para almacenar el saldo actual
        int opcion = 0; // Opción seleccionada por el usuario
        
        // Inicialización de la cuenta con un titular, número de cuenta, saldo inicial y tipo de interés
        cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0);

        // Bucle para mostrar el menú de opciones
        do {
            try {
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                opcion = Integer.parseInt(dato.readLine());

                // Selección de la operación según la opción ingresada
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
                // Manejo de excepciones en caso de error de entrada
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 3);

        // Mostrar el saldo actual al finalizar el programa
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es " + saldoActual);
    }

    /**
     * Método auxiliar para realizar operaciones en la cuenta.
     * @param cuenta1 Objeto de tipo CCuenta que representa la cuenta.
     * @param cantidad Cantidad a ingresar o retirar.
     * @param opcion Opción seleccionada: 1 para ingresar, 2 para retirar.
     */
    public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
        if (opcion == 2) {
            // Intentar retirar dinero de la cuenta
            try {
                cuenta1.retirar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al retirar");
            }
        } else if (opcion == 1) {
            // Intentar ingresar dinero en la cuenta
            try {
                System.out.println("Ingreso en cuenta");
                cuenta1.ingresar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al ingresar");
            }
        }
    }
}
