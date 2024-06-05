package jp.ac.morijyobi.diary.diary.bean.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.ac.morijyobi.diary.diary.bean.entity.Diary;

import java.time.LocalDate;

public record CreateDiaryInput(
        @NotEmpty @Size(max = 255) String title,
        @NotEmpty @Size(max = 400) String content,
        @NotNull LocalDate date) {
    public static CreateDiaryInput empty() {
        return new CreateDiaryInput("", "", LocalDate.now());
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
