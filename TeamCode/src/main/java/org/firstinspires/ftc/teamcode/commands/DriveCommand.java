package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OTOS;
import org.firstinspires.ftc.teamcode.util.Vector;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private DriveSubsystem driveSubsystem;
    private DoubleSupplier strafe, forward, turn;
    private OTOS otos;

    public DriveCommand(DriveSubsystem driveSubsystem,
                        OTOS otos,
                        DoubleSupplier strafe,
                        DoubleSupplier forward,
                        DoubleSupplier turn
                        ) {
        this.driveSubsystem = driveSubsystem;
        this.strafe = strafe;
        this.forward = forward;
        this.turn = turn;

        this.otos = otos;

        otos.init();

        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(
                strafe.getAsDouble(),
                forward.getAsDouble(),
                turn.getAsDouble(),
                otos.getHeading()
        );
    }
}
