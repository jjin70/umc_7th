package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public Page<Mission> getMissionList(Long storeId, Integer page) {

        Page<Mission> missionPage = missionRepository.findAllByStoreId(storeId, PageRequest.of(page, 10));

        return missionPage;
    }

    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page) {

        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMemberIdAndStatus(memberId, MissionStatus.CHALLENGING, PageRequest.of(page, 10));

        return memberMissionPage;
    }
}
