/*
 * Problema: Derdenio y sus Estructuras de Datos
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 23/10/2026
 * Descripción: Junta dos listas en una de mayor a menor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringTokenizer tokens; // números de la línea

    // junta las listas
    static String procesar(long[] primera, long[] segunda) {
        ListaDoble lista1 = new ListaDoble();
        for (long valor : primera) {
            lista1.agregarFinal(valor);
        }
        ListaDoble lista2 = new ListaDoble();
        for (long valor : segunda) {
            lista2.agregarFinal(valor);
        }
        return ListaDoble.fusionarDescendente(lista1, lista2).aTexto();
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

    // arreglo a texto
    static String unir(long[] valores) {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            texto.append(valores[i]);
            if (i < valores.length - 1) {
                texto.append(' ');
            }
        }
        return texto.toString();
    }

    // imprime un caso
    static void mostrarCaso(String titulo, long[] primera, long[] segunda) {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Entrada:");
        System.out.println(primera.length);
        System.out.println(unir(primera));
        System.out.println(unir(segunda));
        System.out.println("Salida:");
        System.out.println(procesar(primera, segunda));
        System.out.println();
    }

    // casos de prueba
    static void ejecutarCasosPorDefecto() {
        System.out.println("No se ingresó entrada: se ejecutan los casos por defecto.\n");

        // ejemplo
        mostrarCaso("Caso 1: normal (enunciado)",
            new long[]{1, 7, 9, 12, 23}, new long[]{2, 3, 8, 14, 24});

        // un número cada una
        mostrarCaso("Caso 2: limite (N = 1)",
            new long[]{5}, new long[]{3});

        // repetidos
        mostrarCaso("Caso 3: repetidos",
            new long[]{1, 2, 2}, new long[]{2, 2, 3});

        // una mayor que la otra
        mostrarCaso("Caso 4: una lista mayor que la otra",
            new long[]{1, 2, 3}, new long[]{10, 20, 30});

        // negativos y cero
        mostrarCaso("Caso 5: con negativos",
            new long[]{-5, -1, 0}, new long[]{-4, 2, 6});

        // N = 5000, pares contra impares
        int n = 5000;
        long[] pares = new long[n];
        long[] impares = new long[n];
        for (int i = 0; i < n; i++) {
            pares[i] = 2L * i;        // 0, 2, 4, ... 9998
            impares[i] = 2L * i + 1;  // 1, 3, 5, ... 9999
        }
        long inicio = System.nanoTime();
        String[] salida = procesar(pares, impares).split(" ");
        long milisegundos = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("=== Caso 6: grande (N = " + n + ") ===");
        System.out.println("Cantidad de números: " + salida.length + " (esperado: 10000)");
        System.out.println("Primero: " + salida[0] + " (esperado: 9999)");
        System.out.println("Último:  " + salida[salida.length - 1] + " (esperado: 0)");
        System.out.println("Tiempo: " + milisegundos + " ms");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribe N, luego la primera lista y luego la segunda (Enter solo = casos por defecto): ");

        String primeraLinea = lector.readLine();
        // sin entrada: casos de prueba
        if (primeraLinea == null || primeraLinea.trim().isEmpty()) {
            System.out.println();
            ejecutarCasosPorDefecto();
            return;
        }

        tokens = new StringTokenizer(primeraLinea);
        int n = Integer.parseInt(siguienteToken(lector));
        long[] primera = new long[n];
        long[] segunda = new long[n];
        for (int i = 0; i < n; i++) {
            primera[i] = Long.parseLong(siguienteToken(lector));
        }
        for (int i = 0; i < n; i++) {
            segunda[i] = Long.parseLong(siguienteToken(lector));
        }
        System.out.println(procesar(primera, segunda));
    }
}
