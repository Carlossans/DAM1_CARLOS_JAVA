package E320GlobosExplosivos;

import java.util.Scanner;

public class Principal {
    // Scanner para leer entrada del usuario desde la consola
    private static Scanner scanner = new Scanner(System.in);
    // Variables para llevar la cuenta de puntos de cada jugador
    private static int puntosJugador1 = 0;
    private static int puntosJugador2 = 0;
    // Array para guardar los 5 globos del juego
    private static Globo[] globos = new Globo[5];
    // Array para guardar quién ganó cada ronda
    private static String[] ganadoresRondas = new String[5];
    
    // Método principal que inicia el programa
    public static void main(String[] args) {
        mostrarMenuPrincipal();  // Muestra el menú con las opciones del juego
        scanner.close();  // Cierra el scanner al terminar
    }
    
    // Muestra el menú principal y maneja la selección del usuario
    private static void mostrarMenuPrincipal() {
        int opcion;  // Variable para guardar la opción elegida
        
        do {
            // Mostrar las opciones del menú
            System.out.println("\nMENÚ PRINCIPAL GLOBOS EXPLOSIVOS");
            System.out.println("1. Fase 1 - Un jugador (práctica)");
            System.out.println("2. Fase 2 - Dos jugadores (práctica)");
            System.out.println("3. Fase 3 - Juego completo (2 jugadores)");
            System.out.println("4. Fase 4 - Contra la máquina");
            System.out.println("0. Salir del juego");
            System.out.print("Elige una opción: ");
            
            // Leer la opción del usuario
            opcion = leerEntero();
            
            // Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    ejecutarFase1();  // Juego con un solo jugador
                    break;
                case 2:
                    ejecutarFase2();  // Juego con dos jugadores (una ronda)
                    break;
                case 3:
                    ejecutarFase3();  // Juego completo (hasta 5 rondas)
                    break;
                case 4:
                    ejecutarFase4();  // Jugar contra la computadora
                    break;
                case 0:
                    System.out.println("Gracias por jugar");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            
            // Pausar antes de volver al menú (excepto al salir)
            if (opcion != 0) {
                pausa();
            }
            
        } while (opcion != 0);  // Repetir hasta que elija salir (0)
    }
    
    // FASE 1: Juego simple con un solo jugador
    private static void ejecutarFase1() {
        System.out.println("Globo con capacidad fija de 10 unidades.");
        
        // Crear un globo con capacidad fija de 10
        Globo globo = new Globo(10);
        System.out.println("Capacidad del globo: " + globo.getCapacidad());
        
        // Continuar jugando hasta que el globo explote
        while (!globo.estaExplotado()) {
            System.out.println("\nGlobo actual: " + globo.toString());
            System.out.print("¿Cuánto aire quieres soplar? ");
            int aire = leerEntero();  // Leer cuánto aire quiere soplar
            
            globo.inflar(aire);  // Inflar el globo con esa cantidad
        }
        
        // Mostrar resultado cuando el globo explota
        System.out.println("\nEl globo ha explotado.");
        System.out.println("Estado final: " + globo.toString());
    }
    
    // FASE 2: Dos jugadores en una sola ronda
    private static void ejecutarFase2() {
        System.out.println("Globo con capacidad fija de 10 unidades.");
        
        // Crear globo y variables para controlar el juego
        Globo globo = new Globo(10);
        int turno = 1;  // Empieza el jugador 1 (1 = jugador 1, 2 = jugador 2)
        boolean rondaTerminada = false;  // Controla cuándo termina la ronda
        
        System.out.println("Capacidad del globo: " + globo.getCapacidad());
        
        // Jugar hasta que alguien haga explotar el globo
        while (!rondaTerminada) {
            System.out.println("\nGlobo actual: " + globo.toString());
            
            // Pedir aire según de quién sea el turno
            if (turno == 1) {
                System.out.print("Jugador 1, ¿cuánto aire quieres soplar? ");
            } else {
                System.out.print("Jugador 2, ¿cuánto aire quieres soplar? ");
            }
            
            int aire = leerEntero();
            globo.inflar(aire);  // Inflar el globo
            
            // Verificar si el globo explotó
            if (globo.estaExplotado()) {
                rondaTerminada = true;  // Terminar la ronda
                System.out.println("\nEl globo ha explotado.");
                System.out.println("Globo final: " + globo.toString());
                
                // El ganador es el que NO hizo explotar el globo
                if (turno == 1) {
                    System.out.println("El Jugador 2 gana esta ronda");
                } else {
                    System.out.println("El Jugador 1 gana esta ronda");
                }
            } else {
                // Cambiar turno si el globo no explotó
                turno = (turno == 1) ? 2 : 1;
            }
        }
    }
    
