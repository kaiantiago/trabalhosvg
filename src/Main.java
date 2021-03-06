import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Reader r = new Reader();

        List<String> palavra;

        palavra = Arrays.asList(r.read().get(0).split(Pattern.quote("")));

        ArrayList<String> novaPalavra = new ArrayList();

        int i = 4;

        for (int j = 0; j < i; j++) {
            for (String letter : palavra) {
                switch (palavra.get(palavra.indexOf(letter))) {
                    case "N" -> novaPalavra.add("NLX"); // N - direita
                    case "X" -> novaPalavra.add("tL"); // X - baixo
                    case "L" -> novaPalavra.add("SN"); // L - esquerda
                    case "S" -> novaPalavra.add("LLN"); // S - cima
                    case "t" ->novaPalavra.add(""); // t - movimento vazio
                    default -> novaPalavra.add(letter);
                }
            }

            palavra = new ArrayList<>();

            for (String part : novaPalavra) {
                List<String> maisUmaPalavra;
                maisUmaPalavra = Arrays.asList(part.split(Pattern.quote("")));
                palavra.addAll(maisUmaPalavra);
            }
        }

        String palavraFinal = "";

        for (int w = 0; w < palavra.size(); w++) {

            palavraFinal += palavra.get(w);

        }

        System.out.println(palavraFinal + " - depois da gramática");

        Drawing desenho = new Drawing();

        String svg = "";

        svg = desenho.converte(palavraFinal);

        Writer escreve = new Writer();

        escreve.write(svg);
    }
}