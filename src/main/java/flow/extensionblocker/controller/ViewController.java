package flow.extensionblocker.controller;

import flow.extensionblocker.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final ExtensionService extensionService;

    @GetMapping("/")
    public String page(Model model) {
        model.addAttribute("fixedList", extensionService.getFixedExtensionList());
        model.addAttribute("customList", extensionService.getCustomExtensionList());
        return "extension";
    }

}
