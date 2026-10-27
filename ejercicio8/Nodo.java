/*
 * Problema: Derdenio y sus Estructuras de Datos
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 23/10/2026
 * Descripción: Nodo de la lista doble.
 */

public class Nodo {
    long valor;      // número
    Nodo siguiente;  // derecha (mayor)
    Nodo anterior;   // izquierda (menor)

    public Nodo(long valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}
