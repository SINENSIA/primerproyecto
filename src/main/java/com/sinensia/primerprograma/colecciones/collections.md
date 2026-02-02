---
title: markmap
markmap:
  maxWidth: 600
---
# Mapa mental: Colecciones en Java

## LIST (ordenadas, permiten duplicados)

### ArrayList

* Basada en array dinámico.
* Acceso por índice **O(1)**.
* Inserción/eliminación en medio **O(n)**.
* Buena para acceso aleatorio frecuente.
  → Usa cuando: lees mucho, escribes poco.

### LinkedList

* Basada en nodos doblemente enlazados.
* Inserción/eliminación **O(1)** si tienes el nodo.
* Acceso por índice **O(n)**.
* También implementa Queue y Deque.
  → Usa cuando: haces muchas inserciones/eliminaciones intermedias.

## SET (sin duplicados, sin índice)

### HashSet

* Basado en tabla hash.
* No garantiza orden.
* Operaciones básicas **O(1)** promedio.
  → Usa cuando: solo te importa unicidad y rendimiento.

### LinkedHashSet

* Igual que HashSet pero conserva orden de inserción.
* Ligero coste extra de memoria.
  → Usa cuando: quieres unicidad + orden estable.

### TreeSet

* Basado en árbol rojo-negro (orden natural o Comparator).
* Ordenado automáticamente.
* Operaciones **O(log n)**.
  → Usa cuando: necesitas elementos únicos y ordenados.

## QUEUE (cola FIFO)

### PriorityQueue

* Basada en heap binario.
* No garantiza orden completo, solo prioridad mínima/máxima en cabeza.
* Operaciones **O(log n)**.
  → Usa cuando: necesitas procesar por prioridad, no por orden de llegada.

## DEQUE (doble cola)

### ArrayDeque

* Basado en array circular.
* Permite inserción/eliminación en ambos extremos **O(1)**.
* Más rápido que Stack o LinkedList para pila/cola.
  → Usa cuando: necesitas pila (push/pop) o cola eficiente sin sincronización.

## Comparación rápida

| Colección         | Duplicados | Orden de inserción | Orden natural | Estructura interna        | Complejidad típica          | Cuándo usar                  |
| ----------------- | ---------- | ------------------ | ------------- | ------------------------- | --------------------------- | ---------------------------- |
| **ArrayList**     | Sí         | Sí                 | No            | Array dinámico            | Acceso O(1), inserción O(n) | Acceso rápido, pocos cambios |
| **LinkedList**    | Sí         | Sí                 | No            | Lista doblemente enlazada | Acceso O(n), inserción O(1) | Muchas inserciones/borrados  |
| **HashSet**       | No         | No                 | No            | Tabla hash                | O(1) promedio               | Evitar duplicados, sin orden |
| **LinkedHashSet** | No         | Sí                 | No            | Hash + lista doble        | O(1) promedio               | Unicidad + orden estable     |
| **TreeSet**       | No         | Sí (ordenado)      | Sí            | Árbol rojo-negro          | O(log n)                    | Unicidad + orden automático  |
| **PriorityQueue** | Sí         | No                 | Parcial       | Heap binario              | O(log n)                    | Procesar por prioridad       |
| **ArrayDeque**    | Sí         | Sí                 | No            | Array circular            | O(1) extremos               | Pila o cola eficiente        |

## Analogía

* **ArrayList** → cine con butacas numeradas: fácil encontrar a una persona por su número de asiento, pero difícil sacarla sin molestar a los demás.
* **LinkedList** → cadena de personas cogidas de la mano: difícil encontrar a alguien en medio, pero fácil quitarlo si tomamos las manos de quienes están a su lado. Mover a una persona de enmendio cuesta, al principio y finales de la cadena humana, no cuesta tanto.
* **HashSet** → caja donde metemos llaves, no hay orden y si intentamos meter una llave ya existente simplemente se ignora.
* **LinkedHashSet** → caja de llaves numeradas: sigue sin permitir duplicados, pero recuerda el orden en que fueron guardadas.
* **TreeSet** → lista de boda: primero se registran los invitados por orden de llegada, pero luego se reorganizan automáticamente en las mesas según criterios de cercanía o relación (Comparator).
* **PriorityQueue** → sala de espera en urgencias: no se atiende por orden de llegada, sino por gravedad del caso.
* **ArrayDeque** → lista del paro: nadie se cuela, pero si alguien se va, pierde su turno; se puede entrar o salir por los extremos de la lista.
