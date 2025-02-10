package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.HDrive;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.util.Vector;

public class DriveSubsystem extends SubsystemBase {
    private HDrive kiwi;
    private MotorEx left, right, back;
    private OTOS otos;
    private Telemetry telemetry;

    public DriveSubsystem(MotorEx left, MotorEx right, MotorEx back, OTOS otos, Telemetry telemetry) {
        this.left = left;
        this.right = right;
        this.back = back;
        this.otos = otos;

        this.telemetry = telemetry;

        left.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);
        back.setZeroPowerBehavior(MotorEx.ZeroPowerBehavior.BRAKE);

        left.setInverted(true);
        right.setInverted(true);
        back.setInverted(true);

        kiwi = new HDrive(right, left, back);
    }

    public void drive(double strafe, double forward, double turn, double heading) {
        kiwi.driveRobotCentric(
                strafe,
                forward,
                turn
        );
    }

    @Override
    public void periodic() {
        otos.update();
        telemetry.addData("pose", otos.getPose());
        telemetry.update();
    }
}
