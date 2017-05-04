package android.anychart.com.example;

import android.annotation.SuppressLint;
import android.anychart.com.anychart.R;
import android.anychart.com.anychart.model.Chart;
import android.anychart.com.anychart.model.ChartType;
import android.anychart.com.anychart.model.Legend;
import android.anychart.com.anychart.model.Position;
import android.anychart.com.anychart.widget.AnychartWebView;
import android.anychart.com.example.data.DataSource;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * (c) Anychart 2010–2017. All rights reserved.
 */
public class MainActivity extends AppCompatActivity {

    private AnychartWebView chartView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chartView = (AnychartWebView) findViewById(R.id.web_view);

        initChart(ChartType.PIE);
    }

    private void initChart(ChartType chartType) {
        DataSource dataSource = new DataSource(); // your real data source

        Chart chart = new Chart();
        chart.setData(dataSource.getData());
        chart.setChartType(chartType);

        chart.setTitle("My harvest");

        Legend legend = new Legend();
        legend.setTitle("From small garden");
        legend.setPosition(Position.RIGHT_BOTTOM);

        chart.setLegend(legend);

        chartView.setChart(chart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.area:
                initChart(ChartType.AREA);
                return true;
            case R.id.bar:
                initChart(ChartType.BAR);
                return true;
            case R.id.column:
                initChart(ChartType.COLUMN);
                return true;
            case R.id.pie:
                initChart(ChartType.PIE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}