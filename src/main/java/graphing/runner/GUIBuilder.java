package graphing.runner;

import graphing.expression.ExpressionTree;
import graphing.expression.RecursiveParser;
import graphing.plotter.PlotBuilder;
import graphing.plotter.TabulatedFunction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;


public class GUIBuilder {
    private static final String PYTHON_NAME = "plot.py";
    private static final String GRAPH_NAME = "graph.png";
    private static final double DEFAULT_X_MIN = -5;
    private static final double DEFAULT_X_MAX = 5;
    private static final double DEFAULT_Y_MIN = -5;
    private static final double DEFAULT_Y_MAX = 5;
    private static final String X_MIN_LABEL = "x min";
    private static final String X_MAX_LABEL = "x max";
    private static final String Y_MIN_LABEL = "y min";
    private static final String Y_MAX_LABEL = "y max";
    private static final int N_COLUMNS = 10;
    private static final String DEFAULT_FUNCTION = "0";
    private static final String ERROR_TITLE = "Error";

    private final JFrame frame;
    private final JTextField functionTextField;
    private final JTextField xMinTextField;
    private final JTextField xMaxTextField;
    private final JTextField yMinTextField;
    private final JTextField yMaxTextField;

    private JLabel picture;

    public GUIBuilder() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        functionTextField = new JTextField(DEFAULT_FUNCTION);
        functionTextField.addActionListener(new TextFieldListener());

        xMinTextField = new JTextField(String.valueOf(DEFAULT_X_MIN));
        xMaxTextField = new JTextField(String.valueOf(DEFAULT_X_MAX));
        yMinTextField = new JTextField(String.valueOf(DEFAULT_Y_MIN));
        yMaxTextField = new JTextField(String.valueOf(DEFAULT_Y_MAX));

        xMinTextField.addActionListener(new TextFieldListener());
        xMaxTextField.addActionListener(new TextFieldListener());
        yMinTextField.addActionListener(new TextFieldListener());
        yMaxTextField.addActionListener(new TextFieldListener());

        xMinTextField.setColumns(N_COLUMNS);
        xMaxTextField.setColumns(N_COLUMNS);
        yMinTextField.setColumns(N_COLUMNS);
        yMinTextField.setColumns(N_COLUMNS);

        JLabel xMinLabel = new JLabel(X_MIN_LABEL);
        JLabel xMaxLabel = new JLabel(X_MAX_LABEL);
        JLabel yMinLabel = new JLabel(Y_MIN_LABEL);
        JLabel yMaxLabel = new JLabel(Y_MAX_LABEL);

        frame.add(BorderLayout.SOUTH, functionTextField);

        JPanel textFields = new JPanel();
        textFields.setLayout(new BoxLayout(textFields, BoxLayout.Y_AXIS));

        textFields.add(xMinLabel);
        textFields.add(xMinTextField);
        textFields.add(xMaxLabel);
        textFields.add(xMaxTextField);
        textFields.add(yMinLabel);
        textFields.add(yMinTextField);
        textFields.add(yMaxLabel);
        textFields.add(yMaxTextField);

        frame.add(BorderLayout.WEST, textFields);

        frame.setVisible(true);
    }

    private void replot() {
        try {
            ExpressionTree func = RecursiveParser.parse(functionTextField.getText());

            double xMin = Double.parseDouble(xMinTextField.getText());
            double xMax = Double.parseDouble(xMaxTextField.getText());
            double yMin = Double.parseDouble(yMinTextField.getText());
            double yMax = Double.parseDouble(yMaxTextField.getText());

            TabulatedFunction table = new TabulatedFunction(func, xMin, xMax, yMin, yMax);

            FileWriter writer = new FileWriter(PYTHON_NAME);

            PlotBuilder.plot(writer, table, GRAPH_NAME);

            writer.close();

            Runtime.getRuntime().exec("python " + PYTHON_NAME).waitFor();

            FileInputStream file = new FileInputStream(GRAPH_NAME);

            BufferedImage pictureBuffer = ImageIO.read(file);
            JLabel picLabel = new JLabel(new ImageIcon(pictureBuffer));

            file.close();

            if (picture != null) {
                frame.remove(picture);
            }

            picture = picLabel;
            frame.add(BorderLayout.CENTER, picLabel);

            frame.revalidate();
            frame.repaint();
            frame.setVisible(true);
        } catch (Exception ex) {
            errorPopup(ex.getMessage(), ERROR_TITLE);
        }
    }

    public static void errorPopup(String infoMessage, String title) {
        JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE);
    }

    class TextFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            replot();
        }
    }
}

