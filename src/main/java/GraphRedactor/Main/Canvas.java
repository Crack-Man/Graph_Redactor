package GraphRedactor.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas extends JPanel {
    private Shape shape;
    private Parameters par;
    private Canvas me;

    public Canvas(Shape shape, Parameters par) {
        me = this;
        this.shape = shape;
        this.par = par;
        this.setBounds(0, 0, par.getWidth(), par.getHeight());
        this.addMouseListener(new MouseListener() {
                //MouseListener
                @Override
                public void mouseClicked(MouseEvent event) {}

                @Override
                public void mouseEntered(MouseEvent event) {}

                @Override
                public void mouseExited(MouseEvent event) {}

                @Override
                public void mousePressed(MouseEvent event) {
                    if(shape.getLast()!=null) {
                        shape.addCoordinates(event.getPoint());
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent event) {
                    if(shape.getLast() != null) {
                        shape.addMotionCoordinates(event.getPoint());
                        repaint();
                    }
                }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent event) {
                if(shape.getLast()!=null) {
                    shape.addMotionCoordinates(event.getPoint());
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent event) {
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(shape.getBuf(), 0, 0, me);
    }

}
