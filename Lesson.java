package com.example.mephi;

public class Lesson {
    private long id;
    private String period;
    private int wday;
    private String started_time_string;
    private String finished_time_string;
    private String room_name;
    private String course_name;
    private String short_lesson_type;
    private String tutor;

    public Lesson(long id, String period, int wday, String started_time_string, String finished_time_string, String room_name, String course_name, String short_lesson_type, String tutor) {
        this.id = id;               //id
        this.period = period;       //human_period
        this.wday = wday;           //wday
        this.started_time_string = started_time_string;         //started_time_string
        this.finished_time_string = finished_time_string;       //finished_time_string
        this.room_name = room_name;         //room_name
        this.course_name = course_name;     //course)name
        this.short_lesson_type = short_lesson_type;     //short_lesson_type
        this.tutor = tutor;         //tutor
    }

    public long getId() {
        return id;
    }

    public String getPeriod() {
        return period;
    }

    public int getWday() {
        return wday;
    }

    public String getStarted_time_string() {
        return started_time_string;
    }

    public String getFinished_time_string() {
        return finished_time_string;
    }

    public String getRoom_name() {
        return room_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getShort_lesson_type() {
        return short_lesson_type;
    }

    public String getTutor() {
        return tutor;
    }
}
