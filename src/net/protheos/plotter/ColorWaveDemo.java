package net.protheos.plotter;


import java.awt.Color;
import java.awt.Shape;
import java.util.Locale.Builder;

import org.jzy3d.chart.Chart;
import org.jzy3d.chart.controllers.keyboard.camera.CameraKeyController;
//import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
//import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.rendering.canvas.Quality;
//import org.w3c.dom.ranges.Range;

public class ColorWaveDemo extends AbstractDemo {
    public static void main(String[] args) throws Exception {
        DemoLauncher.openDemo(new ColorWaveDemo());
    }

    public ColorWaveDemo() {
    }

    @Override
    public void init() {
        // Define a function to plot
        Mapper mapper = new Mapper() {
            public double f(double x, double y) {
                return x * Math.sin(x * y);
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(-3, 3);
        int steps = 80;

        // Create the object to represent the function over the given range.
        final org.jzy3d.plot3d.primitives.Shape surface = org.jzy3d.plot3d.builder.Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper);
        surface.setColorMapper(new org.jzy3d.colors.ColorMapper(new org.jzy3d.colors.colormaps.ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new org.jzy3d.colors.Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // Create a chart
        chart = new Chart(Quality.Advanced, getCanvasType());
        chart.getScene().getGraph().add(surface);
        chart.addController(new CameraKeyController());
    }
}
