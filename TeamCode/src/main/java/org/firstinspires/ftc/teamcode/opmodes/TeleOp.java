package org.firstinspires.ftc.teamcode.opmodes;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.limelight.Limelight;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.movement.Movement;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Turret;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends OpMode{
    private Movement movement = null;
    private Shooter shooter = null;
    private Intake intake = null;
    private Follower follower;
    private Pose pose;
    private Turret turret;
    private double heading;
    public void init(){
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(119.000, 84.000, Math.toRadians(0)));     //RED CLOSE
//        follower.setStartingPose(new Pose(24.000, 84.000, Math.toRadians(0)));         //BLUE CLOSE
//        follower.setStartingPose(new Pose(109.000, 22.650, Math.toRadians(0)));         //RED FAR
//        follower.setStartingPose(new Pose(35.000, 20.650, Math.toRadians(0)));         //BLUE FAR

        movement = new Movement(hardwareMap);
        shooter = new Shooter(hardwareMap);
        intake = new Intake(hardwareMap);
        turret = new Turret(hardwareMap);
    }
    public void loop() {
        pose = follower.getPose();
        if(pose.getHeading() > 180){
            heading = pose.getHeading() - 360;
        } else{
            heading = pose.getHeading();
        }
        turret.rotate(Math.atan2(pose.getY(), (pose.getX() - 5)) - heading);
        movement.movementLoop(gamepad1);
        intake.update();
        intake.take(gamepad1);
        shooter.setTicks(gamepad1);
//        to Natie prin educatie
        shooter.park(gamepad1);//pls give me a spot to nationals
                //from bogdan

    }
}
