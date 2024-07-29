package com.example.memo.service;

import com.example.memo.dto.MemoRequestDto;
import com.example.memo.dto.MemoResponseDto;
import com.example.memo.entity.Memo;
import com.example.memo.repository.MemoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MemoService {
    // 멤버 변수 선언
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = Memo.fromDto(requestDto);

        // DB 저장
        Memo saveMemo = memoRepository.save(memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = MemoResponseDto.from(saveMemo);

        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회
        List<Memo> memos = memoRepository.findAll();

        // Memo -> MemoResponseDto 변환
        return memos.stream()
                .map(MemoResponseDto::from)
                .collect(Collectors.toList());
    }

    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));

        // memo 내용 수정
        memo.setContents(requestDto.getContents());

        // 수정된 내용 저장
        memoRepository.save(memo);

        return id;
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("선택한 메모는 존재하지 않습니다."));

        // memo 삭제
        memoRepository.delete(memo);

        return id;
    }
}
