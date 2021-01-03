package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wobble
{
    public DcMotorEx wobble;
    public Servo wobbleServo;
    private static int START_POSITION = 0;
    private static int STOP_POSITION= 250;
    private static double SERVO_OPEN = 0.7;
    private static double SERVO_CLOSED = 0.45;


    public Wobble(HardwareMap hardwareMap)
    {
        Init(hardwareMap);
    }

    public void Init(HardwareMap hardwareMap)
    {
        wobble = hardwareMap.get(DcMotorEx.class, "Wobble");
        wobble.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        wobble.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        //TODO: set position that wobble starts in
        //wobble.setTargetPosition();

        wobbleServo = hardwareMap.get(Servo.class, "WobbleServo");
        //TODO: set a postion that closes the wobble servo
        //wobbleServo.setPosition();
        closeWobble();



    }
    //Opens Wobble Hand and releases Wobble
    public void openClaw() {
        //TODO: set a postion that opens the wobble servo
        wobbleServo.setPosition(SERVO_OPEN);
    }

    //Closes Wobble Hand and grabs Wobble
    public void closeWobble() {
        //TODO: set a postion that closes the wobble servo
        wobbleServo.setPosition(SERVO_CLOSED);
    }

    //Moves Wobble Arm to Raised Position (over Ramp)
    public void raiseWobble()
    {
        //TODO: set position that raises the wobble
        wobble.setTargetPosition(START_POSITION+75);
        wobble.setPower(0.8);
        wobble.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        wobble.setPower(0);

    }

    //Moves Wobble Arm to Lowered Position (Extended position)
    public void lowerWobble()
    {
        //TODO: set position that lowers the wobble
        wobble.setTargetPosition(STOP_POSITION-50);
        // Positive Target = move clockwise (out from robot)
        wobble.setPower(0.8);
        wobble.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        wobble.setPower(0);
    }
}