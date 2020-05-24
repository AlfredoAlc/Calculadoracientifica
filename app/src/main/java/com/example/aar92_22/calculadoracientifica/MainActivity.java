package com.example.aar92_22.calculadoracientifica;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity {

    //Tag to save bundle
    private static final String TOTAL_TAG = "total";

    private static final double E = Math.E;
    private static final double PI = Math.PI;
    private static final Double percentageValue = .01;

    TextView total;

    //Calculator
    TextView btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot;
    TextView btnAC, btnInvert, btnRoot, btnDiv, btnMul, btnSub, btnAdd, btnCompute, btnPercentage;

    //Scientific calculator
    TextView btnInv, btnSquarePow, btnCubicPow, btnFactorial;
    TextView btnPi, btnAbs, btnDeg, btnRand;
    TextView btnHip, btnPow, btnEuler, btnExp;
    TextView btnSin, btnCos, btnTan, btnTenPow;
    TextView btnSinInv, btnCosInv, btnTanInv, btnRad, btnEulerPow;
    TextView btnLog, btnLn, btnCubicRoot;


    Double num1, num2;
    String grade = "deg";
    String operator = "";
    String intNumber = "";
    String decimal = "";
    String showNumber = "";
    boolean dotClicked = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        btnDot = findViewById(R.id.dot);
        btnAC = findViewById(R.id.borrar);
        btnInvert = findViewById(R.id.inverso);
        btnRoot = findViewById(R.id.raiz);
        btnDiv = findViewById(R.id.entre);
        btnMul = findViewById(R.id.por);
        btnSub = findViewById(R.id.menos);
        btnAdd = findViewById(R.id.mas);
        btnCompute = findViewById(R.id.igual);
        btnPercentage = findViewById(R.id.porciento);
        btnInv = findViewById(R.id.elevadoaMenosuno);
        btnSquarePow = findViewById(R.id.alcuadrado);
        btnCubicPow = findViewById(R.id.alcubo);
        btnFactorial = findViewById(R.id.xfactorial);
        btnPi = findViewById(R.id.pi);
        btnHip = findViewById(R.id.hipotenusa);
        btnPow = findViewById(R.id.potencia);
        btnEuler = findViewById(R.id.e);
        btnExp = findViewById(R.id.exponente);
        btnSin = findViewById(R.id.seno);
        btnCos = findViewById(R.id.coseno);
        btnTan = findViewById(R.id.tangente);
        btnTenPow = findViewById(R.id.diezelevado);
        btnSinInv = findViewById(R.id.senoinverso);
        btnCosInv = findViewById(R.id.cosenoinverso);
        btnTanInv = findViewById(R.id.tangenteinverso);
        btnRad = findViewById(R.id.radianes);
        btnEulerPow = findViewById(R.id.eelevado);
        btnLog = findViewById(R.id.logaritmo);
        btnLn = findViewById(R.id.logaritmonatural);
        btnCubicRoot = findViewById(R.id.raizcubica);
        btnDeg = findViewById(R.id.degree);
        btnAbs = findViewById(R.id.absoluto);
        btnRand = findViewById(R.id.random);

        total = findViewById(R.id.numberDisplay);

        if (savedInstanceState != null) {
            String numberDisplayed = savedInstanceState.getString(TOTAL_TAG);
            if(numberDisplayed != null){
                setDecimalNumber(numberDisplayed);
            }
            displayNumbers();
        }

        setStateListToButtons();
        setOperationsButtonsUnClickable();
    }



    public void onClickBtn0(View view){
        if(!showNumber.equals("")){
            inputNumber("0");
        }
    }

    public void onClickBtn1(View view){
        inputNumber("1");
    }

    public void onClickBtn2(View view){
        inputNumber("2");
    }

    public void onClickBtn3(View view){
        inputNumber("3");
    }

    public void onClickBtn4(View view){
        inputNumber("4");
    }

    public void onClickBtn5(View view){
        inputNumber("5");
    }

    public void onClickBtn6(View view){
        inputNumber("6");
    }

    public void onClickBtn7(View view){
        inputNumber("7");
    }

    public void onClickBtn8(View view){
        inputNumber("8");
    }

    public void onClickBtn9(View view){
        inputNumber("9");
    }

    public void onClickBtnDot(View view){
        dotClicked = true;
        btnDot.setClickable(false);
        if(btnAC.getText().toString().equals(getString(R.string.clear_all))){
            setUpButtonsAtFirst();
        }
        displayNumbers();
    }

    //Basic calculator clicks


    public void addOnClick(View view){
        operationClick("+");
    }

    public void subOnClick(View view){
        operationClick("-");
    }

    public void divOnClick(View view){
        operationClick("/");
    }

    public void mulOnClick(View view){
        operationClick("*");
    }

    public void rootOnClick(View view){
        if(!showNumber.equals("")){
            getNumber1();
            num1 = Math.sqrt(num1);
            operator = "";
            dotClicked = false;
            classifyNumberAndShow();
        }
    }


    public void onClickBtnInvert(View view){
        if(!showNumber.equals("")){
            getNumber1();
            num1 *= -1;
            classifyNumberAndShow();
        }
    }

    public void onClickBtnPercentage(View view) {
        if(!showNumber.equals("")){
            num2 = num1;
            getNumber1();

            num1 *= num2 * percentageValue;
            classifyNumberAndShow();
            num1 = num2;
        }
    }

    public void onClickBtnAC(View view){
        if(btnAC.getText().equals(getString(R.string.clear))){
            clearStrings();
            setBtnClickable();
            setOperationsButtonsUnClickable();
        }else{
            num2 = 0.0;
            num1 = 0.0;
        }
    }

    public void onClickBtnCompute(View view){

        if(!showNumber.equals("")){

            switch (operator) {
                case "+":
                case "-":
                case "*":
                case "/":
                    compute();
                    break;

                case "hip":
                    num2 = num1;
                    getNumber1();
                    num1 = Math.hypot(num2, num1);
                    break;

                case "pow":
                    num2 = num1;
                    getNumber1();
                    num1 = Math.pow(num2, num1);
                    btnPow.setBackgroundResource(0);
                    break;

                case "exp":
                    num2 = num1;
                    getNumber1();
                    num1 = num2 * (Math.pow(10, num1));
                    btnExp.setBackgroundResource(0);
                    break;

                case "powTen":
                    getNumber1();
                    num1 = Math.pow(10, num1);
                    btnTenPow.setBackgroundResource(0);
                    break;

                case "ePow":
                    getNumber1();
                    num1 = (Math.pow(E, num1));
                    btnEulerPow.setBackgroundResource(0);
                    break;


            }

            classifyNumberAndShow();
            operator = "";

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
            btnDot.setClickable(true);
            int orientation = getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                btnEuler.setClickable(true);
                btnPi.setClickable(true);
            }


        }

    }






    ///////// Scientific Calculator buttons ///////////

    public void onClickBtnPowMinusOne(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            try{
                num1 = Math.pow(num1, -1);
            }catch (Exception e){
                total.setText(getString(R.string.math_error));
            }
            classifyNumberAndShow();
            btnCompute.setClickable(false);
        }
    }

    public void onClickBtnDeg(View view) {
        btnDeg.setBackgroundResource(R.drawable.shape_button_selected);
        btnRad.setBackgroundResource(0);
        grade = "deg";
        btnDeg.setClickable(false);
        btnRad.setClickable(true);
        btnCompute.setClickable(false);
        clearStrings();
    }

    public void onClickBtnRad(View view) {
        btnRad.setBackgroundResource(R.drawable.shape_button_selected);
        btnDeg.setBackgroundResource(0);
        grade = "rad";
        btnRad.setClickable(false);
        btnDeg.setClickable(true);
        btnCompute.setClickable(false);
        clearStrings();
    }

    public void onClickBtnPi(View view) {
        if(showNumber.equals("")){
            if(num1 > 0.0){
                num2 = num1;
            }
            num1 = PI;
            classifyNumberAndShow();

            btnPi.setClickable(false);
            btnDot.setClickable(false);
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

    }


    public void onClickBtnAbs(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            num1 = Math.abs(num1);
            classifyNumberAndShow();
            btnCompute.setClickable(false);
        }
    }

    public void onClickBtnPowSquare(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            num1 = Math.pow(num1, 2);
            classifyNumberAndShow();
        }

    }

    public void onClickBtnHip(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            operator = "hip";
            btnDot.setClickable(true);
            btnCompute.setClickable(true);
        }
    }

    public void onClickBtnPowX(View view) {
        if(!showNumber.equals("")){
            btnPow.setBackgroundResource(R.drawable.shape_button_selected);
            getNumber1();
            operator = "pow";
            btnDot.setClickable(true);
            btnCompute.setClickable(true);
            btnTenPow.setClickable(false);
            btnEulerPow.setClickable(false);
        }

    }


    public void onClickBtnE(View view) {
        if(showNumber.equals("")){
            if(num1 > 0.0){
                num2 = num1;
            }
            num1 = E;
            classifyNumberAndShow();

            btnEuler.setClickable(false);
            btnDot.setClickable(false);
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

    }


    public void onClickBtnTenPow(View view) {
        if(!showNumber.equals("")){
            btnExp.setBackgroundResource(R.drawable.shape_button_selected);
            getNumber1();
            operator = "exp";
            btnDot.setClickable(true);
            btnCompute.setClickable(true);
            btnTenPow.setClickable(false);
            btnPow.setClickable(false);
        }

    }

    public void onClickBtnCubicPow(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            num1 = Math.pow(num1, 3);
            classifyNumberAndShow();
        }
    }

    public void onClickBtnSin(View view) {
        if(!showNumber.equals("")){
            getNumber1();

            switch (grade) {
                case "rad":
                    num1 = Math.sin(num1);
                    classifyNumberAndShow();
                    break;

                case "deg":
                    num1 = Math.toRadians(num1);
                    num1 = Math.sin(num1);
                    classifyNumberAndShow();
                    break;

            }
        }


    }


    public void onClickBtnCos(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            switch (grade){
                case "rad":
                    num1 = Math.cos(num1);
                    classifyNumberAndShow();
                    break;

                case "deg":
                    num1 = Math.toRadians(num1);
                    num1 = Math.cos(num1);
                    classifyNumberAndShow();
                    break;
            }

        }

    }

    public void onClickBtnTan(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            switch (grade) {
                case "rad":
                    num1 = Math.tan(num1);
                    classifyNumberAndShow();
                    break;

                case "deg":
                    num1 = Math.toRadians(num1);
                    num1 = Math.tan(num1);
                    classifyNumberAndShow();
                    break;
            }
        }
    }


    public void onClickBtnPowTen(View view) {
        operator = "powTen";
        btnTenPow.setBackgroundResource(R.drawable.shape_button_selected);
        btnDot.setClickable(true);
        btnCompute.setClickable(true);
        btnAC.setText(getString(R.string.clear));
        btnPow.setClickable(false);
        btnEulerPow.setClickable(false);
    }

    public void onClickBtnFactorial(View view) {
        if(!showNumber.equals("")){
            getNumber1();

            if (num1 - num1.intValue() != 0  || num1 < 0) {
                total.setText(getString(R.string.math_error));
            } else {
                for(int i = num1.intValue() - 1; i > 0; i--){
                    num1 *= i;
                }
                btnCompute.setClickable(false);
                classifyNumberAndShow();
            }
        }

    }


    public void onClickBtnSinInv(View view) {
        if(!showNumber.equals("")){
            getNumber1();

            try {
                switch (grade) {
                    case "rad":
                        num1 = Math.asin(num1);
                        classifyNumberAndShow();
                        break;

                    case "deg":
                        num1 = Math.asin(num1);
                        num1 = Math.toDegrees(num1);
                        classifyNumberAndShow();
                        break;
                }

            }catch (Exception e ) {
                total.setText(getString(R.string.math_error));
            }

        }
    }


    public void onClickBtnCosInv(View view) {
        if(!showNumber.equals("")){
            getNumber1();

            try{
                switch (grade) {
                    case "rad":
                        num1 = Math.acos(num1);
                        classifyNumberAndShow();
                        break;

                    case "deg":
                        num1 = Math.acos(num1);
                        num1 = Math.toDegrees(num1);
                        classifyNumberAndShow();
                        break;
                }
            }catch (Exception e){
                total.setText(getString(R.string.math_error));
            }
        }
    }

    public void onClickBtnTanInv(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            switch (grade) {
                case "rad":
                    num1 = Math.atan(num1);
                    classifyNumberAndShow();
                    break;

                case "deg":
                    num1 = Math.atan(num1);
                    num1 = Math.toDegrees(num1);
                    classifyNumberAndShow();
                    break;
            }
        }

    }

    public void onClickBtnEPow(View view) {
        operator = "ePow";
        btnEulerPow.setBackgroundResource(R.drawable.shape_button_selected);
        btnCompute.setClickable(true);
        btnTenPow.setClickable(false);
        btnPow.setClickable(false);
    }

    public void onClickBtnLog(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            num1 = Math.log10(num1);
            classifyNumberAndShow();
            btnCompute.setClickable(false);
        }
    }

    public void onClickBtnLN(View view) {
        if(!showNumber.equals("")){
            getNumber1();
            num1 = Math.log(num1);
            classifyNumberAndShow();
            btnCompute.setClickable(false);
        }
    }

    public void onClickBtnCubicRoot(View view) {
        getNumber1();
        btnDot.setClickable(true);
        num1 = Math.cbrt(num1);
        classifyNumberAndShow();
    }

    public void onClickBtnRandom(View view) {
        if(num1 > 0.0){
            num2 = num1;
        }
        num1 = Math.random();
        classifyNumberAndShow();
        btnDot.setClickable(false);
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
        btnDot.setClickable(true);
        btnAC.setText(getString(R.string.clear_all));


        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            btnInv.setClickable(true);
            btnSquarePow.setClickable(true);
            btnCubicPow.setClickable(true);
            btnFactorial.setClickable(true);
            btnDeg.setClickable(true);
            btnAbs.setClickable(true);
            btnPi.setClickable(true);
            btnHip.setClickable(true);
            btnPow.setClickable(true);
            btnEuler.setClickable(true);
            btnExp.setClickable(true);
            btnSin.setClickable(true);
            btnCos.setClickable(true);
            btnTan.setClickable(true);
            btnTenPow.setClickable(true);
            btnSinInv.setClickable(true);
            btnCosInv.setClickable(true);
            btnTanInv.setClickable(true);
            btnRad.setClickable(true);
            btnEulerPow.setClickable(true);
            btnLog.setClickable(true);
            btnLn.setClickable(true);
            btnCubicRoot.setClickable(true);

            btnPow.setBackgroundResource(0);
            btnTenPow.setBackgroundResource(0);
            btnEulerPow.setBackgroundResource(0);
        }

    }
    
    private void setOperationsButtonsUnClickable(){
        btnRoot.setClickable(false);
        btnDiv.setClickable(false);
        btnMul.setClickable(false);
        btnSub.setClickable(false);
        btnAdd.setClickable(false);
        btnCompute.setClickable(false);
        btnPercentage.setClickable(false);
    }

    private void setUpButtonsAtFirst(){
        btnRoot.setClickable(true);
        btnDiv.setClickable(true);
        btnMul.setClickable(true);
        btnSub.setClickable(true);
        btnAdd.setClickable(true);
        btnPercentage.setClickable(true);
        btnAC.setText(getString(R.string.clear));
    }

    public void displayNumbers (){
        if(intNumber.length() < 4){
            showNumber = intNumber;
        }else{
            switch (intNumber.length()) {
                case 4:
                    showNumber = runLoops(0,0);
                    break;
                case 5:
                    showNumber = runLoops(1,1);
                    break;
                case 6:
                    showNumber = runLoops(2,2);
                    break;
                case 7:
                    showNumber = runLoops(0,3);
                    break;
                case 8:
                    showNumber = runLoops(1,4);
                    break;
                case 9:
                    showNumber = runLoops(2,5);

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
                    btnDot.setClickable(false);
                    break;

            }

        }

        if((dotClicked || !decimal.equals("")) && showNumber.length() < 12){
            showNumber += ".";
            showNumber += decimal;
        }

        total.setText(showNumber);
    }


    public void getNumber1(){
        if(decimal.equals("")){
            num1 = Double.parseDouble(intNumber);
        } else {
            num1 = Double.parseDouble(intNumber + "." + decimal);
        }
        clearStrings();
    }

    private void compute(){
        num2 = num1;
        getNumber1();

        switch (operator){
            case "+":
                num1 += num2;
                break;
            case "-":
                num1 = num2 - num1;
                break;
            case "*":
                num1 *= num2;
                break;
            case "/":
                try {
                    num1 = num2 / num1;
                }catch (Exception e){
                    total.setText(getString(R.string.math_error));
                    intNumber = "";
                    decimal = "";
                    showNumber = "";
                    dotClicked = false;
                }
                break;
        }
    }


    public void setDecimalNumber(String number){
        String [] numberSplit = number.split("\\.");
        intNumber = numberSplit[0];
        if(numberSplit.length == 2){
            decimal = numberSplit[1];
        }
    }

    public void classifyNumberAndShow(){
        if (num1 - num1.intValue() != 0) {
            setDecimalNumber(String.valueOf(num1));
            displayNumbers();
        } else {
            intNumber = String.valueOf(num1.intValue());
            displayNumbers();
        }
    }

    private void clearStrings(){
        total.setText("");
        intNumber = "";
        decimal = "";
        showNumber = "";
        dotClicked = false;
    }

    private String runLoops(int j, int k){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<intNumber.length(); i++){
            builder.append(intNumber.charAt(i));
            if(i == j || i == k){
                builder.append(",");
            }
        }
        return builder.toString();
    }

    private void inputNumber(String num){
        if(btnAC.getText().toString().equals(getString(R.string.clear_all))){
            setUpButtonsAtFirst();
        }

        if(dotClicked || !decimal.equals("")){
            decimal += num;
        }else {
            intNumber += num;
        }
        displayNumbers();
    }

    private void operationClick(String op){
        if(!showNumber.equals("")){
            if (operator.equals("")) {
                getNumber1();
            }else{
                compute();
            }
            operator = op;
            btnCompute.setClickable(true);
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
        btnDot.setClickable(true);
    }

    private void setStateListToButtons() {

        btn0.setBackground(setStateListDrawablePressed());
        btn1.setBackground(setStateListDrawablePressed());
        btn2.setBackground(setStateListDrawablePressed());
        btn3.setBackground(setStateListDrawablePressed());
        btn4.setBackground(setStateListDrawablePressed());
        btn5.setBackground(setStateListDrawablePressed());
        btn6.setBackground(setStateListDrawablePressed());
        btn7.setBackground(setStateListDrawablePressed());
        btn8.setBackground(setStateListDrawablePressed());
        btn9.setBackground(setStateListDrawablePressed());
        btnDot.setBackground(setStateListDrawablePressed());
        btnAC.setBackground(setStateListDrawablePressed());
        btnInvert.setBackground(setStateListDrawablePressed());
        btnRoot.setBackground(setStateListDrawablePressed());
        btnDiv.setBackground(setStateListDrawablePressed());
        btnMul.setBackground(setStateListDrawablePressed());
        btnSub.setBackground(setStateListDrawablePressed());
        btnAdd.setBackground(setStateListDrawablePressed());
        btnCompute.setBackground(setStateListDrawablePressed());
        btnPercentage.setBackground(setStateListDrawablePressed());

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            btnInv.setBackground(setStateListDrawablePressed());
            btnSquarePow.setBackground(setStateListDrawablePressed());
            btnCubicPow.setBackground(setStateListDrawablePressed());
            btnFactorial.setBackground(setStateListDrawablePressed());
            btnPi.setBackground(setStateListDrawablePressed());
            btnHip.setBackground(setStateListDrawablePressed());
            btnPow.setBackground(setStateListDrawablePressed());
            btnEuler.setBackground(setStateListDrawablePressed());
            btnExp.setBackground(setStateListDrawablePressed());
            btnSin.setBackground(setStateListDrawablePressed());
            btnCos.setBackground(setStateListDrawablePressed());
            btnTan.setBackground(setStateListDrawablePressed());
            btnTenPow.setBackground(setStateListDrawablePressed());
            btnSinInv.setBackground(setStateListDrawablePressed());
            btnCosInv.setBackground(setStateListDrawablePressed());
            btnTanInv.setBackground(setStateListDrawablePressed());
            btnEulerPow.setBackground(setStateListDrawablePressed());
            btnLog.setBackground(setStateListDrawablePressed());
            btnLn.setBackground(setStateListDrawablePressed());
            btnCubicRoot.setBackground(setStateListDrawablePressed());
            btnAbs.setBackground(setStateListDrawablePressed());
            btnRand.setBackground(setStateListDrawablePressed());

        }
    }



    private StateListDrawable setStateListDrawablePressed(){
        Drawable transparentShape = ContextCompat.getDrawable(this,R.drawable.shape_button_white_pressed);
        if(transparentShape != null){
            transparentShape.setAlpha(100);
        }

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[] {android.R.attr.state_pressed},transparentShape);

        return stateListDrawable;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(decimal.equals("")){
            outState.putString(TOTAL_TAG, intNumber);
        } else {
            outState.putString(TOTAL_TAG, intNumber + "." + decimal);
        }

    }



}
