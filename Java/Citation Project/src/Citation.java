public class Citation implements Comparable<Citation> {
    String format;
    String type;
    String[] authors;
    String workTitle;
    String athologyTitle;
    String[] extraTitles;
    RolePerson[] extraPersons;
    String publisher;
    Integer volumeNum;
    Integer issueNum;
    String date;
    String url;
    boolean dissertation;
    Integer startPage;
    Integer endPage;
    ArrayComparable<String> compareStrs = new ArrayComparable<String>();
    ArrayComparable<RolePerson> compareRolePersons = new ArrayComparable<RolePerson>();
    public Citation(String format, String type, String[] authors, String title, String publisher, String date) {
        this.format = format;
        this.type = type;
        this.authors = authors;
        this.workTitle = title;
        this.publisher = publisher;
        this.date = date;
    }
    public Citation(String format, String type, String[] authors, String title, String anthologyTitle, String publisher, String date) {
        this.format = format;
        this.type = type;
        this.authors = authors;
        this.workTitle = title;
        this.athologyTitle = anthologyTitle;
        this.publisher = publisher;
        this.date = date;
    }
    public Citation(String format, String type, String[] authors, String title, RolePerson[] extraPersons, String publisher, String date) {
        this.format = format;
        this.type = type;
        this.authors = authors;
        this.workTitle = title;
        this.extraPersons = extraPersons;
        this.publisher = publisher;
        this.date = date;
    }
    public Citation(String format, String type, String[] authors, String title, String anthologyTitle, RolePerson[] extraPersons, String publisher, String date) {
        this.format = format;
        this.type = type;
        this.authors = authors;
        this.workTitle = title;
        this.athologyTitle = anthologyTitle;
        this.extraPersons = extraPersons;
        this.publisher = publisher;
        this.date = date;
    }
    public Citation(String format, String type, String title, RolePerson[] extraPersons, String publisher, String date) {
        this.format = format;
        this.type = type;
        this.workTitle = title;
        this.extraPersons = extraPersons;
        this.publisher = publisher;
        this.date = date;
    }
    public Citation(String format, String type, String title, String anthologyTitle, RolePerson[] extraPersons, Integer startPage, Integer endPage) {
        this.format = format;
        this.type = type;
        this.workTitle = title;
        this.athologyTitle = anthologyTitle;
        this.extraPersons = extraPersons;
        this.startPage = startPage;
        this.endPage = startPage;   
    }
    public int compareTo(Citation other) {
        int total = 0;
        total += this.workTitle.compareTo(other.workTitle);
        total += this.athologyTitle.compareTo(other.athologyTitle);
        total += compareStrs.compareTo(this.extraTitles, other.extraTitles);
        total += compareStrs.compareTo(this.authors, other.authors);
        total += compareRolePersons.compareTo(this.extraPersons, other.extraPersons);
        total += this.publisher.compareTo(other.publisher);
        if(this.workTitle.equals(other.workTitle) && type.equals("Magazine")) {
        total += (this.volumeNum - other.volumeNum) + (this.issueNum - this.issueNum);
        }
        if(this.workTitle.equals(other.workTitle)) {
            total += (this.volumeNum - other.volumeNum);
            }
        total += this.date.compareTo(other.date) + this.url.compareTo(other.url);
        total += (this.dissertation ? 1:0) - (other.dissertation ? 1:0);
        if(this.startPage != null && this.endPage != null && this.startPage != null && this.endPage != null && this.athologyTitle.compareTo(other.athologyTitle) == 0) {
        total += this.startPage > other.startPage ? 100:-100;
        total += this.endPage > other.endPage ? 100:-100;
        }
        return total;
    }
    public RolePerson[] getExtraPersons() {
        return extraPersons;
    }
}
