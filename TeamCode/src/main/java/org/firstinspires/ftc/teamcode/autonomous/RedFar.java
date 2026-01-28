package org.firstinspires.ftc.teamcode.autonomous;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.statemachine.StateMachine;

@Autonomous
public class RedFar extends OpMode {
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
    private Intake intake;
    private Shooter shooter;
    private boolean isShooting = false;;
    private ElapsedTime timer = new ElapsedTime();
    private ElapsedTime pathTimer = new ElapsedTime();
    private static double angle = 68.42;

    public void init(){
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(88.000, 8.200, Math.toRadians(90)));
        paths = new Paths(follower);
        intake = new Intake (hardwareMap);
        shooter = new Shooter (hardwareMap);
        shooter.lowerBarrier();
        setUp();
    }
    public void start(){
        timer.reset();
        fsm.init();
        shooter.lowerBarrier();
    }
    public void loop(){
        follower.update();
        fsm.update();
        shooter.spinHighRPM();
    }
    private void setUp() {
        fsm.onStateEnter(AutoState.PATH1, () -> {
            follower.followPath(paths.Path1);
            intake.autoSlowTake();
            shooter.lowerBarrier();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH1, () -> {
            intake.autoSlowTake();
            shooter.lowerBarrier();
            if (!follower.isBusy()) {
                return AutoState.PATH2;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH2, () -> {
            follower.followPath(paths.Path2);
            isShooting = false;
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH2, () -> {
            intake.autoSlowTake();
            if (!follower.isBusy()) {
                if (!isShooting) {
                    pathTimer.reset();
                    isShooting = true;
                }else{
                    if(pathTimer.milliseconds() > 2000)
                        intake.autoShoot();
                    if(pathTimer.milliseconds() > 3000){
                        isShooting = false;
                        return AutoState.PATH3;
                    }
                }
                return null;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH3, () ->{
            follower.followPath(paths.Path3);
            intake.autoTake();
            angle -= 1;
            return null;
        });

        fsm.onStateUpdate(AutoState.PATH3, () -> {
            intake.autoTake();
            shooter.lowerBarrier();
            if (!follower.isBusy()) {
                return AutoState.PATH4;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH4, () ->{
            follower.followPath(paths.Path4);
            intake.autoTake();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH4, () -> {
            intake.autoTake();
            if (!follower.isBusy()) {
                return AutoState.PATH5;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH5, () ->{
            follower.followPath(paths.Path5);
            intake.autoSlowTake();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH5, () -> {
            intake.autoTake();
            if (!follower.isBusy()) {
                if (!isShooting) {
                    pathTimer.reset();
                    isShooting = true;
                }else{
                    intake.autoShoot();
                    if(pathTimer.milliseconds() > 1000){
                        isShooting = false;
                        return AutoState.PATH6;
                    }
                }
                return null;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH6, () ->{
            follower.followPath(paths.Path6);
            intake.autoStop();
            shooter.lowerBarrier();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH6, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH7;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH7, () ->{
            follower.followPath(paths.Path7);
            intake.autoTake();
            angle -= 2;
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH7, () -> {
            intake.autoTake();
            if (!follower.isBusy()) {
                return AutoState.PATH8;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH8, () ->{
            follower.followPath(paths.Path8);
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH8, () -> {
            intake.autoTake();
            if (!follower.isBusy()) {
                if (!isShooting) {
                    pathTimer.reset();
                    isShooting = true;
                } else {
                    intake.autoShoot();
                    if (pathTimer.milliseconds() > 1000) {
                        isShooting = false;
                        return AutoState.PATH9;
                    }
                }
            }
            return null;
        });
        fsm.onStateEnter(AutoState.PATH9, () ->{
            follower.followPath(paths.Path9);
            shooter.lowerBarrier();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH9, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH10;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH10, () ->{
            follower.followPath(paths.Path10);
            intake.autoTake();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH10, () -> {
            intake.autoTake();
            if (!follower.isBusy()) {
                return AutoState.PATH11;
            }else{
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH11, () ->{
            follower.followPath(paths.Path11);
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH11, () -> {
            intake.autoSlowTake();
            if (!follower.isBusy()) {
                if (!isShooting) {
                    pathTimer.reset();
                    isShooting = true;
                }else{
                    intake.autoShoot();
                    if(pathTimer.milliseconds() > 1000){
                        isShooting = false;
                        return AutoState.PATH12;
                    }
                }
            }
            return null;
        });
        fsm.onStateEnter(AutoState.PATH12, () ->{
            follower.followPath(paths.Path12);
            shooter.lowerBarrier();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH12, () -> {
            if (!follower.isBusy()) {
                return AutoState.PATH13;
            } else {
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH13, () ->{
            follower.followPath(paths.Path13);
            intake.autoTake();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH13, () -> {
            intake.autoTake();
            if (!follower.isBusy()) {
                return AutoState.PATH14;
            } else {
                return null;
            }
        });
        fsm.onStateEnter(AutoState.PATH14, () ->{
            follower.followPath(paths.Path14);
            intake.autoSlowTake();
            return null;
        });
        fsm.onStateUpdate(AutoState.PATH14, () -> {
            intake.autoSlowTake();
            if (!follower.isBusy()) {
                if (!isShooting) {
                    pathTimer.reset();
                    isShooting = true;
                }else{
                    intake.autoShoot();
                    if(pathTimer.milliseconds() > 1000){
                        isShooting = false;
                        return AutoState.PATH15;
                    }
                }
            }
            return null;
        });
        fsm.onStateEnter(AutoState.PATH15, () ->{
            follower.followPath(paths.Path15);
            shooter.lowerBarrier();
            return null;
        });
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
                                    new Pose(88.000, 8.200),

                                    new Pose(81.728, 10.960)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(90))

                    .build();

            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(81.728, 10.960),

                                    new Pose(83.128, 17.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(90), Math.toRadians(angle))

                    .build();

            Path3 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(83.128, 17.847),

                                    new Pose(109.000, 20.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 20.650),

                                    new Pose(122.000, 20.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path5 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(122.000, 17.900),

                                    new Pose(83.128, 18.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();
            Path6 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(83.128, 18.847),

                                    new Pose(109.000, 20.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path7 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 20.650),

                                    new Pose(122.000, 19.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path8 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(122.000, 19.900),

                                    new Pose(83.128, 19.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();
            Path9 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(83.128, 19.847),

                                    new Pose(109.000, 20.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path10 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 20.650),

                                    new Pose(122.000, 19.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path11 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(122.000, 19.900),

                                    new Pose(83.128, 19.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();
            Path12 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(83.128, 19.847),

                                    new Pose(109.000, 20.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();

            Path13 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 20.650),

                                    new Pose(122.000, 19.900)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path14 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(122.000, 19.900),

                                    new Pose(83.128, 19.847)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(angle))

                    .build();

            Path15 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(83.128, 19.847),

                                    new Pose(109.000, 22.650)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(angle), Math.toRadians(0))

                    .build();
        }
    }
}
