package flow.extensionblocker.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FixedExtension {
    private Long id;
    private String extension;
    private String blocked;
}
