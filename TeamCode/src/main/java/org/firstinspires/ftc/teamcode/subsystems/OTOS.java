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

    public OTOS(HardwareMap hwMap, DistanceUnit linearUnit, AngleUnit angularUnit) {
        otos = hwMap.get(SparkFunOTOS.class, "otos");
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
}
