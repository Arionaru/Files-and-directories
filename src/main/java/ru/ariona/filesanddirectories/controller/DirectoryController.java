package ru.ariona.filesanddirectories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ariona.filesanddirectories.domen.Directory;
import ru.ariona.filesanddirectories.service.DirectoryService;

@Controller
public class DirectoryController {

    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @GetMapping("/")
    public String listDirs(Model model) {
        model.addAttribute("dirs",directoryService.findAll());
        return "uploadform";
    }

    @GetMapping("/{id}")
    public String listFiles(Model model, @PathVariable("id") Directory directory) {
        model.addAttribute("path",directory.getLink());
        model.addAttribute("dirs",directory.getOnlyDirs());
        model.addAttribute("files",directory.getOnlyFiles());
        return "filespage";
    }


    @PostMapping("/")
    public String handleFileUpload(@RequestParam("dir") String dir,
                                   RedirectAttributes redirectAttributes) {
        if (dir != null && !dir.isEmpty()) {
            String message = directoryService.save(dir);
            redirectAttributes.addFlashAttribute("message",message);
        } else {
            redirectAttributes.addFlashAttribute("message","Не указан путь к директории");
        }

        return "redirect:/";
    }

}
