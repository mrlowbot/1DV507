package km222_nb_assign1.xChart;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.LegendPosition;

public class SinMain {
	public static void main(String[] args) {
		// We need something to hold our x & y values. Could go for integers but doubles
		// don't show the sharp edges at closer numbers to 0. So if the lists were
		// integer lists
		// then we could still make it look okay but we would have to "expand" the field
		// a lot more to see everything nicer.
		double[] xList = new double[1000];
		double[] yList = new double[1000];
		xList[0] = 0;
		for (int i = 1; i < xList.length; i++) {
			xList[i] = xList[i - 1] + Math.PI * 2 / xList.length;

		}
		// Cannot get the wave to "stop" at the lenght of 1y's.
		// It keeps growing for each loop by "1y". The field, aka the width and height,
		// won't help if we change the size (meaning to only get 1y's height at all time).
		for (int i = 0; i < yList.length && i < xList.length; i++) {
			yList[i] = (1 + xList[i] / Math.PI) * Math.cos(xList[i]) * Math.cos(30 * xList[i]);
		}
	

		XYChart chart = new XYChartBuilder().width(1200).height(300).build();
		chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
		chart.getStyler().setMarkerSize(2); 
		chart.addSeries("Sin for 0 < x < 2 * PI", xList, yList);	
		new SwingWrapper<>(chart).displayChart();
	}
}