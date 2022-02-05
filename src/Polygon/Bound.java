package Polygon;

import java.awt.Graphics2D;
import java.awt.geom.*;

public class Bound implements  Drawable {
    private Point2D[] points;
    private Path2D.Double path;
    private AffineTransform transform;

    public Bound(AffineTransform transform, Point2D... points){
        this.points = points;
        this.transform = transform;
        initPath();
    }

    public void draw(Graphics2D g2d) {
        g2d.draw(path);
    }

    public void updateTransform(){
        path.transform(transform);
    }

    private void initPath() {
        path = new Path2D.Double();
        path.moveTo(points[0].getX(), points[0].getY());
        for(Point2D p : points)
            path.lineTo(p.getX(), p.getY());
        path.closePath();
    }

    public boolean contains(Point2D point){
        if(path.getBounds2D().contains(point))
            return path.contains(point);
        return false;
    }
}
