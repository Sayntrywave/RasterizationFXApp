package com.cgvsu.rasterization;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.*;

public class Rasterization {


    public static void fillTriangle(final GraphicsContext gr,
                                    Point2D p1, Point2D p2, Point2D p3,
                                    Color color1, Color color2, Color color3) {


        List<Point2D> points = new ArrayList<>(Arrays.asList(p1, p2, p3));

        Collections.sort(points, Comparator.comparingDouble(Point2D::getY));

        double x1 = points.get(0).getX();
        double x2 = points.get(1).getX();
        double x3 = points.get(2).getX();
        double y1 = points.get(0).getY();
        double y2 = points.get(1).getY();
        double y3 = points.get(2).getY();

        for (int y = (int) y1; y < y2; y++) {
            double startX = getX(y, x1, x2, y1, y2);
            double endX = getX(y, x1, x3, y1, y3);

            fillLine(gr,y, startX, endX, color1, color2, color3, x1, x2, x3, y1, y2, y3);
        }

        for (int y = (int) y2; y < y3; y++) {
            double startX = getX(y, x1, x3, y1, y3);
            double endX = getX(y, x2, x3, y2, y3);
            fillLine(gr, y, startX, endX, color1, color2, color3, x1, x2, x3, y1, y2, y3);
        }

    }

    static void fillTriangle(GraphicsContext gr,
                             double x1, double y1,
                             double x2, double y2,
                             double x3, double y3,
                             Color color1, Color color2, Color color3) {
        fillTriangle(gr,new Point2D(Math.round(x1),Math.round(y1)),new Point2D(Math.round(x2),Math.round(y2)),new Point2D(Math.round(x3),Math.round(y3)),color1,color2,color3);
    }

    private static double getX(double y, double x1, double x2, double y1, double y2) {
        return Math.round((x2 - x1) * (y - y1) / (y2 - y1)) + x1;
    }

    private static void fillLine( final GraphicsContext gr, int y, double startX, double endX,
                                  Color color1, Color color2, Color color3,
                                  double x1, double x2, double x3,
                                  double y1, double y2, double y3) {


        final PixelWriter pixelWriter = gr.getPixelWriter();
        if (Double.compare(startX,endX) > 0) {
            double temp = startX;
            startX = endX;
            endX = temp;
        }

        for (int x = (int) startX; x < endX; x++) {
            pixelWriter.setColor(x,y,
                    getColor(color1, color2, color3, x, y, x1, x2, x3, y1, y2, y3));
        }
    }


    private static Color getColor(Color color1, Color color2, Color color3,
                                  double x, double y,
                                  double x1, double x2, double x3,
                                  double y1, double y2, double y3) {

        double detT = (y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3);

        double alpha = ((y2 - y3) * (x - x3) + (x3 - x2) * (y - y3)) / detT;
        if (alpha < 0 || alpha > 1) {
            alpha = Math.round(alpha);
        }

        double betta = ((y3 - y1) * (x - x3) + (x1 - x3) * (y - y3)) / detT;
        if (betta < 0 || betta > 1) {
            betta = Math.round(betta);
        }

        double gamma = 1 - alpha - betta;
        double r = (alpha * color1.getRed() + betta * color2.getRed() + gamma * color3.getRed());
        double g = (alpha * color1.getGreen() + betta * color2.getGreen() + gamma * color3.getGreen());
        double b = (alpha * color1.getBlue() + betta * color2.getBlue() + gamma * color3.getBlue());
        return Color.color(r, g, b);
    }
}
