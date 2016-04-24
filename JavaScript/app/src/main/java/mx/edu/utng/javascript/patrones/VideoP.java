package mx.edu.utng.javascript.patrones;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.keyes.youtube.OpenYouTubePlayerActivity;

import mx.edu.utng.javascript.R;
import mx.edu.utng.javascript.introduccion.VideoI;

/**
 * Created by Iruzz on 03/04/2016.
 */
public class VideoP extends Activity{
    //Link del video
    Button viewVideoButton = null;
    public String videoId = "Zkc6UGH_9gg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videop_layout);

        //videoIdTextView = (TextView) findViewById(R.id.youtubeIdText);
        viewVideoButton = (Button)findViewById(R.id.viewVideoButton);

        viewVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pV) {

                //String videoId = videoIdTextView.getText().toString();


                if (videoId == null || videoId.trim().equals("")){

                    return;
                }

                Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+videoId),VideoP.this,
                        OpenYouTubePlayerActivity.class);
                startActivity(lVideoIntent);

            }
        });
    }




}
