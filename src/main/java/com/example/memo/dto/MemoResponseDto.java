package com.example.memo.dto;

import com.example.memo.entity.Memo;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;

    public static MemoResponseDto from(Memo memo) {
        MemoResponseDto dto = new MemoResponseDto();
        dto.id = memo.getId();
        dto.username = memo.getUsername();
        dto.contents = memo.getContents();
        return dto;
    }
}
