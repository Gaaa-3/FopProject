import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class main {
    public static boolean CheckIfExists(Variables[] a, String name ) {
        for (int i = 0; i < a.length && a[i] != null; i++) {
            if (a[i].GetName().equals(name)) return true ;
        }
        return false;
    }
    public static String SearchByName(Variables[] a, String name ){
        for (int i = 0; i <a.length  && a[i] != null; i++) {
            if (a[i].GetName().equals(name )) return a[i].GetData()+"";
        }
        return "false" ;
    }

    public static void GetAllValues(Variables[] a) {
        for (int i = 0; i < a.length && a[i] != null; ++i) {

            System.out.print(i + 1 + "  " + a[i].GetName() + " -> ");

            System.out.println(a[i].GetData());
        }

    }

    public static boolean Check(Variables[] a, String name) {
        int o = 0;

        for (int i = 0; i < a.length && a[i] != null; ++i) {
            if (a[i].GetName().equals(name)) {
                ++o;
            }
        }

        if (o > 0) {
            System.out.println("Shecdomaa");
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Variables[] Variables = new Variables[1000];
        Scanner Scan1 = new Scanner(System.in);
        System.out.println("package main");
        System.out.println("import \"fmt\"");
        System.out.println("func main () {");
        String SimpleLine = "";
        int Amount = 0;
        int index = 0;  // es gamoiyeneba Variable klasis indeqsistvis
        int Count = 1;
        String Shemotanili = "";
        Queue<String> Valuablebisqueue = new LinkedList<>();
        int xyz = 0;








        while (true) {
            String Line = "";

            Line = Line + Scan1.nextLine();
            // SimpleLine - aris xazi romelsac bevr spaces(sicvrces) cvlis erti spaceti
            SimpleLine = Line.replaceAll("\\s+", " ");
            // JustLine - aris xazi romelic ert an met spaces cvlist carielit
            String JustLine = Line.replaceAll("\\s+", "");
            JustLine = JustLine.trim();
            SimpleLine = SimpleLine.trim();

            if (!JustLine.equals("") && !SimpleLine.equals("")) {

                // amowmebs var aris tuara stringshi,shemoaqvs var it sheqmnili cvladebi  mag : var name int =1
                if (SimpleLine.length() >= 3) {
                    if (("" + Line.charAt(0) + Line.charAt(1) + Line.charAt(2)).equals("var")) {
                        int space = 0;
                        String Name = "";
                        String Value = "";
                        // amit vigebt saxels da values inputidan magalitad  var name int = 5
                        for (int i = 3; i < SimpleLine.length() && space != 2; ++i) {
                            if (("" + SimpleLine.charAt(i)).equals(" ")) {
                                ++space;
                            } else {
                                Name = Name + SimpleLine.charAt(i);
                            }
                        }
                        // SimpleLine-is gamoyenebit rac weria tolobis marjvniv vigebt da vwert values mnishvnelobas
                        for (int k = 3; k < SimpleLine.length(); ++k) {
                            if (("" + SimpleLine.charAt(k)).equals("=")) {
                                for (int j = k + 1; j < SimpleLine.length(); ++j) {
                                    Value = Value + SimpleLine.charAt(j);
                                }
                            }
                        }
                        // Variables qmnis obieqts romelsac gadaeceba saxeli da shemdeg datrimuli value
                        if (Check(Variables, Name)) {
                            Variables[index] = new Variables(Name, Integer.parseInt(Value.trim()));
                            ++index;
                        }
                    }
                }

                // amit vigebt Stringebs Name-s da Value-s := is gamoyenebit, magalitad x := 10
                for (int i = 0; i < JustLine.length(); ++i) {
                    if (("" + JustLine.charAt(i)).equals(":") && ("" + JustLine.charAt(i + 1)).equals("=")) {
                        int IndexofEq = i;
                        String Name = "";
                        String Value = "";
                        // amit vigebt shemotanili Stringidan saxels
                        for (int j = 0; j < IndexofEq; ++j) {
                            Name = Name + JustLine.charAt(j);
                        }
                        // amit vigebt shemotanili Stringidan values
                        for (int L = IndexofEq + 2; L < JustLine.length(); ++L) {
                            Value = Value + JustLine.charAt(L);
                        }
                        // amit vigebt sheqmnilia tu ara am saxelit cvladi, tu ar aris shegvaqvs axali Variables klasshi, tu ukve sheqmnilia check methodi abrunebs shecdomaas.
                        if (Check(Variables, Name)) {
                            Variables[index] = new Variables(Name, Integer.parseInt(Value));
                            ++index;
                            break;
                        }
                    }
                }


                // gagas gatolebis da informaciis shecvlis
//                for (int i=0; i < SimpleLine.length(); i++) {
//                    if ((""+JustLine.charAt(i)).equals("=")){
//                    String CheckName =" ";//  anu es imistvisaa rom gaigos aris tuara es saxeli sheqmnili
//                    if (CheckIfExists(Variables,CheckName)){
//
//                    }
//                }
//                }


// ------------------------------------------------------------------------------------------------------------------


                // nika  (soutebis sistema)
                // fmt.print()-is sistema, vigebt ( )- ebshi chaweril monacems da gadagvaqvs stringshi



                boolean writeIn = false;
                String JustLine1 = JustLine;
                // vamowmebt tu sout-is inputi iwyeba sworad
                if (JustLine1.startsWith("fmt.Print")) {
                    Shemotanili = ""; // Reset Shemotanili for each fmt.Print line
                    for (int i = 8; i < JustLine1.length(); i++) {
                        char c = JustLine1.charAt(i);
                        if (c == '(') {
                            writeIn = true;
                        } else if (c == ')') {
                            writeIn = false;
                            break;
                        } else if (writeIn) {
                            Shemotanili += c;
                        }
                    }
                    Valuablebisqueue.add(Shemotanili.trim()); // Add trimmed value to the queue
                }







            }


// justline.startswith fmt.printn


            // ranavs im shemtxvevashi tu bolo } daxurulia
            for (int i = 0; i < JustLine.length(); i++) {
                if ((""+JustLine.charAt(i)).equals("{")) Count++;
                if ((""+JustLine.charAt(i)).equals("}")) Count--;
            }



            if (Count == 0){



                while (!Valuablebisqueue.isEmpty()) {
                    String cvladisSaxeli = Valuablebisqueue.poll(); // Retrieve and remove the head of the queue
                    System.out.println( cvladisSaxeli + " -> " + SearchByName(Variables, cvladisSaxeli));


                    xyz++;

                }
                break;
            }



        }
    }
}