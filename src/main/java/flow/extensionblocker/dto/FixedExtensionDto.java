package flow.extensionblocker.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FixedExtensionDto {
    private Long id;
    private Boolean blocked;
}
