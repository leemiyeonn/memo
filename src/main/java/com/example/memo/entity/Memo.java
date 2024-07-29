package com.example.memo.entity;

import com.example.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Memo {
    private Long id;
    private String username;
    private String contents;

    public static Memo fromDto(MemoRequestDto requestDto) {
        Memo memo = new Memo();
        memo.setUsername(requestDto.getUsername());
        memo.setContents(requestDto.getContents());
        return memo;
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
