package tech.java.deserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import tech.java.model.User;

public class DeserializationImpl {

  public static void main (String[] args) {
    ObjectMapper objectMapper = new ObjectMapper ();
    objectMapper.registerModule (new JavaTimeModule ());

    Path jsonPath = Paths.get ("src/main/resources/user.json");
    Path serPath = Paths.get ("src/main/resources/user.ser");

    try (FileInputStream fileInputStream = new FileInputStream(serPath.toFile());
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

      User user1 = (User) objectInputStream.readObject();
      System.out.println("Deserialized from .ser file: " + user1);

    } catch (IOException e) {
      System.out.println("IOException while deserializing .ser file: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      System.out.println("ClassNotFoundException: " + e.getMessage());
    }

    try {
      User user2 = objectMapper.readValue(jsonPath.toFile(), User.class);
      System.out.println("Deserialized from .json file: " + user2);
    } catch (IOException e) {
      System.out.println("IOException while deserializing .json file: " + e.getMessage());
    }
  }
}
