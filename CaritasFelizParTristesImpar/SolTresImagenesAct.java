import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SolTresImagenesAct {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crearInterfazUsuario();
            }
        });
    }

    public static void crearInterfazUsuario() {
        JFrame marco = new JFrame("Interfaz de Usuario con Imágenes");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 400);
        marco.setLayout(new FlowLayout());

        JLabel etiqueta = new JLabel("Ingrese un número:");
        JTextField campoTexto = new JTextField(10);
        JButton boton = new JButton("Mostrar Imagen");
        JPanel panelImagen = new JPanel();

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText();
                try {
                    double numero = Double.parseDouble(texto);
                    BufferedImage imagen;

                    if (numero % 1 == 0) {
                        // Es un número entero (par o impar)
                        if (numero % 2 == 0) {
                            // Proporciona la ruta completa a la imagen "cara_feliz.png"
                            imagen = cargarImagen(
                                    "C:\\Users\\OPTIPLEX\\Pictures\\CaritasFelizParTristesImpar\\caritaFeliz.png");
                        } else {
                            // Proporciona la ruta completa a la imagen "cara_triste.png"
                            imagen = cargarImagen(
                                    "C:\\Users\\OPTIPLEX\\Pictures\\CaritasFelizParTristesImpar\\caritaTriste.jpeg");
                        }
                    } else {
                        // Es un número decimal, muestra la cara sorprendida
                        imagen = cargarImagen(
                                "C:\\Users\\OPTIPLEX\\Pictures\\CaritasFelizParTristesImpar\\caritaSorprendida.png");
                    }

                    ImageIcon icono = new ImageIcon(imagen);
                    JLabel labelImagen = new JLabel(icono);
                    panelImagen.removeAll();
                    panelImagen.add(labelImagen);
                    marco.revalidate();
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        marco.add(etiqueta);
        marco.add(campoTexto);
        marco.add(boton);
        marco.add(panelImagen);

        marco.setVisible(true);
    }


    /* "SolTresImagenesAct.java JFrame, Clase ImageIO" */
    public static BufferedImage cargarImagen(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        return ImageIO.read(archivo);
    }
}
