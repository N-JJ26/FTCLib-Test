package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.util.Vector;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private DriveSubsystem driveSubsystem;
    private DoubleSupplier strafe, forward, turn;

    public DriveCommand(DriveSubsystem driveSubsystem,
                        DoubleSupplier strafe,
                        DoubleSupplier forward,
                        DoubleSupplier turn
                        ) {
        this.driveSubsystem = driveSubsystem;
        this.strafe = strafe;
        this.forward = forward;
        this.turn = turn;

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(
                strafe.getAsDouble(),
                forward.getAsDouble(),
                turn.getAsDouble(),
                driveSubsystem.getHeading()
        );
    }
}
