
package com.tasktrackr.tasktrackr.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private String field;
    private int status;
}