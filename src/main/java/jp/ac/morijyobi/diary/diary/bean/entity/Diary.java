package jp.ac.morijyobi.diary.diary.bean.entity;

import java.time.LocalDate;

public class Diary {
    private int id;
    private final String title;
    private final String content;
    private final LocalDate date;

    public Diary(int id, String title, String content, LocalDate date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public static Diary empty() {
        return new Diary(-1, "", "", LocalDate.now());
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }
}
