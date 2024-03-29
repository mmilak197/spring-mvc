package com.mmilak.validator;

import com.mmilak.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    public void validate(Object target, Errors errors) {

        User user = (User) target;

        validate(ValidatorEnum.USERNAME, user.getUserName(), "userName", errors);
        validate(ValidatorEnum.PASSWORD, user.getUserName(), "password", errors);
        validate(ValidatorEnum.EMAIL, user.getUserName(), "email", errors);


        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();

        if(!password.equals(confirmPassword)) {
            errors.rejectValue("password", "err_code", "Passwords must be the same");
        }
    }

    private void validate(ValidatorEnum validator, String value, String fieldName, Errors errors) {

        String patterReg = validator.getPattern();
        Pattern pattern = Pattern.compile(patterReg);
        Matcher matcher = pattern.matcher(value);

        if(!matcher.matches()) {
            errors.rejectValue(fieldName, validator.getErrCode(), validator.getErrMessage());
        }
    }


}
