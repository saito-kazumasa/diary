package jp.ac.morijyobi.diary.diary.controller;

import jp.ac.morijyobi.diary.diary.bean.entity.Diary;
import jp.ac.morijyobi.diary.diary.bean.input.DetailDiaryInput;
import jp.ac.morijyobi.diary.diary.service.IDeleteDiaryService;
import jp.ac.morijyobi.diary.diary.service.IReadDiaryService;
import jp.ac.morijyobi.diary.diary.service.IUpdateDiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/detail")
public class DetailController {
    private final IReadDiaryService readDiaryService;
    private final IUpdateDiaryService updateDiaryService;
    private final IDeleteDiaryService deleteDiaryService;

    public DetailController(
            final IReadDiaryService readDiaryService,
            final IUpdateDiaryService updateDiaryService,
            final IDeleteDiaryService deleteDiaryService) {
        this.readDiaryService = readDiaryService;
        this.updateDiaryService = updateDiaryService;
        this.deleteDiaryService = deleteDiaryService;
    }

    @GetMapping("")
    public String get(
            @RequestParam int id,
            Model model) {
        final Diary diary = readDiaryService.executeById(id);
        final DetailDiaryInput detailDiaryInput = DetailDiaryInput.createDetailDiaryInput(diary);

        model.addAttribute("detailDiaryInput", detailDiaryInput);
        return "detail";
    }

    @PostMapping(value = "", params = "edit")
    public String postEdit(
            final @Validated DetailDiaryInput detailDiaryInput,
            final BindingResult bindingResult,
            final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) return "detail";

        updateDiaryService.execute(detailDiaryInput);

        redirectAttributes.addAttribute("id", detailDiaryInput.id());
        return "redirect:/detail";
    }

    @PostMapping(value = "", params = "delete")
    public String postDelete(
            final @Validated DetailDiaryInput detailDiaryInput,
            final RedirectAttributes redirectAttributes) {
        deleteDiaryService.execute(detailDiaryInput.id());

        redirectAttributes.addAttribute("year", detailDiaryInput.date().getYear());
        redirectAttributes.addAttribute("monthValue", detailDiaryInput.date().getMonthValue());
        return "redirect:/list";
    }
}
