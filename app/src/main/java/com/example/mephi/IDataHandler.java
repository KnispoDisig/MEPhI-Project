package com.example.mephi;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;

public interface IDataHandler {
    Lesson receiveLesson(Context context) throws IOException, JSONException;
}
