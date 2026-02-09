package com.sinensia.primerprograma.optionals;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        UsuarioRepository repo = new UsuarioRepository();

        System.out.println("=".repeat(70));
        System.out.println("🎯 DEMO: DNI (Dominio) vs ID (Persistencia) + Optional");
        System.out.println("=".repeat(70));

        // ========== PREPARAR DATOS ==========
        System.out.println("\n📝 CREANDO USUARIOS (solo con DNI, sin ID):");
        Usuario ana = new Usuario("12345678A", "Ana García", "ana@ejemplo.com");
        Usuario luis = new Usuario("87654321B", "Luis Pérez", "luis@ejemplo.com");
        Usuario maria = new Usuario("11111111C", "María López", "maria@ejemplo.com");

        System.out.println("Objeto dominio Ana: " + ana);
        System.out.println("¿Tiene ID? NO - Solo tiene DNI\n");

        repo.guardar(ana);
        repo.guardar(luis);
        repo.guardar(maria);

        repo.mostrarBaseDatos();

        // ========== CASO 1: BUSCAR POR DNI (Natural del Dominio) ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("1️⃣ BUSCAR POR DNI (identificador del dominio):");
        System.out.println("=".repeat(70));

        Optional<Usuario> usuario1 = repo.buscarPorDni("12345678A");
        usuario1.ifPresentOrElse(u -> System.out.println("✅ Encontrado: " + u),
                () -> System.out.println("❌ No encontrado"));

        Optional<Usuario> usuario2 = repo.buscarPorDni("99999999Z");
        usuario2.ifPresentOrElse(u -> System.out.println("✅ Encontrado: " + u),
                () -> System.out.println("❌ DNI 99999999Z no existe"));

        // ========== CASO 2: BUSCAR POR ID (Técnico de Persistencia) ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("2️⃣ BUSCAR POR ID (identificador técnico de DB):");
        System.out.println("=".repeat(70));

        repo.buscarPorId(2L).ifPresentOrElse(u -> System.out.println("✅ ID 2 encontrado: " + u),
                () -> System.out.println("❌ No encontrado"));

        repo.buscarPorId(999L).ifPresentOrElse(u -> System.out.println("✅ Encontrado: " + u),
                () -> System.out.println("❌ ID 999 no existe en la base de datos"));

        // ========== CASO 3: BUSCAR POR EMAIL ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("3️⃣ BUSCAR POR EMAIL:");
        System.out.println("=".repeat(70));

        repo.buscarPorEmail("maria@ejemplo.com").ifPresentOrElse(
                u -> System.out.println("✅ Email encontrado - DNI: " + u.getDni()),
                () -> System.out.println("❌ Email no encontrado"));

        // ========== CASO 4: ACTUALIZAR (por DNI) ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("4️⃣ ACTUALIZAR USUARIO (usamos DNI, no ID):");
        System.out.println("=".repeat(70));

        Usuario datosNuevos = new Usuario("12345678A", // Mismo DNI
                "Ana García Rodríguez", // Nombre actualizado
                "ana.nueva@ejemplo.com" // Email actualizado
        );

        Optional<Usuario> actualizado = repo.actualizar("12345678A", datosNuevos);
        actualizado.ifPresentOrElse(u -> {
            System.out.println("✅ Usuario actualizado: " + u);
            repo.mostrarBaseDatos();
        }, () -> System.out.println("❌ No se pudo actualizar"));

        // ========== CASO 5: TRANSFORMACIONES CON MAP ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("5️⃣ TRANSFORMACIONES CON Optional.map():");
        System.out.println("=".repeat(70));

        // Extraer solo el nombre
        Optional<String> nombreOpt = repo.buscarPorDni("87654321B").map(Usuario::getNombre);

        nombreOpt.ifPresent(nombre -> System.out.println("✅ Nombre extraído: " + nombre));

        // Extraer email en mayúsculas
        String email = repo.buscarPorDni("11111111C").map(Usuario::getEmail).map(String::toUpperCase)
                .orElse("EMAIL NO DISPONIBLE");

        System.out.println("✅ Email transformado: " + email);

        // ========== CASO 6: orElse y orElseThrow ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("6️⃣ MANEJO DE AUSENCIA: orElse vs orElseThrow:");
        System.out.println("=".repeat(70));

        // Con orElse - proporciona valor por defecto
        Usuario usuarioDefault = repo.buscarPorDni("NOEXISTE")
                .orElse(new Usuario("00000000X", "Usuario Invitado", "invitado@ejemplo.com"));
        System.out.println("✅ Con orElse: " + usuarioDefault.getNombre());

        // Con orElseThrow - lanza excepción
        try {
            Usuario usuario = repo.buscarPorDni("NOEXISTE")
                    .orElseThrow(() -> new RuntimeException("Usuario con DNI NOEXISTE no encontrado"));
        } catch (RuntimeException e) {
            System.out.println("❌ Excepción capturada: " + e.getMessage());
        }

        // ========== CASO 7: FILTER con Optional ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("7️⃣ FILTRAR con Optional:");
        System.out.println("=".repeat(70));

        // Buscar usuario y validar que el email sea de ejemplo.com
        repo.buscarPorDni("12345678A").filter(u -> u.getEmail().endsWith("@ejemplo.com")).ifPresentOrElse(
                u -> System.out.println("✅ Usuario con email válido: " + u.getEmail()),
                () -> System.out.println("❌ Email no válido o usuario no encontrado"));

        // ========== RESUMEN ==========
        System.out.println("\n" + "=".repeat(70));
        System.out.println("📚 RESUMEN DE CONCEPTOS:");
        System.out.println("=".repeat(70));
        System.out.println("✓ DTO (UsuarioDTO): Tiene 'id' (persistencia/DB)");
        System.out.println("✓ Dominio (Usuario): Tiene 'dni' (mundo real)");
        System.out.println("✓ Repository: Traduce entre capas y asigna IDs técnicos");
        System.out.println("✓ Optional: Evita nulls y permite operaciones fluidas");
        System.out.println("  - isPresent(), ifPresent(), ifPresentOrElse()");
        System.out.println("  - map(), filter()");
        System.out.println("  - orElse(), orElseThrow()");
        System.out.println("=".repeat(70));
    }
}