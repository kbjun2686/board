package com.sparta.memo.service;

import com.sparta.memo.dto.CheckPasswordDto;
import com.sparta.memo.model.Memo;
import com.sparta.memo.repository.MemoRepository;
import com.sparta.memo.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional // 업데이트시 db에 반영되도록 해줌
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
    @Transactional
    public Boolean checkpasswordDto(Long id, CheckPasswordDto checkpasswordDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("값이 존재하지 않습니다 ")
        );
        if (memo.getPassword().equals(checkpasswordDto.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
