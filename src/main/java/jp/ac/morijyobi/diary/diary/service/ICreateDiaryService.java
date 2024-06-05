package jp.ac.morijyobi.diary.diary.service;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;
import jp.ac.morijyobi.diary.diary.bean.form.CreateDiaryForm;

public interface ICreateDiaryService {
    public Diary execute(final CreateDiaryForm createDiaryForm);
}
