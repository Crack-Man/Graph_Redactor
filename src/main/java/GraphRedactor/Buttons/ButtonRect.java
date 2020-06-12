package GraphRedactor.Buttons;

import GraphRedactor.Main.Shape;
import GraphRedactor.Shape.RectDraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRect extends MainButton {
    public ButtonRect(Shape sp) {
        super("Rectangle");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.add(new RectDraw());
            }
        });
    }
}
