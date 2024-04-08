import java.util.Scanner;
public class CitationDriver {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String format = "";
        int citationNum = 0;
        int count = 0;
        System.out.println("What is the format for all the citations? (MLA, APA, Chicago, CSE)");
        System.out.println("MLA is used for English, forign languages, and other humanities");
        System.out.println("APA is used for psychology and other social sciences");
        System.out.println("MLA is used for history, philosophy, and other humanities");
        System.out.println("CSE is used in physical and biological sciences and mathematics");
        String out = scan.nextLine();
        while(!(out.contains("MLA") ||out.contains("APA") || out.contains("Chicago") || out.contains("CSE"))) {
            out = scan.nextLine();
        }
        format = out;
        System.out.print("how many citations do you need?");
        citationNum = scan.nextInt();
        String type = "";
        switch(format) {
            case "MLA": 
            while(count <= citationNum) {
                count++;
            }
            break;
            case "APA": 
            while(count <= citationNum) {
                count++;
            }
            break;
            case "Chicago": 
            while(count <= citationNum) {
                count++;
            }
            break;
            case "CSE":
            while(count <= citationNum) {
                count++;
            } 
            break;
        }


        a.close();
    }
}
