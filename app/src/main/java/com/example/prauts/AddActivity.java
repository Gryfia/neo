package com.example.prauts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class AddActivity extends AppCompatActivity {
    Button btmale, btfemale;
    ImageSwitcher imgswitcher;


    int index=0;
    int gorseller[]={R.drawable.picfimale, R.drawable.picmale};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button nextButton = findViewById(R.id.nextButton);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddActivity.this, "next", Toast.LENGTH_SHORT).show();
            }
        });

        btmale=findViewById(R.id.btmale);
        btfemale=findViewById(R.id.btfemale);
        imgswitcher=findViewById(R.id.imgswitcher);

        btfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++index;
                if (index==gorseller.length){
                    index=0;
                }
                imgswitcher.setImageResource(gorseller[index]);
            }
        });

        btmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --index;
                if (index<0){
                    index=gorseller.length-1;
                }
                imgswitcher.setImageResource(gorseller[index]);
            }
        });

        imgswitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setMaxWidth(200);
                imageView.setMaxHeight(200);

                return imageView;
            }
        });
        imgswitcher.setImageResource(gorseller[index]);
    }
}