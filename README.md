# Ejercicios de listas

Cuatro ejercicios pares de Estructura de datos resueltos en Java con listas enlazadas

**Autor:** José Emmanuel Arredondo Escalante
**Grupo:** GTID244

## Ejercicios

| Ejercicio | Problema | Lista usada |
|-----------|----------|-------------|
| [2](#ejercicio-2--cuenta_letras_al_vector) | cuenta_letras_al_vector | Simple |
| [4](#ejercicio-4--inserción-en-lista-enlazada) | Inserción en Lista Enlazada | Simple |
| [6](#ejercicio-6--cajas-de-dulces) | Cajas de dulces | Simple |
| [8](#ejercicio-8--derdenio-y-sus-estructuras-de-datos) | Derdenio y sus Estructuras de Datos | Doble |

## Estructura del repositorio

```
Ejercicios_Listas/
├── ejercicio2/   Main.java, Nodo.java, ListaSimple.java
├── ejercicio4/   Main.java, Nodo.java, ListaSimple.java
├── ejercicio6/   Main.java, Nodo.java, ListaSimple.java
├── ejercicio8/   Main.java, Nodo.java, ListaDoble.java
└── fotos/        capturas de compilación, ejecución y omegaUp
```

## Cómo compilar y ejecutar

Entra a la carpeta del ejercicio y corre:

```
javac *.java
java Main
```

Si presionas Enter sin escribir nada, el programa corre sus casos de prueba por defecto. Dentro de cada `Main.java` hay una constante `MODO_OMEGAUP`; se pone en `true` solo al enviar a omegaUp.

---

## Ejercicio 2 – cuenta_letras_al_vector

Lee una cadena en minúsculas y cuenta cuántas veces aparece cada letra. Usa una lista simple de 26 nodos, uno por letra, y cada nodo lleva su contador.

**Entrada**

```
Emmanuel
```

**Salida**

```
1 0 0 0 1 0 0 0 0 0 0 1 2 1 0 0 0 0 0 0 1 0 0 0 0 0
La letra a aparece 1 veces
La letra e aparece 1 veces
La letra l aparece 1 veces
La letra m aparece 2 veces
La letra n aparece 1 veces
La letra u aparece 1 veces
```

La primera línea son los 26 contadores de la `a` a la `z`. Después sale una línea por cada letra que sí apareció. El problema trabaja solo con minúsculas, por eso la `E` mayúscula del inicio no se cuenta.

**Compilación**

![Compilación del ejercicio 2](fotos/Ejercicio%202%20Compilacion.png)

**Ejecución**

![Ejecución del ejercicio 2](fotos/Ejercicio%202%20ejecuci%C3%B3n.png)

**omegaUp**

![Envío del ejercicio 2 en omegaUp](fotos/Ejercicio%202%20Curso.png)

---

## Ejercicio 4 – Inserción en Lista Enlazada

Lee una lista de enteros y, antes de cada nodo con valor impar, inserta un nodo con valor `-1`. Imprime cuántos nodos insertó y cómo quedó la lista. La función que lo hace se llama `parcial3`.

**Entrada** (un valor por línea; una línea vacía termina la lista)

```
2
3
4
5
6
7
3
3
4

```

**Salida**

```
5
2 -> -1 -> 3 -> 4 -> -1 -> 5 -> 6 -> -1 -> 7 -> -1 -> 3 -> -1 -> 3 -> 4 -> NULL
```

**Compilación**

![Compilación del ejercicio 4](fotos/Ejercicio%204%20Compilacion.png)

**Ejecución**

![Ejecución del ejercicio 4](fotos/Ejercicio%204%20ejecici%C3%B3n.png)

**omegaUp**

![Envío del ejercicio 4 en omegaUp](fotos/Ejercicio%204%20Curso.png)

---

## Ejercicio 6 – Cajas de dulces

Hay N cajas de dulces en un estante y se pueden llevar K cajas seguidas. El programa calcula la mayor cantidad de dulces que se puede juntar. Usa una ventana deslizante sobre la lista simple: suma las primeras K cajas y luego avanza de una en una, sumando la que entra y restando la que sale.

**Entrada** (`N K` y luego las N cajas)

```
10 4
3 9 9 1 9 10 8 7 2 16
```

**Salida**

```
34
```

**Compilación**

![Compilación del ejercicio 6](fotos/Ejercicio%206%20Compilacion.png)

**Ejecución**

![Ejecución del ejercicio 6](fotos/Ejercicio%206%20ejecucion.png)

**omegaUp**

![Envío del ejercicio 6 en omegaUp](fotos/Ejercicio%206%20Curso.png)

---

## Ejercicio 8 – Derdenio y sus Estructuras de Datos

Recibe dos listas de N números, cada una ordenada de menor a mayor, y las junta en una sola ordenada de mayor a menor. Usa una lista doble: se recorren las dos desde el final hacia atrás con el apuntador `anterior`, tomando siempre el valor más grande.

**Entrada** (`N`, la primera lista y la segunda lista)

```
5
1 7 9 12 23
2 3 8 14 24
```

**Salida**

```
24 23 14 12 9 8 7 3 2 1
```

**Compilación**

![Compilación del ejercicio 8](fotos/Ejercicio%208%20compilacion.png)

**Ejecución**

![Ejecución del ejercicio 8](fotos/Ejercicio%208%20ejecucion.png)

**omegaUp**

![Envío del ejercicio 8 en omegaUp](fotos/Ejercicio%208%20Curso.png)
