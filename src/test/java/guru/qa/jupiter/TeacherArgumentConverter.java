package guru.qa.jupiter;

import com.google.gson.Gson;
import guru.qa.domain.Teacher;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TeacherArgumentConverter implements ArgumentConverter {

    @Override
    public Teacher convert(Object source, ParameterContext parameterContext) throws ArgumentConversionException {

        Teacher teacherObj;

        Gson gson = new Gson();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(source.toString())) {
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            teacherObj = gson.fromJson(json, Teacher.class);
        } catch (IOException e) {
            throw  new ArgumentConversionException("Не удалось прочитать файл с именем: " + source, e);
        }

        return teacherObj;
    }
}
