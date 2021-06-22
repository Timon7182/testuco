package kz.uco.testwork.service;

import kz.uco.testwork.entity.Contacts;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ContactsValidator implements ConstraintValidator<CheckContactType, Contacts> {


    @Override
    public void initialize(CheckContactType constraint) {

    }

    String emailRegex = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.([A-Za-z]{2,6})$";
    String phoneRegex="^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\)))\\d{3}[- .]?\\d{2}[- .]?\\d{2}$";
    Pattern emailPattern = Pattern.compile(emailRegex);
    Pattern phonePattern = Pattern.compile(phoneRegex);

    @Override
    public boolean isValid(Contacts contact, ConstraintValidatorContext context) {
        if (contact == null)
            return false;

        switch (contact.getContact()) {
            case EMAIL:
                return emailPattern.matcher(contact.getValue()).matches();
            case PHONE:
                return phonePattern.matcher(contact.getValue()).matches();

            default:
                throw new IllegalArgumentException("Unexpected value of Contact type");
        }


    }
}
