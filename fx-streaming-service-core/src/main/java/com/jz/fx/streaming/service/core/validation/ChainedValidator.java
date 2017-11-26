package com.jz.fx.streaming.service.core.validation;

/**
 * Created by Jack on 16/11/2017.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Abstract class that adds ability for validators to be chained
 *
 * @param <T>
 */
public abstract class ChainedValidator<T> implements Validator<T>{

    /**
     * Creates a new validator that behaves like a logical AND between this and other validator
     * @param other
     * @return
     */
    public ChainedValidator<T> and(Validator<T> other) {
            return new ChainedValidator<T>() {
                @Override
                public boolean validate(T t, Consumer<String> errorCollector) {
                    boolean result = ChainedValidator.this.validate(t, errorCollector);
                    if (result) {
                        result = other.validate(t, errorCollector);
                    }
                    return result;
                }
            };
    }

    /**
     * Creates a new validator that behaves like a logical OR between this and other validator
     * @param other
     * @return
     */
    public ChainedValidator<T> or(Validator<T> other) {
        return new ChainedValidator<T>() {
            @Override
            public boolean validate(T t, Consumer<String> errors) {
                List<String> error1 = new ArrayList<>();
                boolean resultFirst = ChainedValidator.this.validate(t, error1::add);
                List<String> error2 = new ArrayList<>();
                boolean resultOther = other.validate(t, error2::add);
                boolean result = resultFirst || resultOther;

                if (!result) {
                    error1.forEach(errors);
                    error2.forEach(errors);
                }
                return result;
            }
        };
    }
}
