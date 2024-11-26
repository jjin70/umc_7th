package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.validation.annotation.ExistStores;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionRequestDTO {

    @NotNull(message = "널이어서는 안 됩니다.")
    private Integer reward;
    @NotNull(message = "널이어서는 안 됩니다.")
    private LocalDate deadline;
    @Size(min = 5, max = 30, message = "5자 이상, 30자 이하이어야 합니다.")
    private String missionSpec;
    @ExistStores
    private Long storeId;

    public Mission toEntity(Store store) {
        return Mission.builder()
                .reward(reward)
                .deadline(deadline)
                .missionSpec(missionSpec)
                .store(store)
                .build();
    }
}

