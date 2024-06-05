package jp.ac.morijyobi.diary.diary.controller;

import jp.ac.morijyobi.diary.diary.bean.input.CreateDiaryInput;
import jp.ac.morijyobi.diary.diary.service.ICreateDiaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/create")
public class CreateDiaryController {
    private final ICreateDiaryService createDiaryService;

    public CreateDiaryController(final ICreateDiaryService createDiaryService) {
        this.createDiaryService = createDiaryService;
    }

    @GetMapping("")
    public String get(
            @RequestParam LocalDate currentDate,
            final Model model) {
        final var createDiaryInput = new CreateDiaryInput("", "", currentDate);

        model.addAttribute("createDiaryInput", createDiaryInput);
        return "create";
    }

    @PostMapping("")
    public String post(
            final @Validated CreateDiaryInput createDiaryInput,
            final BindingResult bindingResult,
            final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) return "create";

        createDiaryService.execute(createDiaryInput);

        redirectAttributes.addAttribute("year", createDiaryInput.date().getYear());
        redirectAttributes.addAttribute("monthValue", createDiaryInput.date().getMonthValue());
        return "redirect:/list";
    }
}
