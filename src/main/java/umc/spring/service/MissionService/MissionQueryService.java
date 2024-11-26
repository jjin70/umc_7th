package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long memberId, Integer page);
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
