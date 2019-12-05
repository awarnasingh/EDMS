package com.edms.core.web.rest.errors;

import com.edms.core.constants.ConstantUtils;

public class EmailAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyUsedException() {
        super(ErrorConstants.EMAIL_ALREADY_USED_TYPE, ConstantUtils.EMAIL_ALREADY_IN_USE, ConstantUtils.USER_MANAGEMENT , ConstantUtils.EMAIL_EXISTS);
    }
}
