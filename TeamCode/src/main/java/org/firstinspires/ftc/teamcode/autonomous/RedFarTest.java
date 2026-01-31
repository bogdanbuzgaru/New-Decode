package org.firstinspires.ftc.teamcode.autonomous;

import static org.firstinspires.ftc.teamcode.pedroPathing.Tuning.follower;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class RedFarTest {
    private Paths paths;
    private enum AutoState{
        PATH1,
        PATH2

    }

    public static class Paths{
        public PathChain Path1;
        public PathChain Path2;

        public Paths(Follower follower){
            Path1 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(88.000, 8.200),

                                    new Pose(109.000, 8.200)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();
            Path2 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(109.000, 8.200),

                                    new Pose(88.000, 8.200)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

        }
    }
}
