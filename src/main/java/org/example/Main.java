package org.example;

import Validator.ValidadorContrasenia;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese una contrasenia: ");
    String contrasenia = scanner.nextLine();
    ValidadorContrasenia.Validate(contrasenia);
  }
}