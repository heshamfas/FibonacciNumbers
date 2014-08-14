package com.hesham.fibonacci.fibonaccinumbers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MyActivity extends Activity  implements View.OnClickListener{
    EditText faboET;
    Button faboBtn;
    ArrayList<Integer> fiboNumbers = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        faboET = (EditText)findViewById(R.id.number);
        faboBtn =(Button)findViewById(R.id.btn_calculate);
        faboBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_calculate:
                String faboString = faboET.getText().toString();
                int faboN;
                if(TextUtils.isEmpty(faboString)) {
                    showGeneralDialog("Error", "Please enter a number");
                }else if (!TextUtils.isDigitsOnly(faboString)){
                showGeneralDialog("Error", "please enter digits only");
            }else {
                    faboN = Integer.parseInt(faboString);
                    if(faboN == 0 || faboN > 20){
                        showGeneralDialog("Error", "number is not in range");
                    }else{
                        displayFabonacci(faboN);
                    }

                }

                    break;
        }

    }

    // Java program for Fibonacci number using Loop.
    public  void displayFabonacci(int number){
        int fibo1=1, fibo2=1;
        fiboNumbers = new ArrayList<Integer>();
        if(number == 1){
            fiboNumbers.add(fibo1);

        }else if (number == 2){
            fiboNumbers.add(fibo1); fiboNumbers.add(fibo2);
        }else{
            int fibonacci=1;
            fiboNumbers.add(fibo1); fiboNumbers.add(fibo2);
            for(int i= 3; i<= number; i++){
                fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci numbers
                fiboNumbers.add(fibonacci);
                fibo1 = fibo2;
                fibo2 = fibonacci;
            }}

        printFibonacci();
        listFibonacci();

    }

    private void listFibonacci() {
        Intent intent = new Intent(this, ListFibonacci.class);
        intent.putIntegerArrayListExtra("fib",fiboNumbers);
        startActivity(intent);
    }

    private void printFibonacci() {
        if(fiboNumbers!=null || fiboNumbers.size()>0) {
            for (int i = 0; i < fiboNumbers.size(); i++) {
                Log.d("fibo ", " " + fiboNumbers.get(i).intValue());
            }
        }
    }

    private void showGeneralDialog(String title, String message){
        GeneralDialogFragment generalDialogFragment = new GeneralDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        generalDialogFragment.setArguments(bundle);
        generalDialogFragment.show(getFragmentManager(), "");
    }
}
