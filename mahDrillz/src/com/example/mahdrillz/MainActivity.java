package com.example.mahdrillz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {
	public static final String[] drillSize = {"80", "79", "1/64", "78", "77", "76", "75", "74", "73", "72", "71", "70", "69", "68", "1/32", "67", "66", "65", "64", "63", "62", "61", "60", "59", "58", "57", "56", "3/64", "55", "54", "53", "1/16", "52", "51", "50", "49", "48", "5/64", "47", "46", "45", "44", "43", "42", "3/32", "41", "40", "39", "38", "37", "36", "7/64", "35", "34", "33", "32", "31", "1/8", "30", "29", "28", "9/64", "27", "26", "25", "24", "23", "5/32", "22", "21", "20", "19", "18", "11/64", "17", "16", "15", "14", "13", "3/16", "12", "11", "10", "9", "8", "7", "13/64", "6", "5", "4", "3", "7/32", "2", "1", "A", "15/64", "B", "C", "D", "1/4 (E)", "F", "G", "17/64", "H", "I", "J", "K", "9/32", "L", "M", "19/64", "N", "5/16", "O", "P", "21/64", "Q", "R", "11/32", "S", "T", "23/64", "U", "3/8", "V", "W", "25/64", "X", "Y", "13/32", "Z", "27/64", "7/16", "29/64", "15/32", "31/64", "1/2", "33/64", "17/32", "35/64", "9/16", "37/64", "19/32", "39/64", "5/8", "41/64", "21/32", "43/64", "11/16", "45/64", "23/32", "47/64", "3/4", "49/64", "25/32", "51/64", "13/16", "53/64", "27/32", "55/64", "7/8", "57/64", "29/32", "59/64", "15/16", "61/64", "31/32"};
	public static final String[] decimalEquiv = {".0135", ".0145", ".0156", ".016", ".018", ".020", ".021", ".0225", ".024", ".025", ".026", ".028", ".0292", ".031", ".0313", ".032", ".033", ".035", ".036", ".037", ".038", ".039", ".040", ".041", ".042", ".043", ".0465", ".0469", ".052", ".055", ".0595", ".0625", ".0635", ".067", ".070", ".073", ".076", ".0781", ".0785", ".081", ".082", ".086", ".089", ".0935", ".0938", ".096", ".098", ".0995", ".1015", ".104", ".1065", ".1094", ".110", ".111", ".113", ".116", ".120", ".1250", ".1285", ".136", ".1405", ".1406", ".144", ".147", ".1495", ".152", ".154", ".1563", ".157", ".159", ".161", ".166", ".1695", ".1719", ".173", ".177", ".180", ".182", ".185", ".1875", ".189", ".191", ".1935", ".196", ".199", ".201", ".2031", ".204", ".2055", ".209", ".213", ".2188", ".221", ".228", ".234", ".2344", ".238", ".242", ".246", ".250", ".257", ".261", ".2656", ".266", ".272", ".277", ".281", ".2813", ".290", ".295", ".2969", ".302", ".3125", ".316", ".323", ".3281", ".332", ".339", ".3438", ".348", ".358", ".3594", ".368", ".375", ".377", ".386", ".3906", ".397", ".404", ".4063", ".413", ".4219", ".4375", ".4531", ".4688", ".4844", ".500", ".5156", ".5313", ".5469", ".5625", ".5781", ".5938", ".6094", ".625", ".6406", ".6563", ".6719", ".6875", ".7031", ".7188", ".7344", ".750", ".7656", ".7813", ".7969", ".8125", ".8281", ".8438", ".8594", ".875", ".8906", ".9063", ".9219", ".9375", ".9531", ".9688"};
	
	public static final String[] drillSizeMetric = {"0.05 mm", "0.1 mm", "0.2 mm", "0.3 mm", "1/64 in", "0.4 mm", "0.5 mm", "0.6 mm", "0.7 mm", "1/32 in", "0.8 mm", "0.9 mm", "1 mm", "1.1 mm", "3/64 in", "1.2 mm", "1.3 mm", "1.4 mm", "1.5 mm", "1/16 in", "1.6 mm", "1.7 mm", "1.8 mm", "1.9 mm", "5/64 in", "2 mm", "2.1 mm", "2.2 mm", "2.3 mm", "3/32 in", "2.4 mm", "2.5 mm", "2.6 mm", "2.7 mm", "7/64 in", "2.8 mm", "2.9 mm", "3 mm", "3.1 mm", "1/8 in", "3.2 mm", "3.3 mm", "3.4 mm", "3.5 mm", "9/64 in", "3.6 mm", "3.7 mm", "3.8 mm", "3.9 mm", "5/32 in", "4 mm", "4.1 mm", "4.2 mm", "4.3 mm", "11/64 in", "4.4 mm", "4.5 mm", "4.6 mm", "4.7 mm", "3/16 in", "4.8 mm", "4.9 mm", "5 mm", "5.1 mm", "13/64 in", "5.2 mm", "5.3 mm", "5.4 mm", "5.5 mm", "7/32 in", "5.6 mm", "5.7 mm", "5.8 mm", "5.9 mm", "A", "15/64 in", "6 mm", "B", "6.1 mm", "C", "6.2 mm", "D", "6.3 mm", "1/4 in", "E", "6.4 mm", "6.5 mm", "F", "6.6 mm", "G", "6.7 mm", "17/64 in", "H", "6.8 mm", "6.9 mm", "I", "7 mm", "J", "7.1 mm", "K", "9/32 in", "7.2 mm", "7.3 mm", "L", "7.4 mm", "M", "7.5 mm", "19/64 in", "7.6 mm", "N", "7.7 mm", "7.8 mm", "7.9 mm", "5/16 in", "8 mm", "O", "8.1 mm", "8.2 mm", "P", "8.3 mm", "21/64 in", "8.4 mm", "Q", "8.5 mm", "8.6 mm", "R", "8.7 mm", "11/32 in", "8.8 mm", "S", "8.9 mm", "9 mm", "T", "9.1 mm", "23/64 in", "9.2 mm", "9.3 mm", "U", "9.4 mm", "9.5 mm", "3/8 in", "V", "9.6 mm", "9.7 mm", "9.8 mm", "W", "9.9 mm", "25/64 in", "10 mm", "X", "Y", "13/32 in", "Z", "10.5 mm", "27/64 in", "11 mm", "7/16 in", "11.5 mm", "29/64 in", "15/32 in", "12 mm", "31/64 in", "12.5 mm", "1/2 in", "13 mm", "33/64 in", "17/32 in", "13.5 mm", "35/64 in", "14 mm", "9/16 in", "14.5 mm", "37/64 in", "15 mm", "19/32 in", "39/64 in", "15.5 mm", "5/8 in", "16 mm", "41/64 in", "16.5 mm", "17 mm", "43/64 in", "11/16 in", "17.5 mm", "45/64 in", "18 mm", "23/32 in", "18.5 mm", "47/64 in", "19 mm", "3/4 in", "49/64 in", "19.5 mm", "25/32 in", "20 mm", "51/64 in", "20.5 mm", "13/16 in", "21 mm", "53/64 in", "27/32 in", "21.5 mm", "55/64 in", "22 mm", "7/8 in", "22.5 mm", "57/64 in", "23 mm", "29/32 in", "21/23 in", "59/64 in", "23.5 mm", "15/16 in", "24 mm", "61/64 in", "24.5 mm", "31/32 in", "25 mm", "63/64 in", "1 in", "25.5 mm", "1 1/64 in", "26 mm", "1 1/32 in", "26.5 mm", "1 3/64 in", "1 1/16 in", "27 mm", "1 5/64 in", "27.5 mm", "1 3/32 in", "28 mm", "1 7/64 in", "28.5 mm", "1 1/8 in", "1 9/64 in", "29 mm", "1 5/32 in", "29.5 mm", "1 11/64 in", "30 mm", "1 3/16 in", "30.5 mm", "1 13/64 in", "1 7/32 in", "31 mm", "1 15/64 in", "31.5 mm", "1 1/4 in", "32 mm", "1 17/64 in", "32.5 mm", "1 9/32 in", "1 19/64 in", "33 mm", "1 5/16 in", "33.5 mm", "1 21/64 in", "34 mm", "1 11/32 in", "34.5 mm", "1 23/64 in", "1 3/8 in", "35 mm", "1 25/64 in", "35.5 mm", "1 13/32 in", "36 mm", "1 27/64 in", "36.5 mm", "1 7/16 in", "1 29/64 in", "37 mm", "1 15/32 in", "37.5 mm", "1 31/64 in", "38 mm", "1 1/2 in"};

	public static final String[] drillDiameter = {"0.05", "0.1", "0.2", "0.3", "0.3969", "0.4", "0.5", "0.6", "0.7", "0.7938", "0.8", "0.9", "1", "1.1", "1.1906", "1.2", "1.3", "1.4", "1.5", "1.5875", "1.6", "1.7", "1.8", "1.9", "1.9844", "2", "2.1", "2.2", "2.3", "2.3813", "2.4", "2.5", "2.6", "2.7", "2.7781", "2.8", "2.9", "3", "3.1", "3.175", "3.2", "3.3", "3.4", "3.5", "3.5719", "3.6", "3.7", "3.8", "3.9", "3.9688", "4", "4.1", "4.2", "4.3", "4.3656", "4.4", "4.5", "4.6", "4.7", "4.7625", "4.8", "4.9", "5", "5.1", "5.1594", "5.2", "5.3", "5.4", "5.5", "5.5563", "5.6", "5.7", "5.8", "5.9", "5.9436", "5.9531", "6", "6.0452", "6.1", "6.1468", "6.2", "6.2484", "6.3", "6.35", "6.35", "6.4", "6.5", "6.5278", "6.6", "6.6294", "6.7", "6.7469", "6.7564", "6.8", "6.9", "6.9088", "7", "7.0358", "7.1", "7.1374", "7.1438", "7.2", "7.3", "7.366", "7.4", "7.493", "7.5", "7.5406", "7.6", "7.6708", "7.7", "7.8", "7.9", "7.9375", "8", "8.0264", "8.1", "8.2", "8.2042", "8.3", "8.3344", "8.4", "8.4328", "8.5", "8.6", "8.6106", "8.7", "8.7313", "8.8", "8.8392", "8.9", "9", "9.0932", "9.1", "9.1281", "9.2", "9.3", "9.3472", "9.4", "9.5", "9.525", "9.5758", "9.6", "9.7", "9.8", "9.8044", "9.9", "9.9219", "10", "10.0838", "10.2616", "10.3188", "10.4902", "10.5", "10.7156", "11", "11.1125", "11.5", "11.5094", "11.9063", "12", "12.3031", "12.5", "12.7", "13", "13.0969", "13.4938", "13.5", "13.8906", "14", "14.2875", "14.5", "14.6844", "15", "15.0813", "15.4781", "15.5", "15.875", "16", "16.2719", "16.5", "17", "17.0656", "17.4625", "17.5", "17.8594", "18", "18.2563", "18.5", "18.6531", "19", "19.05", "19.4469", "19.5", "19.8438", "20", "20.2406", "20.5", "20.6375", "21", "21.0344", "21.4313", "21.5", "21.8281", "22", "22.225", "22.5", "22.6219", "23", "23.0188", "23.1913", "23.4156", "23.5", "23.8125", "24", "24.2094", "24.5", "24.6063", "25", "25.0031", "25.4", "25.5", "25.7969", "26", "26.1938", "26.5", "26.5906", "26.9875", "27", "27.3844", "27.5", "27.7813", "28", "28.1781", "28.5", "28.575", "28.9719", "29", "29.3688", "29.5", "29.7656", "30", "30.1625", "30.5", "30.5594", "30.9563", "31", "31.3531", "31.5", "31.75", "32", "32.1469", "32.5", "32.5438", "32.9406", "33", "33.3375", "33.5", "33.7344", "34", "34.1313", "34.5", "34.5281", "34.925", "35", "35.3219", "35.5", "35.7188", "36", "36.1156", "36.5", "36.5125", "36.9094", "37", "37.3063", "37.5", "37.7031", "38", "38.1"};
//168
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 public void EnglishFunction(View view) throws FileNotFoundException 
	 {
		 final TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
		 tableLayout.removeAllViews();
		 
		    //TextView view1 = (TextView) findViewById(R.id.view1);
		    //view1.setText("Standard Drill Sizes - Inches");

		    for (int i = 0; i < (drillSize.length / 3)+1; i++) 
		    {
		        // Creation row
		        final TableRow tableRow = new TableRow(this);
		        //final TableColumn tablecolumn = new TableColumn(this);
		        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

		        // Creation textView
		        final TextView text = new TextView(this);
		        text.setText(drillSize[i] + " = " + decimalEquiv[i]);
		        text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        
		        final TextView text2 = new TextView(this);
		        text2.setText("\t" + drillSize[i + (drillSize.length / 3)+1] + " = " + decimalEquiv[i+ (drillSize.length / 3)+1]);
		        text2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        
		        final TextView text3 = new TextView(this);
		        if((i + ((drillSize.length / 3)*2)+2) < drillSize.length)
		        {
		        	text3.setText("\t" + drillSize[i + ((drillSize.length / 3)*2)+2] + " = " + decimalEquiv[i + ((drillSize.length / 3)*2)+2] + "\t");
		        	text3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        }
		        else
		        {
		        	text3.setText(" ");
		        	text3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        }

		        // Creation  button
		        /*final Button button = new Button(this);
		        button.setText("Delete");
		        button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        button.setOnClickListener(new View.OnClickListener() 
		        {
		            @Override
		            public void onClick(View v) 
		            {
		                final TableRow parent = (TableRow) v.getParent();
		                tableLayout.removeView(parent);
		            }
		        });*/

		        tableRow.addView(text);
		        tableRow.addView(text2);
		        tableRow.addView(text3);
		       // tableRow.addView(button);

		        tableLayout.addView(tableRow);
		    }
	 }
	 
	 public void MetricFunction(View view) throws FileNotFoundException 
	 {
		 final TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
		 tableLayout.removeAllViews();
		    //TextView view1 = (TextView) findViewById(R.id.view1);
		    //view1.setText("English and Metric");

		    for (int i = 0; i < (drillSizeMetric.length / 3); i++) 
		    {
		        // Creation row
		        final TableRow tableRow = new TableRow(this);
		        //final TableColumn tablecolumn = new TableColumn(this);
		        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

		        // Creation textView
		        final TextView text = new TextView(this);
		        text.setText(drillSizeMetric[i] + " = " + drillDiameter[i]);
		        text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        
		        final TextView text2 = new TextView(this);
		        text2.setText("\t" + drillSizeMetric[i + (drillSizeMetric.length / 3)] + " = " + drillDiameter[i + (drillSizeMetric.length / 3)]);
		        text2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        
		        final TextView text3 = new TextView(this);
		        
		        if((i + ((drillSizeMetric.length / 3)*2)) < drillSizeMetric.length)
		        {
		        	text3.setText("\t" + drillSizeMetric[i + ((drillSizeMetric.length / 3)*2)] + " = " + drillDiameter[i + ((drillSizeMetric.length / 3)*2)] + "\t");
		        	text3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        }
		        else
		        {
		        	text3.setText(" ");
		        	text3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        }

		        // Creation  button
		        /*final Button button = new Button(this);
		        button.setText("Delete");
		        button.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
		        button.setOnClickListener(new View.OnClickListener() 
		        {
		            @Override
		            public void onClick(View v) 
		            {
		                final TableRow parent = (TableRow) v.getParent();
		                tableLayout.removeView(parent);
		            }
		        });*/

		        tableRow.addView(text);
		        tableRow.addView(text2);
		        tableRow.addView(text3);
		        //tableRow.addView(button);

		        tableLayout.addView(tableRow);
		    }
	 }

}
