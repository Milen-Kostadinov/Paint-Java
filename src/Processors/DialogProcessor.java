package Processors;

import Model.RectangleShape;
import Model.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DialogProcessor {
    private Shape selection;
    private boolean isDragging;
    private Point lastPoint;
    public  DialogProcessor(){}
    private ArrayList<Shape> shapesList = new ArrayList<Shape>();
    public void AddRandomRect() {
        Random random = new Random();
        Point startPoint = new Point(random.nextInt(100, 400), random.nextInt(100, 400));
        shapesList.add(new RectangleShape(startPoint, 150, 300));
    }
    public void DrawShapes(Graphics graphics){
        for (Shape shape: shapesList) {
            shape.DrawSelf(graphics);
        }
    }
    public Shape Contains(Point point){
        for (int i = shapesList.size() - 1; i >= 0; i--) {
            if(shapesList.get(i).Contains(point)){
                return shapesList.get(i);
            }
        }
        return null;
    }
    public void Translate(Point point){
        selection.setLocation(new Point(getSelection().getLocation().x + point.x- lastPoint.x,
                getSelection().getLocation().y + point.y- lastPoint.y));
        lastPoint = point;
    }
    public void repaint(){
    }
    //region GetterSetter
    public Shape getSelection() {
        return selection;
    }
    public void setSelection(Shape selection) {
        this.selection = selection;
    }

    public boolean isDragging() {
        return isDragging;
    }

    public void setDragging(boolean dragging) {
        isDragging = dragging;
    }

    public void setLastPoint(Point lastPoint) {
        this.lastPoint = lastPoint;
    }
    //endregion
}
