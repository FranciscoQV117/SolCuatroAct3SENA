import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/*Solucion GUI  (interfaz gráfica de usuario)
 * FranciscoQuiñonez2558685 SENA CSF 2023
 * Par CaraFeliz
 * Imapar CaraTriste
 * Decimal 10.5 CaraSorprendida
*/
public class SolDosActTres {

    public static void main(String[] args) {
        // Declarar la variable
        BufferedImage imagen;

        // Solicitar al usuario que ingrese un número
        String input = JOptionPane.showInputDialog("Ingresa un número:");

        // Crear una condición "if" para comprobar si el número es decimal
        if (!Double.isFinite(Double.parseDouble(input))) {
            // El número es decimal, se mostrará una carita enojada
            imagen = crearCaritaSorpresa();
        } else {
            // El número no es decimal, se comprobará si es par o impar
            if (input.matches("\\d+")) {
                // El usuario ingresó un número válido
                int numero = Integer.parseInt(input);

                if (numero % 2 == 0) {
                    imagen = crearCaritaFeliz();
                } else {
                    imagen = crearCaritaTriste();
                }
            } else {
                // El usuario ingresó un texto inválido
                imagen = crearCaritaSorpresa();
            }
        }

        // Mostrar la imagen en una ventana
        ImageIcon icono = new ImageIcon(imagen);
        JOptionPane.showMessageDialog(null, "", "Resultado", JOptionPane.INFORMATION_MESSAGE, icono);
    }

    private static BufferedImage crearCaritaFeliz() {
        int width = 100;
        int height = 100;
        BufferedImage imagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imagen.createGraphics();

        // Dibujar la cara
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(0, 0, width, height);

        // Dibujar los ojos
        g2d.setColor(Color.BLACK);
        g2d.fillOval(30, 30, 15, 15);
        g2d.fillOval(55, 30, 15, 15);

        // Dibujar la boca
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // Aumenta el grosor de la línea
        g2d.drawArc(30, 40, 40, 30, 0, -180); // Ajusta la forma de la boca

        // Dibujar el interior de la boca en negro
        g2d.setColor(Color.BLACK);
        g2d.fillArc(30, 40, 40, 35, 0, -180);

        // Dibujar los dientes
        g2d.setColor(Color.WHITE);
        g2d.fillRect(30, 55, 40, 4); // Diente Arriba
        g2d.fillRect(40, 70, 20, 4); // Diente central bajo

        // Dibujar las mejillas
        g2d.setColor(Color.PINK);
        g2d.fillOval(15, 45, 15, 10);
        g2d.fillOval(70, 45, 15, 10);

        g2d.dispose();

        return imagen;
    }

    // Función para crear una imagen de carita triste
    private static BufferedImage crearCaritaTriste() {
        BufferedImage imagen = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(0, 0, 100, 100);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(30, 30, 15, 15);
        g2d.fillOval(55, 30, 15, 15);
        g2d.drawArc(30, 45, 40, 30, 0, 180);
        g2d.setColor(Color.BLACK); // Color de las cejas
        int yCejas = 25; // Posición en Y de las cejas
        g2d.drawLine(25, yCejas, 40, yCejas - 5); // Ceja izquierda
        g2d.drawLine(60, yCejas - 5, 75, yCejas); // Ceja derecha
        g2d.dispose();
        return imagen;
    }

    // Función para crear una imagen de carita Sopresa
    private static BufferedImage crearCaritaSorpresa() {
        BufferedImage imagen = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(0, 0, 100, 100);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(30, 30, 15, 15);
        g2d.fillOval(55, 30, 15, 15);
        g2d.setColor(Color.BLACK); // Color Boca
        g2d.fillRoundRect(20, 50, 60, 30, 50, 20);
        g2d.setColor(Color.RED); // Color de la lengua
        g2d.fillRoundRect(35, 70, 30, 10, 20, 10); // Lengua
        g2d.dispose();
        return imagen;
    }

}