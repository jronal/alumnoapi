package com.encora.util;

import com.encora.model.WrapperResponseDTO;
import org.springframework.http.HttpStatus;

public class WrapperResponseUtil {

    public static WrapperResponseDTO responseOK(HttpStatus status, String msgStatus) {
        return WrapperResponseDTO.builder()
                .status(msgStatus)
                .statusCode(status.value())
                .build();
    }

}
