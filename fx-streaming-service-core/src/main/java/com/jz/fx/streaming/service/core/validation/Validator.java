package com.jz.fx.streaming.service.core.validation;

/**
 * Created by Jack on 16/11/2017.
 */

import java.util.function.Consumer;

/**
 * Interface being used for validation
 *
 * @param <T>
 */
public interface Validator<T> {

    /**
     *
     * @param t
     * @return boolean indicates if validation is passed
     */
    boolean validate(T t, Consumer<String> errors);
}
