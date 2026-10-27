/*
 * Problema: Cajas de dulces
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Suma máxima de k cajas seguidas.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer tokens; // números de la línea

    // calcula la suma máxima
    static int procesar(int k, int[] cajas) {
        ListaSimple lista = new ListaSimple();
        for (int dulces : cajas) {
            lista.agregarFinal(dulces);
        }
        return lista.sumaMaximaVentana(k);
    }

    // siguiente número de la entrada
    // null si ya no hay
    static String siguienteToken(BufferedReader lector) throws IOException {
        while (tokens == null || !tokens.hasMoreTokens()) {
            String linea = lector.readLine();
            if (linea == null) {
                return null;
            }
            tokens = new StringTokenizer(linea);
        }
        return tokens.nextToken();
    }

    // imprime un caso
    static void mostrarCaso(String titulo, int k, int[] cajas) {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Entrada:");
        System.out.println(cajas.length + " " + k);
        StringBuilder linea = new StringBuilder();
        for (int i = 0; i < cajas.length; i++) {
            linea.append(cajas[i]);
            if (i < cajas.length - 1) {
                linea.append(' ');
            }
        }
        System.out.println(linea);
        System.out.println("Salida:");
        System.out.println(procesar(k, cajas));
        System.out.println();
    }

    // casos de prueba
    static void ejecutarCasosPorDefecto() {
        System.out.println("No se ingresó entrada: se ejecutan los casos por defecto.\n");

        // ejemplo 1
        mostrarCaso("Caso 1: normal (enunciado)", 4, new int[]{3, 9, 9, 1, 9, 10, 8, 7, 2, 16});

        // ejemplo 2
        mostrarCaso("Caso 2: normal (enunciado)", 2, new int[]{9, 5, 2, 10, 3});

        // K = N
        mostrarCaso("Caso 3: limite (K = N)", 5, new int[]{1, 2, 3, 4, 5});

        // K = 1
        mostrarCaso("Caso 4: limite (K = 1)", 1, new int[]{4, 9, 2, 9, 1, 7});

        // una caja
        mostrarCaso("Caso 5: limite (N = 1)", 1, new int[]{500});

        // mejor al inicio
        mostrarCaso("Caso 6: mejor ventana al inicio", 3, new int[]{8, 9, 7, 1, 1});

        // mejor al final
        mostrarCaso("Caso 7: mejor ventana al final", 3, new int[]{1, 1, 1, 1, 9, 9});

        // N = 1000, K = 500
        int n = 1000;
        int[] grande = new int[n];
        for (int i = 0; i < n; i++) {
            grande[i] = (i < 500) ? i + 1 : 1000 - i;
        }
        long inicio = System.nanoTime();
        int resultado = procesar(500, grande);
        long milisegundos = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("=== Caso 8: grande (N = " + n + ", K = 500) ===");
        System.out.println("Suma máxima: " + resultado + " (esperado: 187750)");
        System.out.println("Tiempo: " + milisegundos + " ms");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribe N y K, luego las N cajas (Enter solo = casos por defecto): ");

        String primera = lector.readLine();
        // sin entrada: casos de prueba
        if (primera == null || primera.trim().isEmpty()) {
            System.out.println();
            ejecutarCasosPorDefecto();
            return;
        }

        tokens = new StringTokenizer(primera);
        int n = Integer.parseInt(siguienteToken(lector));
        int k = Integer.parseInt(siguienteToken(lector));
        int[] cajas = new int[n];
        for (int i = 0; i < n; i++) {
            cajas[i] = Integer.parseInt(siguienteToken(lector));
        }
        System.out.println(procesar(k, cajas));
    }
}
