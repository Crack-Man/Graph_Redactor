package GraphRedactor.Main;


import GraphRedactor.Shape.MainShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Shape {
    private int width, height;
    private BufferedImage buf = null;
    private Graphics buffer = null;
    private Turn turn;
    private Parameters par;

    public Shape(Parameters par) {
        this.par = par;
        turn = new Turn();
        this.width = par.getWidth();
        this.height = par.getHeight();
        buf = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
        buffer = buf.getGraphics();
        buffer.setColor(Color.white);
        buffer.fillRect(0, 0, this.width, this.height);
    }

    public MainShape getLast() {
        return turn.getLast();
    }

    public void add(MainShape shape) {
        turn.add(shape);
    }

    public void addCoordinates(Point2D point) {
        turn.getLast().addCoordinates(point);
    }

    public void addMotionCoordinates(Point2D point) {
        turn.getLast().addMotionCoordinates(point);
    }

    public BufferedImage getBuf() {
        buffer.setColor(Color.white);
        buffer.fillRect(0, 0, par.getWidth(), par.getHeight());
        turn.printTo(buffer);
        return buf;
    }
}
