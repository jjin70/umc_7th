package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionRequestDTO {

    private Integer reward;
    private LocalDate deadline;
    private String missionSpec;

    public Mission toEntity(Store store) {
        return Mission.builder()
                .store(store)
                .reward(reward)
                .deadline(deadline)
                .missionSpec(missionSpec)
                .build();
    }
}

