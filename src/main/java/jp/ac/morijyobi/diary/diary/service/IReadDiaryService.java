package jp.ac.morijyobi.diary.diary.service;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;

import java.time.LocalDate;
import java.util.List;

public interface IReadDiaryService {
    public Diary executeById(final int id);
    public List<Diary> executeByYearAndMonth(final LocalDate date);
}
