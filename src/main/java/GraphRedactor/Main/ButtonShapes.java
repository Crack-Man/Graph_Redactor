package GraphRedactor.Main;

import javax.swing.*;
import GraphRedactor.Buttons.*;

public class ButtonShapes extends JPanel {
    public ButtonShapes(Shape sp, Parameters par) {
        super();
        this.setBounds(0,0, par.getWidth(), par.getButHeight());
        this.add(new ButtonRect(sp));
        this.add(new ButtonLine(sp));
        this.add(new ButtonPolygon(sp));
    }
}
