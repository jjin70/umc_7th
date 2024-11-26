package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberMissionResponseDTO {

    private MissionStatus missionStatus;
    private String storeName;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;

    public static MemberMissionResponseDTO from(MemberMission memberMission) {
        return MemberMissionResponseDTO.builder()
                .missionStatus(memberMission.getStatus())
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }
}
