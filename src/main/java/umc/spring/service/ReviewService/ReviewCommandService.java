package umc.spring.service.ReviewService;

import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public interface ReviewCommandService {

    ReviewResponseDTO createReview(Long memberId, Long storeId, ReviewRequestDTO request);
}
