package com.example.workz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton micButton, webButton1, webButtonTranslate;
    public static SensorManager mSensores;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        micButton = findViewById(R.id.micButton);
        webButton1 = findViewById(R.id.webButton1);
        webButtonTranslate = findViewById(R.id.webButton2);
        ativarServicoAcelerometro();


        micButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio();


            }
        });

        webButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview1();


            }
        });
        webButtonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTranslate();

            }
        });

    }



    private void webview1() {
        Intent webgoogle = new Intent(this, GoogleActivity.class);
        startActivity(webgoogle);
    }

    private void abrirTranslate() {
        Intent Translate = new Intent(this, TranslateActivity.class);
        startActivity(Translate);


    }

    private void ativarServicoAcelerometro() {
        Intent iServico = new Intent(this, ServiceActivity.class);
        startService(iServico);
    }



    private void audio(){
        Intent iSTT = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        iSTT.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        iSTT.putExtra(RecognizerIntent.EXTRA_PROMPT, "O que você deseja? ");
        startActivityForResult(iSTT, 100);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> resultado =
                        data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String textoReconhecido = resultado.get(0);



                if(textoReconhecido.toUpperCase().contains("ABRIR O WORD")
                        ||textoReconhecido.toUpperCase().contains("ABRIR WORD")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.microsoft.office.word");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }

                if(textoReconhecido.toUpperCase().contains("ABRIR EXCEL")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.microsoft.office.excel");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }

                if(textoReconhecido.toUpperCase().contains("ABRIR POWERPOINT")
                        ||textoReconhecido.toUpperCase().contains("ABRIR O POWERPOINT")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.microsoft.office.powerpoint");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR YOUTUBE")
                        ||textoReconhecido.toUpperCase().contains("ABRIR O YOUTUBE")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.google.android.youtube");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR NOTAS")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.samsung.android.app.notes");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR CALENDÁRIO")
                        ||textoReconhecido.toUpperCase().contains("ABRIR O CALENDÁRIO")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.samsung.android.calendar");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR LENS")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.microsoft.office.officelens");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }

                if(textoReconhecido.toUpperCase().contains("ABRIR GOOGLE DOCS")
                        ||textoReconhecido.toUpperCase().contains("ABRIR O GOOGLE DOCS")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.google.android.apps.docs.editors.docs");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }

                if(textoReconhecido.toUpperCase().contains("ABRIR GOOGLE PLANILHA")
                        ||textoReconhecido.toUpperCase().contains("ABRIR O GOOGLE PLANILHAS")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.google.android.apps.docs.editors.sheets");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR GOOGLE SLIDES")
                        ||textoReconhecido.toUpperCase().contains("ABRIR O GOOGLE SLIDES")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.google.android.apps.docs.editors.slides");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR WHATSAPP")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.whatsapp");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }
                if(textoReconhecido.toUpperCase().contains("ABRIR SPOTIFY")){
                    Intent iAbrir = getPackageManager().
                            getLaunchIntentForPackage("com.spotify.music");
                    iAbrir.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(iAbrir);
                }

                }


            }
        }
    }





