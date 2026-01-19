package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.statemachine.StateMachine;

public class Shooter {
    private DcMotorEx leftShooter, rightShooter;
    private Hood hood;
    private Index index;
    private int ticksPerSecShoot = 0;
    public enum State {
        TAKE,
        SPIN,
        SHOOT
    }
    private StateMachine<State> fsm = new StateMachine<>(State.TAKE);
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
        if(gamepad.dpadLeftWasPressed()){
            hood.lower();
            ticksPerSecShoot = 1256;
        }else if(gamepad.dpadDownWasPressed()){
            hood.lift();
            ticksPerSecShoot = 1478;
        }else if(gamepad.dpadRightWasPressed()){
            hood.lift();
            ticksPerSecShoot = 1800;
        }else if(gamepad.dpadUpWasPressed()){
            hood.lower();
            ticksPerSecShoot = 1067;
        }
    }
    public void manualSpin(Gamepad gamepad){
        if(gamepad.crossWasPressed()){
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if (gamepad.triangleWasPressed()){
            leftShooter.setVelocity(0);
            rightShooter.setVelocity(0);
            index.stop();
        }else if (gamepad.squareWasPressed()){
            index.feed();
        }
    }
    public void shoot(){
        fsm.onStateEnter(State.TAKE, () -> {

        });
    }
}
