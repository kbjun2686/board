package com.sparta.memo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자 생성
@Getter
@Entity
public class Memo extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private Long password;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String contents;

    private Boolean result;


    public Memo(Long password, String title, String username, String contents, Boolean result) {
        this.password = password;
        this.title = title;
        this.username = username;
        this.contents = contents;
        this.result= false;
    }

    public Memo(MemoRequestDto requestDto) {
        this.password = requestDto.getPassword();
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.result = false;
    }

    public void update(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
