package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Vector2d;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class OTOS extends GyroEx {
    private SparkFunOTOS otos;
    private SparkFunOTOS.Pose2D pose = new SparkFunOTOS.Pose2D();
    private Vector2d lastPose;

    public OTOS(String deviceName, HardwareMap hwMap) {
        otos = hwMap.get(SparkFunOTOS.class, deviceName);
    }

    @Override
    public void init() {
        otos.begin();
        otos.resetTracking();
        otos.calibrateImu();
        otos.setLinearUnit(DistanceUnit.METER);
        otos.setAngularUnit(AngleUnit.DEGREES);
    }

    @Override
    public double getHeading() {
        return pose.h;
    }

    @Override
    public double getAbsoluteHeading() {
        return 0.0;
    }

    @Override
    public double[] getAngles() {
        return null;
    }

    @Override
    public Rotation2d getRotation2d() {
        return null;
    }

    @Override
    public void reset() {
        otos.setPosition(new SparkFunOTOS.Pose2D(pose.x, pose.y, 0.0));
    }

    @Override
    public void disable() {
        otos.close();
    }

    @Override
    public String getDeviceType() {
        return null;
    }

    public Vector2d getPose() {
        return new Vector2d(pose.x, pose.y);
    }

    public Vector2d getPosDeltas() {
        return new Vector2d(pose.x - lastPose.getX(), pose.y - lastPose.getY());
    }

    public void update() {
        lastPose = new Vector2d(pose.x, pose.y);
        pose = otos.getPosition();
    }
}
