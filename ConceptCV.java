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


    @Override
    public Mat processFrame(Mat input) {
        //input image
        Mat src = input;
        //changing it to binary
        Mat gray = new Mat(src.rows(), src.cols(), src.type());
        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        Mat binary = new Mat(src.rows(), src.cols(), src.type(), new Scalar(0));
        Imgproc.threshold(gray, binary, 100, 255, Imgproc.THRESH_BINARY_INV);
        //Finding Contours
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchey = new Mat();
        Imgproc.findContours(binary, contours, hierarchey, Imgproc.RETR_TREE,
                Imgproc.CHAIN_APPROX_SIMPLE);




        for(MatOfPoint contour : contours) {
            boolean searching = true;
    //should make countours into an array now.
        while(searching) {
            Point[] contourArray = contour.toArray();

            Scalar color = new Scalar(0, 0, 255);

            MatOfPoint2f areaPoints = new MatOfPoint2f(contour);


            Rect rect = Imgproc.boundingRect(areaPoints);
            Imgproc.drawContours(src, contours, -1, color, 2, Imgproc.LINE_8,
                    hierarchey, 2, new Point());

            if (rect.height > 180 && rect.height < 350) {
                rectX = rect.x;
                midpoint = rect.width * 0.5 + rectX;

                searching = false;
            }
        }




        }





        return null;
    } ;

    public double getHubX(){
        return midpoint;
    }

}
