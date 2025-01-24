package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class DriveSubsystem extends SubsystemBase {
    private HDrive kiwi;
    private MotorEx left, right, back;
    private OTOS otos;

    public DriveSubsystem(MotorEx left, MotorEx right, MotorEx back, OTOS otos) {
        this.left = left;
        this.right = right;
        this.back = back;
        this.otos = otos;

        left.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);
        back.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);

        left.setInverted(true);
        right.setInverted(true);
        back.setInverted(true);

        kiwi = new HDrive(left, right, back);
    }

    public void drive(double strafe, double forward, double turn) {
        kiwi.driveFieldCentric(
                strafe,
                forward,
                turn,
                otos.getHeading()
        );
    }
}
