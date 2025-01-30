package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OTOS;
import org.firstinspires.ftc.teamcode.util.Vector;

@TeleOp(name="ftclib test")
public class CommandTeleop extends CommandOpMode {
    private MotorEx left, right, back;
    private OTOS otos;
    private DriveSubsystem driveSubsystem;
    private DriveCommand driveCommand;
    private GamepadEx driverIO;

    @Override
    public void initialize() {
        left = new MotorEx(hardwareMap, "leftMotor");
        right = new MotorEx(hardwareMap, "rightMotor");
        back = new MotorEx(hardwareMap, "backMotor");
        otos = new OTOS("laser", hardwareMap, DistanceUnit.METER, AngleUnit.DEGREES);

        driverIO = new GamepadEx(gamepad1);

        driveSubsystem = new DriveSubsystem(left, right, back, otos,
                                new Pose2D(DistanceUnit.METER, 0, 0, AngleUnit.DEGREES, 0),
                                telemetry);
        driveCommand = new DriveCommand(
                    driveSubsystem,
                    driverIO::getLeftY,
                    driverIO::getLeftX,
                    driverIO::getRightX
                );

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}
