package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.mechanisms.Shooter;
import org.firstinspires.ftc.teamcode.movement.Movement;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends OpMode{
    private Movement movement = null;
    private Shooter shooter = null;
    private Intake intake = null;
    public void init(){
        movement = new Movement(hardwareMap);
        shooter = new Shooter(hardwareMap);
        intake = new Intake(hardwareMap);
    }
    public void loop() {
        movement.movementLoop(gamepad1);
        intake.take(gamepad1);
        shooter.setTicks(gamepad1);
        shooter.manualSpin(gamepad1);
        shooter.park(gamepad1);
    }
}
