package GraphRedactor.Shape;

import java.awt.*;
import java.awt.geom.Point2D;

public class RectDraw extends MainShape {
    private Color color;
    private Rect shape;

    public RectDraw() {
        this.shape = new Rect();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(shape.getX0(), shape.getY0(), shape.getX1() - shape.getX0(), shape.getY1() - shape.getY0());
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
