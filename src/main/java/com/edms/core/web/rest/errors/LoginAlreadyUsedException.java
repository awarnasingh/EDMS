package com.edms.core.web.rest.errors;

import com.edms.core.constants.ConstantUtils;

public class LoginAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public LoginAlreadyUsedException() {
        super(ErrorConstants.LOGIN_ALREADY_USED_TYPE, ConstantUtils.LOGIN_NAME_ALREADY_USED , ConstantUtils.USER_MANAGEMENT, ConstantUtils.USER_EXISTS);
    }
}
