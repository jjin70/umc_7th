package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Review;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    private Long id;
    private Float score;
    private String body;
    private Long memberId;
    private Long storeId;

    public static ReviewResponseDTO from(Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getScore(),
                review.getBody(),
                review.getMember().getId(),
                review.getStore().getId()
        );
    }
}