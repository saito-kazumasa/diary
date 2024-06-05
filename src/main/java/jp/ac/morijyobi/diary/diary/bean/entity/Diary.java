package jp.ac.morijyobi.diary.diary.bean.entity;

import java.time.LocalDate;

public record Diary(int id, String title, String content, LocalDate date) {
    public static Diary empty() {
        return new Diary(-1, "", "", LocalDate.now());
    }
}
