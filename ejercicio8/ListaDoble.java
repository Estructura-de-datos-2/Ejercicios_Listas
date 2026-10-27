/*
 * Problema: Derdenio y sus Estructuras de Datos
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 23/10/2026
 * Descripción: Lista doble para juntar dos listas.
 */

public class ListaDoble {
    private Nodo cabeza; // primero
    private Nodo cola;   // último
    private int tamanio;

    public ListaDoble() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    // agrega al final
    public void agregarFinal(long valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;          // primero y último
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;  // enlazo
            nuevo.anterior = cola;   // regreso
            cola = nuevo;            // nuevo último
        }
        tamanio++;
    }

    // junta dos listas en una de mayor a menor
    // voy del final hacia atrás tomando el mayor
    public static ListaDoble fusionarDescendente(ListaDoble a, ListaDoble b) {
        ListaDoble resultado = new ListaDoble();
        Nodo p1 = a.getCola(); // final de la primera
        Nodo p2 = b.getCola(); // final de la segunda

        // mientras haya en las dos
        while (p1 != null && p2 != null) {
            if (p1.valor >= p2.valor) {
                resultado.agregarFinal(p1.valor);
                p1 = p1.anterior;  // atrás
            } else {
                resultado.agregarFinal(p2.valor);
                p2 = p2.anterior;  // atrás
            }
        }
        // lo que sobre ya está en orden
        while (p1 != null) {
            resultado.agregarFinal(p1.valor);
            p1 = p1.anterior;
        }
        while (p2 != null) {
            resultado.agregarFinal(p2.valor);
            p2 = p2.anterior;
        }
        return resultado;
    }

    // números separados por espacio
    public String aTexto() {
        StringBuilder texto = new StringBuilder();
        Nodo actual = cabeza;
        while (actual != null) {
            texto.append(actual.valor);
            if (actual.siguiente != null) {
                texto.append(' ');
            }
            actual = actual.siguiente; // avanzo
        }
        return texto.toString();
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public Nodo getCola() {
        return cola;
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
