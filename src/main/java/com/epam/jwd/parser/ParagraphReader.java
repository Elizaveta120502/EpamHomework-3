package com.epam.jwd.parser;

import com.epam.jwd.entity.TextComponent;
import com.epam.jwd.entity.textComponentImpl.TextComposite;
import com.epam.jwd.logger.LoggerProvider;

import java.util.ArrayList;
import java.util.List;

public class ParagraphReader extends BaseHandler {

    private static final String PARAGRAPHE_REGEX = "\\t(.+)\\p{Punct}";
    private static ParagraphReader paragraphReader;


    private ParagraphReader() {
        super();
    }

    public ParagraphReader getInstance(){
        if (paragraphReader == null){
            paragraphReader = new ParagraphReader();
        }
        return paragraphReader;
    }


    @Override
    public List<TextComponent> parse(String text) {
        LoggerProvider.getLOG().trace("Start parsing paragraph");
        String [] paragraphs = text.split("\t");
        List<TextComponent> paragraphList  = new ArrayList();
        for (int i =0;i <paragraphs.length;i++){
            if (paragraphs[i].matches(PARAGRAPHE_REGEX)) {
                paragraphs[i] = text.replaceAll("\t", "");
            }
        }

        for (String par : paragraphs){

            paragraphList.add(new TextComposite(processingNext(par)));
        }
        LoggerProvider.getLOG().trace("Stop parsing paragraph");
        return paragraphList;
    }



//    private TextComposite readParagraph(String path) throws IOException {
//        List<TextComponent> paragraphList = new ArrayList<>();
//        TextComposite textComposite = null;
//        TextLeaf paragraphLeaf = null;
//
//        TextComponent textComponent = new TextComposite();
//        try {
//            File file = new File(path);
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String paragraph;
//
//            while ((paragraph = bufferedReader.readLine()) != null) {
//                if (paragraph.matches(PARAGRAPHE_REGEX) == true) {
//
//                    textComposite = new TextComposite(paragraphList);
//                    textComposite.addElement(textComponent);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            LoggerProvider.getLOG().error("The file to parse is not found");
//        } catch (IOException e) {
//            LoggerProvider.getLOG().error("An exception is thrown when trying to enter");
//        }
//        return textComposite;
//    }
}
