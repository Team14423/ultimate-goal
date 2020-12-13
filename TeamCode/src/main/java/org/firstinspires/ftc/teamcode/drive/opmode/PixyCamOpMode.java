package org.firstinspires.ftc.teamcode.drive.opmode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ftclib.FtcPixyCam2;
import org.firstinspires.ftc.teamcode.trclib.TrcPixyCam2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demonstrates empty OpMode
 */
@TeleOp(name = "Concept: NullOp", group = "Concept")
@Disabled
public class PixyCamOpMode extends OpMode {

    FtcPixyCam2 pixy;

    private TrcPixyCam2.Block[] blocks;

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run when the op mode is first enabled goes here
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#start()
     */
    @Override
    public void init_loop() {
        pixy = new FtcPixyCam2(hardwareMap, "PixyCam", 0x54, false);
    }

    /*
     * This method will be called ONCE when start is pressed
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void start()
    {
        pixy.setEnabled(true);
        runtime.reset();
    }

    /*
     * This method will be called repeatedly in a loop
     * @see com.qualcomm.robotcore.eventloop.opmode.OpMode#loop()
     */
    @Override
    public void loop() {
        blocks = pixy.getBlocks(1, 5);
        for(TrcPixyCam2.Block block : blocks) {
            telemetry.addData("BlockHeight", block.height);
            telemetry.addData("BlockWidth", block.width);
        }
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }
}