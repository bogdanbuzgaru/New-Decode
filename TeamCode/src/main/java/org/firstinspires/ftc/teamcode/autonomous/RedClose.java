package org.firstinspires.ftc.teamcode.autonomous;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.statemachine.StateMachine;

@Autonomous
public class RedClose extends OpMode {
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
        STOP
    }

    private StateMachine <AutoState> fsm = new StateMachine<>(AutoState.PATH1);
    private Paths paths;
    private Follower follower;
    private ElapsedTime timer = new ElapsedTime();
    private ElapsedTime pathTimer = new ElapsedTime();

    @Override
    public void init(){
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(112.000, 135.000, Math.toRadians(0)));
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
                                    new Pose(112.000, 135.000),

                                    new Pose(109.000, 108.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(43.4))

                    .build();

            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 108.000),

                                    new Pose(95.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(43.4), Math.toRadians(0))

                    .build();

            Path3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(95.000, 84.000),

                                    new Pose(124.000, 84.000)
                            )
                    ).setTangentHeadingInterpolation()

                    .build();

            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(124.000, 84.000),

                                    new Pose(85.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(43.4))

                    .build();

            Path5 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(85.000, 84.000),

                                    new Pose(95.000, 60.000)
                            )
                    ).setTangentHeadingInterpolation()

                    .build();

            Path6 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(95.000, 60.000),

                                    new Pose(124.000, 60.000)
                            )
                    ).setTangentHeadingInterpolation()

                    .build();

            Path7 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(124.000, 60.000),

                                    new Pose(127.000, 72.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(270))

                    .build();

            Path8 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.000, 72.000),

                                    new Pose(85.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(43.4))

                    .build();

            Path9 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(85.000, 84.000),

                                    new Pose(95.000, 36.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(43.4), Math.toRadians(43.4))

                    .build();

            Path10 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(95.000, 36.000),

                                    new Pose(130.000, 36.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path11 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(130.000, 36.000),

                                    new Pose(85.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(43.4))

                    .build();

            Path12 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(85.000, 84.000),

                                    new Pose(130.984, 45.840)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(43.4), Math.toRadians(290))

                    .build();

            Path13 = follower.pathBuilder().addPath(
                            new BezierCurve(
                                    new Pose(130.984, 45.840),
                                    new Pose(131.070, 44.990),
                                    new Pose(131.156, 44.139),
                                    new Pose(131.241, 43.289),
                                    new Pose(131.327, 42.439),
                                    new Pose(131.430, 41.419),
                                    new Pose(131.516, 40.568),
                                    new Pose(131.602, 39.718),
                                    new Pose(131.688, 38.868),
                                    new Pose(131.791, 37.848),
                                    new Pose(131.877, 36.997),
                                    new Pose(131.962, 36.147),
                                    new Pose(132.048, 35.297),
                                    new Pose(133.000, 31.000),
                                    new Pose(133.000, 25.000),
                                    new Pose(133.000, 20.000),
                                    new Pose(133.000, 15.000),
                                    new Pose(134.297, 13.020),
                                    new Pose(134.400, 12.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(290), Math.toRadians(270))

                    .build();

            Path14 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(134.400, 12.000),

                                    new Pose(85.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(43.4))

                    .build();

            Path15 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(85.000, 84.000),

                                    new Pose(120.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(43.4), Math.toRadians(270))

                    .build();
        }
    }

}
