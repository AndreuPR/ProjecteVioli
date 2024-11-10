package violi.grafic;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author andre
 */
public class PracticaVioli {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mástil de Violi");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            MastilVioli mastil = new MastilVioli(4, 24, 90); // 4 cuerdas, 24 segmentos, longitud base 30

            // Activar algunas notas
            mastil.setNote(2, 1, true); // Nota activa en segmento 2, cuerda 1
            //mastil.setNote(5, 2, true); // Nota activa en segmento 5, cuerda 2
            //mastil.setNote(10, 3, true); // Nota activa en segmento 10, cuerda 3
            //mastil.setNote(15, 1, true); // Nota activa en segmento 10, cuerda 3

            frame.add(mastil);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}