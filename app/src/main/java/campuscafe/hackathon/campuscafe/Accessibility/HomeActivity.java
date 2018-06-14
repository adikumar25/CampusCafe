package campuscafe.hackathon.campuscafe.Accessibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import campuscafe.hackathon.campuscafe.R;

public class HomeActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Android_Gesture_Detector android_gesture_detector=new Android_Gesture_Detector();
        gestureDetector=new GestureDetector(this,android_gesture_detector);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
}
