package com.example.base_spring_boot.models.dtos.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DataRes<T>
{
    private HttpStatus status;
    private int code;
    private T data;
}