package com.edms.core.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import com.edms.core.constants.ConstantUtils;

public class EmailNotFoundException extends AbstractThrowableProblem {

    private static final long serialVersionUID = 1L;

    public EmailNotFoundException() {
        super(ErrorConstants.EMAIL_NOT_FOUND_TYPE,ConstantUtils.EMAIL_ADDRESS_NOT_REGISTERED , Status.BAD_REQUEST);
    }
}
