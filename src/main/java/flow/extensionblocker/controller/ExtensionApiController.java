package flow.extensionblocker.controller;

import flow.extensionblocker.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/extensions")
public class ExtensionApiController {

    private final ExtensionService extensionService;
}
