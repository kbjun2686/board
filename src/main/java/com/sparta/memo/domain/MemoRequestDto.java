package com.sparta.memo.domain;


import lombok.Getter;

@Getter
    public class MemoRequestDto {
        private Long password;
        private String title;
        private String username;
        private String contents;
        private Boolean result;
}
