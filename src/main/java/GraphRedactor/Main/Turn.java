package GraphRedactor.Main;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import GraphRedactor.Shape.MainShape;

public class Turn implements Serializable {
    private List<MainShape> list;

    public Turn() {
        list = new ArrayList<MainShape>();
    }

    public void add(MainShape shape) {
        list.add(shape);
        this.getLast().setColor(Color.black);
    }

    public void printTo(Graphics buffer) {
        for (MainShape shape: list) {
            if(shape.get() != null) {
                shape.draw(buffer);
            }
        }
    }

    public MainShape getLast() {
        if(list.size() == 0) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
