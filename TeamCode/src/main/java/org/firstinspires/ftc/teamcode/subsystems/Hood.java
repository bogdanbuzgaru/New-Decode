package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hood {
    private Servo hood;
    public Hood (HardwareMap hardwareMap){
        hood = hardwareMap.get(Servo.class, "hood");
        hood.setPosition(0);
    }
    public void lift(){
        hood.setPosition(0.15);
    }
    public void semiLift(){
        hood.setPosition(0.5);
    }
    public void lower(){
        hood.setPosition(1);
    }
}
