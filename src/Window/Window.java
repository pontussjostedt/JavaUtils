package Window;

import java.awt.*;

public class Window {
    private int width;
    private int height;
    Display display;
    public Window(int width, int height, String name){
        display = new Display(width, height, name);
        this.width = width;
        this.height = height;

    }

    public void render(Callback<Graphics2D>... drawer){
        var bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            bs = display.getCanvas().getBufferStrategy();
        }
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        g2d.clearRect(0, 0, width, height);
        for(int i = 0; i < drawer.length; i++)
            drawer[i].call(g2d); //RITAR ALLT
        bs.show();
        g2d.dispose();
    }
}
