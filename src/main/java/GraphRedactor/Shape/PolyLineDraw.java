package GraphRedactor.Shape;

import java.awt.*;
import java.awt.geom.Point2D;

public class PolyLineDraw extends MainShape{
    private Color color;
    private PolyLine shape;

    public PolyLineDraw() {
        this.shape = new PolyLine();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawPolyline(shape.getX(), shape.getY(), shape.size());
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Shape get() {
        return this.shape;
    }

    @Override
    public void addCoordinates(Point2D point) {
        this.shape.addCoordinate(point);
    }

    @Override
    public void addMotionCoordinates(Point2D point) {
        this.shape.addMotionCoordinates(point);
    }
}
