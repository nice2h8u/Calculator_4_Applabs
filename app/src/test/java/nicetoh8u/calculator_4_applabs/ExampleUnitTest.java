package nicetoh8u.calculator_4_applabs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Calculator calc = new Calculator();

    @Test
    public void check_sum() throws Exception {

        assertEquals(6,calc.calculate(3,"+",3),0);

    }

    @Test
    public void check_sum_with_2_negative_par() throws Exception {

        assertEquals(-6,calc.calculate(-3,"+",-3),0);

    }

    @Test
    public void check_sum_with_1_negative_par_1() throws Exception {

        assertEquals(1,calc.calculate(-3,"+",4),0);

    }

    @Test
    public void check_sum_with_1_negative_par_2() throws Exception {

        assertEquals(-1,calc.calculate(3,"+",-4),0);

    }

    @Test
    public void check_minus() throws Exception {

        assertEquals(0.5,calc.calculate((float)3.5,"-",3),0);

    }

    @Test
    public void check_minus_with_2_negative_par() throws Exception {

        assertEquals(-0.5,calc.calculate((float)-3.5,"-",-3),0);

    }


    @Test
    public void check_minus_with_1_negative_par_1() throws Exception {

        assertEquals(-6.5,calc.calculate((float)-3.5,"-",3),0);

    }

    @Test
    public void check_minus_with_1_negative_par_2() throws Exception {

        assertEquals(6.5,calc.calculate((float)3.5,"-",-3),0);

    }
    @Test
    public void check_division() throws Exception {

        assertEquals(6.2,calc.calculate((float)18.6,"/",3),0.00001);

    }

    @Test
    public void check_division_with_2_negative_par() throws Exception {

        assertEquals(6.2,calc.calculate((float)-18.6,"/",-3),0.0001);

    }

    @Test
    public void check_division_with_1_negative_par_1() throws Exception {

        assertEquals(-6.2,calc.calculate((float)-18.6,"/",3),0.0001);

    }

    @Test
    public void check_division_with_1_negative_par_2() throws Exception {

        assertEquals(-6.2,calc.calculate((float)18.6,"/",-3),0.0001);

    }

    @Test
    public void check_division_on_null() throws Exception {

        assertEquals(3,calc.calculate(3,"/",0),0);

    }

    @Test
    public void check_multiplication() throws Exception {

        assertEquals(1.8,calc.calculate((float)0.6,"*",3),0.0001);

    }

    @Test
    public void check_multiplication_with_2_negative_par() throws Exception {

        assertEquals(1.8,calc.calculate((float)-0.6,"*",-3),0.0001);

    }

    @Test
    public void check_multiplication_with_1_negative_par_1() throws Exception {

        assertEquals(-1.8,calc.calculate((float)-0.6,"*",3),0.0001);

    }


    @Test
    public void check_multiplication_with_1_negative_par_2() throws Exception {

        assertEquals(-1.8,calc.calculate((float)0.6,"*",-3),0.0001);

    }



    @Test
    public void check_all_operations() throws Exception {

        //1.8
        float temp1 = calc.calculate((float)0.6,"*",3);

        //0.9
        float temp2 = calc.calculate(temp1,"/",2);

        //2
        float temp3 = calc.calculate(temp2,"+",(float)1.1);

        assertEquals(1,calc.calculate(temp3,"-",1),0.00001);

    }


    @Test
    public void check_finding_aruments() throws Exception {
        String[] check =new String[3];
        check[0] = "12";
        check[1] = "+";
        check[2] = "25";
        assertEquals(check,calc.findArguments("12+25"));

    }

}