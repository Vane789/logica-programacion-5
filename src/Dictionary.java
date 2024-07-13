import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("hola", "hello");
        dictionary.put("adiós", "goodbye");
        dictionary.put("perro", "dog");
        dictionary.put("carro", "car");
        dictionary.put("dulce", "sweet");
        dictionary.put("sí", "yes");
        dictionary.put("no", "no");
        dictionary.put("cama", "bed");
        dictionary.put("comida", "food");
        dictionary.put("amor", "love");
        dictionary.put("escuela", "school");
        dictionary.put("libro", "book");
        dictionary.put("bailar", "dance");
        dictionary.put("feliz", "happy");
        dictionary.put("gato", "cat");
        dictionary.put("sol", "sun");
        dictionary.put("luna", "moon");
        dictionary.put("mar", "sea");
        dictionary.put("montaña", "mountain");
        dictionary.put("familia", "family");

        int numberOfEntries = 5;
        String green = "\u001B[32m";
        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        ArrayList<String> answerCorrect = new ArrayList<>();
        ArrayList<String> answerIncorrect = new ArrayList<>();
        List<Map.Entry<String, String>> randomEntries = getRandomValues(dictionary, numberOfEntries);
        Scanner in = new Scanner(System.in);
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║                 JUEGO DEL DICCIONARIO            ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ Traduce las siguientes 5 palabras de español     ║");
        System.out.println("║ a inglés correctamente...                        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        
        for (Map.Entry<String, String> entry : randomEntries) {
            System.out.println("Palabra en español: " + entry.getKey());
            System.out.print("Escribe la traducción en ingles: ");
            String word = in.nextLine();
            if(word.equals(entry.getValue())){
                answerCorrect.add(word);
                System.out.println(green+"Yeees, that's right!!" + reset);
            } else{
                answerIncorrect.add(word);
                System.out.println(red +"Nooo :c. The correct word is: "+reset+ green +entry.getValue()+ reset);
            }
            System.out.println("-----------------------------------------------------");  
        }
        in.close();
        System.out.println("\nRESULTADOS:");
        System.out.println("Respuestas correctas: " + answerCorrect.size() + " - " + answerCorrect.toString());
        System.out.println("Respuestas incorrectas: " + answerIncorrect.size() + " - " + answerIncorrect.toString());
    }

    public static List<Map.Entry<String, String>> getRandomValues(HashMap<String, String> dictionary, int numberOfEntries) {
        List<Map.Entry<String, String>> entries = new ArrayList<>(dictionary.entrySet());
        Collections.shuffle(entries);
        return entries.subList(0, numberOfEntries);
    }
}
