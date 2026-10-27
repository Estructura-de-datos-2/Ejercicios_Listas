/*
 * Problema: Cajas de dulces
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Lista simple de cajas.
 */

public class ListaSimple {
    private Nodo cabeza; // primera
    private Nodo cola;   // última
    private int tamanio;

    public ListaSimple() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    // agrega al final
    public void agregarFinal(int dulces) {
        Nodo nuevo = new Nodo(dulces);
        if (cabeza == null) {
            cabeza = nuevo;          // primera y última
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;  // enlazo
            cola = nuevo;            // nueva última
        }
        tamanio++;
    }

    // suma máxima de k cajas seguidas
    // -1 si k no sirve
    public int sumaMaximaVentana(int k) {
        if (cabeza == null || k < 1 || k > tamanio) {
            return -1;
        }

        Nodo inicio = cabeza; // inicio de la ventana
        Nodo fin = cabeza;    // fin de la ventana

        // primera ventana
        int suma = cabeza.dulces;
        for (int i = 1; i < k; i++) {
            fin = fin.siguiente;
            suma += fin.dulces;
        }
        int maximo = suma;

        // deslizo la ventana
        while (fin.siguiente != null) {
            fin = fin.siguiente;       // entra una
            suma += fin.dulces;
            suma -= inicio.dulces;     // sale una
            inicio = inicio.siguiente;
            if (suma > maximo) {
                maximo = suma;         // mejor hasta ahora
            }
        }
        return maximo;
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
