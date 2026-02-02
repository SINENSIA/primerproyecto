# Colas en Java (`Queue` y `Deque`)

## 1. Queue — Interfaz FIFO

* Definición: Interfaz que define una cola First In, First Out (FIFO)
* No se instancia directamente
* Métodos clave:

  * `offer(E e)` → añade elemento
  * `poll()` → elimina y devuelve primero
  * `peek()` → consulta sin eliminar

### Implementaciones comunes

#### LinkedList

* Implementa `Queue` y `Deque`
* Permite `null`
* Uso: cola FIFO estándar
* Estructura interna: lista doblemente enlazada
* Rendimiento:

  * Inserción/eliminación O(1)
  * Acceso aleatorio O(n)
  * Más lenta por gestión de nodos y referencias
* Ejemplo:

  ```java
  Queue<String> cola = new LinkedList<>();
  cola.offer("A");
  cola.offer("B");
  System.out.println(cola.poll()); // A
  ```

#### PriorityQueue

* Ordena por prioridad natural o `Comparator`
* No permite `null`
* Iteración no ordenada, pero `peek/poll` sí
* Uso: tareas por prioridad, simulaciones
* Estructura interna: heap binario (mínimo por defecto)
* Rendimiento:

  * Inserción O(log n)
  * Eliminación O(log n)
  * Acceso O(1) al mínimo o máximo
* Ejemplo:

  ```java
  Queue<Integer> pq = new PriorityQueue<>();
  Collections.addAll(pq, 5, 1, 3);
  while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
  // 1 3 5
  ```
* Máxima prioridad:

  ```java
  Queue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
  Collections.addAll(maxpq, 5, 1, 3);
  System.out.println(maxpq.poll()); // 5
  ```

---

## 2. Deque — Interfaz de doble extremo

* Definición: Cola doble (Double Ended Queue)
* Permite insertar y eliminar por ambos extremos
* Puede comportarse como:

  * FIFO (cola normal)
  * LIFO (pila)
* Métodos clave:

  * `addFirst()`, `addLast()`
  * `removeFirst()`, `removeLast()`
  * `peekFirst()`, `peekLast()`
  * `push()`, `pop()` (modo pila)

### Implementaciones comunes

#### ArrayDeque

* No admite `null`
* Muy rápida y no bloqueante
* Mejor que `Stack` o `LinkedList` para pila o cola
* Estructura interna: buffer circular redimensionable
* Rendimiento:

  * Inserción y eliminación en extremos O(1)
  * Redimensionamiento ocasional (dobla tamaño)
  * Muy eficiente en memoria y velocidad
* Ejemplo:

  ```java
  Deque<String> d = new ArrayDeque<>();
  d.addFirst("head");
  d.addLast("tail");
  System.out.println(d.removeFirst()); // head
  ```
* Como pila:

  ```java
  Deque<Integer> stack = new ArrayDeque<>();
  stack.push(10);
  stack.push(20);
  System.out.println(stack.pop()); // 20
  ```

#### LinkedList (como Deque)

* También implementa `Deque`
* Más flexible, pero menos eficiente que `ArrayDeque`
* Estructura interna: lista doblemente enlazada
* Rendimiento:

  * Inserción/eliminación O(1)
  * Acceso aleatorio O(n)
  * Más lenta por gestión de punteros y GC

---

## 3. Comparativa final

| Interfaz | Tipo        | Implementaciones                      | Estructura interna             | Admite `null`   | Rendimiento   | Uso típico               |
| -------- | ----------- | ------------------------------------- | ------------------------------ | --------------- | ------------- | ------------------------ |
| Queue    | FIFO        | LinkedList, PriorityQueue, ArrayDeque | Lista / Heap / Buffer circular | Depende         | O(1)–O(log n) | Procesamiento secuencial |
| Deque    | FIFO o LIFO | ArrayDeque, LinkedList                | Buffer circular / Lista        | No (ArrayDeque) | O(1)          | Cola doble, pila         |

---

## 4. Analogías

* Queue: fila de supermercado → el primero que llega es el primero en salir.
* Deque: fila con dos puertas → se puede entrar o salir por cualquiera de los extremos.
* PriorityQueue: triaje médico → se atiende según prioridad, no por orden de llegada.

---

## 5. Jerarquía y paquetes

* Paquete: `java.util`
* Jerarquía:

  * `Collection<E>`

    * `Queue<E>`

      * `Deque<E>`
* Implementaciones destacadas:

  * `LinkedList<E>` implementa `List`, `Deque`, `Queue`
  * `PriorityQueue<E>` implementa `Queue`
  * `ArrayDeque<E>` implementa `Deque`, `Queue`

---

## 6. Recomendaciones prácticas

* Usar `ArrayDeque` para colas y pilas rápidas no bloqueantes.
* Usar `PriorityQueue` cuando la prioridad importe.
* Usar `LinkedList` si se necesita también manipular en mitad de la lista o compatibilidad con `List` y `Deque`.
