package GraphRedactor.Buttons;

import GraphRedactor.Main.Shape;
import GraphRedactor.Shape.PolygonDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPolygon extends MainButton {
    public ButtonPolygon(Shape sp) {
        super("Polygon");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.add(new PolygonDraw());
            }
        });
    }
}
