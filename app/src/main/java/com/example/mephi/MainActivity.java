package com.example.mephi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private final int MARGIN_BETWEEN_BLOCKS = 25;
    private final int MARGIN_SIDES = 40;
    private int prevId = 0;
    private int topMargin = MARGIN_BETWEEN_BLOCKS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dateText = findViewById(R.id.date);
        dateText.setText(getCurrentDate());
    }

    public void toTimeTable(View view) {}

    public void toNotes(View view) {
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }

    public void toGroups(View view) {
        Intent intent = new Intent(this, Groups.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void getLesson(View view) throws IOException, JSONException {
        IDataHandler dataHandler = new LocalHandler();

        Lesson lesson = dataHandler.receiveLesson(this);
        RelativeLayout lessonsLayout = findViewById(R.id.lessons_info);
        LinearLayout lessonBlock = new LinearLayout(this);
        TextView timeView = new TextView(this);
        TextView lessonNameView = new TextView(this);
        TextView roomNameView = new TextView(this);
        TextView tutorNameView = new TextView(this);

        RelativeLayout.LayoutParams recordParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams lessonBlockParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lessonBlockParams.setMargins(MARGIN_SIDES, topMargin, MARGIN_SIDES, 0);

        if (prevId != 0) {
            topMargin += findViewById(prevId).getHeight() + MARGIN_BETWEEN_BLOCKS;
            lessonBlockParams.setMargins(MARGIN_SIDES, topMargin, MARGIN_SIDES, 0);
        }
        lessonsLayout.addView(lessonBlock, lessonBlockParams);
        lessonBlock.setId(LinearLayout.generateViewId());
        prevId = lessonBlock.getId();

        lessonBlock.setOrientation(LinearLayout.VERTICAL);
        lessonBlock.setBackgroundColor(getResources().getColor(R.color.grey));

        lessonBlock.addView(timeView, recordParams);
        lessonBlock.addView(lessonNameView, recordParams);
        lessonBlock.addView(roomNameView, recordParams);
        lessonBlock.addView(tutorNameView, recordParams);

        timeView.setText(lesson.getStarted_time_string() + " - "  + lesson.getFinished_time_string());
        lessonNameView.setText(lesson.getCourse_name());
        roomNameView.setText(lesson.getRoom_name());
        tutorNameView.setText(lesson.getTutor());

        timeView.setTextSize(35);
        lessonNameView.setTextSize(20);
        roomNameView.setTextSize(20);
        tutorNameView.setTextSize(20);

    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String weekDay = sdf.format(new Date());

        switch (weekDay) {
            case ("Mon"):
                weekDay = "Понедельник";
                break;
            case ("Tue"):
                weekDay = "Вторник";
                break;
            case ("Wed"):
                weekDay = "Среда";
                break;
            case ("Thu"):
                weekDay = "Четверг";
                break;
            case ("Fri"):
                weekDay = "Пятница";
                break;
            case ("Sat"):
                weekDay = "Суббота";
                break;
            case ("Sun"):
                weekDay = "Воскресенье";
                break;
        }
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(new Date());
        date = weekDay + ", " + date;

        return date;
    }
}
