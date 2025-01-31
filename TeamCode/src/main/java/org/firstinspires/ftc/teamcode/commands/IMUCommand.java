package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.OTOS;

public class IMUCommand extends CommandBase {
    private OTOS otos;

    public IMUCommand(OTOS otos) {
        this.otos = otos;
    }

    @Override
    public void execute() {
        otos.reset();

        otos.update();
    }
}
