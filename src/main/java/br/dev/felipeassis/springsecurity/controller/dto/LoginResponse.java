package br.dev.felipeassis.springsecurity.controller.dto;

public record LoginResponse(String accessToken, Long expiresIm) {
}
