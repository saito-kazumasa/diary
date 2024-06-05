package jp.ac.morijyobi.diary.diary.bean.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.ac.morijyobi.diary.diary.bean.entity.Diary;

import java.time.LocalDate;

public record DetailDiaryInput(
        @Min(1) int id,
        @NotEmpty @Size(max = 255) String title,
        @NotEmpty @Size(max = 400) String content,
        @NotNull LocalDate date) {
    public static DetailDiaryInput createDetailDiaryInput(final Diary diary) {
        return new DetailDiaryInput(
                diary.getId(),
                diary.getTitle(),
                diary.getContent(),
                diary.getDate()
        );
    }

    public Diary toDiary() {
        return new Diary(
                id,
                title,
                content,
                date
        );
    }
}
