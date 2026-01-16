package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private DcMotorEx leftShooter, rightShooter;
    private Hood hood;
    private Index index;
    private int ticksPerSecShoot = 0;
    public Shooter(HardwareMap hardwareMap) {
        hood = new Hood(hardwareMap);
        index = new Index(hardwareMap);

        leftShooter = hardwareMap.get(DcMotorEx.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotorEx.class, "rightShooter");

        rightShooter.setDirection(DcMotorEx.Direction.REVERSE);

        leftShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

    }
    public void setTicks(Gamepad gamepad){
        if(gamepad.dpad_left){
            hood.lower();
            ticksPerSecShoot = 1256;
        }
        if(gamepad.dpad_down){
            hood.lift();
            ticksPerSecShoot = 1478;
        }
        if(gamepad.dpad_right){
            hood.lift();
            ticksPerSecShoot = 1800;
        }
        if(gamepad.dpad_up){
            hood.lower();
            ticksPerSecShoot = 1067;
        }
    }
    public void manualSpin(Gamepad gamepad){
        if(gamepad.crossWasPressed()){
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
            index.feed();
        }else if (gamepad.triangleWasPressed()){
            leftShooter.setVelocity(0);
            rightShooter.setVelocity(0);
            index.stop();
        }
    }

}