    // FASE 3: Juego completo con 5 rondas (2 jugadores humanos)
    private static void ejecutarFase3() {
        System.out.println("Bienvenidos al juego de Globos Explosivos");
        System.out.println("Se jugarán hasta 5 rondas. Gana el primero en alcanzar 3 victorias.");
        
        reiniciarPuntuaciones();  // Poner los puntos a 0
        
        // Jugar hasta 5 rondas
        for (int ronda = 0; ronda < 5; ronda++) {
            // Salir si alguien ya ganó 3 rondas
            if (puntosJugador1 == 3 || puntosJugador2 == 3) {
                break;
            }
            
            System.out.println("\n=== RONDA " + (ronda + 1) + " ===");
            globos[ronda] = new Globo();  // Crear un nuevo globo aleatorio
            jugarRondaContraHumano(ronda);  // Jugar la ronda
            
            mostrarPuntuacionParcial();  // Mostrar puntos actuales
            
            // Pausar entre rondas si no ha terminado el juego
            if (ronda < 4 && puntosJugador1 < 3 && puntosJugador2 < 3) {
                pausaParaContinuar();
            }
        }
        
        // Mostrar resultados finales
        mostrarResultadoFinal();
        mostrarEstadoGlobos();
    }
    
    // FASE 4: Jugar contra la computadora
    private static void ejecutarFase4() {
        System.out.println("Juegas contra la máquina");
        System.out.println("Se jugarán hasta 5 rondas. Gana el primero en alcanzar 3 victorias.");
        
        reiniciarPuntuaciones();  // Poner los puntos a 0
        
        // Jugar hasta 5 rondas
        for (int ronda = 0; ronda < 5; ronda++) {
            // Salir si alguien ya ganó 3 rondas
            if (puntosJugador1 == 3 || puntosJugador2 == 3) {
                break;
            }
            
            System.out.println("\n=== RONDA " + (ronda + 1) + " ===");
            globos[ronda] = new Globo();  // Crear un nuevo globo aleatorio
            jugarRondaContraMaquina(ronda);  // Jugar la ronda contra la máquina
            
            mostrarPuntuacionParcial();  // Mostrar puntos actuales
            
            // Pausar entre rondas si no ha terminado el juego
            if (ronda < 4 && puntosJugador1 < 3 && puntosJugador2 < 3) {
                pausaParaContinuar();
            }
        }
        
        // Mostrar resultados finales
        mostrarResultadoFinal();
        mostrarEstadoGlobos();
    }
    
    // Método para jugar una ronda entre dos jugadores humanos
    private static void jugarRondaContraHumano(int indiceRonda) {
        Globo globo = globos[indiceRonda];  // Obtener el globo de esta ronda
        int turno = 1;  // Empieza el jugador 1
        boolean rondaTerminada = false;  // Controla cuándo termina la ronda
        
        System.out.println("Capacidad del globo: " + globo.getCapacidad());
        
        // Jugar hasta que alguien haga explotar el globo
        while (!rondaTerminada) {
            System.out.println("\nGlobo actual: " + globo.toString());
            
            if (turno == 1) {
                // Turno del jugador 1
                System.out.print("Jugador 1, ¿cuánto aire quieres soplar? ");
                int aire = leerEntero();
                globo.inflar(aire);
                
                // Verificar si explotó
                if (globo.estaExplotado()) {
                    rondaTerminada = true;
                    System.out.println("\nEl globo ha explotado.");
                    System.out.println("Globo final: " + globo.toString());
                    System.out.println("El Jugador 2 gana esta ronda");
                    puntosJugador2++;  // Sumar punto al jugador 2
                    ganadoresRondas[indiceRonda] = "Jugador 2";  // Guardar ganador
                }
                turno = 2;  // Pasar turno al jugador 2
                
            } else {
                // Turno del jugador 2
                System.out.print("Jugador 2, ¿cuánto aire quieres soplar? ");
                int aire = leerEntero();
                globo.inflar(aire);
                
                // Verificar si explotó
                if (globo.estaExplotado()) {
                    rondaTerminada = true;
                    System.out.println("\nEl globo ha explotado.");
                    System.out.println("Globo final: " + globo.toString());
                    System.out.println("El Jugador 1 gana esta ronda");
                    puntosJugador1++;  // Sumar punto al jugador 1
                    ganadoresRondas[indiceRonda] = "Jugador 1";  // Guardar ganador
                }
                turno = 1;  // Pasar turno al jugador 1
            }
        }
    }
    
