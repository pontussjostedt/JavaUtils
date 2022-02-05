package main;
import Window.Window;
import Polygon.*;

import java.awt.geom.*;
import java.util.function.Function;
import java.util.function.*;
public class Main {

    public static void main(String[] args) {
        var a = new Window(500, 500, "ss");
        //var poly = new Polygon(new Point(25,25), new Point(25, 75), new Point(90, 90), new Point(75, 25));
        var transform = new AffineTransform();
        transform.rotate(Math.toRadians(45));
        var bound = new Bound(transform,new Point2D.Double(25, 25), new Point2D.Double(25, 75), new Point2D.Double(90, 90), new Point2D.Double(75, 25));
        var fps = 0;

        var t0 = System.currentTimeMillis();
        var angle = 0D;
        while(true) {
            transform.rotate(angle);
            bound.updateTransform();
            angle += 0.0001;
            fps ++;
            a.render((g2d) -> {
                bound.draw(g2d);
            });
            System.out.println(bound.contains(new Point2D.Double(50, 50)));
            if(System.currentTimeMillis() - t0 > 1000){
                System.out.println("fps = " + fps);
                fps = 0;
                t0 = System.currentTimeMillis();
            }
        }
    }
}
