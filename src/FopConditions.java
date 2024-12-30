public class ForConditions {

    // operations - * / % + - == && || 4
    public static boolean Compare(Variables[] Variable, String Value1, String Operation, String Value2){
        int answerInt;
        boolean answer = false;
        int IntValue1;
        int IntValue2;
        if (main.CheckIfExists(Variable,Value1)){
            IntValue1 = Integer.parseInt(main.SearchByName(Variable, Value1));
        }else {
            IntValue1 = Integer.parseInt(Value1);
        }
        if (main.CheckIfExists(Variable,Value2)){
            IntValue2 = Integer.parseInt(main.SearchByName(Variable, Value2));
        }else {
            IntValue2 = Integer.parseInt(Value2);

        }
//            >  <    >=   <=   ==   !=
        switch (Operation){

            case ">" -> {
                answerInt = IntValue1 - IntValue2;
                if (answerInt > 0) answer = true;
                else if (answerInt <= 0) answer = false;
                return answer;
            }

            case "<" -> {
                answerInt = IntValue1 - IntValue2;
                if (answerInt < 0) answer = true;
                else if (answerInt >= 0) answer = false;
                return answer;
            }
            case ">=" -> {
                answerInt = IntValue1 - IntValue2;
                if (answerInt >= 0) answer = true;
                else if (answerInt < 0) answer = false;
                return answer;
            }
            case "<=" -> {
                answerInt = IntValue1 - IntValue2;
                if (answerInt <= 0) answer = true;
                else if (answerInt > 0) answer = false;
                return answer;
            }
            case "==" -> {
                answerInt = IntValue1 - IntValue2;
                if (answerInt == 0) answer = true;
                else answer = false;
                return answer;
            }
            case "!=" -> {
                answerInt = IntValue1 - IntValue2;
                if (answerInt != 0) answer = true;
                else answer = false;
                return answer;
            }
            default -> {
                return false;
            }

        }



    }



}


