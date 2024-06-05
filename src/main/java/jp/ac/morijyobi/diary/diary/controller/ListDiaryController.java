package jp.ac.morijyobi.diary.diary.controller;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;
import jp.ac.morijyobi.diary.diary.service.IReadDiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping({"/", "/index", "/list"})
public class ListDiaryController {
    private final IReadDiaryService readDiaryService;

    public ListDiaryController(final IReadDiaryService readDiaryService) {
        this.readDiaryService = readDiaryService;
    }

    @GetMapping("")
    public String get(final Model model) {
        final var currentDate = LocalDate.now();
        final List<Diary> diaries = readDiaryService.executeByYearAndMonth(currentDate);

        model.addAttribute("currentDate", currentDate);
        model.addAttribute("diaries", diaries);
        return "list";
    }

    @GetMapping(value = "", params = {"year", "monthValue"})
    public String getByDate(
            final @RequestParam int year,
            final @RequestParam int monthValue,
            final Model model) {
        final var currentDate = LocalDate.of(year, monthValue, 1);
        final List<Diary> diaries = readDiaryService.executeByYearAndMonth(currentDate);

        model.addAttribute("currentDate", currentDate);
        model.addAttribute("diaries", diaries);
        return "list";
    }

    @PostMapping("/list")
    public String post(
            final @RequestParam int year,
            final @RequestParam int monthValue,
            final Model model) {
        final var currentDate = LocalDate.of(year, monthValue, 1);
        final List<Diary> diaries = readDiaryService.executeByYearAndMonth(currentDate);

        model.addAttribute("currentDate", currentDate);
        model.addAttribute("diaries", diaries);
        return "list";
    }
}
