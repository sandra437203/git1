public class Libro {
    private String titulo;
    private String autor;
    private String isbn;

//contructor
    public Libro(String isbn, String autor, String titulo) {
        this.titulo = titulo;
        this.autor = autor;
        if(setISBN(isbn)){
            this.isbn = isbn;
        }else{
            System.err.println("El ISBN no es valido ");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean setISBN(String isbn) {
        if (isbn.length() == 10) {
            if (compruebaIsbn10(isbn)) {
                this.isbn = isbn;
                return true;
            }
        } else if (isbn.length() == 13) {
            if (compruebaIsbn13(isbn)) {
                this.isbn = isbn;
                return true;
            }
        }
        System.out.println("El isbn es no valido ");
        return false;
    }

    //si es multiplo de 11
    // return suma % 11 == 0;


    //comprobar la validez del isbn10
    private boolean compruebaIsbn10(String isbn){
        //84-481-2231-2
        int suma=0;
        if(isbn.matches("^\\d{2}-\\d{3}-\\d{4}-(\\d|X)$")){
            System.out.println("es valido");
            return true;
        }
    }

    private boolean compruebaIsbn13(String isbn) {
        //978-84-415-2682-2
        int suma=0;
        if(isbn.matches("^\\d{3}-\\d{2}-\\d{3}-\\d{4}-(\\d$")){
            suma
        }
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    private int obtenerSumaISBN10{
        //84-481-2231-2
        int suma=0;
        isbn = isbn.replaceAll("-","");
        int guiones =0;
        for (int i = 0; i < isbn.length(); i++) {
            if (i== (isbn.length() - 1) && isbn.charAt(isbn.length()-1 == 'X'){
           suma += 10* (i+1);
            }else{
                suma += Character
            }

        }
    }
    public void  setIsbn{
        if(compruebaIsbn10(isbn) || compruebaIsbn13(isbn))
    }
}
