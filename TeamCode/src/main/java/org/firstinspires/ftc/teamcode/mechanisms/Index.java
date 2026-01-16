package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Index {
    private DcMotorEx index;
    public Index(HardwareMap hardwareMap) {
        index = hardwareMap.get(DcMotorEx.class, "index");
    }
    public void feed(){
        index.setPower(0.8);
    }
    public void stop(){
        index.setPower(0);
    }
}
