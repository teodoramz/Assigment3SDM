package com.google.android.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.google.android.calculator.databinding.ActivityMainBinding;

import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private com.google.android.calculator.databinding.ActivityMainBinding binding;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        decimalFormat = new DecimalFormat("#.######");
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + ".");
            }
        });
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });
        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });
        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });
        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });
        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });
        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });
        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });
        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });
        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });
        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        //Math Operation Buttons
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create computation function later
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.editText.setText(null);
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create computation function later
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.editText.setText(null);
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create computation function later
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "*");
                binding.editText.setText(null);
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create computation function later
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                binding.infoTextView.setText(binding.infoTextView.getText().toString()
                        + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editText.getText().length() > 0) {
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.editText.setText("");
                    binding.infoTextView.setText("");
                }
            }
        });
    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);
            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            valueOne = Double.parseDouble(binding.editText.getText().toString());
        }
    }
}