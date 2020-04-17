package com.example.release;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.util.Random;

public class Pdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Random random = new Random();
        int k = random.nextInt(6);
        if(k==0){
        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("DataBase")
                .scrollHandle(new DefaultScrollHandle(this))
                .load();}
        else if(k==1){
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("Oriented objected programming")
                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        }
        else if(k==2){
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("Basic Git Commands")
                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        }
        else if(k==3){
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("IELTS Academic wordlist")
                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        }
        else if(k==4){
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("Basic Git Commands")
                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        }
        else if(k==5){
            PDFView pdfView = findViewById(R.id.pdfView);
            pdfView.fromAsset("Basic Git Commands")
                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        }

    }
}
