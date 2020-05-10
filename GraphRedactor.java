package graphredactor;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraphRedactor extends JFrame
{
    public GraphRedactor()
    {}

    public static void main(String[] args)
    {
        Panel p = new Panel();
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Маркер
        JButton marker = new JButton("Маркер");
        marker.setBounds(0,0,80,30);
        marker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mode = 1;
            }
        });

        //Линия
        JButton line = new JButton("Линия");
        line.setBounds(0,0,80,30);
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mode = 2;
            }
        });


        //Прямоугольник
        JButton rectangle = new JButton("Прямоугольник");
        rectangle.setBounds(0,0,80,30);
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.mode = 3;
            }
        });


        p.add(marker);
        p.add(line);
        p.add(rectangle);
        p.setBackground(Color.white);
        f.add(p);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}