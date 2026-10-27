/*
 * Problema: Inserción en Lista Enlazada
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Mete un -1 antes de cada impar.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // true solo para omegaUp
    static final boolean MODO_OMEGAUP = false;

    // arma la lista
    static ListaSimple construir(int[] valores) {
        ListaSimple lista = new ListaSimple();
        for (int valor : valores) {
            lista.agregarFinal(valor);
        }
        return lista;
    }

    // aplica parcial3
    static String resolver(ListaSimple lista) {
        int insertados = lista.parcial3();
        return insertados + "\n" + lista.aTexto() + "\n";
    }

    // imprime un caso
    static void mostrarCaso(String titulo, int[] valores) {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Entrada:");
        if (valores.length == 0) {
            System.out.println("(lista vacía)");
        }
        for (int valor : valores) {
            System.out.println(valor);
        }
        System.out.println("Salida:");
        System.out.print(resolver(construir(valores)));
        System.out.println();
    }

    // casos de prueba
    static void ejecutarCasosPorDefecto() {
        System.out.println("No se ingresó entrada: se ejecutan los casos por defecto.\n");

        // ejemplo
        mostrarCaso("Caso 1: normal (enunciado)", new int[]{1, 2, 3});

        // mezcla
        mostrarCaso("Caso 2: mezcla", new int[]{4, 5, 8, 3, 3, 10});

        // vacía
        mostrarCaso("Caso 3: limite (lista vacia)", new int[]{});

        // un impar
        mostrarCaso("Caso 4: limite (un solo impar)", new int[]{7});

        // todos pares
        mostrarCaso("Caso 5: todos pares", new int[]{2, 4, 6});

        // todos impares
        mostrarCaso("Caso 6: todos impares", new int[]{1, 3, 5});

        // del 1 al 10000
        int n = 10000;
        int[] grande = new int[n];
        for (int i = 0; i < n; i++) {
            grande[i] = i + 1;
        }
        ListaSimple lista = construir(grande);
        long inicio = System.nanoTime();
        int insertados = lista.parcial3();
        long milisegundos = (System.nanoTime() - inicio) / 1_000_000;
        System.out.println("=== Caso 7: grande (N = " + n + ") ===");
        System.out.println("Nodos insertados: " + insertados + " (esperado: 5000)");
        System.out.println("Tamaño final de la lista: " + lista.tamanio() + " (esperado: 15000)");
        System.out.println("Tiempo: " + milisegundos + " ms");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        if (!MODO_OMEGAUP) {
            System.out.println("Escribe un valor por línea; una línea vacía termina la lista.");
            System.out.print("(Enter solo al inicio = casos por defecto): ");
        }

        String linea = lector.readLine();

        // sin entrada: casos de prueba
        if (!MODO_OMEGAUP && (linea == null || linea.trim().isEmpty())) {
            System.out.println();
            ejecutarCasosPorDefecto();
            return;
        }

        ListaSimple lista = new ListaSimple();
        while (linea != null) {
            if (linea.trim().isEmpty()) {
                if (!MODO_OMEGAUP) {
                    break; // local: línea vacía termina
                }
            } else {
                StringTokenizer partes = new StringTokenizer(linea);
                while (partes.hasMoreTokens()) {
                    lista.agregarFinal(Integer.parseInt(partes.nextToken()));
                }
            }
            linea = lector.readLine();
        }
        System.out.print(resolver(lista));
    }
}
