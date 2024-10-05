public class LinkedCitationList {
    private class CitationBlock {
        CitationBlock next;
        Citation citation;
        
        public CitationBlock(Citation citation, CitationBlock next) {
            this.citation = citation;
            this.next = next;
        }
    }
    CitationBlock first;
    CitationBlock last;
    int size;
    public LinkedCitationList() {
        first = null;
        last = null;
    }
    public void add(Citation citation) {
        if(first == null && last == null) {
            CitationBlock block = new CitationBlock(citation, null);
            first = block;
            last = block;
        } else if (last.citation.compareTo(citation) < 0) {
            CitationBlock block = new CitationBlock(citation, null);
            last.next = block;
            last = block;
        } else if (first.citation.compareTo(citation) > 0) {
            CitationBlock block = new CitationBlock(citation, first);
            first = block;
        } else {
            CitationBlock c1 = first;
            while(c1.citation.compareTo(citation) < 0) {
                c1 = c1.next;
            }
            CitationBlock block = new CitationBlock(citation, c1.next);
            c1.next = block;
        }
        size++;
    }
    public int size() {
        return this.size;
    }
   public Citation[] arrayTransformation() {
    Citation[] citationArr = new Citation[size];
    CitationBlock c1 = first;
    int pos = 0;
    while(c1 != null) {
        citationArr[pos] = c1.citation;
        pos++;
        c1 = c1.next;
    }
    return citationArr;
   }
}
