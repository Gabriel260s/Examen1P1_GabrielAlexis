package examen1p1_gabrielalexis;

import java.util.Scanner;
import java.util.Random;

public class Examen1P1_GabrielAlexis {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Ingrese una opcion: \n1.Fight or flight\n2. Trifuerza\n4. Para salir\nIngrese una opcion. ");
        int opc = input.nextInt();
        while (opc != 4) {
            switch (opc) {
                case 1:
                    int vida_zombie = 25,
                     balas = 25,
                     prob_fallo = 65,
                     dagno_aleat,
                     distan_aleat,
                     pos_zombie,

                     prob_dagno;
                    pos_zombie = random.nextInt(15, 30);

                    char resp = 's';

                    System.out.println("Ingrese maestria\n1. Principiante(0% de hit extra + extra damage)\n2. Intermedio (5% de hit extra + extra damage)\n3. Experto (15% de hit extra + extra damage)");
                    int maestria = input.nextInt();
                    switch (maestria) {
                        case 1:
                            prob_fallo += 0;
                            break;
                        case 2:
                            prob_fallo += 5;
                            break;
                        case 3:
                            prob_fallo += 15;
                            break;

                    }
                    System.out.println(prob_fallo);
                    if (maestria >= 1 && maestria <= 3) {
                        while ((resp == 's' || resp == 'S')) {
                            System.out.println("EL zombie se encuentra a: " + pos_zombie + " metros!.\n\nEl jugador cuenta con " + balas + " balas!\n");

                            prob_dagno = random.nextInt(1, 100);
                            {
                                if (prob_dagno <= prob_fallo) {
                                    dagno_aleat = random.nextInt(1, 7);
                                    System.out.println("Hit! El zombie se a reducido el HP del zombie por un total de: " + dagno_aleat + "\n");
                                    vida_zombie = vida_zombie - dagno_aleat;
                                    balas--;
                                } else {
                                    int distancia_avanzada = random.nextInt(3, 5);
                                    pos_zombie = pos_zombie - distancia_avanzada;
                                    System.out.println("Ha fallado! El zombie se encuentra a " + pos_zombie + "\n");
                                    balas--;

                                }

                                if (pos_zombie <= 0) {
                                    pos_zombie = 0;
                                    System.out.println("Haz muerto! El zombie te ha alcanzado\n");
                                    resp = 'n';
                                } else if (balas <= 0) {
                                    System.out.println("Haz perdido! Te haz quedado sin balas");
                                    balas = 0;
                                    resp = 'n';
                                } else if (vida_zombie <= 0) {
                                    vida_zombie = 0;
                                    System.out.println("You win! El zombie a muerto\n");
                                    resp = 'n';
                                } else if (vida_zombie > 0) {
                                    System.out.println("Vida restante del zombie " + vida_zombie + "\n\nListo para pasar a la siguiente ronda");
                                    resp = input.next().charAt(0);

                                }

                            }

                        }
                        maestria = 0;

                    }
                    break;

                case 2:
                    Trifuerza();
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("Ingrese una opcion: \n1.Fight or flight\n2. Trifuerza\n4. Para salir\nIngrese una opcion. ");
            opc = input.nextInt();
        }

    }

    public static void Trifuerza() {
        System.out.println("Ingrese el tamagno de la figura mayor a 20 y par: ");

        int tamagno = input.nextInt();
        while ((tamagno / 2) % 2 != 0) {

            {
                for (int i = 0; i < tamagno / 2 + 1; i++) {
                    for (int j = 0; j < tamagno * 2 - 1; j++) {
                      
                      
                      if (j >= tamagno - i - 1 && j <= tamagno + i - 1) {
                            System.out.print("*");

                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                System.out.println("Ingrese otro numero: ");
                tamagno =input.nextInt();
            }
        }
    }

}
