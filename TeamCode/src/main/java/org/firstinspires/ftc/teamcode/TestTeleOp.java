package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.OTOS;

@TeleOp(name="test")
public class TestTeleOp extends OpMode {
    private SparkFunOTOS otos;

    @Override
    public void init() {
        otos = hardwareMap.get(SparkFunOTOS.class, "laser");
        otos.begin();
        otos.calibrateImu();
        otos.resetTracking();
        otos.setAngularUnit(AngleUnit.DEGREES);
        otos.setLinearUnit(DistanceUnit.METER);
    }

    @Override
    public void loop() {
        telemetry.addData("otos thingy :3", otos.getPosition().h);
    }
}
