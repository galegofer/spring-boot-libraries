package com.baeldung.toggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.ActivationParameter;
import org.togglz.core.annotation.DefaultActivationStrategy;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;
import org.togglz.spring.activation.SpringEnvironmentPropertyActivationStrategy;

import static org.togglz.core.activation.AbstractPropertyDrivenActivationStrategy.PARAM_NAME;
import static org.togglz.core.activation.AbstractPropertyDrivenActivationStrategy.PARAM_PROPERTY_VALUE;

public enum MyFeatures implements Feature {

    @Label("Employee Management Feature")
    @DefaultActivationStrategy(id = SpringEnvironmentPropertyActivationStrategy.ID,
            parameters = {
                    @ActivationParameter(name = PARAM_NAME, value = "employee.feature"),
                    @ActivationParameter(name = PARAM_PROPERTY_VALUE, value = "true")
            })
    EMPLOYEE_MANAGEMENT_FEATURE;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
