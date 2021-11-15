package Regresion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author Jesus Alberto
 */
public class PredictData {
    
    public void getPredictedData() {
        try {
            String ruta="MANIZALES_temp_hum.arff"; 
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            
            //EL TARGET ES EL 1, QUE ES LA HUMEDAD
            dataset.setClassIndex(1);
            
            System.out.println("---- Regresión lineal que relaciona la temp con la humedad para manizales ----");
            LinearRegression lr=new LinearRegression();
            lr.buildClassifier(dataset);
            System.out.println(lr);
            System.out.println(Arrays.toString(lr.coefficients()));
            
            Evaluation ev=new Evaluation(dataset);
            ev.crossValidateModel(lr, dataset, 10, new Random(5), new String[]{});
            System.out.println(ev.toSummaryString());
            System.out.println("---- Regresión lineal que relaciona la temp con la humedad para manizales ----");
            
            //Predicción
            Instance ins=new Instance(2);
            ins.setDataset(dataset);
            ins.setValue(0, 200);
            System.out.println("Predicción de la humedad a partir de la temperatura: "+lr.classifyInstance(ins));                 
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error #1 in PredictDataClass - Method: PredicData " + ex);
        } catch (IOException ex) {
            System.out.println("Error #2 in PredictDataClass - Method: PredicData " + ex);
        } catch (Exception ex) {
            System.out.println("Error #3 in PredictDataClass - Method: PredicData " + ex);
        }
    }
    
    public double[] getX(){
        
        try {
            String ruta="MANIZALES_temp_hum.arff"; 
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            //EL TARGET ES EL 1, QUE ES LA HUMEDAD
            dataset.setClassIndex(1);
            double xValues[] = new double [dataset.numInstances()];
            for (int i = 0; i < dataset.numInstances(); i++) {
                Instance ins = dataset.instance(i);
                xValues[i] = ins.value(0);
                //System.out.println("    x" + xValues[i]);
            }
            return xValues;
        } catch (FileNotFoundException ex) {
            System.out.println("Error #1 in PredictDataClass - Method: PredicData " + ex);
        } catch (IOException ex) {
            System.out.println("Error #2 in PredictDataClass - Method: PredicData " + ex);
        } catch (Exception ex) {
            System.out.println("Error #3 in PredictDataClass - Method: PredicData " + ex);
        }
                
        return null;
    }
    
    public double[] getY(){
        try {
            String ruta="MANIZALES_temp_hum.arff"; 
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            //EL TARGET ES EL 1, QUE ES LA HUMEDAD
            dataset.setClassIndex(1);
            double yValues[] = new double [dataset.numInstances()];
            for (int i = 0; i < dataset.numInstances(); i++) {
                Instance ins = dataset.instance(i);
                yValues[i] = ins.value(1);
                //System.out.println("    y" + yValues[i]);
            }
            return yValues;
        } catch (FileNotFoundException ex) {
            System.out.println("Error #1 in PredictDataClass - Method: PredicData " + ex);
        } catch (IOException ex) {
            System.out.println("Error #2 in PredictDataClass - Method: PredicData " + ex);
        } catch (Exception ex) {
            System.out.println("Error #3 in PredictDataClass - Method: PredicData " + ex);
        }
        return null;
    }
    
    public double[] getCoef(){
        try {
            String ruta="MANIZALES_temp_hum.arff"; 
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            
            //EL TARGET ES EL 1, QUE ES LA HUMEDAD
            dataset.setClassIndex(1);
            
            LinearRegression lr=new LinearRegression();
            lr.buildClassifier(dataset);
            
            //System.out.println("coeeeeeeeeeeeef"+Arrays.toString(lr.coefficients()));
            return lr.coefficients();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error #1 in PredictDataClass - Method: PredicData " + ex);
        } catch (IOException ex) {
            System.out.println("Error #2 in PredictDataClass - Method: PredicData " + ex);
        } catch (Exception ex) {
            System.out.println("Error #3 in PredictDataClass - Method: PredicData " + ex);
        }
                
        return null;
    }
}
