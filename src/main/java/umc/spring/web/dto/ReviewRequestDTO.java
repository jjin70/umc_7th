package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "널이어서는 안 됩니다.")
    private Float score;
    @Size(min = 5, max = 30, message = "5자 이상, 30자 이하이어야 합니다.")
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
