package com.example.aar92_22.calculadoracientifica;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;


public class Calculadora extends AppCompatActivity{

    TextView total;

    TextView btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPunto;
    TextView btnAC, btnInverso, btnRaiz, btnEntre, btnPor, btnMenos, btnMas, btnIgual, btnPorcentaje;

    private static final String TOTAL_TAG = "total";

    public static Double resultado;

    public static Double percentageValue = .01;

    int resultadoEntero, invertirEntero;

    Double parainvertir;
    Double num1, num2;

    String operador;

    boolean basicOperationClicked = true;


    //Variables calculadora cientifica

    TextView btnxInverso, btnxAlCuadrado, btnxAlCubo, btnxFactorial;
    TextView btnPi, btnAbsoluto, btnDeg;
    TextView btnHipotenusa, btnElevar, btnEuler, btnExp;
    TextView btnSeno, btnCos, btnTan, btnDiezElevado;
    TextView btnSenoInverso, btnCosInverso, btnTanInverso, btnRad, btnEulerElevado;
    TextView btnLog, btnLn, btnRaizCubica;
    String grados = "deg";


    final double e = Math.E;

    ArrayList<String> initialNumber;
    String showNumber = "";
    String decimal = "";
    boolean puntoClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn0 = findViewById(R.id.n0);
        btn1 = findViewById(R.id.n1);
        btn2 = findViewById(R.id.n2);
        btn3 = findViewById(R.id.n3);
        btn4 = findViewById(R.id.n4);
        btn5 = findViewById(R.id.n5);
        btn6 = findViewById(R.id.n6);
        btn7 = findViewById(R.id.n7);
        btn8 = findViewById(R.id.n8);
        btn9 = findViewById(R.id.n9);
        btnPunto = findViewById(R.id.punto);
        btnAC = findViewById(R.id.borrar);
        btnInverso = findViewById(R.id.inverso);
        btnRaiz = findViewById(R.id.raiz);
        btnEntre = findViewById(R.id.entre);
        btnPor = findViewById(R.id.por);
        btnMenos = findViewById(R.id.menos);
        btnMas = findViewById(R.id.mas);
        btnIgual = findViewById(R.id.igual);
        btnPorcentaje = findViewById(R.id.porciento);
        btnxInverso = findViewById(R.id.elevadoaMenosuno);
        btnxAlCuadrado = findViewById(R.id.alcuadrado);
        btnxAlCubo = findViewById(R.id.alcubo);
        btnxFactorial = findViewById(R.id.xfactorial);
        btnPi = findViewById(R.id.pi);
        btnHipotenusa = findViewById(R.id.hipotenusa);
        btnElevar = findViewById(R.id.potencia);
        btnEuler = findViewById(R.id.e);
        btnExp = findViewById(R.id.exponente);
        btnSeno = findViewById(R.id.seno);
        btnCos = findViewById(R.id.coseno);
        btnTan = findViewById(R.id.tangente);
        btnDiezElevado = findViewById(R.id.diezelevado);
        btnSenoInverso = findViewById(R.id.senoinverso);
        btnCosInverso = findViewById(R.id.cosenoinverso);
        btnTanInverso = findViewById(R.id.tangenteinverso);
        btnRad = findViewById(R.id.radianes);
        btnEulerElevado = findViewById(R.id.eelevado);
        btnLog = findViewById(R.id.logaritmo);
        btnLn = findViewById(R.id.logaritmonatural);
        btnRaizCubica = findViewById(R.id.raizcubica);
        btnDeg = findViewById(R.id.degree);
        btnAbsoluto = findViewById(R.id.absoluto);




        total = findViewById(R.id.resultados);



        if (savedInstanceState != null) {
            String numberDisplayed = savedInstanceState.getString(TOTAL_TAG);
            total.setText(numberDisplayed);
        }


        initialNumber = new ArrayList<>();

