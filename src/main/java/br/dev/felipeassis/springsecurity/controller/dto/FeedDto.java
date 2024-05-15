package br.dev.felipeassis.springsecurity.controller.dto;

import java.util.List;

public record FeedDto(List<FeedItemDto> feedItems,
                      int page,
                      int pageSize,
                      long totalElements) {
}
