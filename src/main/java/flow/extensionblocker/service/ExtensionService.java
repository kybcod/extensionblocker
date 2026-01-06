package flow.extensionblocker.service;

import flow.extensionblocker.domain.CustomExtension;
import flow.extensionblocker.domain.FixedExtension;
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
}
