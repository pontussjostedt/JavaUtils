package SVGReader;

import Polygon.Drawable;

import java.awt.*;
import java.awt.geom.Path2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class SVGFile implements Drawable {
    int width = -1;
    int height = -1;
    Path2D path;

    public SVGFile(String stringPath) throws IOException {
        Path path = Paths.get(stringPath);
        String content = Files.readString(path);
        System.out.println(content);
        String[] words = content.split(" ");
        var out = Arrays.stream(words).filter((w1) -> w1.contains("=\"M")).toArray(String[]::new);
        var p = out[0].split("\"")[1];
        this.path = pathFromString("M64.942,147.289L285.076,62.705L382.672,178.736L382.672,319.709C294.93,399.795 209.611,420.094 130.548,286.092L64.942,147.289Z");
        for(String s: out){
            //System.out.println(s);
        }

    }

    public Path2D pathFromString(String s){
        Path2D path = new Path2D.Double();
        ArrayList<StringBuilder> ins = new ArrayList<StringBuilder>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            if(Character.isLetter(c))
                ins.add(new StringBuilder().append(c));
            else
                ins.get(ins.size() -1).append(c);
        }
        for(StringBuilder sb: ins) {
            switch(sb.charAt(0)) {
                case 'M' -> {
                    System.out.println(sb);
                    String[] coordinates = sb.deleteCharAt(0).toString().split(",");
                    Double x = Double.parseDouble(coordinates[0]);
                    Double y = Double.parseDouble(coordinates[1]);
                    path.moveTo(x, y);
                }
                case 'L' -> {
                    System.out.println(sb);
                    String[] coordinates = sb.deleteCharAt(0).toString().split(",");
                    Double x = Double.parseDouble(coordinates[0]);
                    Double y = Double.parseDouble(coordinates[1]);
                    path.lineTo(x, y);
                    path.moveTo(x, y);
                }
                case 'C' -> {
                    System.out.println(sb);
                    String[] co = sb.deleteCharAt(0).toString().split(" ");
                    String[] p1 = co[0].split(",");
                    String[] p2 = co[1].split(",");
                    String[] p3 = co[2].split(",");
                    double x1 = Double.parseDouble(p1[0]);
                    double y1 = Double.parseDouble(p1[1]);
                    double x2 = Double.parseDouble(p2[0]);
                    double y2 = Double.parseDouble(p2[1]);
                    double x3 = Double.parseDouble(p3[0]);
                    double y3 = Double.parseDouble(p3[1]);
                    path.curveTo(x1,y1, x2, y2, x3, y3);
                    path.moveTo(x3, y3);

                }

                case 'Z' -> {
                    path.closePath();
                }

                default -> System.out.println("you forgot something");
            }
        }
        return path;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.draw(path);
    }
}
