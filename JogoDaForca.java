import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {

	private String[] palavras = {"processador","fonte", "teclado", "mouse",
			"gabinete", "monitor", "tecnologia", "controle", "livro",
			"caneta", "instrumento", "impressora", "janela"};
	private String palavraSecreta;
	private char[] palavraAdivinhada;
	private int tentativasRestantes;
	private final int MAX_TENTATIVAS = 6;
	
	public JogoDaForca() {
		palavraSecreta = escolherPalavra();
		palavraAdivinhada = new char[palavraSecreta.length()];
		tentativasRestantes = MAX_TENTATIVAS;
		inicializarPalavraAdivinhada();
	}

	private void inicializarPalavraAdivinhada() {
		for (int i = 0; i < palavraAdivinhada.length; i++) {
			palavraAdivinhada[i] = '_';
		}
	}

	private String escolherPalavra() {
		Random escolher = new Random();
		int i = escolher.nextInt(palavras.length);
		return palavras[i];
	}
	
	public void jogar() {
		
		Scanner scanner = new Scanner(System.in);
		
		while (tentativasRestantes > 0 && !palavraAdivinhadaCompleta()) {
			System.out.println("PALAVRA: " + String.valueOf(palavraAdivinhada));
			System.out.println("TENTATIVAS RESTANTES: " + tentativasRestantes);
			System.out.print("INSIRA UMA LETRA: ");
			char letra = scanner.nextLine().toLowerCase().charAt(0);
			
			if (!verificarLetra(letra)) {
				tentativasRestantes--;
			}
			
			System.out.println();
			
		}
		
		if (palavraAdivinhadaCompleta()) {
			System.out.println("VOCÊ DESCOBRIU A PALAVRA SECRETA!");
			System.out.println("RESPOSTA: " + palavraSecreta.toUpperCase());
			System.out.println("PARABÉNS! ESTOU ORGULHOSO DE VOCÊ!  :D");
		} else {
			System.out.println("NÃO FOI DESSA VEZ   :(");
			System.out.println("RESPOSTA: " + palavraSecreta.toUpperCase());
		}
		
		scanner.close();
		
	}
	
	private boolean verificarLetra(char letra) {
		boolean acertou = false;
		for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra) {
                palavraAdivinhada[i] = letra;
                acertou = true;
            }
        }
        return acertou;
	}
	
	  private boolean palavraAdivinhadaCompleta() {
	        for (char c : palavraAdivinhada) {
	            if (c == '_') {
	                return false;
	            }
	        }
	        return true;
	    }

	  public static void main(String[] args) {
		
		  JogoDaForca forca = new JogoDaForca();
		  forca.jogar();
		  
	}
	
}
