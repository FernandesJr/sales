package com.siganatural.sales.services.validation;


import com.siganatural.sales.dto.user.UserUpdateDTO;
import com.siganatural.sales.resources.exception.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> { //Tipo da annotation e onde ela é aplicada

    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
        if(!dto.getPassword().equals(dto.getPasswordConfirm())){
            list.add(new FieldMessage("passwordConfirm", "Confirmação não confere, por favor verifique"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getField())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
