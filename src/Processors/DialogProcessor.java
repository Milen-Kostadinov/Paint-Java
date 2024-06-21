package Processors;

import Model.CircleShape;
import Model.RectangleShape;
import Model.Shape;
import Model.SquareShape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DialogProcessor {
    private Shape selection;
    private boolean isDragging;
    private Point lastPoint;
    public Color selectedColor;
    protected int selectedShape;
    public  DialogProcessor(){}
    private ArrayList<Shape> shapesList = new ArrayList<Shape>();

    public ArrayList<Shape> getShapesList() {
        return shapesList;
    }

    public void AddRectangle() {
        Random random = new Random();
        Point startPoint = new Point(random.nextInt
                (100, 400), random.nextInt(100, 400));
        RectangleShape rect = new RectangleShape(startPoint, 150, 300);
        rect.setColor(Color.WHITE);
        shapesList.add(rect);
    }

    public void AddSquare() {
        Random random = new Random();
        Point startPoint = new Point(random.nextInt
                (100, 400), random.nextInt(100, 400));
        SquareShape square = new SquareShape(startPoint, 150);
        square.setColor(Color.WHITE);
        shapesList.add(square);
    }

    public void AddCircle() {
        Random random = new Random();
        Point startPoint = new Point(random.nextInt
                (100, 400), random.nextInt(100, 400));
        CircleShape circle = new CircleShape(startPoint, 150);
        circle.setColor(Color.WHITE);
        shapesList.add(circle);
    }

    public void DrawShapes(Graphics graphics){
        for (Shape shape: shapesList) {
            shape.DrawSelf(graphics);
        }
    }
    public Shape Contains(Point point){
        for (int i = shapesList.size() - 1; i >= 0; i--) {
            if(shapesList.get(i).Contains(point)){
                if (selectedColor == null)
                    shapesList.get(i).setColor(Color.WHITE);
                else {
                    shapesList.get(i).setColor(selectedColor);
                }
                selectedShape = i;
                return shapesList.get(i);
            }
        }
        return null;
    }

    public Shape Remove(){
        for (int i = shapesList.size() - 1; i >= 0; i--) {
            if (selectedShape == 0){
                shapesList.remove(shapesList.size() - 1);
                return shapesList.get(i);
            }
            else if(i == selectedShape){
                shapesList.remove(i);
                selectedShape = 0;
                return shapesList.get(i);
            }
        }
        return null;
    }

    public void Translate(Point point){
        selection.setLocation(new Point
                (getSelection().getLocation().x + point.x- lastPoint.x,
                        getSelection().getLocation().y + point.y- lastPoint.y));
        lastPoint = point;
    }
    public void repaint(){
    }
    //region Getters and Setters
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
