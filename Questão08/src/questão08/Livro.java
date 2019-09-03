package questão08;

import java.util.ArrayList;

public class Livro {
    private String titulo;
    private int quantPaginas;
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getQuantPaginas() {
        return quantPaginas;
    }
    public void setQuantPaginas(int quantPaginas) {
        this.quantPaginas = quantPaginas;
    }
    public Livro(String titulo, int quantPaginas){
        this.quantPaginas = quantPaginas;
        this.titulo = titulo;
    }
    public static void main(){
        ArrayList<Livro> livros = new ArrayList<>();
        Livro livro = new Livro("Harry Potter", 221);
        livros.add(livro);
        livro = new Livro("Narnia", 854);
        livros.add(livro);
        livro = new Livro("Finlândia", 367);
        livros.add(livro);
        livro = new Livro("Slam Dunk", 50);
        livros.add(livro);
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("Livro: " +(i+1)+ "\nNome: " +livros.get(i).getTitulo()+
            "\nQuantidade de páginas: " +livros.get(i).getQuantPaginas()+ "\n\n");
        }
    }
}