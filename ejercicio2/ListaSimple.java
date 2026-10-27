/*
 * Problema: Formados en la cafetería
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Lista simple de letras.
 */

public class ListaSimple {
    private Nodo cabeza; // primero
    private Nodo cola;   // último

    public ListaSimple() {
        cabeza = null;
        cola = null;
    }

    // agrega al final
    public void agregarFinal(char letra) {
        Nodo nuevo = new Nodo(letra);
        if (cabeza == null) {
            cabeza = nuevo;          // primero y último
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;  // enlazo
            cola = nuevo;            // nuevo último
        }
    }

    // crea de la a a la z
    public void crearAbecedario() {
        for (char c = 'a'; c <= 'z'; c++) {
            agregarFinal(c);
        }
    }

    // suma 1 a la letra
    public void incrementar(char letra) {
        Nodo actual = cabeza;
        // busca la letra
        while (actual != null && actual.letra != letra) {
            actual = actual.siguiente;
        }
        if (actual != null) {
            actual.cantidad++;
        }
    }

    public Nodo getCabeza() {
        return cabeza;
    }
}
