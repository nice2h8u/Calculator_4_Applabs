package nicetoh8u.calculator_4_applabs;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btn_cancel;
    private Button btn_0;
    private Button btn_minus;
    private Button btn_plus;
    private Button btn_div;
    private Button btn_multi;
    private Button btn_calc;
    private Button btn_dot;
    private Button btn_delete;
    private TextView calculate_area;
    private Calculator calculator;

    private String[] arrayOfArgs4Calculation;
    private String lastSymbol;

    private boolean flagOnSign = false;
    private boolean dotMutex = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        // initialize components
        calculate_area = (TextView) findViewById(R.id.calculate_area);
        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn_calc = (Button) findViewById(R.id.button_result);
        btn_calc.setOnClickListener(this);
        btn_plus = (Button) findViewById(R.id.button_plus);
        btn_plus.setOnClickListener(this);
        btn_minus = (Button) findViewById(R.id.button_minus);
        btn_minus.setOnClickListener(this);
        btn_div = (Button) findViewById(R.id.button_div);
        btn_div.setOnClickListener(this);
        btn_multi = (Button) findViewById(R.id.button_multi);
        btn_multi.setOnClickListener(this);
        btn_cancel = (Button) findViewById(R.id.button_cancel);
        btn_cancel.setOnClickListener(this);
        btn_0 = (Button) findViewById(R.id.button_0);
        btn_0.setOnClickListener(this);
        btn_dot = (Button) findViewById(R.id.button_dot);
        btn_dot.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.button_delete);
        btn_delete.setOnClickListener(this);

        ///


    }

    //function calculate the results and if the answer is int - cast float to int
    public void calculate_to_int() {

        arrayOfArgs4Calculation = calculator.findArguments(calculate_area.getText().toString());

        float result = calculator.calculate(Float.parseFloat(arrayOfArgs4Calculation[0]), arrayOfArgs4Calculation[1]
                , Float.parseFloat(arrayOfArgs4Calculation[2]));

        //calculate result
        if (result % 1 == 0.0) {
            calculate_area.setText(String.valueOf((int) result));
            dotMutex = true;
        } else {
            calculate_area.setText(String.valueOf(result));
            dotMutex = false;
        }

    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button:
                calculate_area.append("1");
                break;
            case R.id.button2:
                calculate_area.append("2");
                break;
            case R.id.button3:
                calculate_area.append("3");
                break;
            case R.id.button4:
                calculate_area.append("4");
                break;
            case R.id.button5:
                calculate_area.append("5");
                break;
            case R.id.button6:
                calculate_area.append("6");
                break;
            case R.id.button7:
                calculate_area.append("7");
                break;
            case R.id.button8:
                calculate_area.append("8");
                break;
            case R.id.button9:
                calculate_area.append("9");
                break;
            case R.id.button_0:
                calculate_area.append("0");
                break;

            case R.id.button_dot:
                //if calculate area is not empty
                if (calculate_area.getText().length() != 0)
                    //get last char
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();
                //if it eq to sign
                if (checkTheLastChar()) {
                    //do nothing
                }
                //if length not 0
                else if (calculate_area.getText().length() != 0)
                    //and if dotMutex is free
                    if (dotMutex) {
                        calculate_area.append(".");
                        dotMutex = false;
                    }

                break;

            case R.id.button_delete:
                //if calculate area is not empty
                if (calculate_area.getText().length() != 0)
                    //get last char
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();
                //if it eq to sign
                if (checkTheLastChar()) {
                    flagOnSign = false;
                    if (calculate_area.getText().toString().contains("."))
                        dotMutex = false;


                    else dotMutex = true;
                }
                //if it eq to dot
                if (".".equals(lastSymbol))
                    dotMutex = true;

                if (calculate_area.getText().length() <= 1)
                    calculate_area.setText("");
                else {
                    calculate_area.setText(calculate_area.getText().subSequence(0, calculate_area.getText().length() - 1));
                }


                break;
            case R.id.button_cancel:

                calculate_area.setText("");
                //if (flagOnSign)
                flagOnSign = false;
                dotMutex = true;

                break;

            case R.id.button_plus:


                if (calculate_area.getText().length() != 0)
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();

                //flag unpressed
                if ((!flagOnSign) & (calculate_area.getText().length() != 0) & !(".".equals(lastSymbol))) {

                    //+ to string
                    calculate_area.append("+");
                    //flag pressed
                    flagOnSign = true;

                    dotMutex = true;

                    //if sigh was already pressed and last symbol not +,-,*,/
                } else if (checkTheLastChar()) {
                    //swap the sign
                    calculate_area.setText(calculate_area.getText().subSequence(0, calculate_area.getText().length() - 1) + "+");
                }

                //if last char is not sign and sign was already pressed - calculate
                else if ((flagOnSign) ) {
                    calculate_to_int();

                    calculate_area.append("+");
                    //sign unpressed
                    flagOnSign = true;

                }


                break;

            case R.id.button_minus:


                if (calculate_area.getText().length() != 0)
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();

                //flag unpressed
                if ((!flagOnSign) & (calculate_area.getText().length() != 0) & !(".".equals(lastSymbol))) {

                    //+ to string
                    calculate_area.append("-");
                    //flag pressed
                    flagOnSign = true;
                    dotMutex = true;

                    //if sigh was already pressed and last symbol not +,-,*,/
                }
                else if (checkTheLastChar()) {
                    //swap the sign
                    calculate_area.setText(calculate_area.getText().subSequence(0, calculate_area.getText().length() - 1) + "-");
                }

                //if last char is not sign and sign was already pressed - calculate
                else if ((flagOnSign) ) {
                    calculate_to_int();
                    calculate_area.append("-");
                    //sign unpressed
                    flagOnSign = true;

                }


                break;

            case R.id.button_multi:


                if (calculate_area.getText().length() != 0)
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();

                //flag unpressed
                if ((!flagOnSign) & (calculate_area.getText().length() != 0) & !(".".equals(lastSymbol))) {

                    //+ to string
                    calculate_area.append("*");
                    //flag pressed
                    flagOnSign = true;
                    dotMutex = true;

                    //if sigh was already pressed and last symbol not +,-,*,/
                } else if (checkTheLastChar()) {
                    //swap the sign
                    calculate_area.setText(calculate_area.getText().subSequence(0, calculate_area.getText().length() - 1) + "*");
                }

                //if last char is not sign and sign was already pressed - calculate
                else if ((flagOnSign) &(!".".equals(lastSymbol))) {
                    calculate_to_int();
                    calculate_area.append("*");
                    //sign unpressed
                    flagOnSign = true;

                }


                break;

            case R.id.button_div:


                if (calculate_area.getText().length() != 0)
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();

                //flag unpressed
                if ((!flagOnSign) & (calculate_area.getText().length() != 0) & !(".".equals(lastSymbol))) {

                    //+ to string
                    calculate_area.append("/");
                    //flag pressed
                    flagOnSign = true;
                    dotMutex = true;

                    //if sigh was already pressed and last symbol not +,-,*,/
                } else if (checkTheLastChar()) {
                    //swap the sign
                    calculate_area.setText(calculate_area.getText().subSequence(0, calculate_area.getText().length() - 1) + "/");
                }

                //if last char is not sign and sign was already pressed - calculate
                else if ((flagOnSign) &(!".".equals(lastSymbol))) {
                    calculate_to_int();
                    calculate_area.append("/");
                    //sign unpressed
                    flagOnSign = true;

                }


                break;

            case R.id.button_result:
                // get last character
                if (calculate_area.getText().length() != 0)
                    lastSymbol = (calculate_area.getText().subSequence(calculate_area.getText().length() - 1, calculate_area.getText().length())).toString();


                if (checkTheLastChar()) {
                } else if (flagOnSign) {
                    //find arguments for calculation from calculating area

                    calculate_to_int();
                    flagOnSign = false;
                }

                break;


            default:

                break;
        }


    }

    public boolean checkTheLastChar() {
        return (("+".equals(lastSymbol)) | ("-".equals(lastSymbol)) | ("*".equals(lastSymbol))
                | ("/".equals(lastSymbol)));
    }
}
