package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvInternalCamera;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


public class ConceptCV extends OpenCvPipeline {
        private double rectX;
        private double midpoint;


        OpenCvCamera camera = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK);




        //Converting the source image to binary
        public static Scalar scalarLowerYCrCb = new Scalar(  45.7, -6.6, -8.3);
        public static Scalar scalarUpperYCrCb = new Scalar(149.6, -84.4, -106.8);

    @Override
    public Mat processFrame(Mat input) {
        //input image


        Mat mat = new Mat();
        Mat processed = new Mat();
        Mat output = new Mat();


        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2YCrCb);
        Core.inRange(mat, scalarLowerYCrCb, scalarUpperYCrCb, processed);
        // Core.bitwise_and(input, input, output, processed);

        // Remove Noise
        Imgproc.morphologyEx(processed, processed, Imgproc.MORPH_OPEN, new Mat());
        Imgproc.morphologyEx(processed, processed, Imgproc.MORPH_CLOSE, new Mat());
        // GaussianBlur
        Imgproc.GaussianBlur(processed, processed, new Size(5.0, 15.0), 0.00);
        // Find Contours
        List<MatOfPoint> contours = new ArrayList<>();
        Imgproc.findContours(processed, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);

        // Draw Contours
        Imgproc.drawContours(output, contours, -1, new Scalar(255, 0, 0));



        for(MatOfPoint contour : contours) {

    //should make countours into an array now.

            Point[] contourArray = contour.toArray();

            Scalar color = new Scalar(0, 0, 255);

            MatOfPoint2f areaPoints = new MatOfPoint2f(contour);


            Rect rect = Imgproc.boundingRect(areaPoints);


            if (rect.height > 180 && rect.height < 350) {
                rectX = rect.x;
                midpoint = rect.width * 0.5 + rectX;



        }




        }





        return input;
    } ;

    public double getHubX(){
        return midpoint;
    }

}
