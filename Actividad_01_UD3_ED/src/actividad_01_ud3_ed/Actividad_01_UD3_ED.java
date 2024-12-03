/*
 * Para cambiar este encabezado de licencia, elige Encabezados de Licencia en las propiedades del proyecto.
 * Para cambiar este archivo de plantilla, elige Herramientas | Plantillas
 * y abre la plantilla en el editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED {

    private static byte[] buffer = new byte[1000];
    private static String nombreDelArchivo = "fichero.dat";
    private static FileInputStream flujoDeEntrada = null;
    private static BufferedInputStream bufferDeEntrada = null;

    public static void inicializarArchivos() throws FileNotFoundException {
        flujoDeEntrada = new FileInputStream(nombreDelArchivo);
        bufferDeEntrada = new BufferedInputStream(flujoDeEntrada);
    }

    public static int mostrarTextoArchivo() throws IOException {
        int totalLeido = 0;
        int bytesLeidos = 0;
        while ((bytesLeidos = flujoDeEntrada.read(buffer)) != -1) {
            System.out.println(new String(buffer));
            totalLeido += bytesLeidos;
        }

        return totalLeido;
    }

    /**
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        try {
            inicializarArchivos();

            int totalLeido = mostrarTextoArchivo();

            System.out.println("\nLeídos " + totalLeido + " bytes");
        } catch (IOException ex) {
            System.out.println("Error -> " + ex.toString());
        } finally {
            try {
                if (bufferDeEntrada != null && flujoDeEntrada != null) {
                    flujoDeEntrada.close();
                    bufferDeEntrada.close();
                }
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo -> " + ex.toString());
            }
        }
    }

}
