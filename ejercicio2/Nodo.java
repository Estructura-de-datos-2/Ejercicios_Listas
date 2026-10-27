/*
 * Problema: Formados en la cafetería
 * Autor: José Emmanuel Arredondo Escalante
 * Grupo: GTID244
 * Fecha: 22/10/2026
 * Descripción: Nodo de la lista.
 */

public class Nodo {
    char letra;      // letra
    int cantidad;    // veces
    Nodo siguiente;  // siguiente

    public Nodo(char letra) {
        this.letra = letra;
        this.cantidad = 0;
        this.siguiente = null;
    }
}
