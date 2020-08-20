package HomeWork7_2;


public class EasySearch implements ISearchEngine {

    public int search(String resource, String word) {
        int lastIndex = 0;
        int count = 0;
        while (resource.indexOf(word, lastIndex) > -1) {
            count++;
            lastIndex = resource.indexOf(word, lastIndex) + word.length();
        }
        return count;
    }

    public String[] arrOfWords(String word){
        String[] variWord = new String[7];
        variWord[0] = " " + word + " ";
        variWord[1] = " " + word + ".";
        variWord[2] = " " + word + ",";
        variWord[3] = " " + word + "!";
        variWord[4] = " " + word + "?";
        variWord[5] = " " + word + ":";
        variWord[6] = " " + word + ";";
        variWord[6] = word.substring(0, 1).toUpperCase().concat(word.substring(1)).concat(" ");
        return variWord;
    }

}
