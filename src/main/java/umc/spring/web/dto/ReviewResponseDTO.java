package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Review;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    private String storeName;
    private String nickName;
    private Float score;
    private String body;
    private LocalDate createdAt;

    public static ReviewResponseDTO from(Review review) {
        return ReviewResponseDTO.builder()
                .storeName(review.getStore().getName())
                .nickName(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
}