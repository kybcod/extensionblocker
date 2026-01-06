package flow.extensionblocker.controller;

import flow.extensionblocker.dto.CustomExtensionDto;
import flow.extensionblocker.dto.FixedExtensionDto;
import flow.extensionblocker.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/extension")
public class ExtensionApiController {

    private final ExtensionService extensionService;

    @PostMapping("/checked")
    public void updateFixedChecked(FixedExtensionDto fixedExtensionDto) {
        extensionService.updateFixedChecked(fixedExtensionDto);
    }

    @PostMapping("/add")
    public void addCustom(CustomExtensionDto customExtensionDto) {
        extensionService.addCustom(customExtensionDto);
    }
}
