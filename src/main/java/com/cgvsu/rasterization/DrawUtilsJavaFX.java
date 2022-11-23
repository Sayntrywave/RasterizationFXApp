package com.cgvsu.rasterization;


import javafx.scene.canvas.Canvas;

public class DrawUtilsJavaFX extends GraphicsUtils <Canvas>{
    public DrawUtilsJavaFX(Canvas graphics) {
        super(graphics);
    }

    @Override
    public void setPixel(int x, int y, MyColor myColor) {
        graphics.getGraphicsContext2D().getPixelWriter().setColor(x,y,toColor(myColor));
    }
    private javafx.scene.paint.Color toColor(MyColor myColor){
      //
        //  System.out.println(myColor.getRed() + myColor.getGreen() + myColor.getBlue());
        return javafx.scene.paint.Color.color(myColor.getRed(), myColor.getGreen(), myColor.getBlue());
    }
}
