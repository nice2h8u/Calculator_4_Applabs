package nicetoh8u.calculator_4_applabs;

import java.util.ArrayList;

/**
 * Created by Ilya on 30.07.2018.
 */

public class Calculator{



    private float  temp = 0;

    public float calculate(float arg1, String atom,float arg2 ){
        switch(atom){
            case "+":
                temp = arg1 + arg2;
            break;
            case "-":
                temp = arg1 - arg2;
                break;
            case "/":
                if (arg2!=0)
                    temp = arg1 / arg2;
                else temp = arg1;
                break;
            case "*":
                temp = arg1 * arg2;
                break;
                default:
                    System.out.println("You enter the wrong operation");
                    break;
        }

        return temp;
    }

    public String[] findArguments(String calculate_area){

        String[] args = new String[3];
        char[] charTemp = calculate_area.toCharArray();
        for (int i=0;i<charTemp.length;i++)
            if ((charTemp[i]=='+')|(charTemp[i]=='-')|(charTemp[i]=='*')|(charTemp[i]=='/')) {
                args[0] = calculate_area.substring(0, i);
                args[1] = calculate_area.substring(i,i+1);
                args[2] = calculate_area.substring(i+1,calculate_area.length());
            }
        return args;
    }



}
