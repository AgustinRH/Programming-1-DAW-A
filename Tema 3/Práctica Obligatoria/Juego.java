import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner para leer la entrada del usuario

        // Informamos al usuario de como comenzará el juego...
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(
                "OHH NOOO!!, !!TE HAS CAIDO A UNA SIMA DE HIELO!! \n Encuentra la forma de salir, pero ten cuidado, no sabes lo que puede haber en esta cueva...");

        Explorador explorer = new Explorador(); // Crea un objeto Explorador para representar al jugador
        Pingu pingu = new Pingu(); // Crea un objeto Pingu para representar los enemigos

        // Variables de control para el juego
        String camino;
        boolean seguir = false, correcto = false, fin = false;

        System.out.println("--------------------------------------------------------------------------");
        // Bucle para no finalizar el juego cuando sea necesario
        do {
            try {
                // Muestra la información del jugador y los pingüinos vencidos
                System.out.println("Tienes " + explorer.getSalud() + " puntos de vida.");
                System.out.println("Has vencido a " + pingu.getVencidos() + "/5 pingüinos.");
                seguir = false;
                


                // Bucle para elegir el camino
                while (!seguir) {

                    System.out.println(
                            "Oh no!!. Se divide el camino. ¿Dónde quieres ir?");
                    if (explorer.getNoCamino().equals("N")) { // Si el camino bloqueado es "Norte", no lo muestra por
                                                              // pantalla
                        System.out.println("\n E = Este. \n O = Oeste. \n S = Sur.");
                    } else if (explorer.getNoCamino().equals("S")) { // Si el camino bloqueado es "Sur", no lo muestra
                                                                     // por pantalla
                        System.out.println("\n E = Este. \n O = Oeste. \n N = Norte.");
                    } else if (explorer.getNoCamino().equals("E")) { // Si el camino bloqueado es "Este", no lo muestra
                                                                     // por pantalla
                        System.out.println("\n N = Norte. \n S = Sur. \n O = Oeste.");
                    } else if (explorer.getNoCamino().equals("O")) { // Si el camino bloqueado es "Oeste", no lo muestra
                                                                     // por pantalla
                        System.out.println("\n N = Norte. \n S = Sur. \n E = Este.");
                    }
                    camino = sc.nextLine();

                    // Comprobamos que el camino escogido no es el que esta bloquedo
                    if (!camino.equals(explorer.getNoCamino())) {
                        explorer.elegirCamino(camino);
                        seguir = true;
                        System.out
                                .println("--------------------------------------------------------------------------");
                        // Decimos que camino ha escogido
                        if (explorer.getCamino().equals("S")) {
                            System.out.println("Has elegido ir hacia el Sur");
                        } else if (explorer.getCamino().equals("N")) {
                            System.out.println("Has elegido ir hacia el Norte");
                        } else if (explorer.getCamino().equals("E")) {
                            System.out.println("Has elegido ir hacia el Este");
                        } else if (explorer.getCamino().equals("O")) {
                            System.out.println("Has elegido ir hacia el Oeste");
                        } else {
                            System.out.println("¡Esa dirección no existe!");
                            seguir = false;
                        }
                    } else if (camino.equals(explorer.getNoCamino())) { // Si el camino escogido es el bloqueado,
                                                                        // avisamos que no puede volver por ahí
                        System.out.println("¡¡No puedes volver por donde has venido, estás atrapado por la nieve!!");
                    } else { // Si ha introducido otra dirección, alertamos de que ese camino no existe
                        System.out.println("Esa dirección no existe");
                    }
                }
                // Variables del juego
                int eleccion = 0;
                String tipopingu;
                correcto = false;

                // Bucle para el encuentro con el pingüino
                while (!correcto) {
                    // Genera un tipo de pingüino aleatorio
                    System.out.println("--------------------------------------------------------------------------");
                    tipopingu = pingu.pinguAzar();
                    // Muestra un dibujo ASCII del pingüino
                    System.out.println("         /~~~~~~\\\r\n" + //
                            "       /`    -s- ~~~~\\\r\n" + //
                            "      /`::::      ~~~~\r\n" + //
                            "     /`:::::     :\r\n" + //
                            "    /` :::::...::::\r\n" + //
                            "   /`   `:::::::::::\r\n" + //
                            "  /`      `:::::::::\r\n" + //
                            " /`        :::::::::\r\n" + //
                            " :        ::::::::::\r\n" + //
                            " :       :::::::::::\r\n" + //
                            " :       :::::::::::\r\n" + //
                            " :   .    ::::::::::\r\n" + //
                            " :   :.   ::::::::'\r\n" + //
                            " :   ::  .:::::::'\r\n" + //
                            " :   ::..:::::::'\r\n" + //
                            " :    :::::::::'\r\n" + //
                            "  :    :::::::::\r\n" + //
                            "   :..::......::\r\n" + //
                            "||||||||||||||||||||||||||");
                    System.out.println("--------------------------------------------------------------------------");
                    // Menú para elegir si huir o atacar al pingüino que le ataca
                    System.out.println("¡¡Te has encontrado con un " + tipopingu + " mutante!!");
                    System.out.println("¿Qué quieres hacer? \n 1. Huir. \n 2. Luchar. \n 3. Atrapar.");
                    eleccion = sc.nextInt();

                    // Opción a escoger para que el jugador elija entre huir o luchar
                    System.out.println("--------------------------------------------------------------------------");
                    switch (eleccion) {
                        case 1: // Si decide huir llamamos al método huir de la clase Explorador y le restamos
                                // salud por huir
                            explorer.huir();
                            System.out.println("Has escapado a tiempo, pero te has tropezado y ahora tienes "
                                    + explorer.getSalud() + " puntos de vida.");
                            break;
                        case 2: // Si decide atacar llamamos al método pelearPingu de la clase Explorador para
                                // sacar aleatoriamente si gana o pierde
                            System.out.println("Has decidido luchar con un " + tipopingu);

                            System.out.println("SALUD ACTUAL:" + explorer.getSalud());
                            if (explorer.pelearPingu(tipopingu) == 1) { // Si gana, avisamos al usuario y sumamos 1 a
                                                                        // los pingüinos derrotados y sumamos la salud
                                                                        // acorde al pingüino derrotado

                                explorer.saludVictoria();
                                System.out.println(
                                        "¡Has ganado!, ahora tienes " + explorer.getSalud() + " puntos de vida.");
                                System.out.println();

                                pingu.addVencido(); // Añadimos 1 al contador de pingüinos vencidos

                                if (pingu.soltarHuevoMagico()) { // Si suelta un huevo mágico termina el juego
                                                                 // directamente
                                    System.out.println(
                                            "¡¡Te has encontrado un huevo mágico, llevando esto encima serás el rey de los pingüinos!!");
                                    fin = true;
                                }

                            } else { // Si pierde, avisamos al usuario y le restamos la vida que le ha quitado el
                                     // pingüino
                                explorer.saludDerrota();
                                System.out.println("¡Has perdido la batalla!");

                                if (explorer.getSalud() > 0) {
                                    System.out.println("Ahora tienes " + explorer.getSalud() + " puntos de vida.");
                                    System.out.println();
                                } else {
                                    System.out.println("Has sido asesinado por un pingüino :C");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Has decidido atrapar al pingüino. Va a ser difícil...");

                            if (pingu.atraparPingu(tipopingu) == 0) {
                                System.out.println("No has podido atraparlo, ahora debes luchar...");
                                System.out.println("SALUD ACTUAL:" + explorer.getSalud());
                                if (explorer.pelearPingu(tipopingu) == 1) { // Si gana, avisamos al usuario y sumamos 1
                                                                            // a
                                                                            // los pingüinos derrotados y sumamos la
                                                                            // salud
                                                                            // acorde al pingüino derrotado
                                    explorer.saludVictoria();
                                    System.out.println(
                                            "¡Has ganado!, ahora tienes " + explorer.getSalud() + " puntos de vida.");
                                    System.out.println();

                                    pingu.addVencido();
                                    if (pingu.soltarHuevoMagico()) { // Si suelta un huevo mágico termina el juego
                                                                     // directamente
                                        System.out.println(
                                                "¡¡Te has encontrado un huevo mágico, llevando esto encima serás el rey de los pingüinos!!");
                                        fin = true;
                                    }

                                } else { // Si pierde, avisamos al usuario y le restamos la vida que le ha quitado el
                                         // pingüino
                                    explorer.saludDerrota();
                                    System.out.println("¡Has perdido la batalla!");

                                    if (explorer.getSalud() > 0) {
                                        System.out.println("Ahora tienes " + explorer.getSalud() + " puntos de vida.");
                                    } else {
                                        System.out.println("Has sido asesinado por un pingüino");
                                    }
                                }
                            } else if (pingu.atraparPingu(tipopingu) == 1) {
                                if (pingu.cantAtrapados >= 1) {
                                    System.out.println(
                                            "No puedes atrapar más pingüinos, ya tienes un pingüino en el saco.");
                                } else {
                                    System.out.println("Has atrapado un pingüino, bien hecho!!");
                                }

                            }
                            break;
                        default: // Si elige otra opción que no sea huir o luchar, avisamos al usuario de que esa
                                 // opción no es válida
                            System.out.println("Esa opción no esta en tus planes..");
                            break;
                    }

                    correcto = true;
                    System.out.println("--------------------------------------------------------------------------");
                    // Si el jugador pierde todos los puntos de vida, muere y acaba el juego
                    if (explorer.getSalud() <= 0) {
                        fin = true;
                    }
                    // Si el jugador derrota a 5 pingüinos, logra escapar de la cueva con vida
                    if (pingu.getVencidos() >= 5) {
                        System.out.println("Has derrotado a todos los pingüinos de la caverna. ¡Bien hecho!");
                        fin = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al introducir el valor correcto");
            }
            
            sc.nextLine();
        } while (!fin);

        sc.close();
    }
}
