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
//        follower.setStartingPose(new Pose(119.000, 84.000, Math.toRadians(0)));     //RED CLOSE
//        follower.setStartingPose(new Pose(24.000, 84.000, Math.toRadians(180)));         //BLUE CLOSE
        follower.setStartingPose(new Pose(109.000, 22.650, Math.toRadians(0)));         //RED FAR
//        follower.setStartingPose(new Pose(35.000, 20.650, Math.toRadians(180)));         //BLUE FAR

        movement = new Movement(hardwareMap);
        shooter = new Shooter(hardwareMap);
        intake = new Intake(hardwareMap);
        turret = new Turret(hardwareMap);
    }
    public void loop() {
        follower.update();
        pose = follower.getPose();
        turret.setHeading(Math.toDegrees(pose.getHeading()));
        if(turret.getRed())
            turret.rotateRed(pose.getX(), pose.getY());
        else
            turret.rotateBlue(pose.getX(), pose.getY());      //TODO change for each alliance
        turret.toggle(gamepad2);
        movement.movementLoop(gamepad1);
        intake.update();
        intake.take(gamepad1);
        shooter.setTicks(gamepad1);
//        shooter.autoTicks(pose.getX(), pose.getY());
//        to Natie prin educatie
        shooter.park(gamepad1);//pls give me a spot to nationals
                //from bogdan
        if(gamepad2.leftBumperWasPressed()){
            turret.goMin();
        }else if(gamepad2.rightBumperWasPressed()){
            turret.goMax();
        }else if (gamepad2.crossWasPressed()){
            turret.goNeutral();
        }else if (gamepad2.triangleWasPressed()){
            turret.follow();
        }
        if (gamepad2.circleWasPressed()){
            follower.setPose(new Pose(13.000, 9.000, Math.toRadians(0)));
        }
        if (gamepad2.squareWasPressed()){
            follower.setPose(new Pose(131.000, 9.000, Math.toRadians(180)));
        }
        if(gamepad2.right_trigger > 0.0001){
            intake.autoTake();
        }
//        if (gamepad2.dpadRightWasPressed()){
//            turret.rotateRed();
//        }
        telemetry.addData("Heading", Math.toDegrees(pose.getHeading()));
        telemetry.addData("X", pose.getX());
        telemetry.addData("Y", pose.getY());
        telemetry.addData("Alpha", turret.alpha);
        telemetry.addData("Angle", 0.5 - 0.5 * turret.alpha / 102.8571428571429);
        telemetry.update();
    }
}
