package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionResponseDTO {
    private String storeName;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;

    public static MissionResponseDTO from(Mission mission) {
        return MissionResponseDTO.builder()
                .storeName(mission.getStore().getName())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }
}
