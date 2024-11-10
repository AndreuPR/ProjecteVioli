/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violi.grafic;
import javax.swing.*;
import java.awt.*;

class MastilVioli extends JPanel {
    private boolean[][] notes; // Matriz para representar las notas por segmento y cuerda
    private int numCuerdas;    // Número de cuerdas
    private int numSegmentos;  // Número de segmentos
    private int baseLongitud;  // Longitud inicial de los segmentos

    public MastilVioli(int numCuerdas, int numSegmentos, int baseLongitud) {
        this.numCuerdas = numCuerdas;
        this.numSegmentos = numSegmentos;
        this.baseLongitud = baseLongitud;
        this.notes = new boolean[numSegmentos][numCuerdas]; // Inicializa todas las notas como inactivas
    }

    public void setNote(int segmento, int cuerda, boolean activa) {
        if (segmento >= 0 && segmento < numSegmentos && cuerda >= 0 && cuerda < numCuerdas) {
            notes[segmento][cuerda] = activa;
            repaint(); // Redibuja el mástil con las notas actualizadas
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Espacio horizontal entre cuerdas
        int espacioCuerdas = 40;//panelWidth / (numCuerdas + 1);
        int xOffset = espacioCuerdas;

        for (int cuerda = 0; cuerda < numCuerdas; cuerda++) {
            // Ajusta la distancia entre cordes amb el (-2)
            int xCuerda = xOffset + cuerda * espacioCuerdas;
            int yOffset = 0; // Posición inicial en Y

            for (int segmento = 0; segmento < numSegmentos; segmento++) {
                int longitudSegmento = baseLongitud - (segmento * 10); // Escalado vertical progresivo

                // Dibujar la cuerda (recta vertical)
                g2d.setColor(Color.BLACK);
                g2d.drawLine(xCuerda, yOffset, xCuerda, yOffset + longitudSegmento);

                // Dibujar la nota si está activa
                if (notes[segmento][cuerda]) {
                    g2d.setColor(Color.RED);
                    g2d.fillOval(xCuerda - 5, yOffset + longitudSegmento / 2 - 5, 10, 10); // Círculo
                }

                yOffset += longitudSegmento + 5; // Avanzar al siguiente segmento
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 600);
    }
}
