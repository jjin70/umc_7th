package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.spring.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDto{
        @NotBlank(message = "공백일 수 없습니다.")
        String name;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer gender;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer birthYear;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer birthMonth;
        @NotNull(message = "널이어서는 안 됩니다.")
        Integer birthDay;
        @Size(min = 5, max = 12, message = "5자 이상, 12자 이하이어야 합니다.")
        String address;
        @Size(min = 5, max = 12, message = "5자 이상, 12자 이하이어야 합니다.")
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}