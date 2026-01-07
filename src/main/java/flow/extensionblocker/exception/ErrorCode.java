package flow.extensionblocker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 커스텀 확장자 관리
    EXTENSION_LENGTH_EXCEEDED(400, "확장자는 최대 20자까지 가능합니다."),
    EXTENSION_LIMIT_EXCEEDED(400, "커스텀 확장자는 최대 200개까지 등록 가능합니다."),
    DUPLICATE_EXTENSION(409, "이미 등록된 확장자입니다."),

    // 파일 업로드 검사
    BLOCKED_EXTENSION(400, "차단된 확장자입니다. 파일 업로드가 제한됩니다."),
    INVALID_EXTENSION(400, "확장자를 확인할 수 없는 파일입니다."),
    FILE_SIZE_EXCEEDED(400, "파일 크기가 허용된 최대 용량을 초과했습니다."),

    // 공통
    INVALID_REQUEST(400, "잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류가 발생했습니다.");

    private final int status;
    private final String message;
}
