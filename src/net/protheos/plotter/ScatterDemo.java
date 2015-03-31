package net.protheos.plotter;


import org.jzy3d.chart.Chart;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;


public class ScatterDemo extends AbstractDemo{
	public static void main(String[] args) throws Exception {
		DemoLauncher.openDemo(new ScatterDemo());
	}

	public ScatterDemo(){
	}

	public void init(){
        int size = 500000;
        float x;
        float y;
        float z;
        float a;

        Coord3d[] points = new Coord3d[size];
        Color[]   colors = new Color[size];

        for(int i=0; i<size; i++){
            x = (float)Math.random() - 0.5f;
            y = (float)Math.random() - 0.5f;
            z = (float)Math.random() - 0.5f;
            points[i] = new Coord3d(x, y, z);
            a = 0.25f;
            colors[i] = new Color(x, y, z, a);
        }

        Scatter scatter = new Scatter(points, colors);
        chart = new Chart(Quality.Advanced, getCanvasType());
        chart.getScene().add(scatter);
    }
}
