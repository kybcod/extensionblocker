package flow.extensionblocker.mapper;

import flow.extensionblocker.domain.FixedExtension;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FixedExtensionMapper {
    List<FixedExtension> selectAll();

    void updateFixedBlocked(Long id, String blocked);

    int existsFixedByExtension(String extension);

    int existsBlockedExtension(String extension);
}
