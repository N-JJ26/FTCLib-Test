package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

import java.util.Locale;

public class Eyes extends SubsystemBase {
    private Servo eyeBallX, eyeBallY, eyeLeftUpperLid, eyeLeftLowerLid, eyeRightUpperLid, eyeRightLowerLid;

    public Eyes(Servo eyeBallX,
                Servo eyeBallY,
                Servo eyeLeftUpperLid,
                Servo eyeLeftLowerLid,
                Servo eyeRightUpperLid,
                Servo eyeRightLowerLid) {
        this.eyeBallX = eyeBallX;
        this.eyeBallY = eyeBallY;
        this.eyeLeftUpperLid = eyeLeftUpperLid;
        this.eyeLeftLowerLid = eyeLeftLowerLid;
        this.eyeRightUpperLid = eyeRightUpperLid;
        this.eyeRightLowerLid = eyeRightLowerLid;
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
                eyeLeftUpperLid.setPosition(open ?
                        Constants.EyeConstants.LEFT_UPPER_OPEN : Constants.EyeConstants.LEFT_UPPER_CLOSED);
                eyeLeftLowerLid.setPosition(open ?
                        Constants.EyeConstants.LEFT_LOWER_OPEN : Constants.EyeConstants.LEFT_LOWER_CLOSED);
                break;
            case RIGHT:
                eyeRightUpperLid.setPosition(open ?
                        Constants.EyeConstants.RIGHT_UPPER_OPEN : Constants.EyeConstants.RIGHT_UPPER_CLOSED);
                eyeRightLowerLid.setPosition(open ?
                        Constants.EyeConstants.RIGHT_LOWER_OPEN : Constants.EyeConstants.RIGHT_LOWER_CLOSED);
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
}
