import java.util.Scanner;

public class RuletaPruebaV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 0, apuestaNumero = 0, apuestaColor = 0;
        int color = 0, seleccion = 0, numero = 0;
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
                        System.out.println("Tu saldo es de " + ruleta.getSaldo());
                        break;
                    case 2:
                        System.out.println("¿Cuánto dinero quieres añadir?");
                        saldo = sc.nextDouble();
    
                        if (saldo < 0) {
                            System.out.println("Error al añadir saldo");
                        } else {
                            ruleta.addSaldo(saldo);
                            System.out.println("Saldo añadido correctamente");
                        }
                        break;
                    case 3:
                        System.out.println("¿Cuánto dinero quieres retirar?");
                        saldo = sc.nextDouble();
                        if (saldo > ruleta.getSaldo()) {
                            System.out.println("No puedes retirar más dinero del que tienes.");
                        } else {
                            ruleta.removeSaldo(saldo);
                            System.out.println("¡Saldo retirado correctamente!");
                        }
                        break;
                    case 4:
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
                        }
                        break;
                    case 5:
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
                        }
                        break;
                    case 6:
                        System.out.println("¡Hasta pronto!");
                        continuar = false;
                        break;
                    case 7:
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
