import javax.swing.*;
import java.awt.*;
public class JFventana extends JPanel {
    private int[] array;

    public JFventana(int[] array) {
        this.array = array;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int alto = getHeight();
        int x = 20;
        int y = alto - 20;
        int max = getMaxValue(array);
        double escala = (double)(alto - 40) / max;
        g.setColor(Color.BLACK);
        for (int i = 0; i < array.length; i++) {
            g.drawRect(x, y - (int)(array[i] * escala), 20, (int)(array[i] * escala));
            g.drawString(Integer.toString(array[i]), x, y + 15);
            x += 30;
        }
    }

    private int getMaxValue(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
