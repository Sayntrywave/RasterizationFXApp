package com.cgvsu.rasterization;

import java.awt.*;

public class DrawUtilsSwing extends GraphicsUtils<Graphics> {


    public DrawUtilsSwing(Graphics graphics) {
        super(graphics);
    }

    @Override
    public void setPixel(int x, int y, MyColor myColor) {
        graphics.setColor(toColor(myColor));
        graphics.drawLine(x,y,x,y);
    }

    private java.awt.Color toColor(MyColor myColor){
        java.awt.Color color1 = new java.awt.Color((int) (255* myColor.getRed()),(int)(255* myColor.getGreen()),(int)(255* myColor.getBlue()));
        return color1;
    }



}
//public class Rasterization {
//
//    public static void drawRectangle(
//            final GraphicsContext graphicsContext,
//            final int x, final int y,
//            final int width, final int height,
//            final javafx.scene.paint.MyColor color)
//    {
//        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
//
//        for (int row = y; row < y + height; ++row)
//            for (int col = x; col < x + width; ++col)
//                pixelWriter.setColor(col, row, color);
//    }
//
//    public static void fillTriangle(final GraphicsContext gr,
//                                    Point2D p1, Point2D p2, Point2D p3,
//                                    javafx.scene.paint.MyColor color1, javafx.scene.paint.MyColor color2, javafx.scene.paint.MyColor color3) {
//
//
//        List<Point2D> points = new ArrayList<>(Arrays.asList(p1, p2, p3));
//
//        Collections.sort(points, Comparator.comparingDouble(Point2D::getY));
//
//        double x1 = points.get(0).getX();
//        double x2 = points.get(1).getX();
//        double x3 = points.get(2).getX();
//        double y1 = points.get(0).getY();
//        double y2 = points.get(1).getY();
//        double y3 = points.get(2).getY();
//
//        for (int y = (int) y1; y < y2; y++) {
//            double startX = getX(y, x1, x2, y1, y2);
//            double endX = getX(y, x1, x3, y1, y3);
//
//            fillLine(gr,y, startX, endX, color1, color2, color3, x1, x2, x3, y1, y2, y3);
//        }
//
//        for (int y = (int) y2; y < y3; y++) {
//            double startX = getX(y, x1, x3, y1, y3);
//            double endX = getX(y, x2, x3, y2, y3);
//            fillLine(gr, y, startX, endX, color1, color2, color3, x1, x2, x3, y1, y2, y3);
//        }
//
//    }
//
//    private static double getX(double y, double x1, double x2, double y1, double y2) {
//        return Math.round((x2 - x1) * (y - y1) / (y2 - y1)) + x1;
//    }
//
//    private static void fillLine(final GraphicsContext gr, int y, double startX, double endX,
//                                 javafx.scene.paint.MyColor color1, javafx.scene.paint.MyColor color2, javafx.scene.paint.MyColor color3,
//                                 double x1, double x2, double x3,
//                                 double y1, double y2, double y3) {
//        final PixelWriter pixelWriter = gr.getPixelWriter();
//        if (Double.compare(startX,endX) > 0) {
//            double temp = startX;
//            startX = endX;
//            endX = temp;
//        }
//
//        for (int x = (int) startX; x < endX; x++) {
//            pixelWriter.setColor(x,y,
//                    getColor(color1, color2, color3, x, y, x1, x2, x3, y1, y2, y3));
//        }
//    }
//
//
//    private static javafx.scene.paint.MyColor getColor(javafx.scene.paint.MyColor color1, javafx.scene.paint.MyColor color2, javafx.scene.paint.MyColor color3,
//                                                     double x, double y,
//                                                     double x1, double x2, double x3,
//                                                     double y1, double y2, double y3) {
//
//        double detT = (y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3);
//
//        double alpha = ((y2 - y3) * (x - x3) + (x3 - x2) * (y - y3)) / detT;
//        if (alpha < 0 || alpha > 1) {
//            alpha = Math.round(alpha);
//        }
//
//        double betta = ((y3 - y1) * (x - x3) + (x1 - x3) * (y - y3)) / detT;
//        if (betta < 0 || betta > 1) {
//            betta = Math.round(betta);
//        }
//
//        double gamma = 1 - alpha - betta;
//        int r = (int) (alpha * color1.getRed() + betta * color2.getRed() + gamma * color3.getRed());
//        int g = (int) (alpha * color1.getGreen() + betta * color2.getGreen() + gamma * color3.getGreen());
//        int b = (int) (alpha * color1.getBlue() + betta * color2.getBlue() + gamma * color3.getBlue());
//        return javafx.scene.paint.MyColor.rgb(r, g, b);
//    }
//}