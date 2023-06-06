package logic.gamestrucure.gameworldoption.collision;


import util.Constant;

import java.awt.*;
import java.util.ArrayList;

public class Rect extends Polygon{
    private int leftX, rightX, topY, bottomY;
    private int width, height;
    private Polygon polygon;
    private int unit;
    public Rect(int leftX, int rightX, int topY, int bottomY,int unit) {
        this.leftX = leftX;
        this.rightX = rightX;
        this.topY = topY;
        this.bottomY = bottomY;
        width = Math.abs(rightX - leftX);
        height = Math.abs(topY-bottomY);
    }

    public Rect(int leftX, int rightX, int topY, int bottomY) {
        this.leftX = leftX;
        this.rightX = rightX;
        this.topY = topY;
        this.bottomY = bottomY;
    }
    public Polygon getPolygon (){
        if (polygon == null) {
            int[] xPoints = {leftX,leftX,rightX,rightX};
            int[] yPoints = {topY,bottomY,topY,bottomY};
            polygon = new Polygon(xPoints,yPoints,4);
        }
        return polygon;
    }
    public void updatePosition(int leftX,int topY) {
        this.leftX = leftX;
        this.rightX = leftX+ Constant.BACKGROUND_TILE_SIZE;
        this.topY = topY;
        this.bottomY = topY+Constant.BACKGROUND_TILE_SIZE;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getRightX() {
        return rightX;
    }

    public int getTopY() {
        return topY;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
