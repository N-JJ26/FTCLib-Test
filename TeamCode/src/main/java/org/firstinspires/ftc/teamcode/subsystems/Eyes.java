package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.constants.EyeConstants;

import java.util.Locale;

public class Eyes extends SubsystemBase implements EyeConstants {
    private Servo eyeBallX, eyeBallY, eyeLeftUpperLid, eyeLeftLowerLid, eyeRightUpperLid, eyeRightLowerLid;
    private Telemetry telemetry;

    public Eyes(Servo eyeBallX,
                Servo eyeBallY,
                Servo eyeLeftUpperLid,
                Servo eyeLeftLowerLid,
                Servo eyeRightUpperLid,
                Servo eyeRightLowerLid,
                Telemetry telemetry) {
        this.eyeBallX = eyeBallX;
        this.eyeBallY = eyeBallY;
        this.eyeLeftUpperLid = eyeLeftUpperLid;
        this.eyeLeftLowerLid = eyeLeftLowerLid;
        this.eyeRightUpperLid = eyeRightUpperLid;
        this.eyeRightLowerLid = eyeRightLowerLid;

        this.telemetry = telemetry;
    }

    public enum Eye {
        LEFT, RIGHT
    }

    public void setEyeBallX(double position) {
        eyeBallX.setPosition(position);
    }

    public void setEyeBallY(double position) {
        eyeBallY.setPosition(position);
    }

    public void setEyeLidState(Eye eye, boolean open) {
        switch (eye) {
            case LEFT:
                eyeLeftUpperLid.setPosition(open ? LEFT_UPPER_OPEN : LEFT_UPPER_CLOSED);
                eyeLeftLowerLid.setPosition(open ? LEFT_LOWER_OPEN : LEFT_LOWER_CLOSED);
                break;
            case RIGHT:
                eyeRightUpperLid.setPosition(open ? RIGHT_UPPER_OPEN : RIGHT_UPPER_CLOSED);
                eyeRightLowerLid.setPosition(open ? RIGHT_LOWER_OPEN : RIGHT_LOWER_CLOSED);
        }
    }

    public String getServoPositions() {
        return String.format(Locale.US, "[%.3f, %.3f, %.3f, %.3f, %.3f, %.3f]",
                eyeBallX.getPosition(),
                eyeBallY.getPosition(),
                eyeLeftUpperLid.getPosition(),
                eyeLeftLowerLid.getPosition(),
                eyeRightUpperLid.getPosition(),
                eyeRightLowerLid.getPosition()
        );
    }

    @Override
    public void periodic() {
        telemetry.addData("eyes", getServoPositions());
        telemetry.update();
    }
}
