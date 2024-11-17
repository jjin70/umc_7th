package umc.spring.service.MissionService;

import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

public interface MissionCommandService {

    MissionResponseDTO createMission(Long storeId, MissionRequestDTO request);

    MemberMissionResponseDTO challengeMission(Long memberId, Long missionId);
}
