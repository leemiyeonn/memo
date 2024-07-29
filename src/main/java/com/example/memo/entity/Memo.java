package com.example.memo.entity;

import com.example.memo.dto.MemoRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String contents;

    public static Memo fromDto(MemoRequestDto requestDto) {
        Memo memo = new Memo();
        memo.setUsername(requestDto.getUsername());
        memo.setContents(requestDto.getContents());
        return memo;
    }
}
