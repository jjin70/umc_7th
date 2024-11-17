package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {

    private Float score;
    private String body;

    public Review toEntity(Member member, Store store) {
        return Review.builder()
                .member(member)
                .store(store)
                .score(score)
                .body(body)
                .build();
    }
}
