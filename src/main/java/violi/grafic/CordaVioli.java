/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violi.grafic;

import javax.swing.*;
import java.awt.*;

class CordaVioli extends JPanel {
    private boolean[] notes; // Array para representar las notas
    private int length; // Longitud de la cuerda
    private int segments; // Número de segmentos

    public CordaVioli(int length, int segments) {
        this.length = length;
        this.segments = segments;
        this.notes = new boolean[segments];
    }

    public void setNotes(boolean[] notes) {
        this.notes = notes;
        repaint(); // Redibuja la cuerda con las nuevas notas
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int totalWidth = getWidth();
        int currentWidth = totalWidth; // Ancho dinámico inicial
        int segmentHeight = getHeight() / segments; // Altura de cada segmento

        for (int i = 0; i < segments; i++) {
            int y = i * segmentHeight;
            g2d.setColor(notes[i] ? Color.RED : Color.BLACK); // Nota (rojo) o vacío (negro)
            g2d.fillRect((totalWidth - currentWidth) / 2, y, currentWidth, segmentHeight - 2); // Dibujar segmento
            currentWidth *= 0.95; // Reducir proporcionalmente el ancho
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(length, 300);
    }
}