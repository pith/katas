import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void should_return_0_when_given_null() {
        assertThat(new StringCalculator().add(null)).isEqualTo(0);
    }

    @Test
    public void should_return_0_when_given_empty() {
        assertThat(new StringCalculator().add("")).isEqualTo(0);
    }

    @Test
    public void should_return_number_when_given_number() {
        assertThat(new StringCalculator().add("1")).isEqualTo(1);
    }

    @Test
    public void should_return_sum_given_string_with_unknown_number_of_arguments_separated_by_comma_or_new_line(){
        assertThat(new StringCalculator().add("1,2\n3")).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_new_line_follow_comma(){
        new StringCalculator().add("1,\n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_comma_follow_new_line(){
        new StringCalculator().add("1\n,");
    }

    @Test
    public void should_return_1_when_1_with_new_delimiter() {
        assertThat(new StringCalculator().add("//,\n1")).isEqualTo(1);
    }
}
