import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class wordnet
 {
    String a[]=new String[2];
    public static void wordnet(String a[])
    {
        int j=0;
        while(j<2)
        {

            System.setProperty("wordnet.database.dir", "C:\\Program Files\\WordNet\\2.1\\dict");
            NounSynset nounSynset;
            NounSynset[] hyponyms;
            WordNetDatabase database = WordNetDatabase.getFileInstance();
            Synset[] synsets = database.getSynsets(a[j], SynsetType.NOUN);
             System.out.println("*********************************************");
            for (int i = 0; i < synsets.length; i++)
                {
            nounSynset = (NounSynset)(synsets[i]);
            hyponyms = nounSynset.getHyponyms();

            System.err.println(nounSynset.getWordForms()[0] +": " + nounSynset.getDefinition() + ") has " + hyponyms.length + " hyponyms");

                }
            j++;
        }
         System.out.println("*********************************************");
    }

}
