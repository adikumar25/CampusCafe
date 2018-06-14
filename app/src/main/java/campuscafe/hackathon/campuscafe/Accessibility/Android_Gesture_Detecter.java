package campuscafe.hackathon.campuscafe.Accessibility;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import static campuscafe.hackathon.campuscafe.Accessibility.HomeActivity.deleteFromCart;
import static campuscafe.hackathon.campuscafe.Accessibility.HomeActivity.moveLeftCafeteria;
import static campuscafe.hackathon.campuscafe.Accessibility.HomeActivity.moveRightCafeteria;
import static campuscafe.hackathon.campuscafe.Accessibility.HomeActivity.readMenuDown;
import static campuscafe.hackathon.campuscafe.Accessibility.HomeActivity.readMenuUp;

class Android_Gesture_Detector implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("Gesture ", " onDown");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        HomeActivity.addToCart();
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("Gesture ", " onSingleTapUp");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("Gesture ", " onShowPress");
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("Gesture ", " onDoubleTap");
        deleteFromCart();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d("Gesture ", " onDoubleTapEvent");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("Gesture ", " onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        Log.d("Gesture ", " onScroll");
        if (e1.getY() < e2.getY()){
            Log.d("Gesture ", " Scroll Down");
//            HomeActivity.readMenuDown();
        }
        if(e1.getY() > e2.getY()){
            Log.d("Gesture ", " Scroll Up");
//            HomeActivity.readMenuUp();
        }
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        try {

            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                moveRightCafeteria();
            }
            // left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                moveLeftCafeteria();
            }
            else if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
               readMenuDown();            }
            // left to right swipe
            else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                readMenuUp();}
        } catch (Exception e) {

        }





        return false;
    }





//
//        if (e1.getX() < e2.getX()) {
//            Log.d("Gesture ", "Left to Right swipe: "+ e1.getX() + " - " + e2.getX());
//            Log.d("Speed ", String.valueOf(velocityX) + " pixels/second");
//            moveLeftCafeteria();
//
//        }
//        if (e1.getX() > e2.getX()) {
//            Log.d("Gesture ", "Right to Left swipe: "+ e1.getX() + " - " + e2.getX());
//            Log.d("Speed ", String.valueOf(velocityX) + " pixels/second");
//            moveRightCafeteria();
//        }
//        if (e1.getY() < e2.getY()) {
//            Log.d("Gesture ", "Up to Down swipe: " + e1.getX() + " - " + e2.getX());
//            Log.d("Speed ", String.valueOf(velocityY) + " pixels/second");
//            readMenuUp();
//        }
//        if (e1.getY() > e2.getY()) {
//            Log.d("Gesture ", "Down to Up swipe: " + e1.getX() + " - " + e2.getX());
//            Log.d("Speed ", String.valueOf(velocityY) + " pixels/second");
//            readMenuDown();
//        }
//        return true;

    }
