package jp.ac.morijyobi.diary.diary.service;

import jp.ac.morijyobi.diary.diary.bean.input.CreateDiaryInput;

public interface ICreateDiaryService {
    public void execute(final CreateDiaryInput diaryForm);
}
