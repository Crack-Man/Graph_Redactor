package GraphRedactor.Shape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

public abstract class MainShape implements Serializable {
    abstract public void draw(Graphics g);
    abstract public Color getColor();
    abstract public void setColor(Color color);
    abstract public Shape get();
    abstract public void addCoordinates(Point2D point);
    abstract public void addMotionCoordinates(Point2D point);
}
