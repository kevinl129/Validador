package Validator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeoresContrasenias implements Validator{
  public String error = "La contrasenia esta en la lista de las peores 10mil";
  @Override
  public String validate(String contrasenia) {
    List<String> worstPasswords = getPeoresContrasenias();
    if(worstPasswords.stream().anyMatch(n-> n.equals(contrasenia)))
      return error;
    return null;
  }

  private List<String> getPeoresContrasenias(){
    String path = new File("").getAbsolutePath();
    List<String> contrasenias = new ArrayList<>();
    FileReader fr;
    try {
      fr = new FileReader(path + "/src/main/java/constants/peoresContrasenias.txt");
    } catch (IOException exception) {
      System.out.println(exception);
      throw new RuntimeException("Error al conseguir la lista de contrasenias");
    }
    int i;
    String partialPassword = "";
    try {
      while ((i = fr.read()) != -1) {
        char c = (char) i;
        if (c == '\n') {
          contrasenias.add(partialPassword);
          partialPassword = "";
        } else if (c != '\r') {
          partialPassword += c;
        }
      }
    } catch (IOException exception) {
      System.out.println(exception);
      throw new RuntimeException("Error al buscar en la lista de contrasenias");
    }
    return contrasenias;
  }

}
