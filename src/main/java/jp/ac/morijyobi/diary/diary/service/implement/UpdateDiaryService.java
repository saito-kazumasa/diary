package jp.ac.morijyobi.diary.diary.service.implement;

import jp.ac.morijyobi.diary.diary.bean.input.DetailDiaryInput;
import jp.ac.morijyobi.diary.diary.mapper.IDiaryMapper;
import jp.ac.morijyobi.diary.diary.service.IUpdateDiaryService;
import org.springframework.stereotype.Service;

@Service
public class UpdateDiaryService implements IUpdateDiaryService {
    private final IDiaryMapper diaryMapper;

    public UpdateDiaryService(final IDiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public int execute(final DetailDiaryInput detailDiaryInput) {
        final var diary = detailDiaryInput.toDiary();
        return diaryMapper.update(diary);
    }
}
