package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Turret {
    private Servo turretServo1, turretServo2;
    private boolean isNegative = false;
    public Turret(HardwareMap hardwareMap){
        turretServo1 = hardwareMap.get(Servo.class, "turretServo1");
        turretServo2 = hardwareMap.get(Servo.class, "turretServo2");
    }
    public void rotate(double angle){
        if(angle < 0){
            isNegative = true;
        }else{
            isNegative = false;
        }
        if(!isNegative && Math.abs(angle) < 90){
            turretServo1.setPosition(0.5 * angle / 90);
            turretServo2.setPosition(0.5 * angle / 90);
        }else if (isNegative && Math.abs(angle) < 90){
            turretServo1.setPosition(0.5 * angle / 90 + 0.5);
            turretServo2.setPosition(0.5 * angle / 90 + 0.5);
        }else{
            turretServo1.setPosition(0.5);
            turretServo2.setPosition(0.5);
        }
    }
}