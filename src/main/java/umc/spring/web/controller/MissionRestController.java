package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO> createMission(@RequestBody @Valid MissionRequestDTO request){
        MissionResponseDTO response = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(response);
    }

    @PostMapping("/challenge/{missionId}")
    public ApiResponse<MemberMissionResponseDTO> challengeMission(@RequestParam(name = "memberId") Long memberId, @PathVariable(name = "missionId") Long missionId) {
        MemberMissionResponseDTO response = missionCommandService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(response);
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API ",description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionListResponseDTO> getMissionList(@ExistStores @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = missionQueryService.getMissionList(storeId, page-1);
        return ApiResponse.onSuccess(MissionListResponseDTO.from(missionList));
    }

    @GetMapping("/member/{memberId}")
    @Operation(summary = "특정 사용자의 진행 중인 미션 목록 조회 API ",description = "특정 사용자의 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({
            @Parameter(name = "memberId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionListResponseDTO> getMemberMissionList(@PathVariable(name = "memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<MemberMission> memberMissionList = missionQueryService.getMemberMissionList(memberId, page-1);
        return ApiResponse.onSuccess(MemberMissionListResponseDTO.from(memberMissionList));
    }
}
