import java.util.Scanner;
import java.util.ArrayList;
public class CitationDriver {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String format = "";
        int citationNum = 0;
        int count = 0;
        LinkedCitationList citations = new LinkedCitationList();
        CitationWindow window = new CitationWindow();
        boolean cited = false;
        System.out.println("What is the format for all the citations? (MLA, APA, Chicago, CSE)");
        System.out.println("MLA is used for English, forign languages, and other humanities");
        System.out.println("APA is used for psychology and other social sciences");
        System.out.println("Chicago is used for history, philosophy, and other humanities");
        System.out.println("CSE is used in physical and biological sciences and mathematics");
        String out = scan.nextLine();
        while(!(out.equals("MLA") ||out.equals("APA") || out.equals("Chicago") || out.equals("CSE"))) {
            out = scan.nextLine();
        }
        format = out;
        System.out.print("how many citations do you need? ");
        citationNum = scan.nextInt();
        

        String type = "";
        switch(format) {
            case "MLA": 
            while(count <= citationNum) {
                cited = false;
                System.out.print("What are you citing? ");
                type = scan.nextLine();
                switch (type.toLowerCase()) {
                    case "book":
                    case "paper heard at a conference":
                    case "film":
                    case "musical score":
                    case "oral persentation":
                        citations.add(citeOnetitledMedia(format, type, scan));
                        cited = true;
                        break;
                    case "comic book":
                    case "graphic novel":
                    case "comic":
                        citations.add(citeComic(format, type, scan));
                        cited = true;
                        break;
                    case "anthology":
                        Citation anth = citeAnthology(format, type, scan);
                        citations.add(anth);
                        System.out.print("Are you citing 2 or more books within the anthology? ");
                        String decision = scan.nextLine();
                        if(decision.contains("yes")) {
                            int n = 0;
                            while(n < 2) {
                                try {
                                System.out.print("How many books?");
                                n = scan.nextInt();
                                } catch(Exception e) {

                                }
                            }
                           type = "one of the multiple books within an anthology";
                           count += n;
                           ArrayList<Citation> citationsArr = citeBooksWithinAnthology(n, format, type, decision, scan, anth.getExtraPersons(), new ArrayList<Citation>());
                           for(int i = 0; i < citationsArr.size(); i++) {
                                citations.add(citationsArr.get(i));
                           }
                        }
                        cited = true;
                        break;
                    case "article":
                    case "review":
                        break;
                    case "entry within a reference work":
                    case "Editoral":
                    case "Op-ED":
                    break;

                    default:
                    System.out.print("Would you like to have all possible types of citations shown? ");
                    String response = scan.nextLine();
                    if(response.contains("yes")) {
                        
                    }
                     break;
                }
                if(cited) {
                count++;
                }
            }
            break;
            case "APA": 
            while(count <= citationNum) {
                cited = false;
                if(cited) {
                count++;
                }
            }
            break;
            case "Chicago": 
            while(count <= citationNum) {
                cited = false;
                if(cited) {
                count++;
                }
            }
            break;
            case "CSE":
            while(count <= citationNum) {
                cited = false;
                if(cited) {
                count++;
                }
            } 
            break;
        }
        System.out.println("Works Cited:"); 
        System.out.println("Bullock R, Brody M, Weinberg F. The Little Seagull Handbook. Canada: W.W Norton & Company; 2022");
        window.toggleVisible();
        scan.close();
    }

    public static Citation citeOnetitledMedia(String format, String type, Scanner scan) {
       switch (format) {
        case "MLA":
        System.out.println("How many authors does this " + type + "have?");
        int authorNum = scan.nextInt();
        String[] authors;
        ArrayList<RolePerson> PersonList = new ArrayList<RolePerson>();
        boolean noOtherPerson = true;
        RolePerson editorRole;
        RolePerson translatorRole;
        String antitle = "";
        if(authorNum < 3) {
            authors = new String[authorNum];
            for(int i = 0; i < authorNum; i++) {
                System.out.print("Author" + (i+1) + ": ");
                authors[i] = scan.nextLine();
            }
        } else {
            authors = new String[2];
            System.out.print("Author 1: ");
            authors[0] = scan.nextLine();
            authors[1] = "et al.";
        }
        System.out.print("What is the title of this" + type + "? ");
        String title = scan.nextLine();
        System.out.print("Publisher: ");
        String publisher = scan.nextLine();
        System.out.print("Date: ");
        String date = scan.nextLine();
        System.out.print("Does this " + type + " have an editor? ");
        String decision = scan.nextLine();
        if(decision.toLowerCase().contains("yes")) {
            System.out.print("Editor: ");
            String editor = scan.nextLine();
            editorRole = new RolePerson("Edited by", editor);
            noOtherPerson = false;
            PersonList.add(editorRole);
        }
        System.out.print("Does this " + type + "have a translator? ");
        decision = scan.nextLine();
        if(decision.toLowerCase().contains("yes")) {
            System.out.print("Translator: ");
            String translator = scan.nextLine();
            translatorRole = new RolePerson("Translated by", translator);
            noOtherPerson = false;
            PersonList.add(translatorRole);
        }
        System.out.println("Is this" + type + "in an athology?");
        decision = scan.nextLine();
        if(decision.toLowerCase().contains("yes")) {
            System.out.print("Anthology Title: ");
            antitle = scan.nextLine();
        }
        if(!(antitle.equals(""))) {
            if(!noOtherPerson) {
                RolePerson[] extraPersons = (RolePerson[])(PersonList.toArray());
                return new Citation(format, type, authors, title, antitle, extraPersons, publisher, date); 
            }
            return new Citation(format, type, authors, title, antitle, publisher, date);
        }
        if(noOtherPerson) {
            return new Citation(format, type, authors, title, publisher, date);
        } else {
            RolePerson[] extraPersons = (RolePerson[])(PersonList.toArray());
            return new Citation(format, type, authors, title, extraPersons, publisher, date);
        }
        /*case "APA":

        break;
        case "Chicago":

        break;
        case "CSE":

        break;*/
        default:
        return null;    
       }
    }
    public static Citation citeComic(String format, String type, Scanner scan) {
        System.out.println("How many authors does this " + type + "have?");
        int authorNum = scan.nextInt();
        String[] authors;
        ArrayList<RolePerson> PersonList = new ArrayList<RolePerson>();
        if(authorNum < 3) {
            authors = new String[authorNum];
            for(int i = 0; i < authorNum; i++) {
                System.out.print("Author" + (i+1) + ": ");
                authors[i] = scan.nextLine();
            }
        } else {
            authors = new String[2];
            System.out.print("Author 1: ");
            authors[0] = scan.nextLine();
            authors[1] = "et al.";
        }
        System.out.print("What is the title of this" + type + "? ");
        String title = scan.nextLine();
        System.out.print("Publisher: ");
        String publisher = scan.nextLine();
        System.out.print("Date: ");
        String date = scan.nextLine();
        System.out.print("Does the " + type + "have people with other roles than the author(s)?(e.g. Illustrator)? ");
        String decision = scan.nextLine();
        if(decision.toLowerCase().contains("yes")) {
            boolean continuing = true;
            while(continuing) {
                try {
                System.out.print("(Type STOP to end) Put the people with other roles in this format (role-person): ");
                String person = scan.nextLine();
                if(!(person.equals("STOP"))) {
                String[] role = person.split("-");
                RolePerson newPerson = new RolePerson(role[0], role[1]);
                PersonList.add(newPerson);
                } else {
                    continuing = false;
                }
            } catch(Exception e) {

            }
            }
            RolePerson[] extraPersons = (RolePerson[])(PersonList.toArray());
            return new Citation(format, type, authors, title, extraPersons, publisher, date);
        }
        return new Citation(format, type, authors, title, publisher, date);
    }
    public static Citation citeAnthology(String format, String type, Scanner scan) {
        ArrayList<RolePerson> personList = new ArrayList<RolePerson>();
        String editor = "";
        int count = 1;
        while(!(editor.equals("STOP"))) {
            System.out.println("Editor " + count + ": ");
            editor = scan.nextLine();
            if(!(editor.equals("STOP"))) {
            RolePerson editPerson = new RolePerson("editor", editor);
            personList.add(editPerson);
            }
        }
        System.out.print("What is the title of this" + type + "? ");
        String title = scan.nextLine();
        System.out.print("Publisher: ");
        String publisher = scan.nextLine();
        System.out.print("Publication Year: ");
        String date = scan.nextLine();
        RolePerson[] extraPersons = (RolePerson[])(personList.toArray());
        return new Citation(format, type, title, extraPersons, publisher, date);
 
    }
    public static ArrayList<Citation> citeBooksWithinAnthology(int n, String format, String type, String anthologyTitle, Scanner scan, RolePerson[] editors, ArrayList<Citation> Citations) {
        if(n == 0) {
            return Citations;
        }
        System.out.println("How many authors does this " + type + "have?");
        int authorNum = scan.nextInt();
        String[] authors;
        if(authorNum < 3) {
            authors = new String[authorNum];
            for(int i = 0; i < authorNum; i++) {
                System.out.print("Author" + (i+1) + ": ");
                authors[i] = scan.nextLine();
            }
        } else {
            authors = new String[2];
            System.out.print("Author 1: ");
            authors[0] = scan.nextLine();
            authors[1] = "et al.";
        }
        System.out.print("What is the title of this" + type + "? ");
        String title = scan.nextLine();
        System.out.print("Start page: ");
        Integer start = scan.nextInt();
        System.out.print("End page: ");
        Integer end = scan.nextInt();
        Citations.add(new Citation(format, type, title, anthologyTitle, editors, start, end));
        n--;
        return citeBooksWithinAnthology(end, format, type, anthologyTitle, scan, editors, Citations);
    }
    public static Citation citeArticle(String format, String type, Scanner scan) {
        System.out.println("Where does the article come from?");
        String origin = scan.nextLine();
        System.out.println("How many authors does this " + type + "have?");
        int authorNum = scan.nextInt();
        String[] authors;
        ArrayList<RolePerson> PersonList = new ArrayList<RolePerson>();
        ArrayList<String> TitleList = new ArrayList<String>();
        boolean noOtherPerson = true;
        RolePerson editorRole;
        RolePerson translatorRole;
        String url = "";
        Integer volume = -1;
        Integer issue = -1;
        Integer startPage = -1;
        Integer endPage = -1;
        if(authorNum < 3) {
            authors = new String[authorNum];
            for(int i = 0; i < authorNum; i++) {
                System.out.print("Author" + (i+1) + ": ");
                authors[i] = scan.nextLine();
            }
        } else {
            authors = new String[2];
            System.out.print("Author 1: ");
            authors[0] = scan.nextLine();
            authors[1] = "et al.";
        }
        System.out.print("What is the title of this" + type + "? ");
        String title = scan.nextLine();
        if(origin.contains("online") || origin.contains("website") || origin.contains("internet")) {
            System.out.print("Name of Publication:");
        } else {
            System.out.print("Name of "  + origin + ":");
        }
        TitleList.add(scan.nextLine());
        if(origin.contains("database")) {
            System.out.print("Name of Periodical: "); 
            String swap = scan.nextLine();
            TitleList.add(swap);
            TitleList.add(TitleList.remove(0));
            System.out.print("Volume:");
            volume = scan.nextInt();
            System.out.print("Issue:");
            issue = scan.nextInt();
            System.out.print("Start Page:");
            startPage = scan.nextInt();
            System.out.print("End Page:");
            endPage = scan.nextInt();
        }
        if(origin.contains("online") || origin.contains("website") || origin.contains("internet") || origin.contains("database")) {
            System.out.print("Link to article (ctrl+shift+V should work): ");
            url = scan.nextLine();
        } else if(type.equals("review")) {
            System.out.print("Start Page:");
            startPage = scan.nextInt();
            System.out.print("End Page:");
            endPage = scan.nextInt();
        }
        System.out.print("Date: ");
        String date = scan.nextLine();
        type += " from " + origin;
        if(volume != -1 && issue != -1 && startPage != -1 && endPage != -1 && !(url.equals(""))) {
            return new Citation();
        } else if (!(url.equals(""))) {
            if(volume != -1 && issue != -1) {
                return new Citation();
            } else {
                return new Citation();
            }
        } else if (volume != -1 && issue != -1 && startPage != -1 && endPage != -1) {
            return new Citation();
        } else if (startPage != -1 && endPage != -1) {
            return new Citation();
        }
        return new Citation();
    }
}

