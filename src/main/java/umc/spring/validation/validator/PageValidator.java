package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.validation.annotation.CheckPage;

@Component
@RequiredArgsConstructor
public class PageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value < 1) { // 페이지 수 1보다 작으면 에러 처리
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("페이지 번호는 1 이상이어야 합니다.").addConstraintViolation();
            return false;
        }

        return true;
    }
}