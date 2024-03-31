package ait.imagga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private ResultDto result;
    private StatusDto status;

    @Override
    public String toString() {
        return "ResponseDto{" +
                "result=" + result +
                '}';
    }
}
