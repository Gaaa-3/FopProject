import java.util.Scanner;
class main {
    // aige yvela saxeli  da mnishneloba
    public static void GetAllValues(Variables[] a) {
        for (int i = 0; i < a.length && a[i] != null; i++) {
            System.out.print(a[i].GetName() + "  ");
            System.out.println(a[i].GetData());

        }

    }

    // amowmebs or ertnair saxelian cvlads
    public static boolean Check(Variables[] a, String name) {
        int o = 0;
        for (int i = 0; i < a.length && a[i] != null; i++) {
            a[i].equals(name);
            o++;
        }
        if (o > 0) return false;
        else return true;
    }

    public static void main(String[] args) {
        Variables[] Variables = new Variables[1000];
        Scanner Scan1 = new Scanner(System.in);
        System.out.println("package main");
        System.out.println("import " + "\"fmt\"");
        System.out.println("func main () {");
        String SimpleLine = "";
        int Amount = 0;
        int index = 0;


        while (true) {
            String Line = "";
            // TITO XAZi
            Line = Line + Scan1.nextLine();

            SimpleLine = Line.replaceAll("\\s+ ", " ");
            SimpleLine = SimpleLine.trim();


            // cvladis sheqmna
            if (("" + Line.charAt(0) + Line.charAt(1) + Line.charAt(2)).equals("var")) {

                int space = 0;
                String Name = "";
                String Value = "";
                for (int i = 3; i < SimpleLine.length() && space != 2; i++) {

                    if (("" + SimpleLine.charAt(i)).equals(" ")) {
                        space++;
                        continue;

                    } else Name = Name + SimpleLine.charAt(i);

                }
                for (int k = 3; k < SimpleLine.length(); k++) {
                    if (("" + SimpleLine.charAt(k)).equals("=")) {
                        for (int j = k + 1; j < SimpleLine.length(); j++) {
                            Value = Value + SimpleLine.charAt(j);

                        }

                    }

                }
                if (Check(Variables, Name)) {

                    Variables[index] = new Variables(Name, Integer.parseInt(Value.trim()));
                    index++;

                }
            }
        }
    }
}