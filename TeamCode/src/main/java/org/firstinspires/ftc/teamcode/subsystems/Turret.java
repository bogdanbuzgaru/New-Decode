package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Turret {
    private Servo turretServo1, turretServo2;
    private boolean isNegative = false;
    private double heading;
    private double angle = 0;
    private double alpha = 0;
    private boolean follow;
    public void setHeading(double heading) {
        this.heading = heading;
    }

    public Turret(HardwareMap hardwareMap){
        turretServo1 = hardwareMap.get(Servo.class, "turretServo1");
        turretServo2 = hardwareMap.get(Servo.class, "turretServo2");
        goNeutral();
    }
    private boolean isInRangeRed(){
        return heading <= 90 && heading >=0;
    }
    private boolean isInRangeBlue(){
        return heading >= 90 && heading <= 180;
    }
    public void rotateRed(double dx, double dy){
        angle = Math.atan2(144 - dy, 144 - dx);
        alpha = angle - heading;
        if(follow) {
            if (isInRangeRed() && alpha > 0) {
                turretServo1.setPosition(0.5 - 0.5 * alpha / 90);
                turretServo2.setPosition(0.5 - 0.5 * alpha / 90);
            } else if (isInRangeRed() && alpha < 0) {
                turretServo1.setPosition(0.5 - 0.5 * alpha / 90);
                turretServo2.setPosition(0.5 - 0.5 * alpha / 90);
            } else {
                turretServo1.setPosition(0.5);
                turretServo2.setPosition(0.5);
            }
        }else{
            goNeutral();
        }
    }
    public void rotateBlue(double dx, double dy){
        angle = Math.atan2(144 - dy, dx);
        alpha = angle - heading;
        if(follow) {
            if (isInRangeRed() && alpha > 0) {
                turretServo1.setPosition(0.5 - 0.5 * alpha / 90);
                turretServo2.setPosition(0.5 - 0.5 * alpha / 90);
            } else if (isInRangeRed() && alpha < 0) {
                turretServo1.setPosition(0.5 - 0.5 * alpha / 90);
                turretServo2.setPosition(0.5 - 0.5 * alpha / 90);
            } else {
                turretServo1.setPosition(0.5);
                turretServo2.setPosition(0.5);
            }
        }else{
            goNeutral();
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