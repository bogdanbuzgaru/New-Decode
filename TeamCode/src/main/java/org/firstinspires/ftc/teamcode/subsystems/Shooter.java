package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.SimpleMotorFeedforward;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

public class Shooter {
    private DcMotorEx leftShooter, rightShooter;
    private Servo barrier;
    private Hood hood;
    private Index index;

    public void setTicksPerSecShoot(int ticksPerSecShoot) {
        this.ticksPerSecShoot = ticksPerSecShoot;
    }

    public int getTicksPerSecShoot() {
        return ticksPerSecShoot;
    }

    private int ticksPerSecShoot = 1130;
    private Lift lift;
    private double voltage;
    public static  double ks = 0.1, kv = 0.0003555641, ka = 0.01, kp = 0.015, velocity, nominalVoltage = 10.7;
    private boolean increase = false;
//    SimpleMotorFeedforward ff = new SimpleMotorFeedforward(ks, kv, ka);
    PIDController p = new PIDController(kp, 0, 0);
    public Shooter(HardwareMap hardwareMap) {
        hood = new Hood(hardwareMap);
        index = new Index(hardwareMap);
        lift = new Lift(hardwareMap);

        leftShooter = hardwareMap.get(DcMotorEx.class, "leftShooter");
        rightShooter = hardwareMap.get(DcMotorEx.class, "rightShooter");
        barrier = hardwareMap.get(Servo.class, "barrier");

        rightShooter.setDirection(DcMotorEx.Direction.REVERSE);
        barrier.setDirection(Servo.Direction.REVERSE);

        leftShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        voltage = hardwareMap.voltageSensor.iterator().next().getVoltage();
    }
    public void setTicks(Gamepad gamepad){
        if(gamepad.dpadLeftWasPressed()){
            hood.lower();
            ticksPerSecShoot = 1256;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if(gamepad.circleWasPressed()){
            hood.semiLift();
            ticksPerSecShoot = 1428;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if(gamepad.dpadRightWasPressed()){
            hood.lift();
            ticksPerSecShoot = 1800;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if(gamepad.crossWasPressed()){
            hood.fullLow();
            ticksPerSecShoot = 1130;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }
    }
    public void autoTicks(double dx, double dy){
        double distance = (144 - dx) * (144 - dx) + (144 - dy) * (144 - dy);
        if(distance > 13000){
            hood.lift();
            ticksPerSecShoot = 1800;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if(distance > 6000){
            hood.semiLift();
            ticksPerSecShoot = 1380;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if(distance > 4300){
            hood.lower();
            ticksPerSecShoot = 1256;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }else if(distance > 150){
            hood.lower();
            ticksPerSecShoot = 1150;
            leftShooter.setVelocity(ticksPerSecShoot);
            rightShooter.setVelocity(ticksPerSecShoot);
        }
    }
    public void park(Gamepad gamepad){
        if(gamepad.dpadUpWasPressed()){
            lift.lift();
        }else if(gamepad.dpadDownWasPressed()){
            lift.lower();
        }
    }
    public void spinHighRPM(){
        ticksPerSecShoot = 1760;
        hood.lift();
        leftShooter.setVelocity(ticksPerSecShoot);
        rightShooter.setVelocity(ticksPerSecShoot);
    }
    public void spinNormalRPM(){
        ticksPerSecShoot = 1530;
        hood.semiLift();
        leftShooter.setVelocity(ticksPerSecShoot);
        rightShooter.setVelocity(ticksPerSecShoot);
    }
    public void spinBlue(){
        ticksPerSecShoot = 1490;
        hood.blueLift();
        leftShooter.setVelocity(ticksPerSecShoot);
        rightShooter.setVelocity(ticksPerSecShoot);
    }
    public void spinLowRPM(){
        ticksPerSecShoot = 1176;
        hood.lower();
        leftShooter.setVelocity(ticksPerSecShoot);
        rightShooter.setVelocity(ticksPerSecShoot);
    }
    public void liftBarrier(){
        barrier.setPosition(0.6);
        index.feed();
    }
    public void lowerBarrier(){
        barrier.setPosition(1);
    }
    public void stopIndex(){
        index.stop();
    }

    public void update() {
        voltage = hardwareMap.voltageSensor.iterator().next().getVoltage();

        SimpleMotorFeedforward ff = new SimpleMotorFeedforward(ks, kv, ka);
        p.setPID(kp, 0, 0);

        velocity = leftShooter.getVelocity();

        double p_output = p.calculate(velocity, ticksPerSecShoot);
        double ff_output = ff.calculate(ticksPerSecShoot);
        leftShooter.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,new PIDFCoefficients(kp, 0, 0, ff_output));
        leftShooter.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,new PIDFCoefficients(kp, 0, 0, ff_output));
//        if(ticksPerSecShoot != 0){
//            rightShooter.setPower((p_output + ff_output) * (nominalVoltage / voltage));
//            leftShooter.setPower((p_output + ff_output) * (nominalVoltage / voltage));
//        }else {
//            rightShooter.setPower(0);
//            leftShooter.setPower(0);
//        }
    }
}
