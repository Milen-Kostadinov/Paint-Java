import Processors.DialogProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyForm extends JFrame{
    private JButton rectButtonButton;
    private JPanel DrawingApp;
    private JPanel drawArea;
    private final DialogProcessor dialogProcessor = new DialogProcessor();
    public MyForm() {
        setTitle("Paint me like one of your french girls");
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        rectButtonButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dialogProcessor.AddRandomRect();
                Invalidate();
            }
        });
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(dialogProcessor.Contains(e.getPoint()) != null){
                    dialogProcessor.setSelection(dialogProcessor.Contains(e.getPoint()));
                    dialogProcessor.setLastPoint(e.getPoint());
                    dialogProcessor.setDragging(true);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                dialogProcessor.setDragging(false);
            }
        });
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(dialogProcessor.isDragging()){
                    dialogProcessor.Translate(e.getPoint());
                    Invalidate();
                }
            }
        });
        this.add(DrawingApp);
        this.setVisible(true);
    }
    public void Invalidate(){
        drawArea.paint(drawArea.getGraphics());
        dialogProcessor.DrawShapes(drawArea.getGraphics());
    }
}
