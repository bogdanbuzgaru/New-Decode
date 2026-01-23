package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Index {
    private DcMotorEx index;
    public Index(HardwareMap hardwareMap) {
        index = hardwareMap.get(DcMotorEx.class, "index");
    }
    public void slowFeed(){
        index.setPower(0.6);
    }
    public void feed(){
        index.setPower(1);
    }
    public void stop(){
        index.setPower(0);
    }
}
