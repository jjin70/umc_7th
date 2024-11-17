package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{memberId}/{storeId}")
    public ApiResponse<ReviewResponseDTO> createrReview(@RequestParam(name = "memberId")  Long memberId, @RequestParam(name = "storeId")  Long storeId, @RequestBody @Valid ReviewRequestDTO request){
        ReviewResponseDTO response = reviewCommandService.createReview(memberId, storeId, request);
        return ApiResponse.onSuccess(response);
    }

}
