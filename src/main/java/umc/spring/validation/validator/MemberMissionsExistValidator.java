package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.ExistMemberMissions;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MemberMissionsExistValidator implements ConstraintValidator<ExistMemberMissions, List<Long>> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(ExistMemberMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
        boolean isValid = values.stream()
                .allMatch(value -> memberMissionRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_ALREADY_EXIST.toString()).addConstraintViolation();
        }

        return isValid;

    }
}
