package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewListResponseDTO {
    private List<ReviewResponseDTO> reviewList;
    private Integer listSize;
    private Integer totalPage;
    private Long totalElements;
    private Boolean isFirst;
    private Boolean isLast;

    public static ReviewListResponseDTO from(Page<Review> reviewList) {
        List<ReviewResponseDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewResponseDTO::from)
                .collect(Collectors.toList());

        return ReviewListResponseDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
