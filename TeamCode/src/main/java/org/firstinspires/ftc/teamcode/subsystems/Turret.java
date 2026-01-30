package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Turret {
    private Servo turretServo1, turretServo2;
    private boolean isNegative = false;
    private double heading;
    private double angle = 0;
    public double alpha = 0;
    private boolean follow;
    private boolean isUpper = false;
    private int lower = 5;
    public void setHeading(double heading) {
        this.heading = heading;
    }

    public Turret(HardwareMap hardwareMap){
        turretServo1 = hardwareMap.get(Servo.class, "turretServo1");
        turretServo2 = hardwareMap.get(Servo.class, "turretServo2");
        goNeutral();
    }
    private boolean isInRangeRed(){
        return heading <= 120 && heading >= - 30;
    }
    private boolean isInRangeBlue(){
        return heading >= 60 || heading <= -150;
    }
    public void rotateRed(double dx, double dy){
        angle = Math.toDegrees(Math.atan((137 - dy) / (144 - dx)));
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
    public void rotateBlue(double dx, double dy){
        angle = Math.toDegrees(Math.atan((137 - dy) / dx )) + 90;
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