        btnIgual.setClickable(false);


    }













    public void onClickbtn0(View view){

        if(initialNumber.isEmpty() && !puntoClicked){
            initialNumber.add("0");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }
        else{
            if(puntoClicked){
                decimal += "0";
            }else {
                initialNumber.add("0");
            }
            displayNumbers();
        }

    }
    public void onClickbtn1(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("1");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "1";
            }else {
                initialNumber.add("1");
            }
            displayNumbers();
        }
    }
    public void onClickbtn2(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("2");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "2";
            }else {
                initialNumber.add("2");
            }
            displayNumbers();
        }
    }
    public void onClickbtn3(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("3");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "3";
            }else {
                initialNumber.add("3");
            }
            displayNumbers();
        }

    }
    public void onClickbtn4(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("4");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "4";
            }else {
                initialNumber.add("4");
            }
            displayNumbers();
        }
    }
    public void onClickbtn5(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("5");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "5";
            }else {
                initialNumber.add("5");
            }
            displayNumbers();
        }
    }
    public void onClickbtn6(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("6");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "6";
            }else {
                initialNumber.add("6");
            }
            displayNumbers();
        }
    }
    public void onClickbtn7(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("7");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "7";
            }else {
                initialNumber.add("7");
            }
            displayNumbers();
        }
    }
    public void onClickbtn8(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("8");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "8";
            }else {
                initialNumber.add("8");
            }
            displayNumbers();
        }
    }
    public void onClickbtn9(View view){
        if(initialNumber.isEmpty()){
            initialNumber.add("9");
            showNumber = initialNumber.get(0);
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            if(puntoClicked){
                decimal += "9";
            }else {
                initialNumber.add("9");
            }
            displayNumbers();
        }
    }
    public void onClickbtnPunto(View view){
        puntoClicked = true;
        btnPunto.setClickable(false);

        if(initialNumber.isEmpty()){
            initialNumber.add("0");
            showNumber = initialNumber.get(0);
            showNumber += ".";
            total.setText(showNumber);
            btnAC.setText(getString(R.string.clear));
        }else{
            displayNumbers();
        }

    }





    public void onClickbtnMas(View view){

        if(initialNumber.size() > 0) {

            if (basicOperationClicked) {
                operador = "+";
                capturaNumero();
                basicOperationClicked = false;
            } else if (operador.equals("-")) {
                igual();
                operador = "+";
            } else if (operador.equals("/")) {
                igual();
                operador = "+";
            } else if (operador.equals("*")) {
                igual();
                operador = "+";
            } else {
                operador = "+";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
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

        }

    }



    public void onClickbtnMenos(View view){

        if(initialNumber.size() > 0) {

            if (basicOperationClicked) {
                capturaNumero();
                operador = "-";
                basicOperationClicked = false;
            } else if (operador.equals("+")) {
                igual();
                operador = "-";
            } else if (operador.equals("/")) {
                igual();
                operador = "-";
            } else if (operador.equals("*")) {
                igual();
                operador = "-";
            } else {
                operador = "-";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
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
        }
    }



    public void onClickbtnEntre(View view){
        if(initialNumber.size() > 0) {

            if (basicOperationClicked) {
                capturaNumero();
                operador = "/";
                basicOperationClicked = false;
            } else if (operador.equals("+")) {
                igual();
                operador = "/";
            } else if (operador.equals("-")) {
                igual();
                operador = "/";
            } else if (operador.equals("*")) {
                igual();
                operador = "/";
            } else {
                operador = "/";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
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
        }
    }



    public void onClickbtnPor(View view){
        if(initialNumber.size() > 0) {

            if (basicOperationClicked) {
                capturaNumero();
                operador = "*";
                basicOperationClicked = false;
            } else if (operador.equals("+")) {
                igual();
                operador = "*";
            } else if (operador.equals("-")) {
                igual();
                operador = "*";
            } else if (operador.equals("/")) {
                igual();
                operador = "*";
            } else {
                operador = "*";
                igual();
            }

            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
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
        }
    }



    public void onClickbtnRaiz(View view){
        if(initialNumber.size() > 0) {
            capturaNumero();

            resultado = Math.sqrt(resultado);
            clasifyNumberAndShow();

        }
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

    }



    public void onClickbtnIgual(View view){

        if(initialNumber.size() > 0) {
            num2 = Double.parseDouble(getNumber());

            switch (operador) {

                case "+":
                case "-":
                case "*":
                case "/":
                    resultado = igual();

                    clasifyNumberAndShow();
                    resultado = 0.0;
                    basicOperationClicked = true;
                    operador = "";


                    break;

                case "hipo":
                    resultado = Math.hypot(num1, num2);
                    clasifyNumberAndShow();

                    btnEuler.setClickable(true);
                    btnPi.setClickable(true);

                    break;

                case "pot":
                    resultado = Math.pow(num1, num2);
                    btnElevar.setBackgroundResource(0);
                    clasifyNumberAndShow();

                    btnEuler.setClickable(true);
                    btnPi.setClickable(true);
                    btnElevar.setClickable(false);

                    break;

                case "exp":
                    resultado = num1 * (Math.pow(10, num2));
                    btnExp.setBackgroundResource(0);

                    clasifyNumberAndShow();
                    btnEuler.setClickable(true);
                    btnPi.setClickable(true);
                    btnExp.setClickable(false);

                    break;

                case "diezelevado":
                    resultado = (Math.pow(10, num2));
                    btnDiezElevado.setBackgroundResource(0);
                    clasifyNumberAndShow();
                    btnEuler.setClickable(true);
                    btnPi.setClickable(true);
                    btnDiezElevado.setClickable(false);

                    break;

                case "eelevado":
                    resultado = (Math.pow(e, num2));
                    btnEulerElevado.setBackgroundResource(0);
                    clasifyNumberAndShow();
                    btnEuler.setClickable(true);
                    btnPi.setClickable(true);
                    btnEulerElevado.setClickable(false);
                    break;


            }


            btnIgual.setClickable(false);
            btnPunto.setClickable(true);
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


        }

    }

    public void onClickbtnInverso(View view){
        if(initialNumber.size() > 0 ) {
            parainvertir = Double.parseDouble(getNumber());
            parainvertir = parainvertir * -1;

            if (parainvertir - parainvertir.intValue() != 0) {
                setNumber(String.valueOf(parainvertir));
                total.setText(getNumber());
            } else {
                invertirEntero = parainvertir.intValue();
                setIntNumber(String.valueOf(invertirEntero));
                total.setText(getNumber());
            }

        }

    }


    public void onClickbtnporciento(View view) {

        if(initialNumber.size() > 0) {
            num2 = Double.parseDouble(getNumber());

            Double percentage = resultado;
            if(!basicOperationClicked){
                percentage = percentage * num2 * percentageValue;
            } else {
                percentage = num2 * percentageValue;
            }



            if (percentage - percentage.intValue() != 0) {
                setNumber(String.valueOf(percentage));
                total.setText(getNumber());

            } else {
                resultadoEntero = percentage.intValue();
                setIntNumber(String.valueOf(resultadoEntero));
                total.setText(getNumber());

            }

        }

    }


    public void onClickbtnAC(View view){

        if(btnAC.getText().equals(getString(R.string.clear))){
            basicOperationClicked = true;
            initialNumber.clear();
            showNumber = "";
            decimal = "";
            puntoClicked = false;
            total.setText("");
            btnAC.setText(getString(R.string.clear_all));
            btnElevar.setBackgroundResource(0);
            btnDiezElevado.setBackgroundResource(0);
            btnEulerElevado.setBackgroundResource(0);
            setBtnClickable();
        }else{
            num2 = 0.0;
            num1 = 0.0;
            resultado = 0.0;
        }

    }






    ///////// Scientific Calculator buttons ///////////

    public void onClickbtnelevadoaMenosuno(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();
            resultado = Math.pow(resultado, -1);
            clasifyNumberAndShow();
            btnIgual.setClickable(false);
        }else{
            total.setText(getString(R.string.math_error));
        }
        btnAC.setText(getString(R.string.clear));

    }

    public void onClickbtndegree(View view) {
        btnDeg.setBackgroundResource(R.drawable.custom_shape_button_pressed);
        btnRad.setBackgroundResource(0);
        grados = "deg";
        btnDeg.setClickable(false);
        btnRad.setClickable(true);
        btnIgual.setClickable(false);
        total.setText("");
    }

    public void onClickbtnradianes(View view) {
        btnRad.setBackgroundResource(R.drawable.custom_shape_button_pressed);
        btnDeg.setBackgroundResource(0);
        grados = "rad";
        btnRad.setClickable(false);
        btnDeg.setClickable(true);
        btnIgual.setClickable(false);
        total.setText("");
    }

    public void onClickbtnpi(View view) {
        setNumber(String.valueOf(Math.PI));
        total.setText(getNumber());

        btnPi.setClickable(false);
        btnPunto.setClickable(false);
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

        btnAC.setText(getString(R.string.clear));
    }


    public void onClickbtnabsoluto(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();
            resultado = Math.abs(resultado);
            clasifyNumberAndShow();
            btnIgual.setClickable(false);
        }


    }

    public void onClickbtnalcuadrado(View view) {

        if(initialNumber.size() > 0){
            capturaNumero();
            resultado = Math.pow(resultado, 2);
            clasifyNumberAndShow();
        }

    }

    public void onClickbtnhipotenusa(View view) {
        if(initialNumber.size() > 0){
            capturaNumero2();
            operador = "hipo";
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
        }

    }

    public void onClickbtnpotencia(View view) {
        if(initialNumber.size() > 0){
            capturaNumero2();
            btnElevar.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            operador = "pot";
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
            btnDiezElevado.setClickable(false);
            btnEulerElevado.setClickable(false);
        }

    }


    public void onClickbtne(View view) {
        setNumber(String.valueOf(e));
        total.setText(getNumber());
        btnEuler.setClickable(false);
        btnPunto.setClickable(false);
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

        btnAC.setText(getString(R.string.clear));

    }


    public void onClickbtnexponente(View view) {
        if(initialNumber.size() > 0){
            capturaNumero2();
            btnExp.setBackgroundResource(R.drawable.custom_shape_button_pressed);
            operador = "exp";
            btnPunto.setClickable(true);
            btnIgual.setClickable(true);
            btnDiezElevado.setClickable(false);
            btnElevar.setClickable(false);
        }

    }

    public void onClickbtnalcubo(View view) {
        if(initialNumber.size() > 0){
            capturaNumero();
            resultado = Math.pow(resultado, 3);
            clasifyNumberAndShow();
        }


    }

    public void onClickbtnseno(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();

            switch (grados) {
                case "rad":
                    resultado = Math.sin(resultado);
                    clasifyNumberAndShow();
                    break;

                case "deg":
                    resultado = Math.toRadians(resultado);
                    resultado = Math.sin(resultado);
                    clasifyNumberAndShow();
                    break;

            }
        }


    }


    public void onClickbtncoseno(View view) {
        if(initialNumber.size() > 0){
            capturaNumero();
            switch (grados){
                case "rad":
                    resultado = Math.cos(resultado);
                    clasifyNumberAndShow();
                    break;

                case "deg":
                    resultado = Math.toRadians(resultado);
                    resultado = Math.cos(resultado);
                    clasifyNumberAndShow();
                    break;
            }

        }

    }

    public void onClickbtntangente(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();
            switch (grados) {

                case "rad":
                    resultado = Math.tan(resultado);
                    clasifyNumberAndShow();
                    break;


                case "deg":
                    resultado = Math.toRadians(resultado);
                    resultado = Math.tan(resultado);
                    clasifyNumberAndShow();
                    break;
            }
        }
    }


    public void onClickbtndiezelevado(View view) {
        operador = "diezelevado";
        btnDiezElevado.setBackgroundResource(R.drawable.custom_shape_button_pressed);
        btnPunto.setClickable(true);
        btnIgual.setClickable(true);
        btnAC.setText(getString(R.string.clear));
        btnElevar.setClickable(false);
        btnEulerElevado.setClickable(false);

    }

    public void onClickbtnxfactorial(View view) {

        if(initialNumber.size() > 0) {
            capturaNumero2();
            int factorial = 1;
            int num;

            if (num1 - num1.intValue() != 0  || num1.intValue() < 0) {
                total.setText(getString(R.string.math_error));
            } else {
                num = Math.abs(num1.intValue());
                while (num != 0) {
                    factorial = factorial * num;
                    num--;
                }
                setIntNumber(String.valueOf(factorial));
                total.setText(getNumber());
            }
            btnIgual.setClickable(false);
        }


    }


    public void onClickbtnsenoinverso(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();

            if (resultado > 1 || resultado < -1) {
                total.setText(getString(R.string.math_error));

            } else {

                switch (grados) {
                    case "rad":
                        resultado = Math.asin(resultado);
                        clasifyNumberAndShow();
                        break;

                    case "deg":
                        resultado = Math.asin(resultado);
                        resultado = Math.toDegrees(resultado);
                        clasifyNumberAndShow();
                        break;

                }

            }

        }

    }


    public void onClickbtncosenoinverso(View view) {

        if(initialNumber.size() > 0) {
            capturaNumero();

            if (resultado > 1 || resultado < -1) {
                total.setText(getString(R.string.math_error));
            } else {
                switch (grados) {

                    case "rad":
                        resultado = Math.acos(resultado);
                        clasifyNumberAndShow();
                        break;


                    case "deg":
                        resultado = Math.acos(resultado);
                        resultado = Math.toDegrees(resultado);
                        clasifyNumberAndShow();
                        break;
                }

            }
        }

    }

    public void onClickbtntangenteinverso(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();
            switch (grados) {
                case "rad":
                    resultado = Math.atan(resultado);
                    clasifyNumberAndShow();
                    break;

                case "deg":
                    resultado = Math.atan(resultado);
                    resultado = Math.toDegrees(resultado);
                    clasifyNumberAndShow();
                    break;
            }
        }

    }

    public void onClickbtneelevado(View view) {
        operador = "eelevado";
        btnEulerElevado.setBackgroundResource(R.drawable.custom_shape_button_pressed);
        btnIgual.setClickable(true);
        btnDiezElevado.setClickable(false);
        btnElevar.setClickable(false);
    }

    public void onClickbtnlogaritmo(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();
            resultado = Math.log10(resultado);
            clasifyNumberAndShow();
            btnIgual.setClickable(false);
        }
    }

    public void onClickbtnlogaritmonatural(View view) {
        if(initialNumber.size() > 0) {
            capturaNumero();
            resultado = Math.log(resultado);
            clasifyNumberAndShow();
            btnIgual.setClickable(false);
        }

    }

    public void onClickbtnraizcubica(View view) {
        capturaNumero();
        btnPunto.setClickable(true);
        resultado = Math.cbrt(resultado);
        clasifyNumberAndShow();
    }

    public void onClickbtnRandom(View view) {
        setNumber(String.valueOf(Math.random()));
        total.setText(getNumber());
        btnPunto.setClickable(false);
    }






    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////METHODS/////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////



    public void setBtnClickable(){

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
        btnPorcentaje.setClickable(true);


        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            btnxInverso.setClickable(true);
            btnxAlCuadrado.setClickable(true);
            btnxAlCubo.setClickable(true);
            btnxFactorial.setClickable(true);
            btnDeg.setClickable(true);
            btnAbsoluto.setClickable(true);
            btnPi.setClickable(true);
            btnHipotenusa.setClickable(true);
            btnElevar.setClickable(true);
            btnEuler.setClickable(true);
            btnExp.setClickable(true);
            btnSeno.setClickable(true);
            btnCos.setClickable(true);
            btnTan.setClickable(true);
            btnDiezElevado.setClickable(true);
            btnSenoInverso.setClickable(true);
            btnCosInverso.setClickable(true);
            btnTanInverso.setClickable(true);
            btnRad.setClickable(true);
            btnEulerElevado.setClickable(true);
            btnLog.setClickable(true);
            btnLn.setClickable(true);
            btnRaizCubica.setClickable(true);
        }

    }


    public void displayNumbers (){

        switch (initialNumber.size()) {

            case 1:
                showNumber = initialNumber.get(0);
                break;
            case 2:
                showNumber = initialNumber.get(0);
                showNumber += initialNumber.get(1);
                break;
            case 3:
                showNumber = initialNumber.get(0);
                showNumber += initialNumber.get(1);
                showNumber += initialNumber.get(2);
                break;
            case 4:
                showNumber = initialNumber.get(0);
                showNumber += ",";
                showNumber += initialNumber.get(1);
                showNumber += initialNumber.get(2);
                showNumber += initialNumber.get(3);
                break;
            case 5:
                showNumber = initialNumber.get(0);
                showNumber += initialNumber.get(1);
                showNumber += ",";
                showNumber += initialNumber.get(2);
                showNumber += initialNumber.get(3);
                showNumber += initialNumber.get(4);
                break;
            case 6:
                showNumber = initialNumber.get(0);
                showNumber += initialNumber.get(1);
                showNumber += initialNumber.get(2);
                showNumber += ",";
                showNumber += initialNumber.get(3);
                showNumber += initialNumber.get(4);
                showNumber += initialNumber.get(5);
                break;
            case 7:
                showNumber = initialNumber.get(0);
                showNumber += ",";
                showNumber += initialNumber.get(1);
                showNumber += initialNumber.get(2);
                showNumber += initialNumber.get(3);
                showNumber += ",";
                showNumber += initialNumber.get(4);
                showNumber += initialNumber.get(5);
                showNumber += initialNumber.get(6);
                break;
            case 8:
                showNumber = initialNumber.get(0);
                showNumber += initialNumber.get(1);
                showNumber += ",";
                showNumber += initialNumber.get(2);
                showNumber += initialNumber.get(3);
                showNumber += initialNumber.get(4);
                showNumber += ",";
                showNumber += initialNumber.get(5);
                showNumber += initialNumber.get(6);
                showNumber += initialNumber.get(7);
                break;
            case 9:
                showNumber = initialNumber.get(0);
                showNumber += initialNumber.get(1);
                showNumber += initialNumber.get(2);
                showNumber += ",";
                showNumber += initialNumber.get(3);
                showNumber += initialNumber.get(4);
                showNumber += initialNumber.get(5);
                showNumber += ",";
                showNumber += initialNumber.get(6);
                showNumber += initialNumber.get(7);
                showNumber += initialNumber.get(8);
                break;

        }

        if(puntoClicked){
            showNumber += ".";
            showNumber += decimal;
        }


        total.setText(showNumber);

    }


    public void capturaNumero(){

        resultado = Double.parseDouble(getNumber());

        initialNumber.clear();
        showNumber = "";
        decimal = "";
        puntoClicked = false;

        total.setText("");
    }

    public void capturaNumero2() {

        num1 = Double.parseDouble(getNumber());

        initialNumber.clear();
        showNumber = "";
        decimal = "";
        puntoClicked = false;
        total.setText("");


    }


    public Double igual(){

        switch (operador){

            case "+":
                resultado = resultado + num2;
                break;
            case "-":
                resultado = resultado - num2;
                break;
            case "*":
                resultado = resultado * num2;
                break;
            case "/":
                resultado = resultado / num2;
                break;
            case "√":
                btnPunto.setClickable(true);
                break;

        }

        total.setText("");
        initialNumber.clear();
        showNumber = "";
        decimal = "";
        puntoClicked = false;

        return resultado;
    }



    public String getNumber(){
        String number = "";

        if(decimal.length() > 0){

            for(int i = 0; i < initialNumber.size(); i++){
                number += initialNumber.get(i);
            }

            number += ".";
            number += decimal;


        }else{

            for(int i = 0; i < initialNumber.size(); i++){
                number += initialNumber.get(i);
            }

        }

        return number;

    }

    public void setNumber (String number){
        String [] numberSplit = number.split("\\.");
        initialNumber.clear();

        for(int i = 0; i < numberSplit [0] .length(); i++){
            initialNumber.add(String.valueOf(number.charAt(i)));
        }
        decimal = numberSplit[1];


    }

    public void setIntNumber(String number){
        initialNumber.clear();
        for(int i = 0; i < number.length(); i++){
            initialNumber.add(String.valueOf(number.charAt(i)));
        }
        decimal = "";
    }


    public void clasifyNumberAndShow(){

        if (resultado - resultado.intValue() != 0) {
            total.setText(String.valueOf(resultado));
            setNumber(String.valueOf(resultado));
        } else {
            resultadoEntero = resultado.intValue();
            total.setText(String.valueOf(resultadoEntero));
            setIntNumber(String.valueOf(resultadoEntero));

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String numberDisplayed = getNumber();

        outState.putString(TOTAL_TAG, numberDisplayed);
    }



}
