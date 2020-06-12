package GraphRedactor.Main;


import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String args[]) {
        int butHeight = 40;
        Parameters par = new Parameters(600, 600, butHeight);
        Shape sp = new Shape(par);
        EventQueue.invokeLater(() -> {
                JFrame frame = new ShapeFrame(sp, par);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
        });
    }
}