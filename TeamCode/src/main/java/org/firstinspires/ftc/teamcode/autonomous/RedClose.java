package org.firstinspires.ftc.teamcode.autonomous;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierCurve;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathChain;

public class RedClose {

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

                                    new Pose(128.000, 84.000)
                            )
                    ).setTangentHeadingInterpolation()

                    .build();

            Path4 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(128.000, 84.000),

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

                                    new Pose(127.000, 60.000)
                            )
                    ).setTangentHeadingInterpolation()

                    .build();

            Path7 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(127.000, 60.000),

                                    new Pose(128.000, 72.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(270))

                    .build();

            Path8 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(128.000, 72.000),

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

                                    new Pose(135.000, 36.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

                    .build();

            Path11 = follower.pathBuilder().addPath(
                            new BezierLine(
                                    new Pose(135.000, 36.000),

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

                                    new Pose(130.000, 84.000)
                            )
                    ).setLinearHeadingInterpolation(Math.toRadians(43.4), Math.toRadians(270))

                    .build();
        }
    }

}
