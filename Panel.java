package graphredactor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel implements MouseMotionListener, MouseListener {
    int x = 0;
    int y = 0;
    int width = 15;
    int height = 15;
    int mode = 0;

    // Маркер
    ArrayList<Integer> posX_m = new ArrayList<>();
    ArrayList<Integer> posY_m = new ArrayList<>();

    // Линия
    ArrayList<Integer> posX_l1 = new ArrayList<>();
    ArrayList<Integer> posY_l1 = new ArrayList<>();
    ArrayList<Integer> posX_l2 = new ArrayList<>();
    ArrayList<Integer> posY_l2 = new ArrayList<>();
    int posX_lD1 = 0;
    int posY_lD1 = 0;
    int posX_lD2 = 0;
    int posY_lD2 = 0;

    // Прямоугольник
    ArrayList<Integer> posX_r1 = new ArrayList<>();
    ArrayList<Integer> posY_r1 = new ArrayList<>();
    ArrayList<Integer> posX_r2 = new ArrayList<>();
    ArrayList<Integer> posY_r2 = new ArrayList<>();
    int posX_rD1 = 0;
    int posY_rD1 = 0;
    int posX_rD2 = 0;
    int posY_rD2 = 0;


    public Panel() {
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);

        // Маркер
        if (y > 40)
            g.fillOval(x, y, width, height);
        for (int i = 0; i < posX_m.size(); i++) {
            g.fillOval(posX_m.get(i), posY_m.get(i), width, height);
        }

        // Линия
        for (int i = 0; i < posY_l2.size(); i++) {
            g.drawLine(posX_l1.get(i), posY_l1.get(i), posX_l2.get(i), posY_l2.get(i));
        }
        g.drawLine(posX_lD1, posY_lD1, posX_lD2, posY_lD2);

        // Прямоугольник
        for (int i = 0; i < posY_r2.size(); i++) {
            if ((posX_r2.get(i) - posX_r1.get(i) < 0) && (posY_r2.get(i) - posY_r1.get(i) < 0)) {
                g.drawRect(posX_r2.get(i), posY_r2.get(i), (posX_r1.get(i) - posX_r2.get(i)), (posY_r1.get(i) - posY_r2.get(i)));
            } else if (posX_r2.get(i) - posX_r1.get(i) < 0) {
                g.drawRect(posX_r2.get(i), posY_r1.get(i), (posX_r1.get(i) - posX_r2.get(i)), (posY_r2.get(i) - posY_r1.get(i)));
            } else if (posY_r2.get(i) - posY_r1.get(i) < 0) {
                g.drawRect(posX_r1.get(i), posY_r2.get(i), (posX_r2.get(i) - posX_r1.get(i)), (posY_r1.get(i) - posY_r2.get(i)));
            } else {
                g.drawRect(posX_r1.get(i), posY_r1.get(i), (posX_r2.get(i) - posX_r1.get(i)), (posY_r2.get(i) - posY_r1.get(i)));
            }
        }
        if ((posX_rD2 - posX_rD1 < 0) && (posY_rD2 - posY_rD1 < 0)) {
            g.drawRect(posX_rD2, posY_rD2, (posX_rD1 - posX_rD2), (posY_rD1 - posY_rD2));
        } else if (posX_rD2 - posX_rD1 < 0) {
            g.drawRect(posX_rD2, posY_rD1, (posX_rD1 - posX_rD2), (posY_rD2 - posY_rD1));
        } else if (posY_rD2 - posY_rD1 < 0) {
            g.drawRect(posX_rD1, posY_rD2, (posX_rD2 - posX_rD1), (posY_rD1 - posY_rD2));
        } else {
            g.drawRect(posX_rD1, posY_rD1, (posX_rD2 - posX_rD1), (posY_rD2 - posY_rD1));
        }

        g.setColor(Color.GRAY);
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        g.fillRect(0,0, sSize.width,40);
    }


    public void mousePressed(MouseEvent e) {
        if (e.getY() > 40) {
            switch (mode) {
                case 1:
                    posX_m.add(e.getX() - 7);
                    posY_m.add(e.getY() - 7);
                    repaint();
                    break;
                case 2:
                    posX_l1.add(e.getX());
                    posY_l1.add(e.getY());
                    posX_lD1 = e.getX();
                    posY_lD1 = e.getY();
                    break;
                case 3:
                    posX_r1.add(e.getX());
                    posY_r1.add(e.getY());
                    posX_rD1 = e.getX();
                    posY_rD1 = e.getY();
                    break;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getY() > 40) {
            switch (mode) {
                case 2:
                    posX_l2.add(e.getX());
                    posY_l2.add(e.getY());
                    repaint();
                    break;
                case 3:
                    posX_r2.add(e.getX());
                    posY_r2.add(e.getY());
                    repaint();
                    break;
            }
        }
    }


    public void mouseDragged(MouseEvent e) {
        if (e.getY() > 40) {
            switch (mode) {
                case 1:
                    posX_m.add(e.getX() - 7);
                    posY_m.add(e.getY() - 7);
                    repaint();
                    break;
                case 2:
                    posX_lD2 = e.getX();
                    posY_lD2 = e.getY();
                    repaint();
                    break;
                case 3:
                    posX_rD2 = e.getX();
                    posY_rD2 = e.getY();
                    repaint();
                    break;
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (e.getY() > 40) {
            switch (mode) {
                case 1:
                    x = e.getX() - 7;
                    y = e.getY() - 7;
                    repaint();
                    break;
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getY() > 40) {
            switch (mode) {
                case 2:
                    posX_l1.add(e.getX());
                    posY_l1.add(e.getY());
                    posX_l2.add(e.getX());
                    posY_l2.add(e.getY());
                    posX_lD1 = e.getX();
                    posY_lD1 = e.getY();
                    posX_lD2 = e.getX();
                    posY_lD2 = e.getY();
                    repaint();
                    break;
                case 3:
                    posX_r1.add(e.getX());
                    posY_r1.add(e.getY());
                    posX_r2.add(e.getX());
                    posY_r2.add(e.getY());
                    posX_rD1 = e.getX();
                    posY_rD1 = e.getY();
                    posX_rD2 = e.getX();
                    posY_rD2 = e.getY();
                    posY_rD2 = e.getY();
                    repaint();
                    break;
            }
        }
    }

    public void mouseExited(MouseEvent e) {
    }
}

