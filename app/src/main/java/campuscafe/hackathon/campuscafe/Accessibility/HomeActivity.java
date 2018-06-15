package campuscafe.hackathon.campuscafe.Accessibility;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import campuscafe.hackathon.campuscafe.R;

import static campuscafe.hackathon.campuscafe.Accessibility.Constants.cafe1;
import static campuscafe.hackathon.campuscafe.Accessibility.Constants.cafe2;
import static campuscafe.hackathon.campuscafe.Accessibility.Constants.cafe3;

public class HomeActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;
    static TextToSpeech textToSpeech;
    static int cafeID=0;
    static int itemID=-1;
    static ArrayList<String> cart;
    static  int cart_value=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });




        Android_Gesture_Detector android_gesture_detector=new Android_Gesture_Detector();
        gestureDetector=new GestureDetector(this,android_gesture_detector);


        cart=new ArrayList<>();
        cart.clear();



        readText("Hello welcome to Campus Cafe. You are at Cafe 1");

        RelativeLayout TextLoggerLayout = (RelativeLayout)findViewById(R.id.rl);
        TextLoggerLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){

                    @Override
                    public boolean onTouch(View v, MotionEvent m) {
                        handleTouch(m);
                        return true;
                    }

                });


//        final RelativeLayout layout=findViewById(R.id.rl);
//        layout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                if(motionEvent.getActionMasked()==MotionEvent.ACTION_POINTER_DOWN)
//                {
//
//                }
//                return false;
//            }
//        });



    }

    private void handleTouch(MotionEvent m) {
        int pointerCount = m.getPointerCount();
        if(pointerCount == 2) {
            readText("Order Confirmed with total cart value of "+cart_value);
        }
    }

    public static void readText(String text)
    {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    public static void moveLeftCafeteria()
    {
        if(cafeID!=0)
        {
            cafeID--;
            readCafeteria(cafeID);
            itemID=-1;
            cart.clear();
            cart_value=0;
        }

    }

    public static void moveRightCafeteria()
    {
        if(cafeID!=2)
        {
            cafeID++;
            itemID=-1;
            readCafeteria(cafeID);
            cart.clear();
            cart_value=0;
        }

    }

    public static void readMenuUp()
    {

        if(itemID!=3)
        {
            itemID++;
            switch (cafeID)
            {
                case 0:
                    readText(cafe1[itemID][0]+" with price of Rupees "+cafe1[itemID][1]);
                    break;
                case 1:
                    readText(cafe2[itemID][0]+" with price of Rupees "+cafe2[itemID][1]);
                    break;
                case 2:
                    readText(cafe3[itemID][0]+" with price of Rupees "+cafe3[itemID][1]);
                    break;
            }


        }
    }
    public static void readMenuDown()
    {

        if(itemID>0)
        {
            itemID--;
            switch (cafeID)
            {
                case 0:
                    readText(cafe1[itemID][0]+" with price of Rupees "+cafe1[itemID][1]);
                    break;
                case 1:
                    readText(cafe2[itemID][0]+" with price of Rupees "+cafe2[itemID][1]);
                    break;
                case 2:
                    readText(cafe3[itemID][0]+" with price of Rupees "+cafe3[itemID][1]);
                    break;
            }


        }
    }

    public static void addToCart()
    {
        cart.add(itemID+"");
        switch (cafeID)
        {
            case 0:
                cart_value+=Integer.parseInt(cafe1[itemID][1]);
                break;
            case 1:
                cart_value+=Integer.parseInt(cafe2[itemID][1]);
                break;
            case 2:
                cart_value+=Integer.parseInt(cafe3[itemID][1]);
                break;
        }


        readText("Item added. Total Cart value is Rupees "+cart_value);
    }

    public static void deleteFromCart()
    {
        cart.remove(itemID+"");
        switch (cafeID)
        {
            case 0:
                cart_value-=Integer.parseInt(cafe1[itemID][1]);
                break;
            case 1:
                cart_value-=Integer.parseInt(cafe2[itemID][1]);
                break;
            case 2:
                cart_value-=Integer.parseInt(cafe3[itemID][1]);
                break;
        }
        readText("Item deleted. Total Cart value is Rupees "+cart_value);
    }


















    public void onPause(){
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
    public static void readCafeteria(int cafeId){

        switch(cafeId)
        {
            case 0:
                readText("Welcome to cafe 1");
                break;
            case 1:
                readText("Welcome to cafe 2");
                break;
            case 2:
                readText("Welcome to cafe 3");
                break;
        }
    }

    public void changeRestaurant(int a,int type)
    {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
}
