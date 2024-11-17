package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.MemberMission;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberMissionResponseDTO {

    private Long memberMissionId;
    private String missionStatus;
    private Long memberId;
    private Long missionId;

    public static MemberMissionResponseDTO from(MemberMission memberMission) {
        return MemberMissionResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .missionStatus(memberMission.getStatus().name())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }
}
