package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Intake {
    private DcMotorEx intake;
    private boolean isShooting = false;
    private Shooter shooter;
    private Index index;
    private boolean increaseRPM;
    private int currRPM;
    private ElapsedTime time = new ElapsedTime();
    public Intake(HardwareMap hardwareMap){
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        shooter = new Shooter(hardwareMap);
        index = new Index (hardwareMap);
    }
    public void update(){
        currRPM = shooter.getTicksPerSecShoot();
    }
    public void take(Gamepad gamepad){
        if(gamepad.right_trigger > 0.0001){
            intake.setPower(gamepad.right_trigger);
            index.feed();
            increaseRPM = false;
        }else if(gamepad.left_trigger > 0.2){
            intake.setPower(gamepad.left_trigger);
            shooter.liftBarrier();
            if(!increaseRPM){
                time.reset();
            }else{
                shooter.setTicksPerSecShoot(currRPM + (int) (time.milliseconds() / 10));
            }
            increaseRPM = true;
        }else{
            increaseRPM = false;
            intake.setPower(0);
            shooter.stopIndex();
            shooter.lowerBarrier();
        }
    }
    public void autoTake(){
        intake.setPower(1);
        index.feed();
    }
    public void autoSlowTake(){
        intake.setPower(0.6);
        index.slowFeed();
    }
    public void autoStop(){
        intake.setPower(0);
        shooter.stopIndex();
        shooter.lowerBarrier();
    }
    public void autoShoot(){
        intake.setPower(1);
        index.feed();
        shooter.liftBarrier();
    }
//    public void spit(Gamepad gamepad){
//        if(gamepad.left_bumper && !isShooting){
//            intake.setPower(-1);
//            isShooting = true;
//        }else if (gamepad.right_bumper && isShooting){
//            intake.setPower(-1);
//            isShooting = false;
//        }
//    }
}
