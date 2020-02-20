
package chcndmediaplayer;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class VisualizerModel implements Visualizer {
    
    private final String name = "Chcnd Visualizer 1";
    private AnchorPane vizPane;
    private Integer numBands;
    private Double halfBandHeight = 0.0;
    private final Double bandHeightPercentage = 1.3;
    private Double width = 0.0;
    private Double height = 0.0;
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    private final Double startHue = 260.0;
    private Rectangle[] rectangles;
    
    public VisualizerModel() {
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        bandWidth = width / numBands;
        bandHeight = height * bandHeightPercentage;
        halfBandHeight = bandHeight / 2;
        
        rectangles = new Rectangle[100];
        
        for (int i = 0; i < numBands; i++) {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(bandWidth / 2 + bandWidth * i);
            rectangle.setY(height / 2);
            rectangle.setWidth(bandWidth/2);
            rectangle.setHeight(5);
            rectangle.setFill(Color.hsb(startHue, 1.0, 1.0, 1.0));
            vizPane.getChildren().add(rectangle);
            rectangles[i] = rectangle;
        }

    }
    @Override
    public void end() {
        if (rectangles != null) {
            for (Rectangle rectangle : rectangles) {
                vizPane.getChildren().remove(rectangle);
             }
            rectangles = null;
        } 
    }
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (rectangles == null) {
            return;
        }
        Integer num2 = min(rectangles.length, magnitudes.length);
        for (int i = 0; i < num2; i++) {
            rectangles[i].setTranslateY((Math.abs(magnitudes[i]) * 5) - 290);
            rectangles[i].setFill(Color.hsb(startHue - (magnitudes[i] * - 6.0), 1.0, 1.0, 1.0));
        }
    }
}
