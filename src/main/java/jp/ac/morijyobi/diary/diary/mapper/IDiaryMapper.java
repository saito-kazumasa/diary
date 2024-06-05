package jp.ac.morijyobi.diary.diary.mapper;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface IDiaryMapper {
    @Insert("insert into diary (title, content, date) " +
            "values (#{title}, #{content}, #{date})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(final Diary diary);

    @Select("select * from diary " +
            "where date between #{startDate} and #{endDate} " +
            "order by date")
    public List<Diary> selectByDate(final LocalDate startDate, final LocalDate endDate);
}
