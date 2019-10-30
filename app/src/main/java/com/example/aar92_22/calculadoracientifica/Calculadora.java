package com.example.aar92_22.calculadoracientifica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Calculadora extends AppCompatActivity{

    TextView total;

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPunto;
    Button btnAC, btnInverso, btnRaiz, btnEntre, btnPor, btnMenos, btnMas, btnIgual, btnPorcentaje;

    private static final String TOTAL_TAG = "total";

    public static Double resultado;

    int resultadoEntero, invertirEntero;

    Double parainvertir;
    Double num1, num2;

    String operador;

    boolean presionado = true;


    //Variables calculadora cientifica

    Button btnxInverso, btnxAlCuadrado, btnxAlCubo, btnxFactorial;
    Button btnPi, btnAbsoluto, btnDeg;
    Button btnHipotenusa, btnElevar, btnEuler, btnExp;
    Button btnSeno, btnCos, btnTan, btnDiezElevado;
    Button btnSenoInverso, btnCosInverso, btnTanInverso, btnRad, btnEulerElevado;
    Button btnLog, btnLn, btnRaizCubica;
    String grados = "deg";

    final double pi = Math.PI;
    final double e = Math.E;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn0 = (Button) findViewById(R.id.n0);
        btn1 = (Button) findViewById(R.id.n1);
        btn2 = (Button) findViewById(R.id.n2);
        btn3 = (Button) findViewById(R.id.n3);
        btn4 = (Button) findViewById(R.id.n4);
        btn5 = (Button) findViewById(R.id.n5);
        btn6 = (Button) findViewById(R.id.n6);
        btn7 = (Button) findViewById(R.id.n7);
        btn8 = (Button) findViewById(R.id.n8);
        btn9 = (Button) findViewById(R.id.n9);
        btnPunto = (Button) findViewById(R.id.punto);
        btnAC = (Button) findViewById(R.id.borrar);
        btnInverso = (Button) findViewById(R.id.inverso);
        btnRaiz = (Button) findViewById(R.id.raiz);
        btnEntre = (Button) findViewById(R.id.entre);
        btnPor = (Button) findViewById(R.id.por);
        btnMenos = (Button) findViewById(R.id.menos);
        btnMas = (Button) findViewById(R.id.mas);
        btnIgual = (Button) findViewById(R.id.igual);
        btnPorcentaje = (Button) findViewById(R.id.porciento);
        btnxInverso = (Button) findViewById(R.id.elevadoaMenosuno);
        btnxAlCuadrado = (Button) findViewById(R.id.alcuadrado);
        btnxAlCubo = (Button) findViewById(R.id.alcubo);
        btnxFactorial = (Button) findViewById(R.id.xfactorial);
        btnPi = (Button) findViewById(R.id.pi);
        btnHipotenusa = (Button) findViewById(R.id.hipotenusa);
        btnElevar = (Button) findViewById(R.id.potencia);
        btnEuler = (Button) findViewById(R.id.e);
        btnExp = (Button) findViewById(R.id.exponente);
        btnSeno = (Button) findViewById(R.id.seno);
        btnCos = (Button) findViewById(R.id.coseno);
        btnTan = (Button) findViewById(R.id.tangente);
        btnDiezElevado = (Button) findViewById(R.id.diezelevado);
        btnSenoInverso = (Button) findViewById(R.id.senoinverso);
        btnCosInverso = (Button) findViewById(R.id.cosenoinverso);
        btnTanInverso = (Button) findViewById(R.id.tangenteinverso);
        btnRad = (Button) findViewById(R.id.radianes);
        btnEulerElevado = (Button) findViewById(R.id.eelevado);
        btnLog = (Button) findViewById(R.id.logaritmo);
        btnLn = (Button) findViewById(R.id.logaritmonatural);
        btnRaizCubica = (Button) findViewById(R.id.raizcubica);
        btnDeg = (Button) findViewById(R.id.degree);
        btnAbsoluto = (Button) findViewById(R.id.absoluto);




        total = (TextView) findViewById(R.id.resultados);



        if (savedInstanceState != null) {
            String numberDisplayed = savedInstanceState.getString(TOTAL_TAG);
            total.setText(numberDisplayed);
        }



    }













    public void onClickbtn0(View view){
        total.setText(total.getText() + "0");
    }
    public void onClickbtn1(View view){
        total.setText(total.getText() + "1");
    }
    public void onClickbtn2(View view){
        total.setText(total.getText() + "2");
    }
    public void onClickbtn3(View view){
        total.setText(total.getText() + "3");
    }
    public void onClickbtn4(View view){
        total.setText(total.getText() + "4");
    }
    public void onClickbtn5(View view){
        total.setText(total.getText() + "5");
    }
    public void onClickbtn6(View view){
        total.setText(total.getText() + "6");
    }
    public void onClickbtn7(View view){
        total.setText(total.getText() + "7");
    }
    public void onClickbtn8(View view){
        total.setText(total.getText() + "8");
    }
    public void onClickbtn9(View view){
        total.setText(total.getText() + "9");
    }
    public void onClickbtnPunto(View view){
        total.setText(total.getText() + ".");
       // num1 = num1 + ".";
        btnPunto.setClickable(false);
    }



    public void onClickbtnMas(View view){

        try {

            if(presionado) {
                operador = "+";
                capturaNumero();
                presionado=false;
            }
            else if(operador.equals("-")){
                igual();
                operador = "+";
            }
            else if(operador.equals("/")){
                igual();
                operador = "+";
            }
            else if(operador.equals("*")){
                igual();
                operador = "+";
            }

            else{
                operador = "+";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
        }
        catch (Exception ex){

        }

    }



    public void onClickbtnMenos(View view){
        try{

        if(presionado){
        capturaNumero();
        operador="-";
        presionado=false;
        }
        else if(operador.equals("+")){
        igual();
        operador="-";
        }
        else if(operador.equals("/")){
        igual();
        operador="-";
        }
        else if(operador.equals("*")){
        igual();
        operador="-";
        }

        else{
        operador="-";
        igual();
        }

        btnPunto.setClickable(true);
        btnIgual.setClickable(true);
        }
        catch(Exception ex){

        }
    }



    public void onClickbtnEntre(View view){
        try {
            if(presionado) {
                capturaNumero();
                operador = "/";
                presionado=false;
            }
            else if(operador.equals("+")){
                igual();
                operador = "/";
            }
            else if(operador.equals("-")){
                igual();
                operador = "/";
            }
            else if(operador.equals("*")){
                igual();
                operador = "/";
            }

            else{
                operador = "/";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
        }
        catch (Exception ex){

        }
    }



    public void onClickbtnPor(View view){
        try {
            if(presionado) {
                capturaNumero();
                operador = "*";
                presionado=false;
            }
            else if(operador.equals("+")){
                igual();
                operador = "*";
            }
            else if(operador.equals("-")){
                igual();
                operador = "*";
            }
            else if(operador.equals("/")){
                igual();
                operador = "*";
            }

            else{
                operador = "*";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
        }
        catch (Exception ex){

        }
    }



    public void onClickbtnRaiz(View view){
        try {
            capturaNumero();

            if(resultado >=0) {
                operador = "√";
                resultado = Math.sqrt(resultado);
                if (resultado - resultado.intValue() != 0) {
                    total.setText(resultado.toString());
                } else {
                    resultadoEntero = resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }
            else {
                total.setText("Math ERROR");
                btn0.setClickable(false);
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                btn5.setClickable(false);
                btn6.setClickable(false);
                btn7.setClickable(false);
                btn8.setClickable(false);
                btn9.setClickable(false);
                btnPunto.setClickable(false);
                btnInverso.setClickable(false);
                btnRaiz.setClickable(false);
                btnEntre.setClickable(false);
                btnPor.setClickable(false);
                btnMenos.setClickable(false);
                btnMas.setClickable(false);
                btnIgual.setClickable(false);
                btnPorcentaje.setClickable(false);
            }
        }
        catch (Exception ex){

        }
    }



    public void onClickbtnIgual(View view){

        try {
            num2 = Double.parseDouble(total.getText().toString());

            if (operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/")) {

                Calculadora.resultado = igual();

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
                Calculadora.resultado = 0.0;
                presionado = true;
                operador = "";


            } else if (operador.equals("hipo")) {

                Calculadora.resultado = Math.hypot(num1, num2);
                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (operador.equals("pot")) {
                Calculadora.resultado = Math.pow(num1, num2);
                btnElevar.setBackgroundResource(R.drawable.custom_shape_buttons_darkgray);


                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (operador.equals("exp")) {
                Calculadora.resultado = num1 * (Math.pow(10, num2));
                btnExp.setBackgroundResource(R.drawable.custom_shape_buttons_darkgray);


                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (operador.equals("diezelevado")) {
                Calculadora.resultado = (Math.pow(10, num2));
                btnDiezElevado.setBackgroundResource(R.drawable.custom_shape_buttons_darkgray);


                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (operador.equals("eelevado")) {
                Calculadora.resultado = (Math.pow(e, num2));
                btnEulerElevado.setBackgroundResource(R.drawable.custom_shape_buttons_darkgray);


                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }


            btnIgual.setClickable(true);
            btnPunto.setClickable(true);
            btnEuler.setClickable(true);
            btnPi.setClickable(true);
        } catch (Exception ex) {

        }

    }

    public void onClickbtnInverso(View view){
        try {
            parainvertir = Double.parseDouble(total.getText().toString());
            parainvertir = parainvertir*-1;

            if (parainvertir - parainvertir.intValue() != 0) {
                total.setText(parainvertir.toString());
            } else {
                invertirEntero = parainvertir.intValue();
                total.setText(String.valueOf(invertirEntero));
            }


        }
        catch (Exception ex){

        }

    }


    public void onClickbtnporciento(View view) {
        try {

            num2 = Double.parseDouble(total.getText().toString());

            if (operador.equals("*")) {
                Calculadora.resultado = Calculadora.resultado * (num2 / 100);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (operador.equals("/")) {
                Calculadora.resultado = Calculadora.resultado / (num2 / 100);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }

            btnIgual.setClickable(false);

        } catch (Exception ex) {

        }

    }


    public void onClickbtnAC(View view){
        num2 = 0.0;
        num1 = 0.0;
        resultado = 0.0;
        presionado = true;
        total.setText("");
        btn0.setClickable(true);
        btn1.setClickable(true);
        btn2.setClickable(true);
        btn3.setClickable(true);
        btn4.setClickable(true);
        btn5.setClickable(true);
        btn6.setClickable(true);
        btn7.setClickable(true);
        btn8.setClickable(true);
        btn9.setClickable(true);
        btnPunto.setClickable(true);
        btnInverso.setClickable(true);
        btnRaiz.setClickable(true);
        btnEntre.setClickable(true);
        btnPor.setClickable(true);
        btnMenos.setClickable(true);
        btnMas.setClickable(true);
        btnIgual.setClickable(true);
        btnPorcentaje.setClickable(true);


    }




    // Botones calculadora científica

    public void onClickbtnelevadoaMenosuno(View view) {
        try {
            capturaNumero2();
            num1 = Math.pow(num1, -1);
            if (num1 - num1.intValue() != 0) {
                total.setText(num1.toString());
            } else {
                resultadoEntero = num1.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }
            btnIgual.setClickable(false);
        } catch (Exception ex) {

        }
    }

    public void onClickbtndegree(View view) {
        try {
            btnDeg.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            btnRad.setBackgroundResource(R.drawable.custom_shape_buttons_darkgray);
            grados = "deg";
            btnDeg.setClickable(false);
            btnRad.setClickable(true);
            btnIgual.setClickable(false);
            total.setText("");

        } catch (Exception ex) {

        }

    }

    public void onClickbtnradianes(View view) {
        try {
            btnRad.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            btnDeg.setBackgroundResource(R.drawable.custom_shape_buttons_darkgray);
            grados = "rad";
            btnRad.setClickable(false);
            btnDeg.setClickable(true);
            btnIgual.setClickable(false);
            total.setText("");


        } catch (Exception ex) {

        }

    }

    public void onClickbtnpi(View view) {
        total.setText(String.valueOf(pi));
        btnPi.setClickable(false);
    }


    public void onClickbtnabsoluto(View view) {
        try {
            capturaNumero2();
            btnIgual.setClickable(false);
            num1 = Math.abs(num1);

            if (num1 - num1.intValue() != 0) {
                total.setText(num1.toString());
            } else {
                resultadoEntero = num1.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }

        } catch (Exception ex) {

        }

    }

    public void onClickbtnalcuadrado(View view) {
        try {
            capturaNumero2();
            num1 = Math.pow(num1, 2);

            if (num1 - num1.intValue() != 0) {
                total.setText(num1.toString());
            } else {
                resultadoEntero = num1.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }

        } catch (Exception ex) {

        }

    }

    public void onClickbtnhipotenusa(View view) {
        try {
            capturaNumero2();
            operador = "hipo";
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
        } catch (Exception ex) {

        }

    }

    public void onClickbtnpotencia(View view) {
        try {
            capturaNumero2();
            btnElevar.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            operador = "pot";
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);

        } catch (Exception ex) {

        }

    }


    public void onClickbtne(View view) {
        total.setText(String.valueOf(e));
        btnEuler.setClickable(false);
    }


    public void onClickbtnexponente(View view) {
        try {
            capturaNumero2();
            btnExp.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            operador = "exp";
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);

        } catch (Exception ex) {

        }

    }

    public void onClickbtnalcubo(View view) {
        try {
            capturaNumero2();
            num1 = Math.pow(num1, 3);

            if (num1 - num1.intValue() != 0) {
                total.setText(num1.toString());
            } else {
                resultadoEntero = num1.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }

        } catch (Exception ex) {

        }

    }

    public void onClickbtnseno(View view) {

        try {
            capturaNumero2();

            if (grados.equals("rad")) {
                Calculadora.resultado = Math.sin(num1);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }


            else if (grados.equals("deg")) {
                Calculadora.resultado = Math.toRadians(num1);
                Calculadora.resultado = Math.sin(Calculadora.resultado);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }

            }
        }catch (Exception ex){

        }




    }


    public void onClickbtncoseno(View view) {
        try {
            capturaNumero2();

            if (grados.equals("rad")) {
                Calculadora.resultado = Math.cos(num1);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (grados.equals("deg")) {
                Calculadora.resultado = Math.toRadians(num1);
                Calculadora.resultado = Math.cos(Calculadora.resultado);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }


        } catch (Exception ex) {

        }

    }

    public void onClickbtntangente(View view) {
        try {
            capturaNumero2();

            if (grados.equals("rad")) {
                Calculadora.resultado = Math.tan(num1);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (grados.equals("deg")) {
                Calculadora.resultado = Math.toRadians(num1);
                Calculadora.resultado = Math.tan(Calculadora.resultado);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }


        } catch (Exception ex) {

        }

    }


    public void onClickbtndiezelevado(View view) {
        try {
            operador = "diezelevado";
            btnDiezElevado.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);

        } catch (Exception ex) {

        }

    }

    public void onClickbtnxfactorial(View view) {
        try {
            capturaNumero2();
            int factorial = 1;
            int num;

            if (num1 - num1.intValue() != 0) {
                total.setText("Math ERROR");
                btn0.setClickable(false);
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                btn5.setClickable(false);
                btn6.setClickable(false);
                btn7.setClickable(false);
                btn8.setClickable(false);
                btn9.setClickable(false);
                btnPunto.setClickable(false);
                btnInverso.setClickable(false);
                btnRaiz.setClickable(false);
                btnEntre.setClickable(false);
                btnPor.setClickable(false);
                btnMenos.setClickable(false);
                btnMas.setClickable(false);
                btnIgual.setClickable(false);

                btnxInverso.setClickable(false);
                btnxAlCuadrado.setClickable(false);
                btnxAlCubo.setClickable(false);
                btnxFactorial.setClickable(false);
                btnDeg.setClickable(false);
                btnAbsoluto.setClickable(false);
                btnPi.setClickable(false);
                btnHipotenusa.setClickable(false);
                btnElevar.setClickable(false);
                btnEuler.setClickable(false);
                btnExp.setClickable(false);
                btnSeno.setClickable(false);
                btnCos.setClickable(false);
                btnTan.setClickable(false);
                btnDiezElevado.setClickable(false);
                btnSenoInverso.setClickable(false);
                btnCosInverso.setClickable(false);
                btnTanInverso.setClickable(false);
                btnRad.setClickable(false);
                btnEulerElevado.setClickable(false);
                btnLog.setClickable(false);
                btnLn.setClickable(false);
                btnRaizCubica.setClickable(false);
                btnPorcentaje.setClickable(false);

            } else {
                num = Math.abs(num1.intValue());

                while (num != 0) {
                    factorial = factorial * num;
                    num--;
                }

                if (num1.intValue() < 0) {
                    factorial = factorial * -1;

                } else {

                }


                total.setText(String.valueOf(factorial));
            }

        } catch (Exception ex) {

        }

    }


    public void onClickbtnsenoinverso(View view) {
        try {
            capturaNumero2();

            if(num1>1||num1<-1) {

                total.setText("Math ERROR");
                btn0.setClickable(false);
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                btn5.setClickable(false);
                btn6.setClickable(false);
                btn7.setClickable(false);
                btn8.setClickable(false);
                btn9.setClickable(false);
                btnPunto.setClickable(false);
                btnInverso.setClickable(false);
                btnRaiz.setClickable(false);
                btnEntre.setClickable(false);
                btnPor.setClickable(false);
                btnMenos.setClickable(false);
                btnMas.setClickable(false);
                btnIgual.setClickable(false);

                btnxInverso.setClickable(false);
                btnxAlCuadrado.setClickable(false);
                btnxAlCubo.setClickable(false);
                btnxFactorial.setClickable(false);
                btnDeg.setClickable(false);
                btnAbsoluto.setClickable(false);
                btnPi.setClickable(false);
                btnHipotenusa.setClickable(false);
                btnElevar.setClickable(false);
                btnEuler.setClickable(false);
                btnExp.setClickable(false);
                btnSeno.setClickable(false);
                btnCos.setClickable(false);
                btnTan.setClickable(false);
                btnDiezElevado.setClickable(false);
                btnSenoInverso.setClickable(false);
                btnCosInverso.setClickable(false);
                btnTanInverso.setClickable(false);
                btnRad.setClickable(false);
                btnEulerElevado.setClickable(false);
                btnLog.setClickable(false);
                btnLn.setClickable(false);
                btnRaizCubica.setClickable(false);
                btnPorcentaje.setClickable(false);

            }
            else{

                if (grados.equals("rad")) {
                    Calculadora.resultado = Math.asin(num1);

                    if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                        total.setText(Calculadora.resultado.toString());
                    } else {
                        resultadoEntero = Calculadora.resultado.intValue();
                        total.setText(String.valueOf(resultadoEntero));
                    }
                } else if (grados.equals("deg")) {
                    Calculadora.resultado = Math.asin(num1);
                    Calculadora.resultado = Math.toDegrees(Calculadora.resultado);

                    if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                        total.setText(Calculadora.resultado.toString());
                    } else {
                        resultadoEntero = Calculadora.resultado.intValue();
                        total.setText(String.valueOf(resultadoEntero));
                    }
                }


            }


        } catch (Exception ex) {

        }

    }


    public void onClickbtncosenoinverso(View view) {
        try {
            capturaNumero2();

            if(num1>1||num1<-1) {
                total.setText("Math ERROR");
                btn0.setClickable(false);
                btn1.setClickable(false);
                btn2.setClickable(false);
                btn3.setClickable(false);
                btn4.setClickable(false);
                btn5.setClickable(false);
                btn6.setClickable(false);
                btn7.setClickable(false);
                btn8.setClickable(false);
                btn9.setClickable(false);
                btnPunto.setClickable(false);
                btnInverso.setClickable(false);
                btnRaiz.setClickable(false);
                btnEntre.setClickable(false);
                btnPor.setClickable(false);
                btnMenos.setClickable(false);
                btnMas.setClickable(false);
                btnIgual.setClickable(false);

                btnxInverso.setClickable(false);
                btnxAlCuadrado.setClickable(false);
                btnxAlCubo.setClickable(false);
                btnxFactorial.setClickable(false);
                btnDeg.setClickable(false);
                btnAbsoluto.setClickable(false);
                btnPi.setClickable(false);
                btnHipotenusa.setClickable(false);
                btnElevar.setClickable(false);
                btnEuler.setClickable(false);
                btnExp.setClickable(false);
                btnSeno.setClickable(false);
                btnCos.setClickable(false);
                btnTan.setClickable(false);
                btnDiezElevado.setClickable(false);
                btnSenoInverso.setClickable(false);
                btnCosInverso.setClickable(false);
                btnTanInverso.setClickable(false);
                btnRad.setClickable(false);
                btnEulerElevado.setClickable(false);
                btnLog.setClickable(false);
                btnLn.setClickable(false);
                btnRaizCubica.setClickable(false);
                btnPorcentaje.setClickable(false);


            }
            else{

                if (grados.equals("rad")) {
                    Calculadora.resultado = Math.acos(num1);

                    if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                        total.setText(Calculadora.resultado.toString());
                    } else {
                        resultadoEntero = Calculadora.resultado.intValue();
                        total.setText(String.valueOf(resultadoEntero));
                    }
                } else if (grados.equals("deg")) {
                    Calculadora.resultado = Math.acos(num1);
                    Calculadora.resultado = Math.toDegrees(Calculadora.resultado);

                    if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                        total.setText(Calculadora.resultado.toString());
                    } else {
                        resultadoEntero = Calculadora.resultado.intValue();
                        total.setText(String.valueOf(resultadoEntero));
                    }
                }


            }


        } catch (Exception ex) {

        }

    }

    public void onClickbtntangenteinverso(View view) {
        try {
            capturaNumero2();

            if (grados.equals("rad")) {
                Calculadora.resultado = Math.atan(num1);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            } else if (grados.equals("deg")) {
                Calculadora.resultado = Math.atan(num1);
                Calculadora.resultado = Math.toDegrees(Calculadora.resultado);

                if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                    total.setText(Calculadora.resultado.toString());
                } else {
                    resultadoEntero = Calculadora.resultado.intValue();
                    total.setText(String.valueOf(resultadoEntero));
                }
            }


        } catch (Exception ex) {

        }

    }

    public void onClickbtneelevado(View view) {
        try {
            operador = "eelevado";
            btnEulerElevado.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            btnIgual.setClickable(true);

        } catch (Exception ex) {

        }

    }

    public void onClickbtnlogaritmo(View view) {
        try {
            capturaNumero2();
            num1 = Math.log10(num1);
            if (num1 - num1.intValue() != 0) {
                total.setText(num1.toString());
            } else {
                resultadoEntero = num1.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }
            btnIgual.setClickable(false);
        } catch (Exception ex) {

        }
    }

    public void onClickbtnlogaritmonatural(View view) {
        try {
            capturaNumero2();
            num1 = Math.log(num1);
            if (num1 - num1.intValue() != 0) {
                total.setText(num1.toString());
            } else {
                resultadoEntero = num1.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }
            btnIgual.setClickable(false);
        } catch (Exception ex) {

        }
    }

    public void onClickbtnraizcubica(View view) {
        try {
            capturaNumero();
            btnPunto.setClickable(true);

            Calculadora.resultado = Math.cbrt(Calculadora.resultado);

            if (Calculadora.resultado - Calculadora.resultado.intValue() != 0) {
                total.setText(Calculadora.resultado.toString());
            } else {
                resultadoEntero = Calculadora.resultado.intValue();
                total.setText(String.valueOf(resultadoEntero));
            }


        } catch (Exception ex) {

        }
    }










    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////METHODS/////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////



    public void capturaNumero(){
        resultado = Double.parseDouble(total.getText().toString());
        total.setText("");
    }

    public void capturaNumero2() {
        num1 = Double.parseDouble(total.getText().toString());
        total.setText("");


    }


    public Double igual(){
        try {
            num2 = Double.parseDouble(total.getText().toString());

            if (operador.equals("+")) {
                resultado = resultado + num2;
            } else if (operador.equals("-")) {
                resultado = resultado - num2;
            } else if (operador.equals("*")) {
                resultado = resultado * num2;
            } else if (operador.equals("/")) {
                resultado = resultado / num2;
            } else if (operador.equals("√")) {
                btnPunto.setClickable(true);
            } else {

            }

            total.setText("");

        } catch (Exception ex){

        }


        return resultado;
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String numberDisplayed = total.getText().toString();

        outState.putString(TOTAL_TAG, numberDisplayed);
    }




}
