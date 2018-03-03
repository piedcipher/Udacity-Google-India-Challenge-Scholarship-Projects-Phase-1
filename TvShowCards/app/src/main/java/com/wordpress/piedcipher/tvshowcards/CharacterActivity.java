package com.wordpress.piedcipher.tvshowcards;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
public class CharacterActivity extends AppCompatActivity {

    public String primaryColor = "", primaryColorDark = "";
    public String[] tvShowCharacterName = new String[11];
    public String[] tvShowCharacterQuote = new String[11];
    public String[] tvShowCharacterWork = new String[11];
    public int[] tvShowCharacterImage = new int[11];
    public String[] tvShowCharacterPrimaryColor = new String[11];
    public String[] tvShowCharacterPrimaryColorDark = new String[11];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        Bundle tvShowData = getIntent().getExtras();
        String thisTvShow = tvShowData.getString("tvShow");
        LinearLayout charatersListLinearLayout = findViewById(R.id.charaters_list_LinearLayout);
        TextView characterTextView;
        View horizontalDivier;

        setTitle(thisTvShow);
        whichShow(thisTvShow);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primaryColor)));
        getWindow().setStatusBarColor(Color.parseColor(primaryColorDark));
        Intent sendCharacterData = new Intent(getApplicationContext(), CardActivity.class);

        for(int index = 0; index < tvShowCharacterName.length; index++) {

            if(tvShowCharacterName[index].isEmpty()) break;

            characterTextView = new TextView(getApplicationContext());
            horizontalDivier = new View(getApplicationContext());

            characterTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            characterTextView.setTextSize(28);
            characterTextView.setId(index);
            characterTextView.setClickable(true);
            characterTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            characterTextView.setText(tvShowCharacterName[index]);
            characterTextView.setPadding(8, 12, 8, 12);
            charatersListLinearLayout.addView(characterTextView);

            horizontalDivier.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
            horizontalDivier.setBackgroundColor(Color.parseColor("#424242"));
            charatersListLinearLayout.addView(horizontalDivier);

            characterTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendCharacterData = new Intent(getApplicationContext(), CardActivity.class);

                    sendCharacterData.putExtra("characterQuote", tvShowCharacterQuote[v.getId()]);
                    sendCharacterData.putExtra("characterName", tvShowCharacterName[v.getId()]);
                    sendCharacterData.putExtra("characterWork", tvShowCharacterWork[v.getId()]);
                    sendCharacterData.putExtra("characterImage",tvShowCharacterImage[v.getId()]);
                    sendCharacterData.putExtra("characterPrimaryColor", tvShowCharacterPrimaryColor[v.getId()]);
                    sendCharacterData.putExtra("characterPrimaryColorDark", tvShowCharacterPrimaryColorDark[v.getId()]);

                    startActivity(sendCharacterData);
                }
            });
        }
    }

    public void whichShow (String thisTvShow) {
        switch (thisTvShow) {
            case "Silicon Valley":
                primaryColor = "#4CAF50";
                primaryColorDark = "#2E7D32";

                tvShowCharacterName[0] = "Richard Hendriks";
                tvShowCharacterQuote[0] = "\"I always knew I was missing something, and then when someone explained the concept of ‘game’ I remember very distinctly thinking ‘That’s what I don’t have.\"";
                tvShowCharacterWork[0] = "Pied Piper";
                tvShowCharacterImage[0] = R.drawable.character_silicon_valley_richard_hendriks;
                tvShowCharacterPrimaryColor[0] = "#4CAF50";
                tvShowCharacterPrimaryColorDark[0] = "#2E7D32";

                tvShowCharacterName[1] = "Erlich Bachman";
                tvShowCharacterQuote[1] = "\"Ask me what 9 times F is. It's fleventy-five\"";
                tvShowCharacterWork[1] = "Pied Piper";
                tvShowCharacterImage[1] = R.drawable.character_silicon_valley_erlich_bachman;
                tvShowCharacterPrimaryColor[1] = "#4CAF50";
                tvShowCharacterPrimaryColorDark[1] = "#2E7D32";

                tvShowCharacterName[2] = "Nelson Bighetti";
                tvShowCharacterQuote[2] = "\"Peter Gregory demanded a lean, ruthless business plan. And I don't think that the CEO of Microsoft has a paid best friend.\"";
                tvShowCharacterWork[2] = "Pied Piper";
                tvShowCharacterImage[2] = R.drawable.character_silicon_valley_nelson_bighetti;
                tvShowCharacterPrimaryColor[2] = "#009688";
                tvShowCharacterPrimaryColorDark[2] = "#00695C";

                tvShowCharacterName[3] = "Bertram Gilfoyle";
                tvShowCharacterQuote[3] = "\"What do I do? System Architecture. Networking and Security. No one in this house can touch me on that. But does anyone appreciate that? While you were busy minoring in gender studies and singing acapella at Sarah Lawrence, I was getting root access to NSA servers. I was a click away from starting a second Iranian revolution. I prevent cross site scripting, I monitor for DDoS attacks, emergency database rollbacks, and faulty transaction handlings. The internet, heard of it? Transfers half a petabyte of data a minute, do you have any idea how that happens? All of those YouTube ones and zeros streaming directly to your tiny little smart phone day after day. Every person who wear his pants if he can't get the new dubstep Skrillex remix in under 12 seconds. It's not magic, it's talent and sweat. People like me ensuring your packets get delivered unsniffed. So what do I do? I make sure that one bad config on one key component doesn't bankrupt the entire company. That's what I do.\"";
                tvShowCharacterWork[3] = "Pied Piper";
                tvShowCharacterImage[3] = R.drawable.character_silicon_valley_bertram_gilfoyle;
                tvShowCharacterPrimaryColor[3] = "#673AB7";
                tvShowCharacterPrimaryColorDark[3] = "#4527A0";

                tvShowCharacterName[4] = "Dinesh Chugtai";
                tvShowCharacterQuote[4] = "\"PlaceHolder would honestly be a better name than Pied Piper.\"";
                tvShowCharacterWork[4] = "Pied Piper";
                tvShowCharacterImage[4] = R.drawable.character_silicon_valley_dinesh_chugtai;
                tvShowCharacterPrimaryColor[4] = "#795548";
                tvShowCharacterPrimaryColorDark[4] = "#4E342E";

                tvShowCharacterName[5] = "Monica Hall";
                tvShowCharacterQuote[5] = "\"Yeah, that's nothing. Peter would spend millions just to mildly annoy Gavin. These are billionaires, Richard. Annoying each other means more to them than we'll make in a lifetime.\"";
                tvShowCharacterWork[5] = "Raviga";
                tvShowCharacterImage[5] = R.drawable.character_silicon_valley_monica_hall;
                tvShowCharacterPrimaryColor[5] = "#9C27B0";
                tvShowCharacterPrimaryColorDark[5] = "#6A1B9A";

                tvShowCharacterName[6] = "Jared Dunn";
                tvShowCharacterQuote[6] = "\"Sorry if I scared you; I know I have slightly ghost-like features.\"";
                tvShowCharacterWork[6] = "Pied Piper";
                tvShowCharacterImage[6] = R.drawable.character_silicon_valley_jared_dunn;
                tvShowCharacterPrimaryColor[6] = "#FFC107";
                tvShowCharacterPrimaryColorDark[6] = "#FF8F00";

                tvShowCharacterName[7] = "Laurie Bream";
                tvShowCharacterQuote[7] = "\"Dress unattractively when you tell them. I read a study. The less sexual interest they feel for you, the less perturbing it will be. It sounds strange, but it's credible.\"";
                tvShowCharacterWork[7] = "Raviga";
                tvShowCharacterImage[7] = R.drawable.character_silicon_valley_laurie_bream;
                tvShowCharacterPrimaryColor[7] = "#F44336";
                tvShowCharacterPrimaryColorDark[7] = "#C62828";

                tvShowCharacterName[8] = "Gavin Belson";
                tvShowCharacterQuote[8] = "\"It's weird. They always travel in groups of five. These programmers, there's always a tall, skinny white guy; short, skinny Asian guy; fat guy with a ponytail; some guy with crazy facial hair; and then an East Indian guy. It's like they trade guys until they all have the right group.\"";
                tvShowCharacterWork[8] = "Hoolie";
                tvShowCharacterImage[8] = R.drawable.character_silicon_valley_gavin_belson;
                tvShowCharacterPrimaryColor[8] = "#03A9F4";
                tvShowCharacterPrimaryColorDark[8] = "#0277BD";

                tvShowCharacterName[9] = "Jian Yang";
                tvShowCharacterQuote[9] = "\"Yes. I eat the fish.\"";
                tvShowCharacterWork[9] = "Seefood";
                tvShowCharacterImage[9] = R.drawable.character_silicon_valley_jian_yang;
                tvShowCharacterPrimaryColor[9] = "#00BCD4";
                tvShowCharacterPrimaryColorDark[9] = "#00838F";

                tvShowCharacterName[10] = "Russ Hanneman";
                tvShowCharacterQuote[10] = "\"I think we need to talk about getting some shwaaaaaaaaag.\"";
                tvShowCharacterWork[10] = "Radio on the Internet";
                tvShowCharacterImage[10] = R.drawable.character_silicon_valley_russ_hanneman;
                tvShowCharacterPrimaryColor[10] = "#673AB7";
                tvShowCharacterPrimaryColorDark[10] = "#4527A0";

                break;

            case "Death Note":
                primaryColor = "#607D8B";
                primaryColorDark = "#37474F";

                tvShowCharacterName[0] = "Light Yagami";
                tvShowCharacterQuote[0] = "\"I'm going to make the world know I'm here… that somebody is passing righteous judgement on them.\"";
                tvShowCharacterWork[0] = "Kira";
                tvShowCharacterImage[0] = R.drawable.character_death_note_light_yagami;
                tvShowCharacterPrimaryColor[0] = "#F44336";
                tvShowCharacterPrimaryColorDark[0] = "#C62828";

                tvShowCharacterName[1] = "Touta Matsuda";
                tvShowCharacterQuote[1] = "\"You drove your own father to his death...and now you're saying we are the fools?!\"";
                tvShowCharacterWork[1] = "Kira Investigation Team";
                tvShowCharacterImage[1] = R.drawable.character_death_note_touta_matsuda;
                tvShowCharacterPrimaryColor[1] = "#8BC34A";
                tvShowCharacterPrimaryColorDark[1] = "#558B2F";

                tvShowCharacterName[2] = "Shuichi Aizawa";
                tvShowCharacterQuote[2] = "\"Matsuda, you idiot!\"";
                tvShowCharacterWork[2] = "Kira Investigation Team";
                tvShowCharacterImage[2] = R.drawable.character_death_note_shuichi_aizawa;
                tvShowCharacterPrimaryColor[2] = "#CDDC39";
                tvShowCharacterPrimaryColorDark[2] = "#9E9D24";

                tvShowCharacterName[3] = "Ryuk";
                tvShowCharacterQuote[3] = "\"Humans are interesting!\"";
                tvShowCharacterWork[3] = "Shinigami Realm";
                tvShowCharacterImage[3] = R.drawable.character_death_note_ryuk;
                tvShowCharacterPrimaryColor[3] = "#795548";
                tvShowCharacterPrimaryColorDark[3] = "#4E342E";

                tvShowCharacterName[4] = "L";
                tvShowCharacterQuote[4] = "\"Kira is childish and he hates losing… I'm also childish and hate losing.\"";
                tvShowCharacterWork[4] = "Greatest Detective";
                tvShowCharacterImage[4] = R.drawable.character_death_note_l;
                tvShowCharacterPrimaryColor[4] = "#607D8B";
                tvShowCharacterPrimaryColorDark[4] = "#37474F";

                tvShowCharacterName[5] = "Soichiro Yagami";
                tvShowCharacterQuote[5] = "\"Only those who are ready and willing to sacrifice everything and fight, who are truly committed to stopping this psychopath… are asked to remain. I'll find out who you are when I return at five o'clock from my meeting upstairs.\"";
                tvShowCharacterWork[5] = "Kira Investigation Team";
                tvShowCharacterImage[5] = R.drawable.character_death_note_soichiro_yagami;
                tvShowCharacterPrimaryColor[5] = "#009688";
                tvShowCharacterPrimaryColorDark[5] = "#00695C";

                tvShowCharacterName[6] = "Misa Amane";
                tvShowCharacterQuote[6] = "\"I hate evil and love justice. I do not consider the police as my enemies, but my allies against evil.\"";
                tvShowCharacterWork[6] = "Kira";
                tvShowCharacterImage[6] = R.drawable.character_death_note_misa_amane;
                tvShowCharacterPrimaryColor[6] = "#E91E63";
                tvShowCharacterPrimaryColorDark[6] = "#AD1457";

                tvShowCharacterName[7] = "Watari";
                tvShowCharacterQuote[7] = "I am Watari";
                tvShowCharacterWork[7] = "Kira Investigation Team";
                tvShowCharacterImage[7] = R.drawable.character_death_note_watari;
                tvShowCharacterPrimaryColor[7] = "#9E9E9E";
                tvShowCharacterPrimaryColorDark[7] = "#424242";

                tvShowCharacterName[8] = "Rem";
                tvShowCharacterQuote[8] = "\"Light…he can even kill a Shinigami; he has surpassed us.\"";
                tvShowCharacterWork[8] = "Shinigami Realm";
                tvShowCharacterImage[8] = R.drawable.character_death_note_rem;
                tvShowCharacterPrimaryColor[8] = "#607D8B";
                tvShowCharacterPrimaryColorDark[8] = "#37474F";

                tvShowCharacterName[9] = "Near";
                tvShowCharacterQuote[9] = "\"If you can't win the game, if you can't solve the puzzle, you're nothing but a loser.\"";
                tvShowCharacterWork[9] = "SPK";
                tvShowCharacterImage[9] = R.drawable.character_death_note_near;
                tvShowCharacterPrimaryColor[9] = "#9E9E9E";
                tvShowCharacterPrimaryColorDark[9] = "#424242";

                tvShowCharacterName[10] = "Mello";
                tvShowCharacterQuote[10] = "\"In the end there is no greater motivation than revenge.\"";
                tvShowCharacterWork[10] = "American Mafia";
                tvShowCharacterImage[10] = R.drawable.character_death_note_mello;
                tvShowCharacterPrimaryColor[10] = "#FF9800";
                tvShowCharacterPrimaryColorDark[10] = "#EF6C00";
                break;

            case "F.R.I.E.N.D.S":
                primaryColor = "#8BC34A";
                primaryColorDark = "#558B2F";

                tvShowCharacterName[0] = "Rachel Green";
                tvShowCharacterQuote[0] = "\"\"";
                tvShowCharacterWork[0] = "Executive at Ralph Lauren";
                tvShowCharacterImage[0] = R.drawable.character_friends_rachel;
                tvShowCharacterPrimaryColor[0] = "#3F51B5";
                tvShowCharacterPrimaryColorDark[0] = "#283593";

                tvShowCharacterName[1] = "Monica Geller";
                tvShowCharacterQuote[1] = "\"\"";
                tvShowCharacterWork[1] = "Head Chef at Javu";
                tvShowCharacterImage[1] = R.drawable.character_friends_monica;
                tvShowCharacterPrimaryColor[1] = "#00BCD4";
                tvShowCharacterPrimaryColorDark[1] = "#00838F";

                tvShowCharacterName[2] = "Phoebe Buffay";
                tvShowCharacterQuote[2] = "\"\"";
                tvShowCharacterWork[2] = "Songwriter/Musician";
                tvShowCharacterImage[2] = R.drawable.character_friends_phoebe;
                tvShowCharacterPrimaryColor[2] = "#9C27B0";
                tvShowCharacterPrimaryColorDark[2] = "#6A1B9A";

                tvShowCharacterName[3] = "Ross Geller";
                tvShowCharacterQuote[3] = "\"\"";
                tvShowCharacterWork[3] = "Paleontologist";
                tvShowCharacterImage[3] = R.drawable.character_friends_ross;
                tvShowCharacterPrimaryColor[3] = "#2196F3";
                tvShowCharacterPrimaryColorDark[3] = "#1565C0";

                tvShowCharacterName[4] = "Chandler Bing";
                tvShowCharacterQuote[4] = "\"\"";
                tvShowCharacterWork[4] = "IT Procurement Manager";
                tvShowCharacterImage[4] = R.drawable.character_friends_chandler;
                tvShowCharacterPrimaryColor[4] = "#673AB7";
                tvShowCharacterPrimaryColorDark[4] = "#4527A0";

                tvShowCharacterName[5] = "Joey Tribbiani Jr.";
                tvShowCharacterQuote[5] = "\"\"";
                tvShowCharacterWork[5] = "Actor";
                tvShowCharacterImage[5] = R.drawable.character_friends_joey;
                tvShowCharacterPrimaryColor[5] = "#009688";
                tvShowCharacterPrimaryColorDark[5] = "#00695C";

                tvShowCharacterName[6] = tvShowCharacterName[7] = tvShowCharacterName[8] = tvShowCharacterName[9] = tvShowCharacterName[10] = "";
                break;

            case "Rick And Morty":
                primaryColor = "#8BC34A";
                primaryColorDark = "#558B2F";

                tvShowCharacterName[0] = "Rick Sanchez";
                tvShowCharacterQuote[0] = "\"I'M PICKLE RICK!!\"";
                tvShowCharacterWork[0] = "Genius Scientist";
                tvShowCharacterImage[0] = R.drawable.character_rick_and_morty_rick_sanchez;
                tvShowCharacterPrimaryColor[0] = "#8BC34A";
                tvShowCharacterPrimaryColorDark[0] = "#558B2F";

                tvShowCharacterName[1] = "Morty Smith";
                tvShowCharacterQuote[1] = "\"Oh Jeez!!\"";
                tvShowCharacterWork[1] = "Student";
                tvShowCharacterImage[1] = R.drawable.character_rick_and_morty_morty_smith;
                tvShowCharacterPrimaryColor[1] = "#3F51B5";
                tvShowCharacterPrimaryColorDark[1] = "#283593";

                tvShowCharacterName[2] = "Summer Smith";
                tvShowCharacterQuote[2] = "\"Ew, Grandpa, so gross! You're talking about my mom!\"";
                tvShowCharacterWork[2] = "Student";
                tvShowCharacterImage[2] = R.drawable.character_rick_and_morty_summer_smith;
                tvShowCharacterPrimaryColor[2] = "#E91E63";
                tvShowCharacterPrimaryColorDark[2] = "#AD1457";

                tvShowCharacterName[3] = "Beth Smith";
                tvShowCharacterQuote[3] = "\"I can finally go on that trip I've been talking about.\"";
                tvShowCharacterWork[3] = "Veterinary Surgeon";
                tvShowCharacterImage[3] = R.drawable.character_rick_and_morty_beth_smith;
                tvShowCharacterPrimaryColor[3] = "#9C27B0";
                tvShowCharacterPrimaryColorDark[3] = "#6A1B9A";

                tvShowCharacterName[4] = "Jerry Smith";
                tvShowCharacterQuote[4] = "\"Life is effort and I'll stop when I die!\"";
                tvShowCharacterWork[4] = "Federation Employment";
                tvShowCharacterImage[4] = R.drawable.character_rick_and_morty_jerry_smith;
                tvShowCharacterPrimaryColor[4] = "#795548";
                tvShowCharacterPrimaryColorDark[4] = "#4E342E";

                tvShowCharacterName[5] = tvShowCharacterName[6] = tvShowCharacterName[7] = tvShowCharacterName[8] = tvShowCharacterName[9] = tvShowCharacterName[10] = "";
                break;
        }
    }
}
