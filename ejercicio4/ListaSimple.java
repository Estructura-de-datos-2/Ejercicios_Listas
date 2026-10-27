/*
 * Problema: Inserción en Lista Enlazada
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Lista simple con parcial3.
 */

public class ListaSimple {
    private Nodo cabeza; // primero
    private Nodo cola;   // último
    private int tamanio;

    public ListaSimple() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    // agrega al final
    public void agregarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;          // primero y último
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;  // enlazo
            cola = nuevo;            // nuevo último
        }
        tamanio++;
    }

    // mete -1 antes de cada impar
    public int parcial3() {
        int insertados = 0;
        Nodo anterior = null;   // el de atrás
        Nodo actual = cabeza;   // el actual

        while (actual != null) {
            if (actual.valor % 2 != 0) {
                // impar: pongo el -1 antes
                Nodo nuevo = new Nodo(-1);
                nuevo.siguiente = actual;      // -1 apunta al impar
                if (anterior == null) {
                    cabeza = nuevo;            // era el primero
                } else {
                    anterior.siguiente = nuevo; // enlazo el -1
                }
                insertados++;
                tamanio++;
            }
            // avanzo
            anterior = actual;
            actual = actual.siguiente;
        }
        return insertados;
    }

    // lista en texto
    public String aTexto() {
        StringBuilder texto = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            texto.append(actual.valor).append(" -> ");
            actual = actual.siguiente;
        }
        texto.append("NULL");
        return texto.toString();
    }

    // ¿está vacía?
    public boolean estaVacia() {
        return cabeza == null;
    }

    // tamaño
    public int tamanio() {
        return tamanio;
    }
}
