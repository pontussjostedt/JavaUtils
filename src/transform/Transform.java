package transform;

import java.awt.geom.AffineTransform;

public class Transform extends AffineTransform {

    public void setY(int y){
        translate(getX(), y);
    }

    public void setX(int x){
        translate(x, getY());
    }

    public double getX() {
        return getTranslateX();
    }
    public double getY(){
        return getTranslateY();
    }
}
