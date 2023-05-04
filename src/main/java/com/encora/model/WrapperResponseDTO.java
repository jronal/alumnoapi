package com.encora.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class WrapperResponseDTO {

    private String status;
    private int statusCode;
    private Object data;
    private ErrorResponseDTO error;

}
