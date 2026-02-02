# Mapa mental: Colecciones en Java (teórico)


## LIST (ordenadas, permiten duplicados)

### ArrayList

* Basada en array dinámico
* Acceso por índice **O(1)**
* Inserción/eliminación en medio **O(n)**
* Buena para acceso aleatorio frecuente
* → Usa cuando: lees mucho, escribes poco

### LinkedList

* Nodos doblemente enlazados
* Inserción/eliminación **O(1)** con referencia al nodo
* Acceso por índice **O(n)**
* Implementa `Queue` y `Deque`
* → Usa cuando: muchas inserciones/borrados intermedios

## SET (sin duplicados, sin índice)

### HashSet

* Tabla hash, sin orden
* Operaciones básicas **O(1)** promedio
* → Usa cuando: solo unicidad y rendimiento

### LinkedHashSet

* Hash + lista doble; conserva orden de inserción
* Ligeramente más memoria
* → Usa cuando: unicidad + orden estable

### TreeSet

* Árbol rojo‑negro (orden natural o `Comparator`)
* Ordenado automáticamente
* Operaciones **O(log n)**
* → Usa cuando: elementos únicos y ordenados

## QUEUE (FIFO)

### PriorityQueue

* Heap binario
* Prioriza cabeza mínima/máxima; no orden total
* **O(log n)** en `offer/poll`
* → Usa cuando: procesar por prioridad

## DEQUE (doble cola)

### ArrayDeque

* Array circular
* Inserción/eliminación en extremos **O(1)**
* Más rápido que `Stack`/`LinkedList` para pila/cola
* → Usa cuando: pila (`push/pop`) o cola sin sincronización

---

# Mapa mental: Colecciones en Java (práctico con snippets)

> Objetivo: misma estructura, ejemplos mínimos, reproducibles en un `public static void main`.

## LIST (ordenadas, permiten duplicados)

### ArrayList

* Caso: lecturas frecuentes, pocas modificaciones intermedias.

```java
import java.util.*;

List<String> l = new ArrayList<>();
l.add("A"); l.add("B"); l.add("B"); // permite duplicados
System.out.println(l.get(1));          // O(1)
// Insertar en medio: O(n)
l.add(1, "X");
for (String s : l) System.out.print(s + " "); // A X B B
```

* Trade‑off: rápido al leer por índice, costoso al insertar en medio.

### LinkedList

* Caso: muchas inserciones/borrados en posiciones arbitrarias.

```java
import java.util.*;

LinkedList<Integer> q = new LinkedList<>();
q.addFirst(10); // O(1)
q.addLast(20);  // O(1)
q.removeFirst();
// Acceso por índice es O(n)
```

* Nota: también sirve como `Queue`/`Deque`.

## SET (sin duplicados, sin índice)

### HashSet

* Caso: deduplicar y pruebas de pertenencia rápidas.

```java
import java.util.*;

Set<String> s = new HashSet<>();
s.add("a"); s.add("b"); s.add("a"); // "a" duplicado: ignorado
System.out.println(s.contains("b"));   // O(1) promedio
// Iteración sin orden garantizado
```

* Pitfall: requiere `hashCode/equals` coherentes en tipos propios.

### LinkedHashSet

* Caso: deduplicar pero conservando orden de inserción.

```java
import java.util.*;

Set<Integer> s = new LinkedHashSet<>(Arrays.asList(3,1,2,1));
System.out.println(s); // [3, 1, 2]
```

* Trade‑off: más memoria que `HashSet`.

### TreeSet

* Caso: conjunto único y **ordenado** automáticamente.

```java
import java.util.*;

Set<String> s = new TreeSet<>();
s.add("beta"); s.add("alpha"); s.add("alpha");
System.out.println(s); // [alpha, beta]

// Con Comparator personalizado (longitud, luego alfabético)
Set<String> c = new TreeSet<>(Comparator
    .comparingInt(String::length)
    .thenComparing(Comparator.naturalOrder()));
Collections.addAll(c, "bbb", "a", "cc");
System.out.println(c); // [a, cc, bbb]
```

* Pitfall: todos los elementos deben ser comparables bajo el mismo criterio.

## QUEUE (FIFO)

### PriorityQueue

* Caso: procesar por prioridad (mínimo por defecto).

```java
import java.util.*;

Queue<Integer> pq = new PriorityQueue<>();
Collections.addAll(pq, 5, 1, 3);
while (!pq.isEmpty()) System.out.print(pq.poll() + " "); // 1 3 5

// Máxima prioridad: invertir comparador
Queue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
Collections.addAll(maxpq, 5, 1, 3);
System.out.println(maxpq.poll()); // 5
```

* Nota: la iteración no está ordenada; el orden sólo se garantiza en `peek/poll`.

## DEQUE (doble cola)

### ArrayDeque

* Caso: pila o cola no bloqueante y rápida.

```java
import java.util.*;

Deque<String> d = new ArrayDeque<>();
d.addFirst("head");
d.addLast("tail");
System.out.println(d.removeFirst()); // head

// Pila
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10); stack.push(20);
System.out.println(stack.pop()); // 20
```

* Trade‑off: no admite `null`. Mejor rendimiento que `Stack`/`LinkedList` para pila/cola.

---

## Comparación rápida (práctica)

| Colección     | Duplicados | Orden inserción | Orden natural | Inserción típica | Acceso por índice | Cuándo usar                    |
| ------------- | ---------: | --------------: | ------------: | ---------------: | ----------------: | ------------------------------ |
| ArrayList     |         Sí |              Sí |            No |       O(n) medio |              O(1) | Lecturas aleatorias frecuentes |
| LinkedList    |         Sí |              Sí |            No |    O(1) extremos |              O(n) | Muchas inserciones/borrados    |
| HashSet       |         No |              No |            No |       O(1) prom. |               n/a | Unicidad sin orden             |
| LinkedHashSet |         No |              Sí |            No |       O(1) prom. |               n/a | Unicidad + orden estable       |
| TreeSet       |         No |   Sí (ordenado) |            Sí |         O(log n) |               n/a | Unicidad + orden automático    |
| PriorityQueue |         Sí |              No |       Parcial |         O(log n) |               n/a | Prioridades                    |
| ArrayDeque    |         Sí |              Sí |            No |    O(1) extremos |               n/a | Pila/Cola rápidas              |

---

## Snippets de referencia mínima

* Iterar genérico con `forEach`:

```java
collection.forEach(System.out::println);
```

* Medir tiempo bruto de una operación:

```java
long t0 = System.nanoTime();
// operación
long dt = System.nanoTime() - t0;
System.out.println("ns=" + dt);
```

* Comparator común:

```java
Comparator<String> byLenThenAlpha = Comparator
    .comparingInt(String::length)
    .thenComparing(Comparator.naturalOrder());
```

---

## Límites y recomendaciones

* Evita `Vector` y `Stack` en código nuevo; usa `ArrayList`/`ArrayDeque`.
* Para concurrencia, considera `java.util.concurrent` (`ConcurrentLinkedQueue`, `CopyOnWriteArrayList`, etc.).
* Para `Map`, aunque no es `Collection`, suele aparecer en la misma discusión: `HashMap`/`LinkedHashMap`/`TreeMap` siguen análogos a Set.
