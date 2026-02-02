package com.sinensia.primerprograma.ejercicios.streams;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Reuniones .
 */

public class ReunionesEmpresa {
        public static void main(String[] args) {
                // Creación de empleados
                List<Empleado> empleados = Arrays.asList(
                                new Empleado("Ana", "IT", 32000),
                                new Empleado("Luis", "Marketing", 28000),
                                new Empleado("Sofía", "IT", 45000),
                                new Empleado("Carlos", "Finanzas", 27000),
                                new Empleado("Marta", "Marketing", 30000));

                // Creación de reuniones con identificador único
                LocalDateTime fechaInicio1 = LocalDateTime.now().plusDays(2);
                Duration duracion1 = Duration.ofMinutes(60);
                ZoneId zonaMadrid = ZoneId.of("Europe/Madrid");
                Reunion reunion1 = new Reunion(
                                1,
                                "Revisión de proyectos IT",
                                fechaInicio1,
                                duracion1,
                                zonaMadrid);

                LocalDateTime fechaInicio2 = LocalDateTime.now().plusDays(5);
                Duration duracion2 = Duration.ofMinutes(45);
                ZoneId zonaParis = ZoneId.of("Europe/Paris");
                Reunion reunion2 = new Reunion(
                                2,
                                "Estrategia de campaña",
                                fechaInicio2,
                                duracion2,
                                zonaParis);

                LocalDateTime fechaInicio3 = LocalDateTime.now().plusDays(10);
                Duration duracion3 = Duration.ofMinutes(30);
                ZoneId zonaTokyo = ZoneId.of("Asia/Tokyo");
                Reunion reunion3 = new Reunion(
                                3,
                                "Plan de expansión internacional",
                                fechaInicio3,
                                duracion3,
                                zonaTokyo);

                // Asignación de reuniones a empleados (histórico)
                empleados.get(0).agregarReunion(reunion1);
                empleados.get(1).agregarReunion(reunion2);
                empleados.get(2).agregarReunion(reunion1); // Ana -> revisión de proyectos IT
                empleados.get(2).agregarReunion(reunion3); // Ana -> plan de expansión internacional
                empleados.get(3).agregarReunion(reunion2); // CArlos -> estrategia de campaña
                empleados.get(4).agregarReunion(reunion1);

                // Intentar agregar una reunión duplicada a un empleado
                System.out.println("\nIntento de agregar reunión duplicada para Ana:");
                empleados.get(0).agregarReunion(reunion1); // No se agregará, ya que ya está asignada

                System.out.println("\nReuniones de Ana:");

                empleados.get(2).getReuniones().forEach(reunion -> {
                        reunion.mostrarResumen();
                        System.out.println("------------");
                });
                System.out.println("\nReuniones de Carlos:");
                empleados.get(3).getReuniones().forEach(Reunion::mostrarResumen);

                // Filtrar reuniones que comienzan en los próximos 7 días y agrupar por zona
                // horaria

                Map<ZoneId, List<Reunion>> reunionesPorZona = empleados.stream()
                                .flatMap(e -> e.getReuniones().stream())
                                .filter(r -> {
                                        ZonedDateTime inicio = r.getInicioZoned();
                                        ZonedDateTime ahora = ZonedDateTime.now(r.getZona());
                                        return inicio.isAfter(ahora) && inicio.isBefore(ahora.plusDays(7));
                                })
                                .collect(Collectors.groupingBy(Reunion::getZona));

                // Mostrar resumen de reuniones agrupadas por zona horaria
                System.out.println(
                                "\nResumen de reuniones en los próximos 7 días agrupadas por zona horaria:");
                reunionesPorZona.forEach((zona, reuniones) -> {
                        System.out.println("\nZona horaria: " + zona);
                        reuniones.forEach(reunion -> {
                                reunion.mostrarResumen();
                                System.out.println("----------------------------");
                        });
                });

        }
}
