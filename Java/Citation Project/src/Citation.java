public class Citation implements Comparable<Citation> {
    String format;
    String type;
    String author;
    String workTitle;
    String AthologyTitle;
    String[] extraTitles;
    RolePerson[] extraPersons;
    String publisher;
    int volumeNum;
    int issueNum;
    String date;
    String url;
    boolean dissertation;
    public Citation(String format, String type, String author, String title, String publisher, String date) {
        this.format = format;
        this.type = type;
        this.author = author;
        this.workTitle = title;
        this.publisher = publisher;
        this.date = date;
    }
    public int compareTo(Citation other) {
        int total = 0;
        total += this.type.compareTo(other.type) + this.author.compareTo(other.author) + this.workTitle.compareTo(other.workTitle);
        total += this.AthologyTitle.compareTo(AthologyTitle);
        total += extraTitlesCompareTo(other.extraTitles);
        return total;
    }
    public int extraTitlesCompareTo(String[] otherTitles) {
        int total = 0;
        return total;
    }
    public int otherPersonsCompareTo(String[] otherPersons) {
        int total = 0;
        return total;
    }
    
}
