package tech.java.serialization;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import tech.java.model.User;

public class SerializationImpl {

  public static void main (String[] args) {
    User user1 =new User("Robin1", 10020, RandomStringUtils.randomAlphanumeric (10), Instant.now ());

    ObjectMapper objectMapper = new ObjectMapper ();
    objectMapper.registerModule (new JavaTimeModule ());

    Path serPath = Paths.get ("src/main/resources/user.ser");
    Path jsonPath = Paths.get ("src/main/resources/user.json");

    try (FileOutputStream fileOutputStream = new FileOutputStream(serPath.toFile ());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

      objectOutputStream.writeObject(user1);
      System.out.println("User serialized successfully to user.ser file");
    } catch (IOException e) {
      System.out.println("Exception:Serialization to user.ser file: " + user1);
    }

    try {
      objectMapper.writeValue (jsonPath.toFile (),user1);
      System.out.println("User serialized successfully to user.json file");
    } catch (IOException e) {
      System.out.println("Exception:Serialization to user.json file: " + user1);
    }
  }
}
