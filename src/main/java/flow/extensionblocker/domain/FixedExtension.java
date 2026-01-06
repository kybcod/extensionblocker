package flow.extensionblocker.domain;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FixedExtension {
    private Long id;
    private String extension;
    private String blocked;
}
