package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.util.Vector;

public class OTOS extends GyroEx {
    private SparkFunOTOS otos;
    private SparkFunOTOS.Pose2D pose = new SparkFunOTOS.Pose2D();
    private Vector lastPose;

    public OTOS(String deviceName, HardwareMap hwMap, DistanceUnit linearUnit, AngleUnit angularUnit) {
        otos = hwMap.get(SparkFunOTOS.class, deviceName);
        otos.setLinearUnit(linearUnit);
        otos.setAngularUnit(angularUnit);
    }

    @Override
    public void init() {
        otos.begin();
        otos.resetTracking();
        otos.calibrateImu();
    }

    @Override
    public double getHeading() {
        return 0.0;
    }

    @Override
    public double getAbsoluteHeading() {
        return pose.h;
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
        otos.setPosition(new SparkFunOTOS.Pose2D(pose.x, pose.y, 0));
    }

    @Override
    public void disable() {
        otos.close();
    }

    @Override
    public String getDeviceType() {
        return null;
    }

    public Vector getPose() {
        return new Vector(pose.x, pose.y);
    }

    public void update() {
        lastPose = new Vector(pose.x, pose.y);
        pose = otos.getPosition();
    }

    public Vector getPosDeltas() {
        return new Vector(pose.x - lastPose.x, pose.y - lastPose.y);
    }
}
