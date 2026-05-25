package com.study.Study.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PaginatedResponse<T> {
    private int page;
    private int per_page;
    private long total;
    private int total_pages;
    private List<T> data;
}
