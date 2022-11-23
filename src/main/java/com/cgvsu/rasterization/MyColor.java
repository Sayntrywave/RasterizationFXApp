package com.cgvsu.rasterization;

public class MyColor {


    public static final MyColor RED = new MyColor(1,0,0);
    public static final MyColor GREEN = new MyColor(0,1,0);
    public static final MyColor BLUE = new MyColor(0,0,1);

    private final double R;
    private final double G;
    private final double B;

    public MyColor(double r, double g, double b) {
        this.R = r;
        this.G = g;
        this.B = b;
    }

    public double getRed() {
        return R;
    }

    public double getGreen() {
        return G;
    }

    public double getBlue() {
        return B;
    }

    @Override
    public String toString() {
        return "MyColor{" +
                "R=" + R +
                ", G=" + G +
                ", B=" + B +
                '}';
    }
}
