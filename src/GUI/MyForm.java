package GUI;

import Processors.DialogProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyForm extends JFrame{
    private JButton rectButton;
    private JPanel DrawingApp;
    private JPanel drawArea;
    private JButton squareButton;
    private JButton circleButton;
    private JButton colorButton;
    private JButton delButton;
    private final DialogProcessor dialogProcessor = new DialogProcessor();

    public MyForm() {
        setTitle("Paint me like one of your french girls");
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        rectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dialogProcessor.AddRectangle();
                Invalidate();
            }
        });

        squareButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dialogProcessor.AddSquare();
                Invalidate();
            }
        });

        circleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dialogProcessor.AddCircle();
                Invalidate();
            }
        });

        colorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Color color = new Color(255,255,255);
                dialogProcessor.selectedColor = JColorChooser
                        .showDialog(DrawingApp,"Pick a color",color);
            }
        });

        delButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dialogProcessor.Remove();
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

        DrawingApp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == 'r'){
                    dialogProcessor.AddRectangle();
                    Invalidate();
                }
            }
        });
    }
    public void Invalidate(){
        DrawingPanel drawingPanel = (DrawingPanel)drawArea;
        drawingPanel.setShapes(dialogProcessor.getShapesList());
        drawingPanel.repaint(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());

    }

    private void createUIComponents() {
        drawArea = new DrawingPanel();
    }
}
