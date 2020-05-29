import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.awt.geom.*;

import javax.swing.*;

class ShapeTest {
public static void main(String args[]) {
EventQueue.invokeLater(new Runnable() {
public void run() {
JFrame frame = new ShapeTestFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
});
}
}

class ShapeTestFrame extends JFrame {
public ShapeTestFrame() {
setTitle("Shape Test");

Container contentPane = getContentPane();

final ShapePanel panel = new ShapePanel();
contentPane.add(panel, BorderLayout.CENTER);
final JComboBox comboBox = new JComboBox();
comboBox.addItem(new LineMaker());
comboBox.addItem(new RectangleMaker());
comboBox.addItem(new RoundRectangleMaker());
comboBox.addItem(new EllipseMaker());
comboBox.addItem(new PolygonMaker());
comboBox.addItem(new QuadCurveMaker());
comboBox.addItem(new CubicCurveMaker());

comboBox.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent event) {
ShapeMaker shapeMaker = (ShapeMaker) comboBox.getSelectedItem();
panel.setShapeMaker(shapeMaker);
}
});

contentPane.add(comboBox, BorderLayout.NORTH);
pack();
}

}

class ShapePanel extends JPanel {

private static final int WD = 600;
private static final int HT = WD;
private static final Color SHAPES_COLOR = Color.RED;
private static final Color SHAPE_COLOR = Color.black;
private List<Shape> shapes = new ArrayList<>();
private Point2D[] points;
private static Random generator = new Random();
private static int SIZE = 10;
private int current;
private ShapeMaker shapeMaker;
private Shape shape;

public ShapePanel() {

addMouseListener(new MouseAdapter() {
public void mousePressed(MouseEvent event) {
Point p = event.getPoint();
for (int i = 0; i < points.length; i++) {
// System.out.println("points = "+points);
double x = points[i].getX() - SIZE / 2;
double y = points[i].getY() - SIZE / 2;
Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
if (r.contains(p)) {
current = i;
return;
}
}
}

public void mouseReleased(MouseEvent event) {
current = -1;
}
});

addMouseMotionListener(new MouseMotionAdapter() {
public void mouseDragged(MouseEvent event) {
if (current == -1)
return;
points[current] = event.getPoint();
shape = shapeMaker.makeShape(points);
repaint();
}
});
current = -1;

JPanel bottomPanel = new JPanel();
bottomPanel.add(new JButton(new SaveShapeAction("Save Shape")));
setLayout(new BorderLayout());
add(bottomPanel, BorderLayout.PAGE_END);
}

public void setShapeMaker(ShapeMaker aShapeMaker) {
shapeMaker = aShapeMaker;
int n = shapeMaker.getPointCount();
points = new Point2D[n];
for (int i = 0; i < n; i++) {
double x = generator.nextDouble() * getWidth();
double y = generator.nextDouble() * getHeight();
points[i] = new Point2D.Double(x, y);
}
shape = shapeMaker.makeShape(points);
repaint();
}

public Dimension getPreferredSize() {
return new Dimension(WD, HT);
}

public void paintComponent(Graphics g) {
super.paintComponent(g);
if (points == null)
return;
Graphics2D g2 = (Graphics2D) g;
g2.setColor(SHAPES_COLOR);
for (Shape shape : shapes) {
g2.draw(shape);
}
g2.setColor(SHAPE_COLOR);
for (int i = 0; i < points.length; i++) {
double x = points[i].getX() - SIZE / 2;
double y = points[i].getY() - SIZE / 2;
g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
}

if (shape != null) {
g2.draw(shape);
}
}

private class SaveShapeAction extends AbstractAction {
public SaveShapeAction(String name) {
super(name);
int mnemonic = (int) name.charAt(0);
}

@Override
public void actionPerformed(ActionEvent e) {
shapes.add(shape);
repaint();
}
}

}

abstract class ShapeMaker {
private int pointCount;

public ShapeMaker(int aPointCount) {
pointCount = aPointCount;
}

public int getPointCount() {
return pointCount;
}

public abstract
Shape makeShape(Point2D[] p);

public String toString() {
return getClass().getName();
}

}

class LineMaker extends ShapeMaker {
public LineMaker() {
super(2);
}

public Shape makeShape(Point2D[] p) {
return new Line2D.Double(p[0], p[1]);
}
}

class RectangleMaker extends ShapeMaker {
public RectangleMaker() {
super(2);
}

public Shape makeShape(Point2D[] p) {
Rectangle2D s = new Rectangle2D.Double();
s.setFrameFromDiagonal(p[0], p[1]);
return s;
}
}

class RoundRectangleMaker extends ShapeMaker {
public RoundRectangleMaker() {
super(2);
}

public Shape makeShape(Point2D[] p) {
RoundRectangle2D s = new RoundRectangle2D.Double(0, 0, 0, 0, 20, 20);
s.setFrameFromDiagonal(p[0], p[1]);
return s;
}
}

class EllipseMaker extends ShapeMaker {
public EllipseMaker() {
super(2);
}

public Shape makeShape(Point2D[] p) {
Ellipse2D s = new Ellipse2D.Double();
s.setFrameFromDiagonal(p[0], p[1]);
return s;
}
}

class PolygonMaker extends ShapeMaker {
public PolygonMaker() {
super(6);
}

public Shape makeShape(Point2D[] p) {
GeneralPath s = new GeneralPath();
s.moveTo((float) p[0].getX(), (float) p[0].getY());
for (int i = 1; i < p.length; i++)

s.lineTo((float) p[i].getX(), (float) p[i].getY());
s.closePath();
return s;
}
}

class QuadCurveMaker extends ShapeMaker {
public QuadCurveMaker() {
super(3);
}

public Shape makeShape(Point2D[] p) {
return new QuadCurve2D.Double(p[0].getX(), p[0].getY(), p[1].getX(),
p[1].getY(), p[2].getX(), p[2].getY());
}
}

class CubicCurveMaker extends ShapeMaker {
public CubicCurveMaker() {
super(4);
}

public Shape makeShape(Point2D[] p) {
return new CubicCurve2D.Double(p[0].getX(), p[0].getY(), p[1].getX(),
p[1].getY(), p[2].getX(), p[2].getY(), p[3].getX(), p[3].getY());
}
}