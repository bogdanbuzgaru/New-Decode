package org.firstinspires.ftc.teamcode.opmodes;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.mechanisms.Turret;
import org.firstinspires.ftc.teamcode.movement.Movement;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends OpMode{
    private Movement movement = null;
    private Shooter shooter = null;
    private Intake intake = null;
    private Follower follower;
    private Pose pose;
//    private Turret turret;
    private double heading;
    public void init(){
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(119.000, 84.000, Math.toRadians(0)));
        movement = new Movement(hardwareMap);
        shooter = new Shooter(hardwareMap);
        intake = new Intake(hardwareMap);
//        turret = new Turret(hardwareMap);
    }
    public void loop() {
//        pose = follower.getPose();
//        if(pose.getHeading() > 280){
//            heading = 360 - pose.getHeading();
//        } else{
//            heading = pose.getHeading();
//        }
//        turret.rotate(pose.getY()/ (pose.getX() - 5) - heading);
        movement.movementLoop(gamepad1);
        intake.take(gamepad1);
        shooter.setTicks(gamepad1);
        shooter.manualSpin(gamepad1);
        shooter.park(gamepad1);
    }
}
