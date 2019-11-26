package com.example.mephi;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LocalHandler implements IDataHandler {
    public Lesson receiveLesson(Context context) throws IOException, JSONException {
        return readLessonJSONFile(context);
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Lesson readLessonJSONFile(Context context) throws IOException, JSONException {
        String jsonText = readText(context, R.raw.lesson);

        JSONObject jsonRoot = new JSONObject(jsonText);

        int id= jsonRoot.getInt("id");
        String period = jsonRoot.getString("human_period");
        int wday = jsonRoot.getInt("wday");
        String started_time_string = jsonRoot.getString("started_time_string");
        String finished_time_string = jsonRoot.getString("finished_time_string");
        String room_name = jsonRoot.getString("room_name");
        String course_name = jsonRoot.getString("course_name");
        String short_lesson_type = jsonRoot.getString("short_lesson_type");
        String tutor = jsonRoot.getString("tutor");

        return new Lesson(id, period, wday, started_time_string, finished_time_string, room_name, course_name, short_lesson_type, tutor);
    }
}
