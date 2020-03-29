package com.zrx.ichiwanspringboot.validator;

import com.zrx.ichiwanspringboot.exception.ValidationFailedException;

public interface Validator <Obj> {
    void validate(Obj obj) throws ValidationFailedException;
}
