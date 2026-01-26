//package org.firstinspires.ftc.teamcode.subsystems;
//
//
//import com.bylazar.configurables.annotations.Configurable;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//
//
//@Configurable
//public class Turret {
//    private CRServo turretServo1, turretServo2;
//    private DcMotorEx encoder;
//    private int targetPos = 0;
//    public static double p = 0.001, i = 0, d = 0.000001, f = 0;   //TODO tuning parameters
//    private final double integralLimit = 1.0;
//    private PID pid;
//    public Turret (HardwareMap hardwareMap) {
//        turretServo1 = hardwareMap.get(CRServo.class, "turretServo1");
//        turretServo2 = hardwareMap.get(CRServo.class, "turretServo2");
//
//        encoder = hardwareMap.get(DcMotorEx.class, "backLeft");
//        pid = new PID(p, i, d, f);
//        pid.setIntegralLimit(integralLimit);
//        encoder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        encoder.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//    }
//    public int getCurrentPosition(){
//        return encoder.getCurrentPosition();
//    }
//    public void setTargetPosition(int ticks){
//        targetPos = ticks;
//    }
//    public void update (){
//        int currentPos = encoder.getCurrentPosition();
//        double error = targetPos - currentPos;
//
//        double fTerm = f * Math.signum(error);
//
//        double power = pid.update(targetPos, currentPos, p, d, i, fTerm);
//
//        if(Math.abs(error) < 10) {
//            power = 0;
//        }
//
//        turretServo1.setPower(power);
//        turretServo2.setPower(power);
//    }
//}