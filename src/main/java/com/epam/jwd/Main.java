package com.epam.jwd;

import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.exception.ReadDataException;
import com.epam.jwd.interpreter.Client;
import com.epam.jwd.logger.LoggerProvider;
import com.epam.jwd.parser.ParagraphReader;
import com.epam.jwd.sort.ParagraphsSortImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            ParagraphReader.getInstance().parse("C:/Users/ЛИЗАВЕТА/IdeaProjects/text-app/src/main/resources/BasicText.txt");
        } catch (ReadDataException e) {
            LoggerProvider.getLOG().error("Fail reading");
        }

        ParagraphsSortImpl paragraphsSort = new ParagraphsSortImpl();
        String FILE_NAME = "C:/Users/ЛИЗАВЕТА/IdeaProjects/text-app/src/main/resources/BasicText.txt";
        TextComposite textComposite = new TextComposite(ParagraphReader.getInstance().parse(FILE_NAME));


        String expression = "5 1 2 & 3 4 5 6 ^ 47 & 3 & 2 1&";
        System.out.println(Client.getInstance(expression).calculate());

    }


}






