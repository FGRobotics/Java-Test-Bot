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
        public double rectX;
        public double midpoint;





    public int length;


    public static Scalar lowHSv = new Scalar(  0.0, 0.0, 0.0);
    public static Scalar UpHsv = new Scalar(255.0, 255.0, 255.0);

    @Override
    public Mat processFrame(Mat input) {
        //input image

        Mat src = input;
        Mat mat = new Mat();
        Mat processed = new Mat();
        Mat output = new Mat();

        try {
            Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2YCrCb);
            Core.inRange(mat, lowHSv, UpHsv, processed);
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


            length = contours.size();


            for (MatOfPoint contour : contours) {

                //should make countours into an array now.

                Point[] contourArray = contour.toArray();


                MatOfPoint2f areaPoints = new MatOfPoint2f(contour);

                
                Rect rect = Imgproc.boundingRect(areaPoints);

                    
                rectX = rect.x;
                midpoint = (double) rect.width * 0.5 + rectX;


            }
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }











        return input;
    }

    public double getHubX(){
        return midpoint;
    }
    public int getLength(){
        return length;
    }

}
