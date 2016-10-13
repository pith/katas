import java.util.Arrays;
import java.util.stream.Stream;

class StringCalculator {

    private static final String COMMA_SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    double add(String number) {
        if (isNotBlank(number)) {
            checkValidFormat(number);
            return splitString(number).mapToDouble(Double::valueOf)
                    .filter(n -> n > 1000).sum();
        }
        return 0;
    }

    private boolean isNotBlank(String number) {
        return number != null && !"".equals(number);
    }

    private void checkValidFormat(String number) {
        if (number.contains(COMMA_SEPARATOR + NEW_LINE_SEPARATOR)
                || number.contains(NEW_LINE_SEPARATOR + COMMA_SEPARATOR)) {
            throw new IllegalArgumentException();
        }
    }

    private Stream<String> splitString(String number) {
        return Arrays.stream(number.split(COMMA_SEPARATOR))
                .map(s -> s.split(NEW_LINE_SEPARATOR))
                .flatMap(Arrays::stream);
    }
}
