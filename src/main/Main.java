package main;
import SVGReader.SVGFile;
import Window.Window;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       System.out.println("-------------------------------- \n--------------------------------\n");
       var b = new SVGFile("svgTest3.svg");
       Window p = new Window(512, 512, "name");
       while(true)
        p.render((g2d) -> b.draw(g2d));
    }
}
