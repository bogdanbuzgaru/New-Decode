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
        Request request = new Request.Builder().url("http://limelight-neuro.local:5801//results").build();  // Use your Limelight's IP/hostname

        try {
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();
            JSONObject results = new JSONObject(jsonString);

            // Check validity
            int tv = results.getInt("valid");  // Equivalent to 'tv' in NT

            if (tv == 1) {
                JSONArray detectorArray = results.getJSONArray("Detector");  // Array of detections
                for (int i = 0; i < detectorArray.length(); i++) {
                    JSONObject detection = detectorArray.getJSONObject(i);
                    String className = detection.getString("class");
                    double confidence = detection.getDouble("conf");  // 0-1, e.g., >0.8 for "really sure"

                    if (className.equals("green artifact") && confidence > 0.75) {  // Adjust threshold based on your model
                        detected = true;
                        // Optional: Add telemetry here if needed for debugging
                         telemetry.addData("Detection", "Correct: " + className + " (Conf: " + confidence + ")");
                        break;  // Exit loop once a match is found (or remove if you need to check all)
                    }else if (className.equals("purple artifact") && confidence > 0.75) {  // Adjust threshold based on your model
                        detected = true;
                        // Optional: Add telemetry here if needed for debugging
                        telemetry.addData("Detection", "Correct: " + className + " (Conf: " + confidence + ")");
                        break;  // Exit loop once a match is found (or remove if you need to check all)
                    }
                }
            }
        } catch (Exception e) {
            // Optional: telemetry.addData("Error", "HTTP fetch failed: " + e.getMessage());
            detected = false;  // Return false on any error
        }

        // telemetry.update();  // Call this outside the method if needed
        return detected;
    }
}
