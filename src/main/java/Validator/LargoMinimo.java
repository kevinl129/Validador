package Validator;

public class LargoMinimo implements Validator{
  public String error= "La contrasenia debe tener 8 o mas caracteres";

  @Override
  public String validate(String contrasenia) {
    if(contrasenia.length()>=8)return null;
    return error;
  }
}
