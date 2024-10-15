import java.util.Scanner;

public class RuletaPruebaV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 0, apuestaNumero = 0, apuestaColor = 0;
        int color = 0, seleccion = 0, numero = 0, comodin = 0;
        boolean siguiente = true;
        boolean continuar = true;

        RuletaV2 ruleta = new RuletaV2();
        System.out.println("¡¡BIENVENIDO A LA RULETA!!");

        try {
            do {

                System.out.println("--------------------------");
                System.out.println("Elige una opción:");
                System.out.println("1. Ver Saldo.");
                System.out.println("2. Añadir dinero.");
                System.out.println("3. Retirar dinero.");
                System.out.println("4. Apostar a un número.");
                System.out.println("5. Apostar a un color.");
                System.out.println("6. Salir.");
                seleccion = sc.nextInt();

                switch (seleccion) {
                    case 1:
                        do {
                            System.out.println("Tu saldo es de " + ruleta.getSaldo());
                            System.out.println("Inserte -1 para volver al Menú...");
                            comodin = sc.nextInt();
                            if (comodin == -1) {
                                siguiente = false;
                            } 
                        } while (siguiente);
                        break;
                    case 2:
                        do {
                            System.out.println("¿Cuánto dinero quieres añadir?");
                            saldo = sc.nextDouble();
    
                            if (saldo < 0) {
                                System.out.println("Error al añadir saldo");
                            } else {
                                ruleta.addSaldo(saldo);
                                System.out.println("Saldo añadido correctamente");
                            }
                            System.out.println("Inserte -1 para volver al Menú...");
                            comodin = sc.nextInt();
                            if (comodin == -1) {
                                siguiente = false;
                            }  
                        } while (siguiente);
                        break;
                    case 3:
                        do {
                            System.out.println("Tienes " + ruleta.getSaldo() + " euros...");
                            System.out.println("¿Cuánto dinero quieres retirar?");
                            saldo = sc.nextDouble();
                            if (saldo > ruleta.getSaldo()) {
                                System.out.println("No puedes retirar más dinero del que tienes.");
                            } else if (saldo < 0) {
                                System.out.println("Error al retirar saldo.");
                            } else {
                                ruleta.removeSaldo(saldo);
                                System.out.println("¡Saldo retirado correctamente!");
                            }
                            System.out.println("Inserte -1 para volver al Menú...");
                            comodin = sc.nextInt();
                            if (comodin == -1) {
                                siguiente = false;
                            } 
                        } while (siguiente);
                        break;
                    case 4:
                        do {
                            ruleta.numeroRuleta();
                            System.out.println("Dime un número entre el 1 y el 20");
                            numero = sc.nextInt();
                            if (numero > 0 && numero < 21) {
                                System.out.println("¿Cuánto quieres apostar?");
                                apuestaNumero = sc.nextDouble();
                                if (apuestaNumero > ruleta.getSaldo()) {
                                    System.out.println("No puedes apostar más de lo que tienes.");
                                } else {
                                    ruleta.apuestaNumero(apuestaNumero);
    
                                    if (numero == ruleta.getNumero()) {
                                        ruleta.apuestaNumero(apuestaNumero);
                                        System.out.println("¡Has acertado!, ahora tienes " + ruleta.getSaldo());
                                    } else {
                                        System.out.println("Has fallado, el número era " + ruleta.getNumero());
                                    }
                                }
                            } else {
                                System.out.println("Ese número no está en la ruleta");
                            }
                            System.out.println("Inserte -1 para volver al Menú...");
                            comodin = sc.nextInt();
                            if (comodin == -1) {
                                siguiente = false;
                            } 
                        } while (siguiente);
                        break;
                    case 5:
                        do {
                            ruleta.colorRuleta();
                            System.out.println("Dime un color: \n 1 = ROJO \n 2 = NEGRO");
                            color = sc.nextInt();
                            if (color == 1 || color == 2) {
                                System.out.println("¿Cuánto quieres apostar?");
                                apuestaColor = sc.nextDouble();
                                if (apuestaColor > ruleta.getSaldo()) {
                                    System.out.println("No puedes apostar más de lo que tienes.");
                                } else {
                                    ruleta.apuestaColor(apuestaColor);
    
                                    if (color == ruleta.getColor()) {
                                        ruleta.colorAcertado(apuestaColor);
                                        System.out.println("¡Has acertado!, ahora tienes " + ruleta.getSaldo());
                                    } else {
                                        System.out.println("Has fallado, el color era el " + ruleta.getColor()
                                                + " (1 = ROJO, 2 = NEGRO.)");
                                    }
                                }
                            } else {
                                System.out.println("Error al elegir el color, 1 = ROJO, 2 = NEGRO");
                            }
                            System.out.println("Inserte -1 para volver al Menú...");
                            comodin = sc.nextInt();
                            if (comodin == -1) {
                                siguiente = false;
                            } 
                        } while (siguiente);
                        break;
                    case 6:
                        System.out.println("¡Hasta pronto!");
                        continuar = false;
                        break;
                    default:
                        System.out.println("¡Opción incorrecta!");
                        break;
                }
            } while (continuar);
        } catch (Exception e) {
            System.out.println("Error al introducir el valor adecuado para el campo");
        }

        sc.close();
    }
}
