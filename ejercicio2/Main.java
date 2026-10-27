/*
 * Problema: cuenta_letras_al_vector
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Cuenta cuántas veces sale cada letra.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // true solo para omegaUp
    static final boolean MODO_OMEGAUP = false;

    // cuenta las letras
    static String procesar(String cadena) {
        // lista con las letras
        ListaSimple letras = new ListaSimple();
        letras.crearAbecedario();

        // contar
        for (int i = 0; i < cadena.length(); i++) {
            letras.incrementar(cadena.charAt(i));
        }

        // primera línea
        StringBuilder salida = new StringBuilder();
        Nodo actual = letras.getCabeza();
        while (actual != null) {
            salida.append(actual.cantidad);
            if (actual.siguiente != null) {
                salida.append(' ');
            }
            actual = actual.siguiente;
        }
        salida.append('\n');

        // letras que salieron
        actual = letras.getCabeza();
        while (actual != null) {
            if (actual.cantidad > 0) {
                salida.append("La letra ").append(actual.letra)
                      .append(" aparece ").append(actual.cantidad)
                      .append(" veces\n");
            }
            actual = actual.siguiente;
        }
        return salida.toString();
    }

    // imprime un caso
    static void mostrarCaso(String titulo, String cadena) {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Entrada:");
        System.out.println(cadena.isEmpty() ? "(cadena vacía)" : cadena);
        System.out.println("Salida:");
        System.out.print(procesar(cadena));
        System.out.println();
    }

    // casos de prueba
    static void ejecutarCasosPorDefecto() {
        System.out.println("No se ingresó entrada: se ejecutan los casos por defecto.\n");

        // ejemplo 1
        mostrarCaso("Caso 1: normal", "programacion");

        // ejemplo 2
        mostrarCaso("Caso 2: con repeticiones", "aaaaacccceeegghxxzzz");

        // vacía
        mostrarCaso("Caso 3: limite (cadena vacia)", "");

        // un caracter
        mostrarCaso("Caso 4: limite (un caracter)", "z");

        // 1000 caracteres
        String abecedario = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder grande = new StringBuilder();
        while (grande.length() < 1000) {
            grande.append(abecedario);
        }
        grande.setLength(1000); // 1000 justos
        String resultado = procesar(grande.toString());
        String[] lineas = resultado.split("\n");
        System.out.println("=== Caso 5: grande (1000 caracteres) ===");
        System.out.println("Primera línea de la salida:");
        System.out.println(lineas[0]);
        System.out.println("Letras que aparecen: " + (lineas.length - 1) + " (esperado: 26)");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(MODO_OMEGAUP ? "" : "Escribe una cadena en minúsculas (Enter solo = casos por defecto): ");
        String cadena = lector.readLine();

        // sin entrada: casos de prueba
        if (!MODO_OMEGAUP && (cadena == null || cadena.trim().isEmpty())) {
            System.out.println();
            ejecutarCasosPorDefecto();
            return;
        }

        if (cadena == null) {
            cadena = ""; // omegaUp: sin entrada = cadena vacía
        }
        System.out.print(procesar(cadena.trim()));
    }
}
