package jp.ac.morijyobi.diary.diary.bean.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.ac.morijyobi.diary.diary.bean.entity.Diary;

import java.time.LocalDate;

public record DiaryForm(
        @NotEmpty @Size(max = 255) String title,
        @NotEmpty @Size(max = 400) String content,
        @NotNull LocalDate date) {
    public static DiaryForm empty() {
        return new DiaryForm("", "", LocalDate.now());
    }

    public Diary toDiary() {
        return new Diary(
                -1,
                title,
                content,
                date
        );
    }
}
