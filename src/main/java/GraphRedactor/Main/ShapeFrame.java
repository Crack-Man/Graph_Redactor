package GraphRedactor.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ShapeFrame extends JFrame {
    public ShapeFrame(Shape sp, Parameters par) {
        setTitle("Graph Redactor");
        this.setSize(par.getWidth(), par.getHeight());
        setLocationByPlatform(true);
        this.add(new ButtonShapes(sp, par));
        this.add(new Canvas(sp, par));
    }
}