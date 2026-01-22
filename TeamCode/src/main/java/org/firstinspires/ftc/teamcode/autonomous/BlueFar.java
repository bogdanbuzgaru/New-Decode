package org.firstinspires.ftc.teamcode.autonomous;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.statemachine.StateMachine;

@Autonomous
public class BlueFar extends OpMode {
    public enum AutoState {
        PATH1,
        PATH2,
        PATH3,
        PATH4,
        PATH5,
        PATH6,
        PATH7,
        PATH8,
        PATH9,
        PATH10,
        PATH11,
        PATH12,
        PATH13,
        PATH14,
        PATH15,
        STOP;
    }

    private StateMachine<AutoState> fsm = new StateMachine<>(AutoState.PATH1);
    private Follower follower;
    private Paths paths;
    private ElapsedTime timer = new ElapsedTime();
    private ElapsedTime pathTimer = new ElapsedTime();
    private static double angle = 65.22;
    public void init(){
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(56.000, 8.200, Math.toRadians(90)));
        paths = new Paths(follower);
        setUp();
    }
    public void start(){
        timer.reset();
        fsm.init();
    }
    public void loop(){
        follower.update();
        fsm.update();
    }
    private void setUp() {
        fsm.onStateEnter(AutoState.PATH1, () -> follower.followPath(paths.Path1));
        fsm.onStateUpdate(AutoState.PATH1, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH2;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH2, () -> follower.followPath(paths.Path2));
        fsm.onStateUpdate(AutoState.PATH2, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH3;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH3, () -> follower.followPath(paths.Path3));
        fsm.onStateUpdate(AutoState.PATH3, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH4;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH4, () -> follower.followPath(paths.Path4));
        fsm.onStateUpdate(AutoState.PATH4, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH5;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH5, () -> follower.followPath(paths.Path5));
        fsm.onStateUpdate(AutoState.PATH5, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH6;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH6, () -> follower.followPath(paths.Path6));
        fsm.onStateUpdate(AutoState.PATH6, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH7;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH7, () -> follower.followPath(paths.Path7));
        fsm.onStateUpdate(AutoState.PATH7, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH8;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH8, () -> follower.followPath(paths.Path8));
        fsm.onStateUpdate(AutoState.PATH8, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH9;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH9, () -> follower.followPath(paths.Path9));
        fsm.onStateUpdate(AutoState.PATH9, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH10;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH10, () -> follower.followPath(paths.Path10));
        fsm.onStateUpdate(AutoState.PATH10, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH11;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH11, () -> follower.followPath(paths.Path11));
        fsm.onStateUpdate(AutoState.PATH11, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH12;
            } else {
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH12, () -> follower.followPath(paths.Path12));
        fsm.onStateUpdate(AutoState.PATH12, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH13;
            } else {
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH13, () -> follower.followPath(paths.Path13));
        fsm.onStateUpdate(AutoState.PATH13, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH14;
            } else {
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH14, () -> follower.followPath(paths.Path14));
        fsm.onStateUpdate(AutoState.PATH14, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH15;
            } else {
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH15, () -> follower.followPath(paths.Path15));
        fsm.onStateUpdate(AutoState.PATH15, () ->{
            if (!follower.isBusy()) {
                return AutoState.STOP;
            }else{
                return null;
            }
        });
    }
    public static class Paths {
        public PathChain Path1;
        public PathChain Path2;
        public PathChain Path3;
        public PathChain Path4;
        public PathChain Path5;
        public PathChain Path6;
        public PathChain Path7;
        public PathChain Path8;
        public PathChain Path9;
        public PathChain Path10;
        public PathChain Path11;
        public PathChain Path12;
        public PathChain Path13;
        public PathChain Path14;
        public PathChain Path15;

        public Paths(Follower follower) {
            Path1 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(56.000, 8.200),

                                    new Pose(52.172, 12.960)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(90))

                    .build();

            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(52.172, 12.960),

                                    new Pose(60.872, 18.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(angle))

                    .build();

            Path3 = follower.pathBuilder().addPath(
                    new BezierLine(
                            new Pose(60.872, 18.847),

                            new Pose(35.000, 10.650)
                    )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(35.000, 10.650),

                                    new Pose(15.000, 8.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path5 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(15.000, 8.900),

                                    new Pose(60.872, 18.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();
            Path6 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(60.872, 18.847),

                                    new Pose(35.000, 10.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path7 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(35.000, 10.650),

                                    new Pose(15.000, 8.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path8 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(15.000, 8.900),

                                    new Pose(60.872, 18.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();
            Path9 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(60.872, 18.847),

                                    new Pose(35.000, 10.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path10 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(35.000, 10.650),

                                    new Pose(15.000, 8.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path11 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(15.000, 8.900),

                                    new Pose(60.872, 18.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();
            Path12 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(60.872, 18.847),

                                    new Pose(35.000, 10.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path13 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(35.000, 10.650),

                                    new Pose(15.000, 8.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path14 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(15.000, 8.900),

                                    new Pose(60.872, 18.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();

            Path15 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(60.872, 18.847),

                                    new Pose(35.000, 10.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();
        }
    }
}