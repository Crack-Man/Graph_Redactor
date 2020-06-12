package GraphRedactor.Shape;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rect implements Shape, Serializable {
    private int x0, y0, x1, y1;

    public Rect() {
    }

    public int getX0() {
        if(this.x0 - this.x1 < 0) {
            return this.x0;
        } else {
            return this.x1;
        }
    }

    public int getX1() {
        if(this.x0 - this.x1 >= 0) {
            return this.x0;
        } else {
            return this.x1;
        }
    }

    public int getY0() {
        if(this.y0 - this.y1 < 0) {
            return this.y0;
        } else {
            return this.y1;
        }
    }

    public int getY1() {
        if(this.y0 - this.y1 >= 0) {
            return this.y0;
        } else {
            return this.y1;
        }
    }

    public void addCoordinate(Point2D point) {
        this.x0 = (int) point.getX();
        this.y0 = (int) point.getY();
    }

    public void addMotionCoordinates(Point2D point) {
        this.x1 = (int) point.getX();
        this.y1 = (int) point.getY();
    }

    public int size() {
        return 0;
    }




    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}
