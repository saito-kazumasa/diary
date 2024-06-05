package jp.ac.morijyobi.diary.diary.service.implement;

import jp.ac.morijyobi.diary.diary.mapper.IDiaryMapper;
import jp.ac.morijyobi.diary.diary.service.IDeleteDiaryService;
import org.springframework.stereotype.Service;

@Service
public class DeleteDiaryService implements IDeleteDiaryService {
    private final IDiaryMapper diaryMapper;

    public DeleteDiaryService(final IDiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    @Override
    public int execute(final int id) {
        return diaryMapper.delete(id);
    }
}
