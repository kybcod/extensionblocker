package flow.extensionblocker.service;

import flow.extensionblocker.domain.CustomExtension;
import flow.extensionblocker.domain.FixedExtension;
import flow.extensionblocker.dto.CustomExtensionDto;
import flow.extensionblocker.dto.FixedExtensionDto;
import flow.extensionblocker.mapper.CustomExtensionMapper;
import flow.extensionblocker.mapper.FixedExtensionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExtensionService {

    private final FixedExtensionMapper fixedMapper;
    private final CustomExtensionMapper customMapper;

    /* 고정 확장자 전체 조회 */
    public List<FixedExtension> getFixedExtensionList() {
        return fixedMapper.selectAll();
    }

    /* 커스텀 확장자 전체 조회 */
    public List<CustomExtension> getCustomExtensionList() {
        return customMapper.selectAll();
    }

    /* 고정 확장자 : 체크유무 */
    public void updateFixedChecked(FixedExtensionDto fixedExtensionDto) {
        String blocked = fixedExtensionDto.getBlocked() ? "Y" : "N";
        fixedMapper.updateFixedBlocked(fixedExtensionDto.getId(), blocked);
    }

    /* 커스텀 확장자 추가 */
    public void addCustom(CustomExtensionDto customExtensionDto) {

        String extension = customExtensionDto.getExtension().toLowerCase().trim();

        if (extension.length() > 20)
            throw new IllegalArgumentException("20자 초과");

        if (customMapper.count() >= 200)
            throw new IllegalStateException("200개 초과");

        if (customMapper.existsCustomByExtension(extension) >= 1 || fixedMapper.existsFixedByExtension(extension) >= 1)
            throw new IllegalStateException("중복 확장자");

        customMapper.insert(extension);
    }



}
