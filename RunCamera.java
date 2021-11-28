import org.openftc.easyopencv.OpenCvWebcam;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="CVtester",group="Linear OpMode")
public class RunCamera extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {
        OpenCvWebcam webcam;

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam"), cameraMonitorViewId);
        //OpenCV Pipeline
        ConceptCV myPipeline;
        webcam.setPipeline(myPipeline = new ConceptCV());

        OpenCvWebcam finalWebcam = webcam;
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                finalWebcam.startStreaming(1920 ,1080, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        waitForStart();


        while(opModeIsActive()) {


            double midpoint = myPipeline.getHubX();

            telemetry.addData("Midpoint: ", midpoint);
            telemetry.update();
        }



    }
}
