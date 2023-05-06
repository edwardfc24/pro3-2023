package tareas.Jesus_Supayave;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MandelbrotDos extends JFrame implements ActionListener {

    private JPanel ctrlPanel;
    private JPanel btnPanel;
    private int numIter = 50;
    private double zoom = 130;
    private double zoomIncrease = 100;
    private int colorIter = 20;
    private BufferedImage I;
    private double zx, zy, cx, cy, temp;
    private int xMove, yMove = 0;
    private JButton[] ctrlBtns = new JButton[9];
    private Color themeColor = new Color(150, 180, 200);



    public MandelbrotDos() {
        super("Mandelbrot Set");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        plotPoints();

        Container contentPane = getContentPane();

        contentPane.setLayout(null);


        ctrlPanel = new JPanel();
        ctrlPanel.setBounds(600, 0, 200, 600);
        ctrlPanel.setBackground(themeColor);
        ctrlPanel.setLayout(null);

        btnPanel = new JPanel();
        btnPanel.setBounds(0, 200, 200, 200);
        btnPanel.setLayout(new GridLayout(3, 3));
        btnPanel.setBackground(themeColor);

        ctrlBtns[1] = new JButton("up");
        ctrlBtns[7] = new JButton("down");
        ctrlBtns[3] = new JButton("left");
        ctrlBtns[5] = new JButton("right");
        ctrlBtns[2] = new JButton("+");
        ctrlBtns[0] = new JButton("-");
        ctrlBtns[8] = new JButton(">");
        ctrlBtns[6] = new JButton("<");
        ctrlBtns[4] = new JButton();

        contentPane.add(ctrlPanel);
        contentPane.add(new imgPanel());
        ctrlPanel.add(btnPanel);

        for (int x = 0; x < ctrlBtns.length; x++) {
            btnPanel.add(ctrlBtns[x]);
            ctrlBtns[x].addActionListener(this);
        }

        validate();

    }

    public class imgPanel extends JPanel {
        public imgPanel() {
            setBounds(0, 0, 600, 600);

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(I, 0, 0, this);
        }
    }

    public void plotPoints() {
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cx = (x - 320 + xMove) / zoom;
                cy = (y - 290 + yMove) / zoom;
                int iter = numIter;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    temp = zx * zx - zy * zy + cx;
                    zy = 2 * zx * zy + cy;
                    zx = temp;
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << colorIter));
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();

        switch (event) {
            case "up":
                yMove -= 100;
                break;
            case "down":
                yMove += 100;
                break;
            case "left":
                xMove -= 100;
                break;
            case "right":
                xMove += 100;
                break;
            case "+":
                zoom += zoomIncrease;
                zoomIncrease += 100;
                break;
            case "-":
                zoom -= zoomIncrease;
                zoomIncrease -= 100;
                break;
            case ">":
                colorIter++;
                break;
            case "<":
                colorIter--;
                break;
        }


        plotPoints();
        validate();
        repaint();
    }
}
