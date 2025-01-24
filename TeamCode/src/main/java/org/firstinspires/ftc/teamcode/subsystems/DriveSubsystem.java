package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

import org.firstinspires.ftc.teamcode.util.Vector;

public class DriveSubsystem extends SubsystemBase {
    private HDrive kiwi;
    private Motor left, right, back;

    public DriveSubsystem(Motor left, Motor right, Motor back) {
        this.left = left;
        this.right = right;
        this.back = back;

        kiwi = new HDrive(left, right, back);
    }

    public void drive(double strafe, double forward, double turn) {
        kiwi.driveRobotCentric(
                strafe,
                forward,
                turn
        );
    }
}
