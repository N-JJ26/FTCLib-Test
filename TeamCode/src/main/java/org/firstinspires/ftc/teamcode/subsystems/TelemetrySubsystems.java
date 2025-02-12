package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TelemetrySubsystems extends SubsystemBase {
    private DriveSubsystem driveSubsystem;
    //private Eyes eyes;
    private Telemetry telemetry;

    public TelemetrySubsystems(DriveSubsystem driveSubsystem, Telemetry telemetry) {
        this.driveSubsystem = driveSubsystem;

        this.telemetry = telemetry;
    }

    @Override
    public void periodic() {
        telemetry.addData("test", 1);
    }
}
