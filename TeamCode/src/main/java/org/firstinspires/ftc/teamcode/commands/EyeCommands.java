package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Eyes;

public class EyeCommands extends CommandBase {
    private Eyes eyes;

    private boolean right, left;
    private double positionX, positionY;

    public EyeCommands(Eyes eyes, double positionX, double positionY, boolean right, boolean left) {
        this.eyes = eyes;

        this.positionX = positionX;
        this.positionY = positionY;

        this.right = right;
        this.left = left;

        addRequirements(eyes);
    }

    @Override
    public void execute() {
        eyes.setEyeBallX(positionX);
        eyes.setEyeBallY(positionY);

        eyes.setEyeLidState(Eyes.Eye.LEFT, left);
        eyes.setEyeLidState(Eyes.Eye.RIGHT, right);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
