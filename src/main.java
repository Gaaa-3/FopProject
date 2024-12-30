import java.util.*;

class main {
    public static boolean CheckIfExists(Variables[] a, String name) {
        for (int i = 0; i < a.length && a[i] != null; i++) {
            if (a[i].GetName().equals(name)) return true;
        }
        return false;
    }

    public static String SearchByNameIndex(Variables[] a, String name) {
        for (int i = 0; i < a.length && a[i] != null; i++) {
            if (a[i].GetName().equals(name)) return "" + i;
        }
        return "false";
    }

    public static String SearchByName(Variables[] a, String name) {
        for (int i = 0; i < a.length && a[i] != null; i++) {
            if (a[i].GetName().equals(name)) return a[i].GetData() + "";
        }
        return name;
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


    //foris methodi
    public static void ForMethod(String[] LinesArray, int length, Variables[] Variables, int index) {
        String Shemotanili="";
        int xyz=0;

        for (int i = 0; i < length; i++) {
            System.out.println("mamamamdasmda");
        }
        for (int ku = 0; ku < length && LinesArray[ku] != null; ku++) {
            System.out.println("shedis?");
            String JustLine = LinesArray[ku];

            // vamowmebt tu sout-is inputi iwyeba sworad
            if (JustLine.length() > 2) {
                String Value1 = "";
                String Value2 = "";
                String Operation;
                while (!(LinesArray[ku].equals("break"))) {
                    if (!LinesArray[ku].equals("}")) System.out.println(LinesArray[ku]);



                    for (int i = 1; i < JustLine.length(); i++) {
                        String NameForUpdate = "";
                        if (JustLine.charAt(i - 1) == '+' && JustLine.charAt(i) == '+') {
                            for (int j = 0; j < i - 1; j++) {
                                NameForUpdate = NameForUpdate + JustLine.charAt(j);


                            }
                            if (CheckIfExists(Variables, NameForUpdate)) {
                                int hgk = Integer.parseInt(SearchByName(Variables, NameForUpdate));
                                hgk++;
                                Variables[Integer.parseInt(SearchByNameIndex(Variables, NameForUpdate))].SetData(hgk);

                            }

                        }
                    }





                    if (JustLine.length() >= 3) {

                        if (!("" + JustLine.charAt(0) + JustLine.charAt(1) + JustLine.charAt(2)).equals("var")) {
                            for (int i = 1; i < JustLine.length(); i++) {
                                String NameForUpdate = "";

                                if (("" + JustLine.charAt(i)).equals("=") && !("" + JustLine.charAt(i - 1)).equals(":")) {
                                    int operationIndex = -1;
                                    for (int h = i + 1; h < JustLine.length(); h++) {
                                        if (("" + JustLine.charAt(h)).equals("+") || ("" + JustLine.charAt(h)).equals("-") || ("" + JustLine.charAt(h)).equals("/") || ("" + JustLine.charAt(h)).equals("*") || ("" + JustLine.charAt(h)).equals("%")) {
                                            operationIndex = h;
                                            break;
                                        }
                                    }

                                    if (operationIndex != -1) {
                                        Operation = "" + JustLine.charAt(operationIndex);
                                        for (int j = 0; j < i; j++) {
                                            NameForUpdate += JustLine.charAt(j);
                                        }

                                        if (CheckIfExists(Variables, NameForUpdate)) {
                                            for (int k = i + 1; k < operationIndex; k++) {
                                                Value1 += JustLine.charAt(k);
                                            }
                                            for (int k = operationIndex + 1; k < JustLine.length(); k++) {
                                                Value2 += JustLine.charAt(k);
                                            }

                                            int result = Integer.parseInt(CalculatorSimple.Do(Variables, Value1.trim(), Operation, Value2.trim()));
                                            Variables[Integer.parseInt(SearchByNameIndex(Variables, NameForUpdate))].SetData(result);

                                        } else {
                                            System.out.println("NOT CORRECT INPUT");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (ku < length - 1) ku++;
                    else ku = 0;



                }

            }

        }

        System.out.println("Check If Enters");
    }


    public static void main(String[] args) {
        Variables[] Variables = new Variables[1000];
        Scanner Scan1 = new Scanner(System.in);
        System.out.println("package main");
        System.out.println("import \"fmt\"");
        System.out.println("func main () {");
        String SimpleLine = "";
        int ForExists = 0;
        int ForExists1 = 0;
        int index = 0;  // es gamoiyeneba Variable klasis indeqsistvis
        int Count = 1;
        String Shemotanili = "";
        Queue<String> Valuablebisqueue = new LinkedList<>();
        int xyz = 0;
        String[] Lines = new String[1002];
        int IndexL = 0;
        boolean ForBreak = false;

        boolean Break = false;
        while (true) {


            int NumberOfBr = 1;
            String Line = "";

            Line = Line + Scan1.nextLine();
            // SimpleLine - aris xazi romelsac bevr spaces(sicvrces) cvlis erti spaceti
            SimpleLine = Line.replaceAll("\\s+", " ");
            // JustLine - aris xazi romelic ert an met spaces cvlist carielit
            String JustLine = Line.replaceAll("\\s+", "");
            JustLine = JustLine.trim();
            SimpleLine = SimpleLine.trim();
            for (int i = 0; i < JustLine.length(); i++) {
                if (("" + JustLine.charAt(i)).equals("{")) Count++;
                if (("" + JustLine.charAt(i)).equals("}")) Count--;
            }
            // while


            if (!JustLine.equals("") && !SimpleLine.equals("")) {

// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                        for (int k = 3; k < SimpleLine.length(); k++) {
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
                for (int i = 0; i < JustLine.length(); i++) {
                    if (("" + JustLine.charAt(i)).equals(":") && ("" + JustLine.charAt(i + 1)).equals("=")) {
                        int IndexofEq = i;
                        String Name = "";
                        String Value = "";
                        // amit vigebt shemotanili Stringidan saxels
                        for (int j = 0; j < IndexofEq; j++) {
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
                if (ForExists != 0) {
                    String Value1 = "";
                    String Value2 = "";
                    String Operation;
                    // gatolebis da informaciis shecvlis
                    // kalkulaturi
                    // --------------------------------------------------------------------------------------------------------------------------------------------------------------========================================================
                    if (JustLine.length() > 2) {
                        String NameForUpdate = "";
//                    xdggf++
                        for (int i = 1; i < JustLine.length(); i++) {
                            if (JustLine.charAt(i - 1) == '+' && JustLine.charAt(i) == '+') {
                                for (int j = 0; j < i - 1; j++) {
                                    NameForUpdate = NameForUpdate + JustLine.charAt(j);


                                }
                                if (CheckIfExists(Variables, NameForUpdate)) {
                                    int hgk = Integer.parseInt(SearchByName(Variables, NameForUpdate));
                                    hgk++;
                                    Variables[Integer.parseInt(SearchByNameIndex(Variables, NameForUpdate))].SetData(hgk);

                                }

                            }
                        }



                    }

//=====================================================================================================================================================================================================================



                    if (SimpleLine.length() >= 3) {

                        if (!("" + JustLine.charAt(0) + JustLine.charAt(1) + JustLine.charAt(2)).equals("var")) {
                            for (int i = 1; i < JustLine.length(); i++) {
                                String NameForUpdate = "";

                                if (("" + JustLine.charAt(i)).equals("=") && !("" + JustLine.charAt(i - 1)).equals(":")) {
                                    int operationIndex = -1;
                                    for (int h = i + 1; h < JustLine.length(); h++) {
                                        if (("" + JustLine.charAt(h)).equals("+") || ("" + JustLine.charAt(h)).equals("-") || ("" + JustLine.charAt(h)).equals("/") || ("" + JustLine.charAt(h)).equals("*") || ("" + JustLine.charAt(h)).equals("%")) {
                                            operationIndex = h;
                                            break;
                                        }
                                    }

                                    if (operationIndex != -1) {
                                        Operation = "" + JustLine.charAt(operationIndex);
                                        for (int j = 0; j < i; j++) {
                                            NameForUpdate += JustLine.charAt(j);
                                        }

                                        if (CheckIfExists(Variables, NameForUpdate)) {
                                            for (int k = i + 1; k < operationIndex; k++) {
                                                Value1 += JustLine.charAt(k);
                                            }
                                            for (int k = operationIndex + 1; k < JustLine.length(); k++) {
                                                Value2 += JustLine.charAt(k);
                                            }

                                            int result = Integer.parseInt(CalculatorSimple.Do(Variables, Value1.trim(), Operation, Value2.trim()));
                                            Variables[Integer.parseInt(SearchByNameIndex(Variables, NameForUpdate))].SetData(result);

                                        } else {
                                            System.out.println("NOT CORRECT INPUT");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
//==========================================================================================================================================================================================================
                // fori ,lainebs inaxav Linesshi  fori bolo brchxilianad
                if (JustLine.startsWith("fortrue")) {
                    ForExists++;
                    ForExists1++;
                }
                if (JustLine.equals("break")) {

                    ForBreak = true;
                }

                System.out.println(ForExists);
                if (!(JustLine.equals("fortrue{")) && ForExists > 0) {
                    Lines[IndexL] = JustLine;
                    System.out.println(IndexL + " ->  " + Lines[IndexL]);
                    IndexL++;

                }
                if (Count == 1 && ForExists > 0) ForExists--;
                if (Count == 1 && ForExists == 0) continue;
//                indexl raodenoba
//                for true shi
//                lines [indexl] == break


//==========================================================================================================================================================================================================
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
                    Valuablebisqueue.add(Shemotanili.trim()); // trimavs shemotanils da queue-shi amatebs
                }


            }
//---------------------------------------------------------------------------------------------------------------------------
            // vciklavt for true-s(javashi while true) da tu break dagvxvdeba funqcia unda dabreiqdes
// justline.startswith fmt.printn


            // ranavs im shemtxvevashi tu bolo } daxuruli


            if (ForExists1 > 0) {
                if (Count == 0 && !Break) {
                    String[] ForMethodArray = new String[IndexL];
                    for (int i = 0; i < Lines.length && Lines[i] != null; i++) {
                        ForMethodArray[i] = Lines[i];
                    }
//                for (int i = 0; i <IndexL; i++) {
//                    System.out.println(i + "-------------->>>>>>>>>>" + ForMethodArray[i]);
//                }


                    ForMethod(ForMethodArray, IndexL, Variables, index);


                    while (!Valuablebisqueue.isEmpty()) {
                        String cvladisSaxeli = Valuablebisqueue.poll();//queues pirvel elements gvichvenebs da shlis
                        System.out.println(SearchByName(Variables, cvladisSaxeli).replaceAll("\"", ""));

                        xyz++;
// xyz ++
                    }
                    break;
                }
            } else if (Count == 0) {
                while (!Valuablebisqueue.isEmpty()) {
                    String cvladisSaxeli = Valuablebisqueue.poll();//queues pirvel elements gvichvenebs da shlis
                    System.out.println(SearchByName(Variables, cvladisSaxeli).replaceAll("\"", ""));

                    xyz++;

                }
                break;
            }
        }


    }
}