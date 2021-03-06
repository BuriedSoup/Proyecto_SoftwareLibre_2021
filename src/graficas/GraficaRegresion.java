package graficas; 

import Regresion.PredictData;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaRegresion {
    
    private double x[], y[], coef[];
    PredictData _PredictData = new PredictData();    
    
    public GraficaRegresion(double x[], double y[], double coef[]){
        this.x=x; 
        this.y=y; 
        this.coef=coef; 
    }

    public GraficaRegresion() {        
    }
    
    public ChartPanel generarGrafica(){
        XYDataset dataset = crearDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(
            "X vs Y",
            "X",
            "Y",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            false,
            false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);
        ChartPanel cp=new ChartPanel(chart);
        return cp; 
    }
    
    public XYDataset crearDataset(){
        _PredictData.getPredictedData();

        double x[] = _PredictData.getX();
        double y[] = _PredictData.getY();
        double coef[] = _PredictData.getCoef();

        XYSeries series1 = new XYSeries("Series 1");
        XYSeries series2 = new XYSeries("Series 2");
        
        for (int i = 0; i <x.length; i++) {
            series1.add(x[i], y[i]);
            double y_mod=x[i]*coef[0]+coef[2];
            series2.add(x[i], y_mod);
            
        }
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
}
