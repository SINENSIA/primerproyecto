# primerproyecto

Un primer proyecto con diversas pruebas de conceptos para el aprendizaje de Java.

## [ 1 Introducción ]

Este proyecto sirve de apoyo a las explicaciones en clase. Se basa en porciones de código dentro de métodos `main` y diversas clases e interfaces para pruebas pedagógicas. 

- **Localización**: Los paquetes están organizados por niveles de aprendizaje.
- **Documentación**: Se incluye JavaDoc en la mayoría de métodos y clases.
- **Salida**: Se hace uso intensivo de `System.out.println` y ejemplos con `Logger`.
- **Tests**: Ejemplos de tests unitarios con `JUnit5` y `Mockito`.

## [ 2 Objetivos y Mapa de Contenido ]

A continuación se muestra el vínculo entre los objetivos de aprendizaje y la ubicación del código en el repositorio:

| Objetivo | Bloque / Paquete | Ejemplos Clave |
| :--- | :--- | :--- |
| **Fundamentos** | `basico.*` | Tipos Primitivos, Operadores, Estructuras de control |
| **POO** | `poo.*` | Clases, Herencia, Composición, Polimorfismo, Interfaces |
| **Colecciones** | `colecciones.*` | Lists, Maps, Sets, Genéricos |
| **Avanzado** | `excepciones`, `io.*`, `funcional.*` | Try-catch, Streams, Lambdas, Archivos |
| **Concurrencia** | `concurrencia` | Threads y multihilo |
| **Patrones** | `patrones` | Singleton, Factory, etc. |

## [ 3 Estructura Detallada ]

### 1. Bloque Básico (`com.sinensia.primerprograma.basico`)
- **tipos**: [Tipos de datos y wrappers](src/main/java/com/sinensia/primerprograma/basico/tipos)
- **operadores**: [Uso de operadores aritméticos y lógicos](src/main/java/com/sinensia/primerprograma/basico/operadores)
- **dates**: [Manejo de fechas con la API de Java 8+](src/main/java/com/sinensia/primerprograma/basico/dates)
- **texto**: [Manipulación de Strings y StringBuilder](src/main/java/com/sinensia/primerprograma/basico/texto)
- **repaso**: [Ejercicios y pruebas rápidas de conceptos](src/main/java/com/sinensia/primerprograma/basico/repaso)

### 2. Programación Orientada a Objetos (`com.sinensia.primerprograma.poo`)
- **abstraccion**: Clases abstractas.
- **composicion**: Relaciones entre objetos.
- **polimorfismo**: Sobrecarga y sobrescritura.
- **interfaces**: Contratos y decoupling.
- **felinos**: [Caso de estudio completo con jerarquías y comportamientos](src/main/java/com/sinensia/primerprograma/poo/felinos)

### 3. Colecciones y Genéricos (`com.sinensia.primerprograma.colecciones`)
- **colecciones**: Uso de `ArrayList`, `HashMap`, `Arrays`, etc.
- **genericos**: Implementación de clases y métodos genéricos.

### 4. API de Java y Programación Funcional
- **funcional**: [Lambdas y Streams API](src/main/java/com/sinensia/primerprograma/funcional)
- **io**: [Lectura/Escritura de archivos y Serialización](src/main/java/com/sinensia/primerprograma/io)
- **excepciones**: Jerarquía y manejo de errores.

### 5. Otros
- **concurrencia**: Hilos y sincronización.
- **redes**: Ejemplos básicos de networking.
- **patrones**: Aplicación de patrones de diseño comunes.
- **ejercicios**: Enunciados y resoluciones para practicar los conceptos.

## [ 4 Cómo seguir este proyecto ]

1. **Explorar por paquetes**: Sigue el orden numérico/lógico descrito en la estructura.
2. **Ejecutar demos**: Muchas clases contienen un método `main`. Puedes ejecutarlas directamente desde tu IDE (Eclipse, VSCode, IntelliJ).
3. **Consultar Tests**: Revisa `src/test/java` para ver cómo se verifican los comportamientos de las clases.
4. **Maven**: El proyecto usa Maven. Puedes compilarlo con `mvn compile` y ejecutar los tests con `mvn test`.
