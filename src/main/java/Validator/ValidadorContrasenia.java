package Validator;

import errors.ValidationError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidadorContrasenia {

  private List<Validator> validators = new ArrayList<>(
      Arrays.asList(
          new PeoresContrasenias(),
          new LargoMinimo(),
          new EspaciosEnBlanco()
      )
  );

  public String Validate(String contrasenia) {
    List<String> errors = new ArrayList<>();
    errors=validators.stream().map(validator->validator.validate(contrasenia)).filter(Objects::nonNull).collect(Collectors.toList());
    if (errors.size() > 0)
      throw new ValidationError("Los errores fueron: \n - " + String.join("\n - ", errors));
    return contrasenia;
  }
}
