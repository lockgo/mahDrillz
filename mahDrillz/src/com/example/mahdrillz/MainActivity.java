package com.example.mahdrillz;
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
//168
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    final TableLayout tableLayout = (TableLayout) findViewById(R.id.table);
	    TextView view1 = (TextView) findViewById(R.id.view1);
	    view1.setText("Standard Drill Sizes - Inches");

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
	        text2.setText("\t" + drillSize[i + (drillSize.length / 3)+1] + " = " + decimalEquiv[i] + (drillSize.length / 3)+1);
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
	        final Button button = new Button(this);
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
	        });

	        tableRow.addView(text);
	        tableRow.addView(text2);
	        tableRow.addView(text3);
	        tableRow.addView(button);

	        tableLayout.addView(tableRow);
	    }

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
