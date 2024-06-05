package jp.ac.morijyobi.diary.diary.service;

import jp.ac.morijyobi.diary.diary.bean.input.DetailDiaryInput;

public interface IUpdateDiaryService {
    public int execute(final DetailDiaryInput detailDiaryInput);
}
