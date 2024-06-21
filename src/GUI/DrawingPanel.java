package GUI;

import Model.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private ArrayList<Shape> shapes = new ArrayList<>();
    static int index = 0;

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (shapes != null) {
            for (Shape shape : shapes) {
                shape.DrawSelf(g);
            }
        }
    }
    @Override
    public void repaint(){
        super.repaint();
    }
}
