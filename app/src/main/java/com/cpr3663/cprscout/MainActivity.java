package com.cpr3663.cprscout;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onBackPressed() {   //Prevent app from clearing data when user accidentally
        //press back button too many times.
        moveTaskToBack(true);
    }

    //Auto buttons:
    Button btnAutoA, btnAutoB, btnAutoC, btnAutoD, btnAutoE, btnAutoF;
    Button btnAutoG, btnAutoH, btnAutoI, btnAutoJ, btnAutoK, btnAutoL;
    Button btnAutoM, btnAutoX, btnAutoY, btnAutoZ;

    //Teleop buttons:
    Button btnTeleA, btnTeleB, btnTeleC, btnTeleD, btnTeleE, btnTeleF;
    Button btnTeleG, btnTeleH, btnTeleI, btnTeleJ, btnTeleK, btnTeleL;
    Button btnTeleM, btnTeleX, btnTeleY, btnTeleZ;
    Button btnTeleDef0, btnTeleDef1, btnTeleDef2, btnTeleDef3, btnTeleDef4;
    Button btnHiMakeMinus, btnHiMakePlus, btnLoMakeMinus, btnLoMakePlus;
    Button btnHiMissMinus, btnHiMissPlus, btnLoMissMinus, btnLoMissPlus;

    //End game buttons:
    Button btnEndX, btnEndY, btnEndZ, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(  //This fixes the softkeyboard from showing at startup.
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        Spinner spDefense1, spDefense2, spDefense3, spDefense4, spDefenseAuto;

        ArrayAdapter<CharSequence> adapterDefense1, adapterDefense2;
        ArrayAdapter<CharSequence> adapterDefense3, adapterDefense4, adapterCrossDefenses;

        spDefense1 = (Spinner) findViewById(R.id.spinnerAutoDef1);
        adapterDefense1 = ArrayAdapter.createFromResource(this, R.array.defenses, android.R.layout.simple_spinner_item);
        adapterDefense1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDefense1.setAdapter(adapterDefense1);

        spDefense1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btnTeleDef1.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spDefense2 = (Spinner) findViewById(R.id.spinnerAutoDef2);
        adapterDefense2 = ArrayAdapter.createFromResource(this, R.array.defenses, android.R.layout.simple_spinner_item);
        adapterDefense2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDefense2.setAdapter(adapterDefense2);

        spDefense2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btnTeleDef2.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spDefense3 = (Spinner) findViewById(R.id.spinnerAutoDef3);
        adapterDefense3 = ArrayAdapter.createFromResource(this, R.array.defenses, android.R.layout.simple_spinner_item);
        adapterDefense3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDefense3.setAdapter(adapterDefense3);

        spDefense3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btnTeleDef3.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spDefense4 = (Spinner) findViewById(R.id.spinnerAutoDef4);
        adapterDefense4 = ArrayAdapter.createFromResource(this, R.array.defenses, android.R.layout.simple_spinner_item);
        adapterDefense4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDefense4.setAdapter(adapterDefense4);

        spDefense4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btnTeleDef4.setText(parent.getItemAtPosition(position).toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        adapterCrossDefenses = ArrayAdapter.createFromResource(this, R.array.crossdefenses, android.R.layout.simple_spinner_item);
        adapterCrossDefenses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDefenseAuto = (Spinner) findViewById(R.id.spinnerAutoCross);
        spDefenseAuto.setAdapter(adapterCrossDefenses);


        btnAutoA = (Button) findViewById(R.id.btnAutoA);
        btnAutoB = (Button) findViewById(R.id.btnAutoB);
        btnAutoC = (Button) findViewById(R.id.btnAutoC);
        btnAutoD = (Button) findViewById(R.id.btnAutoD);
        btnAutoE = (Button) findViewById(R.id.btnAutoE);
        btnAutoF = (Button) findViewById(R.id.btnAutoF);
        btnAutoG = (Button) findViewById(R.id.btnAutoG);
        btnAutoH = (Button) findViewById(R.id.btnAutoH);
        btnAutoI = (Button) findViewById(R.id.btnAutoI);
        btnAutoJ = (Button) findViewById(R.id.btnAutoJ);
        btnAutoK = (Button) findViewById(R.id.btnAutoK);
        btnAutoL = (Button) findViewById(R.id.btnAutoL);
        btnAutoM = (Button) findViewById(R.id.btnAutoM);
        btnAutoX = (Button) findViewById(R.id.btnAutoX);
        btnAutoY = (Button) findViewById(R.id.btnAutoY);
        btnAutoZ = (Button) findViewById(R.id.btnAutoZ);

        btnTeleA = (Button) findViewById(R.id.btnTeleA);
        btnTeleB = (Button) findViewById(R.id.btnTeleB);
        btnTeleC = (Button) findViewById(R.id.btnTeleC);
        btnTeleD = (Button) findViewById(R.id.btnTeleD);
        btnTeleE = (Button) findViewById(R.id.btnTeleE);
        btnTeleF = (Button) findViewById(R.id.btnTeleF);
        btnTeleG = (Button) findViewById(R.id.btnTeleG);
        btnTeleH = (Button) findViewById(R.id.btnTeleH);
        btnTeleI = (Button) findViewById(R.id.btnTeleI);
        btnTeleJ = (Button) findViewById(R.id.btnTeleJ);
        btnTeleK = (Button) findViewById(R.id.btnTeleK);
        btnTeleL = (Button) findViewById(R.id.btnTeleL);
        btnTeleM = (Button) findViewById(R.id.btnTeleM);
        btnTeleX = (Button) findViewById(R.id.btnTeleX);
        btnTeleY = (Button) findViewById(R.id.btnTeleY);
        btnTeleZ = (Button) findViewById(R.id.btnTeleZ);

        btnTeleDef0 = (Button) findViewById(R.id.btnTeleDef0);
        btnTeleDef1 = (Button) findViewById(R.id.btnTeleDef1);
        btnTeleDef2 = (Button) findViewById(R.id.btnTeleDef2);
        btnTeleDef3 = (Button) findViewById(R.id.btnTeleDef3);
        btnTeleDef4 = (Button) findViewById(R.id.btnTeleDef4);

        btnHiMakeMinus = (Button) findViewById(R.id.btnHiMakeMinus);
        btnHiMakePlus = (Button) findViewById(R.id.btnHiMakePlus);
        btnLoMakeMinus = (Button) findViewById(R.id.btnLoMakeMinus);
        btnLoMakePlus = (Button) findViewById(R.id.btnLoMakePlus);

        btnHiMissMinus = (Button) findViewById(R.id.btnHiMissMinus);
        btnHiMissPlus = (Button) findViewById(R.id.btnHiMissPlus);
        btnLoMissMinus = (Button) findViewById(R.id.btnLoMissMinus);
        btnLoMissPlus = (Button) findViewById(R.id.btnLoMissPlus);

        btnEndX = (Button) findViewById(R.id.btnEndX);
        btnEndY = (Button) findViewById(R.id.btnEndY);
        btnEndZ = (Button) findViewById(R.id.btnEndZ);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnAutoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoA.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoA.setTextColor(Color.BLACK);
                } else {
                    btnAutoA.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("A");
            }
        });

        btnAutoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoB.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoB.setTextColor(Color.BLACK);
                } else {
                    btnAutoB.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("B");
            }
        });

        btnAutoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoC.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoC.setTextColor(Color.BLACK);
                } else {
                    btnAutoC.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("C");
            }
        });

        btnAutoD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoD.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoD.setTextColor(Color.BLACK);
                } else {
                    btnAutoD.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("D");
            }
        });

        btnAutoE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoE.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoE.setTextColor(Color.BLACK);
                } else {
                    btnAutoE.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("E");
            }
        });

        btnAutoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoF.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoF.setTextColor(Color.BLACK);
                } else {
                    btnAutoF.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("F");
            }
        });

        btnAutoG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoG.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoG.setTextColor(Color.BLACK);
                } else {
                    btnAutoG.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("G");
            }
        });

        btnAutoH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoH.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoH.setTextColor(Color.BLACK);
                } else {
                    btnAutoH.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("H");
            }
        });

        btnAutoI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoI.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoI.setTextColor(Color.BLACK);
                } else {
                    btnAutoI.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("I");
            }
        });

        btnAutoJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoJ.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoJ.setTextColor(Color.BLACK);
                } else {
                    btnAutoJ.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("J");
            }
        });

        btnAutoK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoK.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoK.setTextColor(Color.BLACK);
                } else {
                    btnAutoK.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("K");
            }
        });

        btnAutoL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoL.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoL.setTextColor(Color.BLACK);
                } else {
                    btnAutoL.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("L");
            }
        });

        btnAutoM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoM.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoM.setTextColor(Color.BLACK);
                } else {
                    btnAutoM.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("M");
            }
        });

        btnAutoX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoX.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoX.setTextColor(Color.BLACK);
                } else {
                    btnAutoX.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("X");
            }
        });

        btnAutoY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoY.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoY.setTextColor(Color.BLACK);
                } else {
                    btnAutoY.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("Y");
            }
        });

        btnAutoZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnAutoZ.getCurrentTextColor();
                setAuto2black();
                if (color == Color.RED) {
                    btnAutoZ.setTextColor(Color.BLACK);
                } else {
                    btnAutoZ.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextLoc);
                tv.setText("Z");
            }
        });

        btnTeleA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleA.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleA.setTextColor(Color.BLACK);
                } else {
                    btnTeleA.setTextColor(Color.RED);
                }
                //find which Tele Hi or Lo button is selected.
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("A");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("A");
                }
            }
        });
        btnTeleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleB.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleB.setTextColor(Color.BLACK);
                } else {
                    btnTeleB.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("B");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("B");
                }
            }
        });

        btnTeleC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleC.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleC.setTextColor(Color.BLACK);
                } else {
                    btnTeleC.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("C");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("C");
                }
            }
        });

        btnTeleD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleD.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleD.setTextColor(Color.BLACK);
                } else {
                    btnTeleD.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("D");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("D");
                }
            }
        });

        btnTeleE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleE.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleE.setTextColor(Color.BLACK);
                } else {
                    btnTeleE.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("E");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("E");
                }
            }
        });

        btnTeleF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleF.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleF.setTextColor(Color.BLACK);
                } else {
                    btnTeleF.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("F");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("F");
                }
            }
        });

        btnTeleG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleG.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleG.setTextColor(Color.BLACK);
                } else {
                    btnTeleG.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("G");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("G");
                }
            }
        });

        btnTeleH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleH.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleH.setTextColor(Color.BLACK);
                } else {
                    btnTeleH.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("H");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("H");
                }
            }
        });

        btnTeleI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleI.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleI.setTextColor(Color.BLACK);
                } else {
                    btnTeleI.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("I");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("I");
                }
            }
        });

        btnTeleJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleJ.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleJ.setTextColor(Color.BLACK);
                } else {
                    btnTeleJ.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("J");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("J");
                }
            }
        });

        btnTeleK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleK.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleK.setTextColor(Color.BLACK);
                } else {
                    btnTeleK.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("K");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("K");
                }
            }
        });

        btnTeleL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleL.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleL.setTextColor(Color.BLACK);
                } else {
                    btnTeleL.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("L");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("L");
                }
            }
        });

        btnTeleM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleM.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleM.setTextColor(Color.BLACK);
                } else {
                    btnTeleM.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("M");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("M");
                }
            }
        });

        btnTeleX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleX.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleX.setTextColor(Color.BLACK);
                } else {
                    btnTeleX.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("X");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("X");
                }
            }
        });

        btnTeleY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleY.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleY.setTextColor(Color.BLACK);
                } else {
                    btnTeleY.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("Y");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("Y");
                }
            }
        });

        btnTeleZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnTeleZ.getCurrentTextColor();
                setTele2black();
                if (color == Color.RED) {
                    btnTeleZ.setTextColor(Color.BLACK);
                } else {
                    btnTeleZ.setTextColor(Color.RED);
                }
                RadioButton rbHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
                if (rbHi.isChecked()) {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocHi);
                    tv.setText("Z");
                } else {
                    TextView tv = (TextView) findViewById(R.id.editTextTeleLocLo);
                    tv.setText("Z");
                }
            }
        });

        btnTeleDef0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stdefTotal = (EditText) findViewById(R.id.Def0Total);
                String stTotal;
                //If it happens to be blank then reset to 0
                if (stdefTotal.getText().toString().isEmpty())
                    stTotal = "0";
                else
                stTotal = stdefTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stdefTotal.setText(String.valueOf(intTotal));

            }
        });

        btnTeleDef1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stdefTotal = (EditText) findViewById(R.id.Def1Total);
                String stTotal;
                if (stdefTotal.getText().toString().isEmpty())
                    stTotal = "0";
                else
                    stTotal = stdefTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stdefTotal.setText(String.valueOf(intTotal));
            }
        });

        btnTeleDef2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stdefTotal = (EditText) findViewById(R.id.Def2Total);
                String stTotal;
                if (stdefTotal.getText().toString().isEmpty())
                    stTotal = "0";
                else
                    stTotal = stdefTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stdefTotal.setText(String.valueOf(intTotal));
            }
        });

        btnTeleDef3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stdefTotal = (EditText) findViewById(R.id.Def3Total);
                String stTotal;
                if (stdefTotal.getText().toString().isEmpty())
                    stTotal = "0";
                else
                    stTotal = stdefTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stdefTotal.setText(String.valueOf(intTotal));
            }
        });

        btnTeleDef4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stdefTotal = (EditText) findViewById(R.id.Def4Total);
                String stTotal;
                if (stdefTotal.getText().toString().isEmpty())
                    stTotal = "0";
                else
                    stTotal = stdefTotal.getText().toString();
                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stdefTotal.setText(String.valueOf(intTotal));
            }
        });

        btnHiMakeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stHiTotal = (EditText) findViewById(R.id.HiMakeTotal);
                String stTotal;
                stTotal = stHiTotal.getText().toString();
                if (!stTotal.equals("0")) {
                    int intTotal;
                    intTotal = Integer.parseInt(stTotal);
                    intTotal = intTotal - 1;
                    stHiTotal.setText(String.valueOf(intTotal));
                }
            }
        });

        btnHiMakePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stHiTotal = (EditText) findViewById(R.id.HiMakeTotal);
                String stTotal;
                stTotal = stHiTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stHiTotal.setText(String.valueOf(intTotal));
            }
        });

        btnLoMakeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stLoTotal = (EditText) findViewById(R.id.LoMakeTotal);
                String stTotal;
                stTotal = stLoTotal.getText().toString();
                if (!stTotal.equals("0")) {
                    int intTotal;
                    intTotal = Integer.parseInt(stTotal);
                    intTotal = intTotal - 1;
                    stLoTotal.setText(String.valueOf(intTotal));
                }
            }
        });

        btnLoMakePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stLoTotal = (EditText) findViewById(R.id.LoMakeTotal);
                String stTotal;
                stTotal = stLoTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stLoTotal.setText(String.valueOf(intTotal));
            }
        });

        btnHiMissMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stHiTotal = (EditText) findViewById(R.id.HiMissTotal);
                String stTotal;
                stTotal = stHiTotal.getText().toString();
                if (!stTotal.equals("0")) {
                    int intTotal;
                    intTotal = Integer.parseInt(stTotal);
                    intTotal = intTotal - 1;
                    stHiTotal.setText(String.valueOf(intTotal));
                }
            }
        });

        btnHiMissPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stHiTotal = (EditText) findViewById(R.id.HiMissTotal);
                String stTotal;
                stTotal = stHiTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stHiTotal.setText(String.valueOf(intTotal));
            }
        });

        btnLoMissMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stLoTotal = (EditText) findViewById(R.id.LoMissTotal);
                String stTotal;
                stTotal = stLoTotal.getText().toString();
                if (!stTotal.equals("0")) {
                    int intTotal;
                    intTotal = Integer.parseInt(stTotal);
                    intTotal = intTotal - 1;
                    stLoTotal.setText(String.valueOf(intTotal));
                }
            }
        });

        btnLoMissPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText stLoTotal = (EditText) findViewById(R.id.LoMissTotal);
                String stTotal;
                stTotal = stLoTotal.getText().toString();

                int intTotal;
                intTotal = Integer.parseInt(stTotal);
                intTotal = intTotal + 1;
                stLoTotal.setText(String.valueOf(intTotal));
            }
        });

        btnEndX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnEndX.getCurrentTextColor();
                setEnd2black();
                if (color == Color.RED) {
                    btnEndX.setTextColor(Color.BLACK);
                } else {
                    btnEndX.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextEndLoc);
                tv.setText("X");
            }
        });

        btnEndY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnEndY.getCurrentTextColor();
                setEnd2black();
                if (color == Color.RED) {
                    btnEndY.setTextColor(Color.BLACK);
                } else {
                    btnEndY.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextEndLoc);
                tv.setText("Y");
            }
        });

        btnEndZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = btnEndZ.getCurrentTextColor();
                setEnd2black();
                if (color == Color.RED) {
                    btnEndZ.setTextColor(Color.BLACK);
                } else {
                    btnEndZ.setTextColor(Color.RED);
                }
                TextView tv = (TextView) findViewById(R.id.editTextEndLoc);
                tv.setText("Z");
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savefile();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }// Main Closing bracket

    public void savefile() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        String currentDate = sdf.format(new Date());

        String Def0 = "LB"; //Low Bar is Defense 0.

        RadioGroup rgcolor = (RadioGroup) findViewById(R.id.radioGroupColor);
        RadioGroup rgaction = (RadioGroup) findViewById(R.id.radioGroupAction);
        RadioGroup rgautoshot = (RadioGroup) findViewById(R.id.radioGroupAutoShot);
        RadioGroup rgshotspeed = (RadioGroup) findViewById(R.id.radioGroupShotSpeed);
        RadioGroup rgdrivespeed = (RadioGroup) findViewById(R.id.radioGroupDriveSpeed);
        RadioGroup rgdriving = (RadioGroup) findViewById(R.id.radioGroupDrivingAb);
        RadioGroup rgdefend = (RadioGroup) findViewById(R.id.radioGroupDefend);
        RadioGroup rgendgame = (RadioGroup) findViewById(R.id.radioGroupEndGame);

        RadioButton rbcolor, rbaction, rbautoshot, rbshotspeed, rbdrivespeed, rbdriving;
        RadioButton rbdefend, rbendgame;
        RadioButton rbNoAct, rbReach, rbCross;
        RadioButton rbAutoHi, rbAutoLow, rbTeleHi, rbTeleLow;
        RadioButton rbL3, rbG3, rbG6, rbFast, rbMed, rbSlow;
        RadioButton rbSmart, rbOrd, rbReck, rbStruggle;
        RadioButton rbGreat, rbOK, rbPoor;
        RadioButton rbNoChallenge, rbFailChallenge, rbChallenge, rbFailScale, rbScaled;
        CheckBox chkDeadBot, chkNoShow, chkAutoMiss, chkAutoWrong, chkAutoHit;
        CheckBox chkAutoVeers, chkAutoSpy, chkDefensive, chkDrivesPart, chkPoorPickup;
        Spinner spDefense1, spDefense2, spDefense3, spDefense4, spDefenseAuto;

        EditText ScoutName = (EditText) findViewById(R.id.editTextName);
        EditText TeamNum = (EditText) findViewById(R.id.editTextTeamNum);
        EditText MatchNum = (EditText) findViewById(R.id.editTextMatchNum);
        EditText AutoLoc = (EditText) findViewById(R.id.editTextLoc);
        EditText Def0Total = (EditText) findViewById(R.id.Def0Total);
        EditText Def1Total = (EditText) findViewById(R.id.Def1Total);
        EditText Def2Total = (EditText) findViewById(R.id.Def2Total);
        EditText Def3Total = (EditText) findViewById(R.id.Def3Total);
        EditText Def4Total = (EditText) findViewById(R.id.Def4Total);
        EditText HiLoc = (EditText) findViewById(R.id.editTextTeleLocHi);
        EditText LoLoc = (EditText) findViewById(R.id.editTextTeleLocLo);
        EditText HiMake = (EditText) findViewById(R.id.HiMakeTotal);
        EditText HiMiss = (EditText) findViewById(R.id.HiMissTotal);
        EditText LowMake = (EditText) findViewById(R.id.LoMakeTotal);
        EditText LowMiss = (EditText) findViewById(R.id.LoMissTotal);
        EditText ScaleLoc = (EditText) findViewById(R.id.editTextEndLoc);

        String strScoutName = ScoutName.getText().toString();
        String strTeamNum = TeamNum.getText().toString();
        String strMatchNum = MatchNum.getText().toString();
        String strAutoLoc = AutoLoc.getText().toString();
        String strDef0Total = Def0Total.getText().toString();
        String strDef1Total = Def1Total.getText().toString();
        String strDef2Total = Def2Total.getText().toString();
        String strDef3Total = Def3Total.getText().toString();
        String strDef4Total = Def4Total.getText().toString();
        String strHiLoc = HiLoc.getText().toString();
        String strLoLoc = LoLoc.getText().toString();
        String strHiMake = HiMake.getText().toString();
        String strHiMiss = HiMiss.getText().toString();
        String strLowMake = LowMake.getText().toString();
        String strLowMiss = LowMiss.getText().toString();
        String strScaleLoc = ScaleLoc.getText().toString();

        chkDeadBot = (CheckBox) findViewById(R.id.checkBoxDeadBot);
        chkNoShow = (CheckBox) findViewById(R.id.checkBoxNoShow);
        chkAutoMiss = (CheckBox) findViewById(R.id.checkBoxAutoMiss);
        chkAutoWrong = (CheckBox) findViewById(R.id.checkBoxAutoWongWay);
        chkAutoHit = (CheckBox) findViewById(R.id.checkBoxAutoHitPartner);
        chkAutoVeers = (CheckBox) findViewById(R.id.checkBoxAutoVeers);
        chkAutoSpy = (CheckBox) findViewById(R.id.checkBoxSpyBot);
        chkDefensive = (CheckBox) findViewById(R.id.checkBoxDefense);
        chkDrivesPart = (CheckBox) findViewById(R.id.checkBoxDrivePartner);
        chkPoorPickup =(CheckBox) findViewById(R.id.checkBoxPoorPickup);

        //Get spinner data defined.
        spDefense1 = (Spinner) findViewById(R.id.spinnerAutoDef1);
        spDefense2 = (Spinner) findViewById(R.id.spinnerAutoDef2);
        spDefense3 = (Spinner) findViewById(R.id.spinnerAutoDef3);
        spDefense4 = (Spinner) findViewById(R.id.spinnerAutoDef4);
        spDefenseAuto = (Spinner) findViewById(R.id.spinnerAutoCross);
        String Def1 = spDefense1.getSelectedItem().toString();
        String Def2 = spDefense2.getSelectedItem().toString();
        String Def3 = spDefense3.getSelectedItem().toString();
        String Def4 = spDefense4.getSelectedItem().toString();
        String DefAuto = spDefenseAuto.getSelectedItem().toString();

        int selectedIdcolor = rgcolor.getCheckedRadioButtonId();
        rbcolor = (RadioButton) findViewById(selectedIdcolor);

        int selectedIdaction = rgaction.getCheckedRadioButtonId();
        rbaction = (RadioButton) findViewById(selectedIdaction);

        int selectedIdautoshot = rgautoshot.getCheckedRadioButtonId();
        rbautoshot = (RadioButton) findViewById(selectedIdautoshot);

        int selectedIdshotspeed = rgshotspeed.getCheckedRadioButtonId();
        rbshotspeed = (RadioButton) findViewById(selectedIdshotspeed);

        int selectedIddrivespeed = rgdrivespeed.getCheckedRadioButtonId();
        rbdrivespeed = (RadioButton) findViewById(selectedIddrivespeed);

        int selectedIddriving = rgdriving.getCheckedRadioButtonId();
        rbdriving = (RadioButton) findViewById(selectedIddriving);

        int selectedIddefend = rgdefend.getCheckedRadioButtonId();
        rbdefend = (RadioButton) findViewById(selectedIddefend);

        int selectedIdendgame = rgendgame.getCheckedRadioButtonId();
        rbendgame = (RadioButton) findViewById(selectedIdendgame);

        String matchdata = strMatchNum + "," +
                strTeamNum + "," +
                rbcolor.getText() + "," +
                chkDeadBot.isChecked() + "," +
                chkNoShow.isChecked() + "," +
                Def0 + "," + strDef0Total + "," +
                Def1 + "," + strDef1Total + "," +
                Def2 + "," + strDef2Total + "," +
                Def3 + "," + strDef3Total + "," +
                Def4 + "," + strDef4Total + "," +
                rbaction.getText() + "," +
                DefAuto + "," +
                rbautoshot.getText() + "," +
                chkAutoMiss.isChecked() + "," +
                strAutoLoc + "," +
                chkAutoWrong.isChecked() + "," +
                chkAutoHit.isChecked() + "," +
                chkAutoVeers.isChecked() + "," +
                chkAutoSpy.isChecked() + "," +
                strHiLoc + "," +
                strLoLoc + "," +
                strHiMake + "," +
                strHiMiss + "," +
                strLowMake + "," +
                strLowMiss + "," +
                rbshotspeed.getText() + "," +
                rbdrivespeed.getText() + "," +
                rbdriving.getText() + "," +
                chkDefensive.getText() + "," +
                chkDrivesPart.getText() + "," +
                chkPoorPickup.getText() + "," +
                rbdefend.getText() + "," +
                strScaleLoc + "," +
                rbendgame.getText() + "\n";

        strScoutName = strScoutName.replace(" ", "_");
        String FILENAME = "scout_data_" + strScoutName + "_" + currentDate + ".csv";
        //File file;
        //file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), FILENAME);

        try {

            //Save to Internal Storage.  Only available to the app.
            //FileOutputStream out = openFileOutput(FILENAME, Context.MODE_APPEND);
            //out.write(matchdata.getBytes());
            //out.close();
            //} catch (Exception e) {
            //e.printStackTrace();
            //}

            //Save to external Storage

            //The command below doesn't seem to work on Android 4.2.2
            //File docdir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File dir = new File(Environment.getExternalStorageDirectory() + "/data/CPR_Scout");
            if (!dir.exists()) {
                 dir.mkdirs();
            }
            File file = new File(dir, FILENAME);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(matchdata);
            bufferedWriter.close();
            fileWriter.close();

            Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();

            //Clear data
            String empty = "";
            TeamNum.setText(String.valueOf(empty));

            if (!strMatchNum.isEmpty())
            {// Increment the Match Number by one.
                String strMNum;
                strMNum = MatchNum.getText().toString();

                int intMNum;
                intMNum = Integer.parseInt(strMNum);
                intMNum = intMNum + 1;
                MatchNum.setText(String.valueOf(intMNum));
            }

            HiLoc.setText(String.valueOf(empty));
            LoLoc.setText(String.valueOf(empty));
            ScaleLoc.setText(String.valueOf(empty));
            AutoLoc.setText(String .valueOf(empty));
            setAuto2black();
            setTele2black();
            setEnd2black();
            if (chkAutoHit.isChecked()) {
                chkAutoHit.toggle();
            }
            if (chkAutoMiss.isChecked()) {
                chkAutoMiss.toggle();
            }
            if (chkAutoSpy.isChecked()) {
                chkAutoSpy.toggle();
            }
            if (chkAutoVeers.isChecked()) {
                chkAutoVeers.toggle();
            }
            if (chkAutoWrong.isChecked()) {
                chkAutoWrong.toggle();
            }
            if (chkDeadBot.isChecked()) {
                chkDeadBot.toggle();
            }
            if (chkDeadBot.isChecked()) {
                chkDeadBot.toggle();
            }
            if (chkDefensive.isChecked()) {
                chkDefensive.toggle();
            }
            if (chkDrivesPart.isChecked()) {
                chkDrivesPart.toggle();
            }
            if (chkNoShow.isChecked()) {
                chkNoShow.toggle();
            }
            if (chkPoorPickup.isChecked()) {
                chkPoorPickup.toggle();
            }

            spDefense1.setSelection(0);
            spDefense2.setSelection(0);
            spDefense3.setSelection(0);
            spDefense4.setSelection(0);
            spDefenseAuto.setSelection(0);
            Def0Total.setText("0");
            Def1Total.setText("0");
            Def2Total.setText("0");
            Def3Total.setText("0");
            Def4Total.setText("0");
            HiMake.setText("0");
            HiMiss.setText("0");
            LowMake.setText("0");
            LowMiss.setText("0");

            rbNoAct = (RadioButton) findViewById(R.id.radioButtonNoAction);
            rbReach = (RadioButton) findViewById(R.id.radioButtonReach);
            rbCross = (RadioButton) findViewById(R.id.radioButtonCross);
            rbAutoHi = (RadioButton) findViewById(R.id.radioButtonAutoHi);
            rbAutoLow = (RadioButton) findViewById(R.id.radioButtonAutoLow);
            rbTeleHi = (RadioButton) findViewById(R.id.radioButtonTeleHiLoc);
            rbTeleLow = (RadioButton) findViewById(R.id.radioButtonTeleLoLoc);
            rbL3 = (RadioButton) findViewById(R.id.radioButtonL3);
            rbG3 = (RadioButton) findViewById(R.id.radioButtonG3);
            rbG6 = (RadioButton) findViewById(R.id.radioButtonG6);
            rbFast = (RadioButton) findViewById(R.id.radioButtonFast);
            rbMed = (RadioButton) findViewById(R.id.radioButtonMed);
            rbSlow = (RadioButton) findViewById(R.id.radioButtonSlow);
            rbSmart = (RadioButton) findViewById(R.id.radioButtonSmart);
            rbOrd = (RadioButton) findViewById(R.id.radioButtonOrd);
            rbReck = (RadioButton) findViewById(R.id.radioButtonReck);
            rbStruggle = (RadioButton) findViewById(R.id.radioButtonStruggle);
            rbGreat = (RadioButton) findViewById(R.id.radioButtonDefGreat);
            rbOK = (RadioButton) findViewById(R.id.radioButtonDefOK);
            rbPoor = (RadioButton) findViewById(R.id.radioButtonDefPoor);
            rbNoChallenge = (RadioButton) findViewById(R.id.radioButtonNoChallenge);
            rbFailChallenge = (RadioButton) findViewById(R.id.radioButtonChallengeNo);
            rbChallenge = (RadioButton) findViewById(R.id.radioButtonChallenged);
            rbFailScale = (RadioButton) findViewById(R.id.radioButtonFailedScale);
            rbScaled = (RadioButton) findViewById(R.id.radioButtonScaled);

            //Set radio buttons to default position.
            rbNoAct.setChecked(true);
            rbReach.setChecked(false);
            rbCross.setChecked(false);
            rbAutoHi.setChecked(true);
            rbAutoLow.setChecked(false);
            rbTeleHi.setChecked(true);
            rbTeleLow.setChecked(false);
            rbL3.setChecked(true);
            rbG3.setChecked(false);
            rbG6.setChecked(false);
            rbFast.setChecked(true);
            rbMed.setChecked(false);
            rbSlow.setChecked(false);
            rbSmart.setChecked(true);
            rbOrd.setChecked(false);
            rbReck.setChecked(false);
            rbStruggle.setChecked(false);
            rbGreat.setChecked(true);
            rbOK.setChecked(false);
            rbPoor.setChecked(false);
            rbNoChallenge.setChecked(true);
            rbFailChallenge.setChecked(false);
            rbChallenge.setChecked(false);
            rbFailScale.setChecked(false);
            rbScaled.setChecked(false);
            TeamNum.requestFocus(); //Move cursor to Team Number field.

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "File Not Found", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "I/O Exception", Toast.LENGTH_LONG).show();
        }
    }

    public void setContentView(View view) {
    }

    public void setAuto2black() { //Resets all of the shooting locations text colors to black
        btnAutoA.setTextColor(Color.BLACK);
        btnAutoB.setTextColor(Color.BLACK);
        btnAutoC.setTextColor(Color.BLACK);
        btnAutoD.setTextColor(Color.BLACK);
        btnAutoE.setTextColor(Color.BLACK);
        btnAutoF.setTextColor(Color.BLACK);
        btnAutoG.setTextColor(Color.BLACK);
        btnAutoH.setTextColor(Color.BLACK);
        btnAutoI.setTextColor(Color.BLACK);
        btnAutoJ.setTextColor(Color.BLACK);
        btnAutoK.setTextColor(Color.BLACK);
        btnAutoL.setTextColor(Color.BLACK);
        btnAutoM.setTextColor(Color.BLACK);
        btnAutoX.setTextColor(Color.BLACK);
        btnAutoY.setTextColor(Color.BLACK);
        btnAutoZ.setTextColor(Color.BLACK);
    }

    public void setTele2black() { //Resets all of the Teleop shooting locations text colors to black
        btnTeleA.setTextColor(Color.BLACK);
        btnTeleB.setTextColor(Color.BLACK);
        btnTeleC.setTextColor(Color.BLACK);
        btnTeleD.setTextColor(Color.BLACK);
        btnTeleE.setTextColor(Color.BLACK);
        btnTeleF.setTextColor(Color.BLACK);
        btnTeleG.setTextColor(Color.BLACK);
        btnTeleH.setTextColor(Color.BLACK);
        btnTeleI.setTextColor(Color.BLACK);
        btnTeleJ.setTextColor(Color.BLACK);
        btnTeleK.setTextColor(Color.BLACK);
        btnTeleL.setTextColor(Color.BLACK);
        btnTeleM.setTextColor(Color.BLACK);
        btnTeleX.setTextColor(Color.BLACK);
        btnTeleY.setTextColor(Color.BLACK);
        btnTeleZ.setTextColor(Color.BLACK);
    }

    public void setEnd2black() { // Resets all of the End Game shooting locations text colors to black.
        btnEndX.setTextColor(Color.BLACK);
        btnEndY.setTextColor(Color.BLACK);
        btnEndZ.setTextColor(Color.BLACK);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.cpr3663.cprscout/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.cpr3663.cprscout/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}