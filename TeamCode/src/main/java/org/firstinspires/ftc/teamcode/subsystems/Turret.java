package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Turret {
    private Servo turretServo1, turretServo2;
    private boolean isNegative = false;
    private double heading;
    private double angle = 0;
    public double alpha = 0;
    private boolean follow;
    private boolean red = false;
    private int lower = 5;
    private double redAuto = 52.8;
    private double blueAuto = 115.2;
    public void setHeading(double heading) {
        this.heading = heading;
    }

    public Turret(HardwareMap hardwareMap){
        turretServo1 = hardwareMap.get(Servo.class, "turretServo1");
        turretServo2 = hardwareMap.get(Servo.class, "turretServo2");
        goNeutral();
    }
    public boolean getRed(){
        return red;
    }
    private boolean isInRangeRed(){
        return heading <= 120 && heading >= - 30;
    }
    private boolean isInRangeBlue() {
        return heading >= 60 || heading <= -150;
    }
    public void toggle(Gamepad gamepad){
        if(gamepad.dpadRightWasPressed()){
            red = true;
        } else if (gamepad.dpadLeftWasPressed()) {
            red = false;
        }
    }
    public void rotateRed(double dx, double dy){
        angle = Math.toDegrees(Math.atan((149 - dy) / (144 - dx)));
        alpha = angle - heading;
        if(follow && isInRangeRed()) {
            if (alpha > 0) {
                turretServo1.setPosition(0.5 - 0.5 * alpha / 102.8571428571429);
                turretServo2.setPosition(0.5 - 0.5 * alpha / 102.8571428571429);
            } else if (alpha < 0) {
                turretServo1.setPosition(0.5 + 0.5 * Math.abs(alpha) / 102.8571428571429);
                turretServo2.setPosition(0.5 + 0.5 * Math.abs(alpha) / 102.8571428571429);
            }
        }
    }
    public void autoRed(){
        turretServo1.setPosition(0.5 - 0.5 * redAuto / 102.8571428571429);
        turretServo2.setPosition(0.5 - 0.5 * redAuto / 102.8571428571429);
    }
    public void autoBlue(){
        turretServo1.setPosition(0.5 + 0.5 * redAuto / 102.8571428571429);
        turretServo2.setPosition(0.5 + 0.5 * redAuto / 102.8571428571429);
    }
    public void rotateBlue(double dx, double dy){
        angle = Math.toDegrees(Math.atan((149 - dy) / dx )) + 90;
        alpha = angle - heading;
        if(follow && isInRangeBlue()) {
            if (alpha > 0) {
                turretServo1.setPosition(0.5 - 0.5 * alpha / 102.8571428571429);
                turretServo2.setPosition(0.5 - 0.5 * alpha / 102.8571428571429);
            } else if (alpha < 0) {
                turretServo1.setPosition(0.5 + 0.5 * Math.abs(alpha) / 102.8571428571429);
                turretServo2.setPosition(0.5 + 0.5 * Math.abs(alpha) / 102.8571428571429);
            }
        }
    }
    public void goMax(){
        turretServo1.setPosition(1);
        turretServo2.setPosition(1);
    }
    public void goMin(){
        turretServo1.setPosition(0);
        turretServo2.setPosition(0);
    }
    public void goNeutral(){
        follow = false;
        turretServo1.setPosition(0.5);
        turretServo2.setPosition(0.5);
    }
    public void follow(){
        follow = true;
    }
}