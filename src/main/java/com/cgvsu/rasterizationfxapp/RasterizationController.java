package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));
        GraphicsUtils graphicsUtils = new DrawUtilsJavaFX(canvas);
        Rasterization.fillTriangle(graphicsUtils,
                new Point2D(10,10), new Point2D(200,400), new Point2D(300,200),
                MyColor.RED, MyColor.GREEN,MyColor.BLUE);
        Rasterization.fillTriangle(graphicsUtils,
                new Point2D(400,500), new Point2D(600,300), new Point2D(500,500),
                MyColor.RED, MyColor.GREEN,MyColor.BLUE);
        Rasterization.fillTriangle(graphicsUtils,
                new Point2D(500,100), new Point2D(400,300), new Point2D(300,200),
                MyColor.RED, MyColor.GREEN,MyColor.BLUE);
        Rasterization.fillTriangle(graphicsUtils,
                new Point2D(200,100), new Point2D(500,100), new Point2D(300,200),
                MyColor.RED, MyColor.GREEN,MyColor.BLUE);
    }

}