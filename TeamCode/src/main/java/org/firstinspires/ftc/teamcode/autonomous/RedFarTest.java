//package org.firstinspires.ftc.teamcode.autonomous;
//
//import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.follower;
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.geometry.BezierLine;
//import com.pedropathing.geometry.Pose;
//import com.pedropathing.paths.PathChain;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//import org.firstinspires.ftc.teamcode.statemachine.StateMachine;
//import org.firstinspires.ftc.teamcode.subsystems.Shooter;
//
//import java.io.FileOutputStream;
//
//@Autonomous
//public class RedFarTest extends OpMode {
//    private Shooter shooter;
//    private Follower follower;
//    private Paths paths;
//    private enum AutoState{
//        PATH1,
//        PATH2
//
//    }
//    StateMachine<AutoState> fsm = new StateMachine<>(AutoState.PATH1);
//
//    public void init(){
//        shooter = new Shooter (hardwareMap);
//        follower.setStartingPose(new Pose(88.000, 9.000, Math.toRadians(180)));
//    }
//    public void start(){
//
//    }
//    public void loop(){
//
//    }
//    private setUp(){
//        fsm.onStateEnter( AutoState.PATH1, () -> {
//            shooter.lowerBarrier();
//        });
//    }
//    public static class Paths{
//        public PathChain Path1;
//        public PathChain Path2;
//
//        public Paths(Follower follower){
//            Path1 = follower.pathBuilder().addPath(
//                            new BezierLine(
//                                    new Pose(88.000, 8.200),
//
//                                    new Pose(109.000, 8.200)
//                            )
//                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//
//                    .build();
//            Path2 = follower.pathBuilder().addPath(
//                            new BezierLine(
//                                    new Pose(109.000, 8.200),
//
//                                    new Pose(88.000, 8.200)
//                            )
//                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//
//                    .build();
//
//        }
//    }
//}
