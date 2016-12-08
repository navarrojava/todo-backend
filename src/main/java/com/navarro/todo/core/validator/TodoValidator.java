package com.navarro.todo.core.validator;

import com.navarro.todo.core.dto.TodoDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class TodoValidator implements Validator {



    private static final String FIELD_REQUIRED = "field.required";
    @Override
    public boolean supports(Class<?> clazz) {
        return TodoDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", FIELD_REQUIRED);

    }

}
