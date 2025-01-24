package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp(name="ftclib test")
public class CommandTeleop extends CommandOpMode {
    private Motor left, right, back;
    private DriveSubsystem driveSubsystem;
    private DriveCommand driveCommand;

    private GamepadEx driverIO;

    @Override
    public void initialize() {
        left = new Motor(hardwareMap, "left");
        right = new Motor(hardwareMap, "right");
        back = new Motor(hardwareMap, "back");

        driverIO = new GamepadEx(gamepad1);

        driveSubsystem = new DriveSubsystem(left, right, back);
        driveCommand = new DriveCommand(
                driveSubsystem,
                driverIO::getLeftX,
                driverIO::getLeftY,
                driverIO::getRightX
                );

        register(driveSubsystem);
        driveSubsystem.setDefaultCommand(driveCommand);
    }
}
