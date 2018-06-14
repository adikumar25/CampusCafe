package campuscafe.hackathon.campuscafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.SuggestionsInfo;
import android.widget.Button;
import android.widget.EditText;

public class VendorHomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_home);
        findViewById(R.id.buttonEditMenu).setOnClickListener(this);
        findViewById(R.id.buttonOrders).setOnClickListener(this);
        findViewById(R.id.buttonNotification).setOnClickListener(this);
        findViewById(R.id.buttonSuggestion).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Intent intent=null;
        switch (view.getId())
        {
            case R.id.buttonEditMenu:
                intent=new Intent(getApplicationContext(), EditMenuActivity.class);
                break;

            case R.id.buttonNotification:
                intent=new Intent(getApplicationContext(), NotificationActivity.class);
                break;

            case R.id.buttonOrders:
                intent=new Intent(getApplicationContext(), OrderActivity.class);
                break;

            case R.id.buttonSuggestion:
                intent=new Intent(getApplicationContext(), SuggestionActivity.class);
                break;
        }
        startActivity(intent);
        finish();
    }


}
