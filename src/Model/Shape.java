package Model;

import java.awt.*;

public abstract class Shape {

    protected int width;
    protected int height;
    protected Point location;
    protected Color color;

    public abstract boolean Contains(Point point);
    public abstract void DrawSelf(Graphics graphics);

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
