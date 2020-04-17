package com.example.release;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class pdf2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("Android Broadcast Receivers")
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
    }

