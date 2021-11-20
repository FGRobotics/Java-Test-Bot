
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Scalar;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class RunCamera extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        OpenCvWebcam webcam;
        while(opModeIsActive()) {
            int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
            webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
            //OpenCV Pipeline
            ConceptCV myPipeline;
            webcam.setPipeline(myPipeline = new ConceptCV());

            webcam.openCameraDeviceAsync(() -> webcam.startStreaming(CAMERA_WIDTH, CAMERA_HEIGHT, OpenCvCameraRotation.UPRIGHT));

            double midpoint = myPipeline.getHubX();

            telemetry.addData("Midpoint: ", midpoint);
            telemetry.update();
        }



    }
}
