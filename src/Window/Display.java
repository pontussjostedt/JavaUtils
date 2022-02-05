package Window;

import javax.swing.JFrame;
import java.awt.*;

public class Display extends JFrame{
    private Canvas canvas;

    public Display(int width, int height, String name){
        super(name);
        setSize(width, height);
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

}
