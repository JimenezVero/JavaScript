package mx.edu.utng.javascript.fundamenos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class PieGraph1 {

	public Intent getIntent(Context context) {

		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8 };
		CategorySeries series = new CategorySeries("Aprovechamiento");
		int k = 0;
		for (int value : values) {
			series.add("Contenido " + ++k, value);
		}

		int[] colors = new int[] { Color.CYAN, Color.CYAN, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY, Color.DKGRAY };

		DefaultRenderer renderer = new DefaultRenderer();
		for (int color : colors) {
			SimpleSeriesRenderer r = new SimpleSeriesRenderer();
			r.setColor(color);
			renderer.addSeriesRenderer(r);
		}
		renderer.setChartTitle("Aprovechamiento");
		renderer.setChartTitleTextSize(50);
		renderer.setZoomButtonsVisible(true);

		Intent intent = ChartFactory.getPieChartIntent(context, series, renderer, "Pie");
		return intent;
	}
}
