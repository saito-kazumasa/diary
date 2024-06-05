package jp.ac.morijyobi.diary.diary.service.implement;

import jp.ac.morijyobi.diary.diary.bean.input.CreateDiaryInput;
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
    public void execute(final CreateDiaryInput createDiaryInput) {
        final var diary = createDiaryInput.toDiary();
        diaryMapper.insert(diary);
    }
}
