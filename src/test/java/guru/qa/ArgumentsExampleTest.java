package guru.qa;

import com.google.gson.Gson;
import guru.qa.domain.Teacher;
import guru.qa.jupiter.TeacherArgumentConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ArgumentsExampleTest {

    ClassLoader classLoader = getClass().getClassLoader();

    @ParameterizedTest
    @CsvSource(value = {
            "1, true",
            "2, false"
    })
    void paramTest(int first, boolean second) {
        System.out.println(String.valueOf(first) + second);
    }

    @ValueSource(strings = {
            "files/dima.json",
            "files/stas.json"
    })
    @ParameterizedTest
    void apiParamTestV1(String teacher) throws IOException {
        Teacher teacherObj;

        Gson gson = new Gson();

        try (InputStream inputStream = classLoader.getResourceAsStream(teacher)) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            teacherObj = gson.fromJson(json, Teacher.class);
        }

        // В реальности будем отправлять объект Teacher в API
        System.out.println(teacherObj.toString());

    }


    @ValueSource(strings = {
            "files/dima.json",
            "files/stas.json"
    })
    @ParameterizedTest
    void apiParamTestV2(@ConvertWith(TeacherArgumentConverter.class) Teacher teacher) throws IOException {

        // В реальности будем отправлять объект Teacher в API
        System.out.println(teacher.toString());

    }

}
