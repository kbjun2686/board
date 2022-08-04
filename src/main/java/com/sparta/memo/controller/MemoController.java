package com.sparta.memo.controller;

import com.sparta.memo.dto.CheckPasswordDto;
import com.sparta.memo.model.Memo;
import com.sparta.memo.repository.MemoRepository;
import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // 메모 신규 생성하기
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    // 메모 수정하기
    @PutMapping("/api/memos/{id}")
    public long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    // 메모 조회하기
    @GetMapping("/api/memos")
    public List<Memo> readMemo() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    // 메모 삭제하기
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    //비밀번호 비교
    @PostMapping("/api/memos/password")
    public Boolean comparePwd(@RequestBody CheckPasswordDto checkPasswordDto){

        return memoService.checkpasswordDto(checkPasswordDto.getId(), checkPasswordDto); //true or false

    }
}