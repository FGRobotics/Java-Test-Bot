package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Toaster")
public class Toaster extends LinearOpMode {
    //private BNO055IMU imuAsBNO055IMU;
    private DcMotor frAsDcMotor = null;
    private DcMotor brAsDcMotor = null;
    private DcMotor flAsDcMotor = null;
    private DcMotor blAsDcMotor = null;
    private ElapsedTime runtime = new ElapsedTime();
    private DistanceSensor sensorRange;
    public void runOpMode() {
        sensorRange = hardwareMap.get(DistanceSensor.class, "T_D_sensor");
        frAsDcMotor = hardwareMap.get(DcMotor.class, "fr");
        flAsDcMotor = hardwareMap.get(DcMotor.class, "fl");
        brAsDcMotor = hardwareMap.get(DcMotor.class, "br");
        blAsDcMotor = hardwareMap.get(DcMotor.class, "bl");
        flAsDcMotor.setDirection(DcMotor.Direction.REVERSE);
        frAsDcMotor.setDirection(DcMotor.Direction.FORWARD);
        brAsDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        blAsDcMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        //RED CLOSE

        //OpenCV scan or Distance sensor scan

        //Drop to fondu fountain

        //park




        /*
        RED FAR

        //OpenCV scan or Distance sensor scan

        //Drop

        //charge pass through barrier

        //park
         */




    }
}
