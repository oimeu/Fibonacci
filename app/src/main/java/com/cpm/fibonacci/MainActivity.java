package com.cpm.fibonacci;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

public class MainActivity extends AppCompatActivity {

    private LineChart lineChart;
    private List<String> xValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lineChart = findViewById(R.id.lineChart);

        // Define os metadados do grafico
        Description description = new Description();
        description.setText("Fibonacci");
        description.setPosition(150f,15f);
        lineChart.setDescription(description);
        xValues = Arrays.asList("P0", "Final Position");

        // Define o X
       XAxis xAxis = lineChart.getXAxis();
       xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
       xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
       xAxis.setLabelCount(2);
       xAxis.setGranularity(1f);

       // Define o Y
       YAxis yAxis = lineChart.getAxisLeft();
       yAxis.setAxisMaximum(0f);
       yAxis.setAxisMaximum(100f);
       yAxis.setAxisLineWidth(2f);
       yAxis.setAxisLineColor(Color.BLACK);

       List<Entry> entries1 = new ArrayList<>();
        entries1.add(new Entry(0, 10f));

        LineDataSet dataSet1 = new LineDataSet(entries1, "P0" );
        dataSet1.setColor(Color.BLACK);

        LineData lineData = new LineData(dataSet1);

        lineChart.setData(lineData);
        lineChart.invalidate();
    }
}