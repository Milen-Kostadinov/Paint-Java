package Model;

import java.awt.*;

public class CircleShape extends Shape{

    public CircleShape(Point startPoint, int width) {
        this.location = startPoint;
        this.width = width;
    }

    @Override
    public boolean Contains(Point point) {
        return (new Rectangle(location.x, location.y, width, height).contains(point));
    }

    @Override
    public void DrawSelf(Graphics grfx) {
        height = width;
        grfx.setColor(getColor());
        grfx.fillOval(location.x, location.y, width, height);
        grfx.setColor(Color.BLACK);
        grfx.drawOval(location.x, location.y, width, height);
    }
}
