package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

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
}
