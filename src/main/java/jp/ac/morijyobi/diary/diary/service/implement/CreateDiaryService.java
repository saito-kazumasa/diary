package jp.ac.morijyobi.diary.diary.service.implement;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;
import jp.ac.morijyobi.diary.diary.bean.form.CreateDiaryForm;
import jp.ac.morijyobi.diary.diary.mapper.IDiaryMapper;
import jp.ac.morijyobi.diary.diary.service.ICreateDiaryService;
import org.springframework.stereotype.Service;

@Service
public class CreateDiaryService implements ICreateDiaryService {
    private final IDiaryMapper diaryMapper;

    public CreateDiaryService(final IDiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public Diary execute(final CreateDiaryForm createDiaryForm) {
        final var diary = createDiaryForm.toDiary();
        diaryMapper.insert(diary);
        return diary;
    }
}
