import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class CircleTrigGraph extends JPanel {

    private double theta; // ángulo en radianes

    public CircleTrigGraph(double degrees) {
        this.theta = Math.toRadians(degrees);
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Centro y radio
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 150;

        // Dibujar círculo unitario (escala)
        g2.setColor(Color.BLACK);
        g2.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Ejes X e Y
        g2.drawLine(centerX - radius - 20, centerY, centerX + radius + 20, centerY); // eje X
        g2.drawLine(centerX, centerY - radius - 20, centerX, centerY + radius + 20); // eje Y

        // Punto P en el círculo
        int px = centerX + (int) (radius * Math.cos(theta));
        int py = centerY - (int) (radius * Math.sin(theta));

        // Línea del radio
        g2.setColor(Color.BLUE);
        g2.drawLine(centerX, centerY, px, py);

        // Proyección cos(θ) en eje X (horizontal)
        g2.setColor(Color.RED);
        g2.drawLine(centerX, centerY, px, centerY);

        // Proyección sin(θ) en eje Y (vertical)
        g2.setColor(Color.GREEN);
        g2.drawLine(px, centerY, px, py);

        // Línea tangente (x=1 escala -> x = centerX + radius)
        // Intersección para tan(θ)
        double tanValue = Math.tan(theta);
        int tanY = centerY - (int) (radius * tanValue);
        g2.setColor(Color.ORANGE);
        g2.drawLine(centerX + radius, centerY, centerX + radius, tanY); // línea vertical
        g2.drawLine(centerX, centerY, centerX + radius, tanY); // línea tangente

        // Dibuja el punto P
        g2.setColor(Color.MAGENTA);
        g2.fillOval(px - 5, py - 5, 10, 10);

        // Etiquetas
        g2.setColor(Color.BLACK);
        g2.drawString("θ", centerX + 20, centerY - 10);
        g2.drawString("P (cosθ, sinθ)", px + 5, py - 5);
        g2.drawString("cosθ", (centerX + px) / 2, centerY + 15);
        g2.drawString("sinθ", px + 5, (centerY + py) / 2);
        g2.drawString("tanθ", centerX + radius + 5, (centerY + tanY) / 2);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Círculo unitario - sin, cos, tan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CircleTrigGraph(45)); // Ángulo 45 grados
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}