    // Método para jugar una ronda contra la máquina
    private static void jugarRondaContraMaquina(int indiceRonda) {
        Globo globo = globos[indiceRonda];  // Obtener el globo de esta ronda
        int turno = 1;  // Empieza el jugador humano
        boolean rondaTerminada = false;  // Controla cuándo termina la ronda
        
        System.out.println("Capacidad del globo: " + globo.getCapacidad());
        
        // Jugar hasta que alguien haga explotar el globo
        while (!rondaTerminada) {
            System.out.println("\nGlobo actual: " + globo.toString());
            
            if (turno == 1) {
                // Turno del jugador humano
                System.out.print("Jugador, ¿cuánto aire quieres soplar? ");
                int aire = leerEntero();
                globo.inflar(aire);
                
                // Verificar si explotó
                if (globo.estaExplotado()) {
                    rondaTerminada = true;
                    System.out.println("\nEl globo ha explotado.");
                    System.out.println("Globo final: " + globo.toString());
                    System.out.println("La Máquina gana esta ronda");
                    puntosJugador2++;  // Sumar punto a la máquina
                    ganadoresRondas[indiceRonda] = "Máquina";  // Guardar ganador
                }
                turno = 2;  // Pasar turno a la máquina
                
            } else {
                // Turno de la máquina
                System.out.println("Turno de la máquina...");
                int aireMaquina = calcularSoplidoMaquina(globo);  // Calcular cuánto sopla
                System.out.println("La máquina sopla: " + aireMaquina);
                globo.inflar(aireMaquina);
                
                // Verificar si explotó
                if (globo.estaExplotado()) {
                    rondaTerminada = true;
                    System.out.println("\nEl globo ha explotado.");
                    System.out.println("Globo final: " + globo.toString());
                    System.out.println("El Jugador gana esta ronda");
                    puntosJugador1++;  // Sumar punto al jugador
                    ganadoresRondas[indiceRonda] = "Jugador";  // Guardar ganador
                }
                turno = 1;  // Pasar turno al jugador
            }
        }
    }
    
    // Calcula cuánto aire debe soplar la máquina (inteligencia artificial simple)
    private static int calcularSoplidoMaquina(Globo globo) {
        int aireRestante = globo.getAireRestante();  // Cuánto aire le falta para explotar
        
        // Estrategia: si queda poco, explotar; si no, soplar poco
        if (aireRestante <= 3) {
            return aireRestante;  // Explotar el globo
        } else {
            // Soplar entre 1 y 5 (o menos si queda menos aire)
            return 1 + (int)(Math.random() * Math.min(5, aireRestante - 1));
        }
    }
    
    // Reinicia las puntuaciones y los arrays para empezar un nuevo juego
    private static void reiniciarPuntuaciones() {
        puntosJugador1 = 0;
        puntosJugador2 = 0;
        globos = new Globo[5];  // Crear nuevo array de globos
        ganadoresRondas = new String[5];  // Crear nuevo array de ganadores
    }
    
    // Muestra la puntuación actual durante el juego
    private static void mostrarPuntuacionParcial() {
        System.out.println("Jugador 1: " + puntosJugador1 + " puntos");
        System.out.println("Jugador 2: " + puntosJugador2 + " puntos");
    }
    
    // Muestra el resultado final del juego completo
    private static void mostrarResultadoFinal() {
        System.out.println("Jugador 1: " + puntosJugador1 + " victorias");
        System.out.println("Jugador 2: " + puntosJugador2 + " victorias");
        
        // Determinar quién ganó
        if (puntosJugador1 > puntosJugador2) {
            System.out.println("JUGADOR 1, ES EL GANADOR");
        } else if (puntosJugador2 > puntosJugador1) {
            System.out.println("JUGADOR 2 ES EL GANADOR");
        } else {
            System.out.println("EMPATE");
        }
    }
    
    // Muestra el estado final de todos los globos
    private static void mostrarEstadoGlobos() {
        for (int i = 0; i < globos.length; i++) {
            if (globos[i] != null) {
                // Mostrar cada globo con su capacidad y representación visual
                System.out.print("Globo " + (i + 1) + " (capacidad " + globos[i].getCapacidad() + "): ");
                System.out.print(globos[i].toString());
                if (ganadoresRondas[i] != null) {
                    System.out.println(" - Ganador: " + ganadoresRondas[i]);
                } else {
                    System.out.println();
                }
            } else {
                // Mostrar que este globo no se jugó
                System.out.println("Globo " + (i + 1) + ": No se jugó");
            }
        }
    }
    
    // Método seguro para leer números enteros (evita errores)
    private static int leerEntero() {
        // Esperar hasta que el usuario introduzca un número válido
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next();  // Descartar la entrada incorrecta
        }
        int numero = scanner.nextInt();  // Leer el número
        scanner.nextLine();  // Limpiar el buffer del scanner
        return numero;
    }
    
    // Pausa el programa hasta que el usuario presione Enter
    private static void pausa() {
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    
    // Pausa específica para pasar a la siguiente ronda
    private static void pausaParaContinuar() {
        System.out.println("\nPresiona Enter para pasar a la siguiente ronda...");
        scanner.nextLine();
    }
}