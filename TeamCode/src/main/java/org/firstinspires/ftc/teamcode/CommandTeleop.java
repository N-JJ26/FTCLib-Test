package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.EyeCommands;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Eyes;
import org.firstinspires.ftc.teamcode.subsystems.OTOS;

@TeleOp(name="ftclib test")
public class CommandTeleop extends CommandOpMode {
    private MotorEx left, right, back;
    private Servo eyeBallX, eyeBallY, eyeLeftUpperLid, eyeLeftLowerLid, eyeRightUpperLid, eyeRightLowerLid;
    private OTOS otos;
    private DriveSubsystem driveSubsystem;
    private DriveCommand driveCommand;
    private Eyes eyes;
    private EyeCommands eyeCommands;
    private GamepadEx driverIO, operatiorIO;
    private GamepadButton options;

    @Override
    public void initialize() {
        left = new MotorEx(hardwareMap, "leftMotor");
        right = new MotorEx(hardwareMap, "rightMotor");
        back = new MotorEx(hardwareMap, "backMotor");

        eyeBallX = hardwareMap.get(Servo.class, "eyeBallX");
        eyeBallY = hardwareMap.get(Servo.class, "eyeBallY");
        eyeLeftUpperLid = hardwareMap.get(Servo.class, "eyeLeftUpperLid");
        eyeLeftLowerLid = hardwareMap.get(Servo.class, "eyeLeftLowerLid");
        eyeRightUpperLid = hardwareMap.get(Servo.class, "eyeRightUpperLid");
        eyeRightLowerLid = hardwareMap.get(Servo.class, "eyeRightLowerLid");

        otos = new OTOS("laser", hardwareMap);

        driverIO = new GamepadEx(gamepad1);
        operatiorIO = new GamepadEx(gamepad2);

        options = new GamepadButton(driverIO, GamepadKeys.Button.START);

        driveSubsystem = new DriveSubsystem(left, right, back, otos, telemetry);
        driveCommand = new DriveCommand(
                driveSubsystem,
                otos,
                driverIO::getLeftY,
                driverIO::getLeftX,
                driverIO::getRightX
        );

        eyes = new Eyes(
                eyeBallX,
                eyeBallY,
                eyeLeftUpperLid,
                eyeLeftLowerLid,
                eyeRightUpperLid,
                eyeRightLowerLid,
                telemetry
        );
        eyeCommands = new EyeCommands(
                eyes,
                Constants.EyeConstants.OFFSET
                            + (Constants.EyeConstants.MULTIPLIER * operatiorIO.getRightX()),
                Constants.EyeConstants.OFFSET
                            + (Constants.EyeConstants.MULTIPLIER * operatiorIO.getRightY())
        );

        driveSubsystem.setDefaultCommand(driveCommand);
        eyes.setDefaultCommand(eyeCommands);

        schedule(new InstantCommand(
                () -> eyes.setEyeLidState(Eyes.Eye.LEFT, operatiorIO.isDown(GamepadKeys.Button.RIGHT_BUMPER))
        ));

        schedule(new InstantCommand(
                () -> eyes.setEyeLidState(Eyes.Eye.LEFT, operatiorIO.isDown(GamepadKeys.Button.LEFT_BUMPER))
        ));

        options.whenReleased(new InstantCommand(
                () -> otos.reset()
        ));

        register(driveSubsystem);
        register(eyes);
    }
}
