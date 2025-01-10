package fr.diginamic;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import fr.diginamic.components.Filegenerator;

public class MainTest {
  @Test
  public void isFile1Empty() throws IOException {
    Filegenerator filegenerator = new Filegenerator();
    assertTrue(filegenerator.readFile1().isPresent());
  }

  @Test
  public void isFileEqualMagicPhrase() throws IOException {
    Filegenerator filegenerator = new Filegenerator();
    String magicPhrase = "Bonjour tous le monde";
    assertEquals(magicPhrase, (filegenerator.readFile1().get().get(0)));
  }

}
