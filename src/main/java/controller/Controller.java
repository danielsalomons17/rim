package controller;

import generated.ArType;
import generated.LexiconType;
import generated.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    List<ArType> words;

    public static void main(String[] args) {
        Controller run = new Controller();
        run.readXML();
    }

    public void readXML(){
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(LexiconType.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            LexiconType lexicon = (LexiconType) jaxbUnmarshaller.unmarshal(new File("src/main/resources/ordlista.xml"));
            words = lexicon.getAr();
            for(int i = 0; i < words.size(); i++){
                if(words.get(i).getK().contains("/") || words.get(i).getK().contains(":")){
                    continue;
                }
                System.out.println(words.get(i).getK());
                ArType word = words.get(i);
                String path = "src/main/java/template/generated/"+ word.getK().replace("|", "") +".html";
                Path oldHtmlFile = Paths.get("src/main/java/template/content.html");
                List<String> lidl = Files.readAllLines(oldHtmlFile);
                String allRhymes = "";
                for (String oneWord : rhymes(word)){
                    allRhymes += oneWord + "</br>";
                }
                for (int j = 0; j < lidl.size(); j++){
                    lidl.set(j, lidl.get(j).replace("$word", word.getK()));
                    lidl.set(j, lidl.get(j).replace("$rimm", allRhymes));
                }
                File creator = new File(path);
                creator.createNewFile();
                Path newHtmlFile = Paths.get(path);
                Files.write(newHtmlFile, lidl, StandardCharsets.UTF_8);
            }
        }
        catch (JAXBException | IOException e)
        {
            e.printStackTrace();
        }
    }
    //tr = uttal
    //k = ord
    public List<String> rhymes(ArType word){
        List<String> rhymes = new ArrayList<>();
        for(ArType pair : words){
            if(pair.getTr() == null || word.getTr() == null){
                continue;
            }
            if(pair.getTr().length() > 5 && word.getTr().length() > 5){
                if(pair.getTr().substring(pair.getTr().length()-5).equals(word.getTr().substring(word.getTr().length()-5))){
                    rhymes.add(pair.getK().replace("|", ""));
                }
            }
            else if(pair.getK().length() <=3 && pair.getK().length() > 1){
                //Do something
            }
            else {
                //Do something
            }
        }
        return postSort(rhymes, word.getK());
    }

    public List<String> postSort(List<String> rhymes, String word){
        //Remove dupes
        rhymes = rhymes.stream().distinct().collect(Collectors.toList());
        //Remove itself
        rhymes.remove(word);
        //Sort by length
        Collections.sort(rhymes, (o1, o2) -> {
            if(o1.length()>o2.length()){
                return 1;
            }else{
                return o1.compareTo(o2);
            }
        });
        for(String rhyme : rhymes){

        }
        return rhymes;
    }
}
