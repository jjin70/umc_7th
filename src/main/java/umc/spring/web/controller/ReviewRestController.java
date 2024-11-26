package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.ReviewListResponseDTO;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/{memberId}/{storeId}")
    public ApiResponse<ReviewResponseDTO> createrReview(@RequestParam(name = "memberId")  Long memberId, @RequestParam(name = "storeId")  Long storeId, @RequestBody @Valid ReviewRequestDTO request){
        ReviewResponseDTO response = reviewCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "특정 사용자의 리뷰 목록 조회 API",description = "특정 사용자가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewListResponseDTO> getMemberReviewList(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = reviewQueryService.getMemberReviewList(memberId, page-1);
        return ApiResponse.onSuccess(ReviewListResponseDTO.from(reviewList));
    }
}
