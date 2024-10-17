import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Ohhhh nooo!!, ¡¡te has caido por un túnel subterraneo!! \n Encuentra la forma de salir, pero ten cuidado, no sabes lo que puede haber en esta cueva...");

        System.out.println();

        Explorador explorer = new Explorador();
        Pingu pingu = new Pingu();
        String camino;
        boolean seguir = false, correcto = false, fin = false;

        do {
            try {
                System.out.println("Tienes " + explorer.getSalud() + " puntos de vida.");
                System.out.println("Has vencido a " + pingu.getVencidos() + "/5 pingüinos.");
                seguir = false;
                System.out.println("Pulsa cualquier tecla para comenzar...");
                sc.nextLine();

                // Se divide el camino. Escogemos una opción que no sea la anterior...
                while (!seguir) {

                    System.out.println(
                            "Oh no!!. Se divide el camino. ¿Dónde quieres ir?");
                    if (explorer.getNoCamino().equals("N")) {
                        System.out.println("\n E = Este. \n O = Oeste. \n S = Sur.");
                    } else if (explorer.getNoCamino().equals("S")) {
                        System.out.println("\n E = Este. \n O = Oeste. \n N = Norte.");
                    } else if (explorer.getNoCamino().equals("E")) {
                        System.out.println("\n N = Norte. \n S = Sur. \n O = Oeste.");
                    } else if (explorer.getNoCamino().equals("O")) {
                        System.out.println("\n N = Norte. \n S = Sur. \n E = Este.");
                    }
                    camino = sc.nextLine();

                    if (!camino.equals(explorer.getNoCamino())) {
                        explorer.elegirCamino(camino);
                        seguir = true;

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
                    } else if (camino.equals(explorer.getNoCamino())) {
                        System.out.println("¡¡No puedes volver por donde has venido, estás atrapado por la nieve!!");
                    } else {
                        System.out.println("Esa dirección no existe");
                    }
                }

                int eleccion = 0;
                String tipopingu;
                correcto = false;
                // Nos encontramos con un pingüino!!
                while (!correcto) {
                    tipopingu = pingu.pinguAzar();
                    System.out.println("¡¡Te has encontrado con un " + tipopingu + " mutante!!");
                    System.out.println("¿Qué quieres hacer? \n 1. Huir. \n 2. Luchar");
                    eleccion = sc.nextInt();
                    switch (eleccion) {
                        case 1:
                            explorer.huir();
                            System.out.println("Has escapado a tiempo, pero te has tropezado y ahora tienes "
                                    + explorer.getSalud() + " puntos de vida.");
                            break;
                        case 2:
                            System.out.println("Has decidico luchar. Era un " + tipopingu);
                            if (explorer.pelearPingu(tipopingu) == 1) {
                                System.out.println("¡Has ganado!");
                                explorer.saludVictoria();
                                System.out.println("Ahora tienes " + explorer.getSalud() + " puntos de vida.");
                                pingu.addVencido();
                                if (pingu.soltarHuevoMagico()) {
                                    System.out.println(
                                            "¡¡Te has encontrado un huevo mágico, llevando esto encima serás el rey de los pingüinos!!");
                                    fin = true;
                                }

                                System.out.println("¡Enhorabuena! Has logrado salir con vida.");

                            } else {
                                System.out.println("¡Has perdido!");
                                explorer.saludDerrota();
                                if (explorer.getSalud() > 0) {
                                    System.out.println("Ahora tienes " + explorer.getSalud() + " puntos de vida.");
                                } else {
                                    System.out.println("Has sido asesinado por un pingüino");
                                }
                            }
                            break;
                        default:
                            System.out.println("Esa opción no esta en tus planes.");
                            break;
                    }

                    correcto = true;
                    if (explorer.getSalud() <= 0) {
                        fin = true;
                    }
                    if (pingu.getVencidos() >= 5) {
                        System.out.println("Has salido con vida, pero te has topado con... ¡¡El PINGÜINO PADRE!!");
                        System.out.println("Para poder evitarlo debes decirme tu contraseña de tu correo electronico");
                        sc.nextLine();

                        System.out.println("Es broma xd, no la he guardado. Pero ten mucho cudiado la próxima vez.");

                    }
                }
            } catch (Exception e) {
                System.out.println("Error al introducir el valor");
            }
        } while (!fin);

        sc.close();
    }
}
