package flow.extensionblocker.mapper;

import flow.extensionblocker.domain.CustomExtension;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomExtensionMapper {
    List<CustomExtension> selectAll();
}
