package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Eyes;

public class EyeCommands extends CommandBase {
    private Eyes eyes;

    private boolean right, left;
    private double positionX, positionY;

    public EyeCommands(Eyes eyes, boolean right, boolean left, double positionX, double positionY) {
        this.eyes = eyes;

        this.right = right;
        this.left = left;

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
