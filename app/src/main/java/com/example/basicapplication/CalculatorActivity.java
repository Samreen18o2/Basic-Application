package com.example.basicapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText editText;
    private TextView resultTextView;
    private StringBuilder currentInput;
    private double operand1, operand2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText = findViewById(R.id.editText);
        resultTextView = findViewById(R.id.resultTextView);
        currentInput = new StringBuilder();
        operator = "";

        setNumberButtonClickListeners();
        setOperatorButtonClickListeners();
        setClearButtonClickListeners();
        setEqualsButtonClickListeners();
    }


    private void setNumberButtonClickListeners() {
        int[] numberButtonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int id : numberButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentInput.append(button.getText());
                    updateResult();
                }
            });
        }
    }

    private void setOperatorButtonClickListeners() {
        int[] operatorButtonIds = {R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide};

        for (int id : operatorButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentInput.length() > 0) {
                        operand1 = Double.parseDouble(currentInput.toString());
                        operator = button.getText().toString();
                        currentInput.setLength(0); // Clear current input for the next number
                    }
                }
            });
        }
    }

    private void setClearButtonClickListeners() {
        Button clearButton = findViewById(R.id.btnClear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });
    }

    private void setEqualsButtonClickListeners() {
        Button equalsButton = findViewById(R.id.btnEquals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void updateResult() {
        resultTextView.setText(currentInput.toString());
    }

    private void calculateResult() {
        if (!currentInput.toString().isEmpty() && !operator.isEmpty()) {
            operand2 = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        showToast("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            currentInput.setLength(0);
            currentInput.append(result);
            editText.setText(currentInput.toString());
            resultTextView.setText("");
            operand1 = result;
            operator = "";
        }
    }

    private void showToast(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    

    private void clearCalculator() {
        currentInput.setLength(0);
        editText.setText("");  // Clear the EditText field
        resultTextView.setText("");
        operand1 = 0;
        operand2 = 0;
        operator = "";
    }
}

