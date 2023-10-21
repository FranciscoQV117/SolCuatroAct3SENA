
/*Solucion CLI (interfaz de línea de comandos) 
 * FranciscoQuiñonez2558685 SENA CSF 2023
 * Par CaraFeliz
 * Imapar CaraTriste
 * Decimal 9,5 CaraSorprendida
*/
import java.util.Scanner;

public class SolUnoActTres {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese un número: ");
            int numero;

            String cara = crearCaraSorprendida(); // Cara sorprendida como valor predeterminado

            try {
                numero = scanner.nextInt();
                if (numero % 2 == 0) {
                    cara = crearCaraFeliz();
                } else {
                    cara = crearCaraTriste();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido." + crearCaraSorprendida());
                // La cara ya es sorprendida en caso de excepción
                return;
            }

            String mensaje = (numero % 2 == 0) ? "El número es par." : "El número es impar.";

            imprimirMensajeConCara(mensaje, cara);
        }
    }

    private static String crearCaraFeliz() {
        return "\033[33m" +
                "\r\n      ▄▄▄█████▄▄ \r\n" +
                "    ▄█████████████▄ \r\n" +
                "   ████" + "\033[30m" + "██" + "\033[33m" + "█████" + "\033[30m" + " █" + "\033[33" +
                "m" + "████ \r\n" +
                "   ██▀███████████▀██\r\n" +
                "  ███" + "\033[37m" + "█████████████" + "\033[33m" + "███ \r\n" +
                "   ███" + "\033[37m" + "███████████" + "\033[33m" + "███  \r\n" +
                "    ▀███" + "\033[37m" + "███████" + "\033[33m" + "███▀\r\n" +
                "      ▀█████████▀" + "\033[30m";
    }

    private static String crearCaraTriste() {
        return "\033[33m" +
                "\r\n      ▄▄▄█████▄▄ \r\n" +
                "    ▄█████████████▄ \r\n" +
                "   ████" + "\033[30m" + " █ " + "\033[33m" + "███" + "\033[30m" + " █ " + "\033[33m" +
                "████ \r\n" +
                "   ██▀███████████▀██\r\n" +
                "  █████▀▀▀▀▀▀▀▀▀█████ \r\n" +
                "   ███ ▄███████▄ ███  \r\n" +
                "    ▀█████████████▀\r\n" +
                "      ▀█████████▀" + "\033[30m";
    }

    private static String crearCaraSorprendida() {
        String colorAmarillo = "\033[33m";
        String colorNegro = "\033[30m";
        String colorRojo = "\033[31m";

        return colorAmarillo +
                "\r\n      ▄▄▄█████▄▄ \r\n" +
                "    ▄█████████████▄ \r\n" +
                "   ████" + colorNegro + "██" + colorAmarillo + "█████" + colorNegro + "██" + colorAmarillo +
                "████ \r\n" +
                "   █████████████████\r\n" +
                "  █████▀▀▀▀▀▀▀▀▀█████ \r\n" +
                "   ███           ███  \r\n" +
                "    ▀██ " + colorRojo + "▄█████▄" + colorAmarillo + " ██▀\r\n" +
                "      ▀█████████▀" + colorNegro;
    }

    private static void imprimirMensajeConCara(String mensaje, String cara) {
        String showNumber = "(っ °O °)っ ";
        String salto = "\r\n";
        String reset = "\u001B[0m";

        System.out.println(showNumber + mensaje + salto + cara + salto + reset);
    }
}
