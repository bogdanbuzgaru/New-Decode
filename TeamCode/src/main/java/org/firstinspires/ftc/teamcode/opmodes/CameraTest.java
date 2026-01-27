package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.limelight.Limelight;

@TeleOp
public class CameraTest extends OpMode {
    Limelight3A limelight;
    Limelight something;
    String name;
    public void init (){
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
        limelight.pipelineSwitch(0);
        something = new Limelight();
    }
    public void loop (){
        if(something.isDetecting()){
            name = "YES";
        }else{
            name = "NO";
        }
        telemetry.addData("Is detecting artifacts: ", name);
    }
}
