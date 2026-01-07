package flow.extensionblocker.controller;

import flow.extensionblocker.dto.CustomExtensionDto;
import flow.extensionblocker.dto.FixedExtensionDto;
import flow.extensionblocker.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/extension")
public class ExtensionApiController {

    private final ExtensionService extensionService;

    @PostMapping("/checked")
    public ResponseEntity<?> updateFixedChecked(FixedExtensionDto fixedExtensionDto) {
        extensionService.updateFixedChecked(fixedExtensionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustom(CustomExtensionDto customExtensionDto) {
        extensionService.addCustom(customExtensionDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustom(CustomExtensionDto customExtensionDto) {
        extensionService.deleteCustom(customExtensionDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        extensionService.checkFileExtension(file);
        return ResponseEntity.ok().build();
    }
}
