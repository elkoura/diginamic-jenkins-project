package fr.diginamic;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import fr.diginamic.components.Filegenerator;

public class Main {
    public static void main(String[] args) throws IOException {

        Filegenerator filegenerator = new Filegenerator();
        Optional<List<String>> list = filegenerator.readFile1();
        if (list.isPresent()) {
            for (String string : list.get()) {
                System.out.println(string);
            }

        }

    }
}