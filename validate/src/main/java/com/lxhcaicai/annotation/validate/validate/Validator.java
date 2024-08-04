package com.lxhcaicai.annotation.validate.validate;

import java.util.Map;

public interface Validator {
    <T> Map<String,String> validate(T object);
}
