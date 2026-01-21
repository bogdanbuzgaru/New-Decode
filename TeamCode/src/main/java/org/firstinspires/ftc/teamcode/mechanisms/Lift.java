package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Lift {
    private Servo leftLift;     //TODO one of them needs reversing
    private Servo rightLift;
    public Lift(HardwareMap hardwareMap){
        leftLift = hardwareMap.get(Servo.class, "leftLift");
        rightLift = hardwareMap.get(Servo.class, "rightLift");
    }
    public void lift(){
        leftLift.setPosition(0.5);
        rightLift.setPosition(0.5);
    }
    public void lower(){
        leftLift.setPosition(0.0);
        rightLift.setPosition(0.0);
    }
}
