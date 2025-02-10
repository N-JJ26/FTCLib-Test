package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.subsystems.Eyes;

public class EyeCommands extends CommandBase {
    private Eyes eyes;

    private boolean right, left;
    private double positionX, positionY;

    public EyeCommands(Eyes eyes, double positionX, double positionY) {
        this.eyes = eyes;

        this.positionX = positionX;
        this.positionY = positionY;

        addRequirements(eyes);
    }

    @Override
    public void execute() {
        eyes.setEyeBallX(positionX);
        eyes.setEyeBallY(positionY);
    }
}
