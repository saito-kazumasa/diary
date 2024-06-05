package jp.ac.morijyobi.diary.diary.service.implement;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;
import jp.ac.morijyobi.diary.diary.mapper.IDiaryMapper;
import jp.ac.morijyobi.diary.diary.service.IReadDiaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReadDiaryService implements IReadDiaryService {
    private final IDiaryMapper diaryMapper;

    public ReadDiaryService(final IDiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public List<Diary> executeByYearAndMonth(final LocalDate date) {
        final var startDate = LocalDate.of(date.getYear(), date.getMonth(), 1);
        final var endDate = LocalDate.of(date.getYear(), date.getMonth(), date.lengthOfMonth());

        return diaryMapper.selectByDate(startDate, endDate);
    }
}
