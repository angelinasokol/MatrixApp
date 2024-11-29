import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatrixApp extends JFrame {
    private JTextField[][] matrixATextFields;
    private JTextField[][] matrixBTextFields;
    private JTextField[][] matrixCTextFields;
    private JButton calculateButton;

    public MatrixApp() {
        setTitle("Matrix Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        int n = Integer.parseInt(JOptionPane.showInputDialog("Введите количество строк (N):"));
        int m = Integer.parseInt(JOptionPane.showInputDialog("Введите количество столбцов (M):"));

        matrixATextFields = new JTextField[n][m];
        matrixBTextFields = new JTextField[n][m];
        matrixCTextFields = new JTextField[n][m];

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Матрица A:"), c);

        c.gridx = m + 1;
        c.gridy = 0;
        add(new JLabel("Матрица B:"), c);

        c.gridx = 2 * m + 2;
        c.gridy = 0;
        add(new JLabel("Матрица C:"), c);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c.gridx = j;
                c.gridy = i + 1;

                matrixATextFields[i][j] = new JTextField(5);
                add(matrixATextFields[i][j], c);

                c.gridx = j + m + 1;

                matrixBTextFields[i][j] = new JTextField(5);
                add(matrixBTextFields[i][j], c);

                c.gridx = j + 2 * m + 2;

                matrixCTextFields[i][j] = new JTextField(5);
                matrixCTextFields[i][j].setEditable(false);
                add(matrixCTextFields[i][j], c);
            }
        }

        c.gridx = m;
        c.gridy = n + 1;

        calculateButton = new JButton("Рассчитать");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMatrixC();
            }
        });
        add(calculateButton, c);

        pack();
        setVisible(true);
    }

    private void calculateMatrixC() {
        int n = matrixATextFields.length;
        int m = matrixATextFields[0].length;

        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];
        int[][] matrixC = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(matrixATextFields[i][j].getText());
                matrixB[i][j] = Integer.parseInt(matrixBTextFields[i][j].getText());
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                matrixCTextFields[i][j].setText(String.valueOf(matrixC[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MatrixApp();
            }
        });
    }
}

