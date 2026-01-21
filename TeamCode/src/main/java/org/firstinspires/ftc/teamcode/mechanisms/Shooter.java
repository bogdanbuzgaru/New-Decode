package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.statemachine.StateMachine;

public class Shooter {
    private DcMotorEx leftShooter, rightShooter;
    private Servo barrier;
    private Hood hood;
    private Index index;
    private int ticksPerSecShoot = 0;
    private Lift lift;
    public enum State {
        TAKING,
        SHOOTING
    }
    private StateMachine<State> fsm = new StateMachine<>(State.TAKING);
    public Shooter(HardwareMap hardwareMap) {
        hood = new Hood(hardwareMap);
        index = new Index(hardwareMap);
        lift = new Lift(hardwareMap);

        leftShooter = hardwareMap.get(DcMotorEx.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotorEx.class, "rightShooter");
        barrier = hardwareMap.get(Servo.class, "barrier");

        rightShooter.setDirection(DcMotorEx.Direction.REVERSE);

        leftShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

    }
    public void setTicks(Gamepad gamepad){
        if(gamepad.dpadLeftWasPressed()){
            hood.lower();
            ticksPerSecShoot = 1256;
        }else if(gamepad.circleWasPressed()){
            hood.lift();
            ticksPerSecShoot = 1478;
        }else if(gamepad.dpadRightWasPressed()){
            hood.lift();
            ticksPerSecShoot = 1800;
        }else if(gamepad.crossWasPressed()){
            hood.lower();
            ticksPerSecShoot = 1067;
        }
    }
    public void park(Gamepad gamepad){
        if(gamepad.dpadUpWasPressed()){
            lift.lift();
        }else if(gamepad.dpadDownWasPressed()){
            lift.lower();
        }
    }
    public void manualSpin(Gamepad gamepad){
        if(gamepad.leftBumperWasPressed()){
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if (gamepad.rightBumperWasPressed()){
            leftShooter.setVelocity(0);
            rightShooter.setVelocity(0);
            index.stop();
        }
    }
}
