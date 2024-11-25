
package com.tasktrackr.tasktrackr.common.dto;

import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorResponse {
    private String message;
    private Map<String, String> errors;
    private int status;
}