package com.edms.core.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import com.edms.core.constants.ConstantUtils;

public class InvalidPasswordException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public InvalidPasswordException() {
        super(ErrorConstants.INVALID_PASSWORD_TYPE, ConstantUtils.INCORRECT_PASSWORD, Status.BAD_REQUEST);
    }
}
