package com.wordpress.piedcipher.helloworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayoutRoot;
    private String colors[] = {
        "#F44336", "#E91E63", "#9C27B0", "#673AB7", "#3F51B5",
        "#2196F3", "#03A9F4", "#00BCD4", "#009688", "#4CAF50",
        "#8BC34A", "#CDDC39", "#FFEB3B", "#FFC107", "#FF9800",
        "#FF5722", "#795548", "#9E9E9E", "#607D8B", "#000000"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayoutRoot = findViewById(R.id.relative_layout_root);
        relativeLayoutRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * this line of code
                 * picks up a random color from colors array,
                 * parse it to a Hex-code from String,
                 * set it as Relative Layout's background.
                 */
                relativeLayoutRoot.setBackgroundColor(Color.parseColor(colors[new Random().nextInt(colors.length)]));
            }
        });
    }
}
