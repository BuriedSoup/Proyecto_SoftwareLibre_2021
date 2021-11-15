package graficas; 

import Clustering.ClusteringModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficaDispersion {

    ClusteringModel _ClusteringModel = new ClusteringModel();

    public GraficaDispersion() {
    }
    
    private double x[],y[]; 
    private int asig[]; 
    
    public GraficaDispersion(double x[], double y[], int asig[]){
       this.x=x;
       this.y=y;
       this.asig=asig;
    }
    
    public ChartPanel generarGrafica(){
        XYDataset dataset = crearDataset();
        JFreeChart chart=ChartFactory.createScatterPlot("X vs Y","X", "Y", dataset);
        ChartPanel cp=new ChartPanel(chart);
        return cp; 
    }
    
    public XYDataset crearDataset(){
        _ClusteringModel.generateData();
        
        double xValues[] = _ClusteringModel.getX();      
        double yValues[] = _ClusteringModel.getY();
        double asigValues[] = _ClusteringModel.getAsignementsArray();      
        
        XYSeriesCollection dataset=new XYSeriesCollection();
        XYSeries c1=new XYSeries("C1");
        XYSeries c2=new XYSeries("C2");
               
        for (int i = 0; i < xValues.length; i++) {
            
            if(asigValues[i]==0){
                c1.add(xValues[i],yValues[i]);
            }
            else{
                c2.add(xValues[i],yValues[i]);
            }
        }
        dataset.addSeries(c1);
        dataset.addSeries(c2);
        
        return dataset; 
    }
    
}
