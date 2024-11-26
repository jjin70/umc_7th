package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMemberReviewList(Long memberId, Integer page) {

        Page<Review> reviewPage = reviewRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));

        return reviewPage;
    }
}
