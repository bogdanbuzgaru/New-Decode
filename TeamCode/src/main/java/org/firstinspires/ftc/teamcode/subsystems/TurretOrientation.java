//package org.firstinspires.ftc.teamcode.subsystems;
//
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.geometry.Pose;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
//
//public class TurretOrientation {
//    //    blue basket coordonates
////
////          10.752
////          139.584
////
////    red basket coordonates
////
////          133.248
////          139.584
//    private Pose initialPosition = new Pose(110.000,10.000,Math.toRadians(0));
//    private Follower follower;
//    private Turret turret;
//    private final double ticksPerRev = 8192.0; //for one biig wheel rotation
//    private final double fullRotation = 360; //a full circle angle
//    private boolean isTracking = false;
//    private boolean blue = false;
//    public TurretOrientation(HardwareMap hardwareMap){
//        turret = new Turret(hardwareMap);
//
//        follower = Constants.createFollower(hardwareMap);
//        follower.setStartingPose(new Pose(initialPosition.getX(), initialPosition.getY(), initialPosition.getHeading()));
//
//    }
//    public void update(){
//        follower.update();
////        if(limelight.getFiducialId() == 24){        //TODO change to 20 if blue ALLIANCE
////            trackTarget();
////        }
//        if(isTracking){
//            trackTarget();
//        }
//        turret.update();
//    }
//    public void setAngle(Gamepad gamepad){
////        limelight.setBlueAllianceId();
////        limelight.setRedAllianceId();
//        if(gamepad.triangleWasPressed()){
//            isTracking = !isTracking;
//            if (!isTracking) {
//                goNeutral();
//            }
//        }else if (gamepad.rightBumperWasPressed()){
//            isTracking = false;
//            goNeutral();
//        }
//    }
//
//    private void trackTarget(){
//        double offsetAngle = 2;
//        offsetAngle = Math.abs(offsetAngle) > 0.5 ? offsetAngle : 0;
//
//        int offsetTicks = angleToTicks(offsetAngle);
//        int currentTicks = turret.getCurrentPosition();
//        if(currentTicks + offsetTicks > 8192/4){
//            turret.setTargetPosition(8192/4 - 200);
//            return;
//        }
//        turret.setTargetPosition(currentTicks + offsetTicks);
//    }
//    private void goNeutral(){
//        turret.setTargetPosition(0);
//    }
//    private int angleToTicks(double angle){
//        double ret = angle/fullRotation * ticksPerRev;
//        return (int) Math.round(ret);
//    }
//}
