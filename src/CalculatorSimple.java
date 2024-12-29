

public class CalculatorSimple {

    // operations - * / % + - == && ||4
    public static String Do(Variables[] Variable, String Value1  , String Operation,String Value2){
        int answerInt;
        String answer;
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
            IntValue2= Integer.parseInt(Value2);

        }

        switch (Operation){

            case "+" ->{
                if (Value2.equals("+")){
                    answerInt = IntValue1 + 1;
                    answer = answerInt + "";
                    return answer;
                }else{
                    answerInt = IntValue1 + Integer.parseInt(Value2);
                    answer = answerInt + "";
                    return answer;
                }
            }

            case "-" -> {
                answerInt = IntValue1 - IntValue2;
                answer = answerInt + "";
                return answer;
            }
            case "*" -> {
                answerInt = IntValue1 * IntValue2;
                answer = answerInt + "";
                return answer;
            }
            case "/" -> {
                answerInt = IntValue1 / IntValue2;
                answer = answerInt + "";
                return answer;
            }
            case "%" ->  {
                answerInt = IntValue1 % IntValue2;
                answer = answerInt + "";
                return answer;
            }
            default -> {
                return  "EXCEPTION";
            }

        }



    }



}

