package com.example.mytestapp;


import java.text.DecimalFormat;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
    private Button button_calc;
    private EditText field_height;
    private EditText field_weight;
    private TextView view_result;
    //private TextView view_suggest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		//find components
		findViews();		
		 //Listen for button clicks
        //setListeners();	

	}
	
	//function of "find components"
	private void findViews()
	{
        button_calc = (Button) findViewById(R.id.mybutton);       
        field_height = (EditText) findViewById(R.id.editheight);
        field_weight = (EditText) findViewById(R.id.editweight);
        view_result = (TextView) findViewById(R.id.resulttext);
       // view_suggest = (TextView) findViewById(R.id.suggest);
        button_calc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	DecimalFormat nf = new DecimalFormat("0.0");
       		    double height = 0.0;
                double weight = 0.0;
                double BMI = 0.0;                
                if( (field_height.getText().toString().length() == 0) ||  
                    (field_weight.getText().toString().length() == 0) )
                { // do nothing         	 
                } else {
                        height = Double.parseDouble(field_height.getText().toString())/100;
                        weight = Double.parseDouble(field_weight.getText().toString());	
                        BMI = weight / (height * height);
                        //Present result 
                        view_result.setText( nf.format(BMI));      
                }
            }
        });
		
	}	
	
	
	// Called when the user touches the button
	/*
	public void CalculateBMIValue(View view) {
		 DecimalFormat nf = new DecimalFormat("0.0");
		 double height = 0.0;
         double weight = 0.0;
         double BMI = 0.0;
         
         if( (field_height.getText().toString().length() == 0) ||  
             (field_weight.getText().toString().length() == 0) )
         { // do nothing         	 
         } else {
                 height = Double.parseDouble(field_height.getText().toString())/100;
                 weight = Double.parseDouble(field_weight.getText().toString());	
                 BMI = weight / (height * height);
                 //Present result 
                 view_result.setText( nf.format(BMI));      
         }
		
	}
	*/
    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
