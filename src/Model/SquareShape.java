package Model;

import java.awt.*;

public class SquareShape extends Shape{

    public SquareShape(Point startPoint, int width) {
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
        grfx.fillRect(location.x, location.y, width, height);
        grfx.setColor(Color.BLACK);
        grfx.drawRect(location.x, location.y, width, height);
    }
}
