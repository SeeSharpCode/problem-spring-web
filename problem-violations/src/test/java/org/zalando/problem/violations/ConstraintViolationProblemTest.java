package org.zalando.problem.violations;

import org.junit.jupiter.api.Test;
import org.zalando.problem.Problem;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.zalando.problem.Status.BAD_REQUEST;

class ConstraintViolationProblemTest {

    @Test
    void shouldCreateCopyOfViolations(){
        final List<Violation> violations = new ArrayList<>();
        violations.add(new Violation("x", "y"));

        final ConstraintViolationProblem problem = new ConstraintViolationProblem(BAD_REQUEST, violations);

        violations.clear();

        assertThat(problem.getViolations(), hasSize(1));
    }

    @Test
    void shouldCreateWithNullViolations(){
        final ConstraintViolationProblem problem = new ConstraintViolationProblem(BAD_REQUEST, null);
        assertThat(problem.getViolations(), notNullValue());
    }

    @Test
    void shouldCreateWithNullViolations2(){
        final ConstraintViolationProblem problem = new ConstraintViolationProblem(Problem.DEFAULT_TYPE, BAD_REQUEST, null);
        assertThat(problem.getViolations(), notNullValue());
    }

}
