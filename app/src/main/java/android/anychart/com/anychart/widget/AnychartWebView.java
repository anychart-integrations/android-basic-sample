package android.anychart.com.anychart.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.anychart.com.anychart.model.Chart;
import android.anychart.com.anychart.utils.Utils;
import android.content.Context;
import android.os.Build;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/**
 * (c) Anychart 2010–2017. All rights reserved.
 */
public class AnychartWebView extends WebView {

    public AnychartWebView(Context context) {
        super(context);
        init();
    }

    public AnychartWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AnychartWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AnychartWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AnychartWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        setWebChromeClient(new WebChromeClient());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setLoadsImagesAutomatically(true);
    }

    //js configuration, can be moved into the external builder
    public void setChart(Chart chart) {

        StringBuilder sb = new StringBuilder();

        Collection<Pair<String, Number>> data = chart.getData();

        StringBuilder jsData = new StringBuilder();

        Iterator<Pair<String, Number>> iterator = data.iterator();
        jsData.append("[");
        while (iterator.hasNext()) {
            Pair<String, Number> pair = iterator.next();
            jsData.append(String.format(Locale.US, "['%s', %d]", pair.first, pair.second));

            if (iterator.hasNext()) {
                jsData.append(",\n");
            }
        }
        jsData.append("]\n");

        //create chart
        sb.append(String.format(Locale.US, "chart = anychart.%s(%s);\n", chart.getChartType().chertType, jsData.toString()));

        //adding the title
        if (!TextUtils.isEmpty(chart.getTitle())) {
            sb.append(String.format(Locale.US, "chart.title('%s');\n", chart.getTitle()));
        }

        //legend
        if (chart.getLegend() != null) {
            sb.append("chart.legend(true);\n");
            sb.append(String.format(Locale.US, "chart.legend().title('%s');\n", chart.getLegend().getTitle()));
            sb.append(String.format(Locale.US, "chart.legend().position('%s');\n", chart.getLegend().getPosition().positionName));
        }

        //read html
        String html = null;
        try {
            html = Utils.readHtmlFile(getContext()).replaceFirst("___chart___", sb.toString());
        } catch (Exception e) {
            //add logs or crash at this line
            e.printStackTrace();
        }

        loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }
}