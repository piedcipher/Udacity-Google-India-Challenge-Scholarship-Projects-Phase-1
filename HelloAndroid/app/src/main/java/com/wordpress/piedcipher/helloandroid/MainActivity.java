package com.wordpress.piedcipher.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    CarouselView udacityImageCarouselView;
    int[] udacityImages = {R.drawable.udacity0, R.drawable.udacity1, R.drawable.udacity2, R.drawable.udacity3, R.drawable.udacity4, R.drawable.udacity5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        udacityImageCarouselView = findViewById(R.id.udacity_image_carouselView);
        udacityImageCarouselView.setPageCount(udacityImages.length);
        udacityImageCarouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int thisImage, ImageView udacityImageView) {
            udacityImageView.setImageResource(udacityImages[thisImage]);
            udacityImageView.setAdjustViewBounds(true);
            udacityImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    };
}
