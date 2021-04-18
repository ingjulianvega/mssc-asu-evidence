package ingjulianvega.ximic.msscasuevidence.exception;

import lombok.Getter;

@Getter
public class EvidenceException extends RuntimeException {

    private final String code;

    public EvidenceException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

