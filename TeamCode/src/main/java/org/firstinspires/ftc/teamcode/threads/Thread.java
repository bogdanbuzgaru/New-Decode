package org.firstinspires.ftc.teamcode.threads;

public class Thread extends java.lang.Thread {
    private double xPosition, yPosition;
    private double angle;

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getAngle(){
        return angle;
    }
    public double getY(){
        return yPosition;
    }
    public double getX(){
        return xPosition;
    }
}
