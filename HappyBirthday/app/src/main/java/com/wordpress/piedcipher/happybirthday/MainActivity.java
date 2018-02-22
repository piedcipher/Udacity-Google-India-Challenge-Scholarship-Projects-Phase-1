package com.wordpress.piedcipher.happybirthday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button makeBirthdayCard;
    private EditText wishFromName, wishToName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeBirthdayCard = findViewById(R.id.make_birthday_card_button);
        wishFromName = findViewById(R.id.happy_birthday_from_EditText);
        wishToName = findViewById(R.id.happy_birthday_to_EditText);

        makeBirthdayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wishFromName.getText().toString().isEmpty() || wishToName.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.input_error, Toast.LENGTH_SHORT).show();
                } else {
                    Intent makeThisBirthdayCard = new Intent(getApplicationContext(), BirthdayCardActivity.class);
                    makeThisBirthdayCard.putExtra("wishTo", wishToName.getText().toString());
                    makeThisBirthdayCard.putExtra("wishFrom", wishFromName.getText().toString());

                    wishFromName.setText("");
                    wishToName.setText("");

                    startActivity(makeThisBirthdayCard);
                }
            }
        });
    }

}
