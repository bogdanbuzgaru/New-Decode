package org.firstinspires.ftc.teamcode.limelight;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Limelight {
    Limelight3A limelight;
    public Limelight (){
    }
    public boolean isDetecting() {
        boolean detected = false;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://limelight-neuro.local:5800/results").build();  // Fixed port and removed double slash

        try {
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            JSONObject results = new JSONObject(jsonString);

            // Check validity (fixed key: "v")
            int tv = results.getInt("v");  // Equivalent to 'tv' in NT

            if (tv == 1) {
                JSONArray detectorArray = results.getJSONArray("Detector");  // Array of detections
                for (int i = 0; i < detectorArray.length(); i++) {
                    JSONObject detection = detectorArray.getJSONObject(i);
                    String className = detection.getString("class");
                    double confidence = detection.getDouble("conf");  // 0-1, e.g., >0.8 for "really sure"

                    if ((className.equals("green artifact") || className.equals("purple artifact")) && confidence > 0.75) {  // Combined check for either class; adjust threshold
                        detected = true;
//                        telemetry.addData("Detection", "Correct: " + className + " (Conf: " + confidence + ")");  // For debugging
                        break;  // Exit loop once a match is found
                    }
                }
            }
        } catch (Exception e) {
//            telemetry.addData("Error", "HTTP fetch failed: " + e.getMessage());  // Log errors for debug
            detected = false;  // Return false on any error
        }

        // Do NOT call telemetry.update() here—do it in your OpMode loop after calling this method
        return detected;
    }
}
