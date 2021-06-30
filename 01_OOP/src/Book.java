public class Book {
    public String Title;
    public String Autor;
    public int Year;
    public String Publicher;
    public String Ganre;
    public int PageCount;

    public Book(String title, String autor, int year, String publicher, String ganre, int pageCount) {
        Title = title;
        Autor = autor;
        Year = year;
        Publicher = publicher;
        Ganre = ganre;
        PageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + Title + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Year=" + Year +
                ", Publicher='" + Publicher + '\'' +
                ", Ganre='" + Ganre + '\'' +
                ", PageCount=" + PageCount +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getPublicher() {
        return Publicher;
    }

    public void setPublicher(String publicher) {
        Publicher = publicher;
    }

    public String getGanre() {
        return Ganre;
    }

    public void setGanre(String ganre) {
        Ganre = ganre;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }
}
