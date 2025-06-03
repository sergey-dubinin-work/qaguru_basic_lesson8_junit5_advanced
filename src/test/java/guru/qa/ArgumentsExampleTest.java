package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArgumentsExampleTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, false"
    })
    void paramTest(int first, boolean second) {
        System.out.println(String.valueOf(first) + second);
    }
    
}
