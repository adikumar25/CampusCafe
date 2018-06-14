package campuscafe.hackathon.campuscafe;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText et_userName, et_password;
    Button LoginButton;
    ProgressDialog progressDialog;
    String TAG="Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog=new ProgressDialog(this);
        et_userName=(EditText)findViewById(R.id.et_UserName);
        et_password=(EditText)findViewById(R.id.et_Password);
        LoginButton=(Button)findViewById(R.id.buttonLogin);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName,password;
                userName=et_userName.getText().toString();
                password=et_password.getText().toString();

                volleyStringRequst();
            }
        });
    }

    public void volleyStringRequst(){

        String  URL = "https://campus-cafe.herokuapp.com/login/?username="+et_userName.getText().toString();

        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest strReq = new StringRequest(Request.Method.GET,
                URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    Log.d(TAG, jsonObject.getString("user-type"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                progressDialog.dismiss();
            }
        });


                // Adding String request to request queue
                AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq, URL);
    }

}
