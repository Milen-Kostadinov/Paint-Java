package Model;

import java.awt.*;

public class RectangleShape extends Shape{
    public RectangleShape(Point startPoint, int width, int height) {
        this.location = startPoint;
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean Contains(Point point) {
        return (new Rectangle(location.x, location.y, width, height).contains(point));
    }
    @Override
    public void DrawSelf(Graphics graphics) {
        graphics.drawRect(location.x, location.y, width, height);
    }
}
