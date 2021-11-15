package Clustering;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author Jesus Alberto, Malena Altamiranda
 */
public class ClusteringModel {
    
    public void generateData() {
        try {
                String ruta="MANIZALES_temp_vel.arff";
                Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));

                SimpleKMeans skm=new SimpleKMeans();
                skm.setNumClusters(5);
                skm.setPreserveInstancesOrder(true);
                skm.buildClusterer(dataset);

                Instances centroides=skm.getClusterCentroids();

                System.out.println("---- Modelo de Clustering para la temperatura (X) y velocidad del viento (Y) ----");
                for (int i = 0; i < centroides.numInstances(); i++) {
                    Instance ins=centroides.instance(i);
                    System.out.println("X: "+ins.toString(0) + " Y: "+ins.toString(1));
                }

                int[] asignementsArray=skm.getAssignments();
                int arr1[]=skm.getClusterSizes();
                System.out.println("Asignaciones "+Arrays.toString(asignementsArray));
                System.out.println("Instancias por cluster "+Arrays.toString(arr1));
                System.out.println("---- Modelo de Clustering para la temperatura (X) y velocidad del viento (Y) ----");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public double[] getX() {
        try {
            String ruta="MANIZALES_temp_vel.arff";
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            
            SimpleKMeans skm=new SimpleKMeans();
            skm.setNumClusters(5);
            skm.setPreserveInstancesOrder(true);
            skm.buildClusterer(dataset);
            
            Instances centroides=skm.getClusterCentroids();
            double xValueArray[] = new double [centroides.numInstances()];
            
            for (int i = 0; i < centroides.numInstances(); i++) {
                Instance ins=centroides.instance(i);
                xValueArray[i] = ins.value(0);                
            }

            return xValueArray;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        }   
                
        return null;
    }
    
    public double[] getY() {
        try {
            String ruta="MANIZALES_temp_vel.arff";
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            
            SimpleKMeans skm=new SimpleKMeans();
            skm.setNumClusters(5);
            skm.setPreserveInstancesOrder(true);
            skm.buildClusterer(dataset);
            
            Instances centroides=skm.getClusterCentroids();
            double yValueArray[] = new double [centroides.numInstances()];
            
            for (int i = 0; i < centroides.numInstances(); i++) {
                Instance ins=centroides.instance(i);
                yValueArray[i] = ins.value(1);                 
            }
            
            return yValueArray;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } 
                
        return null;
    }
    
    public double[] getAsignementsArray() {
        try {
            String ruta="MANIZALES_temp_vel.arff";
            Instances dataset=new Instances(new BufferedReader(new FileReader(ruta)));
            
            SimpleKMeans skm=new SimpleKMeans();
            skm.setNumClusters(5);
            skm.setPreserveInstancesOrder(true);
            skm.buildClusterer(dataset);
            
            Instances centroides=skm.getClusterCentroids();            
            int[] asignementsArray = skm.getAssignments();
            
            double[] doubles = Arrays.stream(asignementsArray).asDoubleStream().toArray();
            return doubles;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ClusteringModel.class.getName()).log(Level.SEVERE, null, ex);
        }  
                
        return null;
    }
}
