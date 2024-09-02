import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommissionCalculator {

    public static void main(String[] args) {
        // สร้างหน้าต่าง UI
        JFrame frame = new JFrame("Commission Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // สร้าง Label และ Input Fields
        JLabel lockLabel = new JLabel("Enter the number of locks:");
        JTextField lockInput = new JTextField(10);
        JLabel stockLabel = new JLabel("Enter the number of stocks:");
        JTextField stockInput = new JTextField(10);
        JLabel barrelLabel = new JLabel("Enter the number of barrels:");
        JTextField barrelInput = new JTextField(10);

        // สร้างปุ่มสำหรับการคำนวณ
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("");

        // การทำงานเมื่อกดปุ่ม Calculate
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int locks = Integer.parseInt(lockInput.getText());
                int stocks = Integer.parseInt(stockInput.getText());
                int barrels = Integer.parseInt(barrelInput.getText());

                double lockPrice = 45.0;
                double stockPrice = 30.0;
                double barrelPrice = 25.0;

                double lockSales = lockPrice * locks;
                double stockSales = stockPrice * stocks;
                double barrelSales = barrelPrice * barrels;
                double sales = lockSales + stockSales + barrelSales;
                double commission;

                if (sales > 1800.0) {
                    commission = 0.10 * 1000.0;
                    commission += 0.15 * 800.0;
                    commission += 0.20 * (sales - 1800.0);
                } else if (sales > 1000.0) {
                    commission = 0.10 * 1000.0;
                    commission += 0.15 * (sales - 1000.0);
                } else {
                    commission = 0.10 * sales;
                }

                resultLabel.setText("<html>Total sales: $" + String.format("%.2f", sales) +
                        "<br/>Commission: $" + String.format("%.2f", commission) + "</html>");
            }
        });

        // สร้าง Panel และเพิ่มองค์ประกอบต่างๆ ลงไป
        JPanel panel = new JPanel();
        panel.add(lockLabel);
        panel.add(lockInput);
        panel.add(stockLabel);
        panel.add(stockInput);
        panel.add(barrelLabel);
        panel.add(barrelInput);
        panel.add(calculateButton);
        panel.add(resultLabel);

        // เพิ่ม Panel ลงใน Frame และแสดงหน้าต่าง UI
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
