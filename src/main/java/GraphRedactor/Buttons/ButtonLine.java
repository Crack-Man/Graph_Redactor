package GraphRedactor.Buttons;

import GraphRedactor.Main.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GraphRedactor.Shape.PolyLineDraw;

public class ButtonLine extends MainButton {
    public ButtonLine(Shape sp) {
        super("PolyLine");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.add(new PolyLineDraw());
            }
        });
    }
}
