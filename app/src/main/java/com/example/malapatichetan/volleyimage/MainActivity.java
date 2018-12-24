package com.example.malapatichetan.volleyimage;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String myUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Starburst_in_NGC_4449_(captured_by_the_Hubble_Space_Telescope).jpg/1024px-Starburst_in_NGC_4449_(captured_by_the_Hubble_Space_Telescope).jpg";

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Button mybutton = (Button)findViewById(R.id.button);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImageRequest imageRequest = new ImageRequest(myUrl, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                      imageView.setImageBitmap(response);
                    }
                }, 0, 0, null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("Error","Error");
                            }
                        });
                MySingleton.getinstance(MainActivity.this).addToRequestQueue(imageRequest);


            }
        });
    }
}
