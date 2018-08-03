package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;

public class DataValidValidator implements ConstraintValidator<DataValid, Integer> {

    private int startDate;
    private int endDate;


    @Override
    public void initialize(DataValid dataValid) {
        this.startDate = dataValid.start();
        this.endDate = dataValid.end();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {



        return false;
    }


}
