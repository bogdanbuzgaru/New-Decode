package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hood {
    private Servo hood;
    private double pos;
    private ElapsedTime time = new ElapsedTime();
    public Hood (HardwareMap hardwareMap){
        hood = hardwareMap.get(Servo.class, "hood");
        hood.setPosition(0);
    }
    public void lift(){
        hood.setPosition(0.15);
    }
    public void semiLift(){
        hood.setPosition(0.44);
    }
    public void lower(){
        hood.setPosition(0.71);
    }
    public void update(){
        pos = hood.getPosition();
    }
    public void blueLift(){
        hood.setPosition(0.49);
    }
    public void fullLow(){
        hood.setPosition(1);
    }
    public void lowerBit(){
        time.reset();
//        if(time.milliseconds() > 1050 && time.milliseconds() < 1450){
//            hood.setPosition(pos - 0.1);
//        }
    }
    public void goPos(){
        hood.setPosition(pos);
    }
    public double getPos() {
        return pos;
    }
}
