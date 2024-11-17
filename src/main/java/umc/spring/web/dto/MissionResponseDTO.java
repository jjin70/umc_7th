package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MissionResponseDTO {

    private Long id;
    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;
    private Long storeId;

    public static MissionResponseDTO from(Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getReward(),
                mission.getDeadline(),
                mission.getMissionSpec(),
                mission.getStore().getId()
        );
    }
}
