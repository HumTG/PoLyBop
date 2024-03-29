import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoadingFrame extends JFrame {
    private JLabel loadingLabel;
    private JProgressBar progressBar;

    public LoadingFrame() {
        super("Loading Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Hiển thị frame ở giữa màn hình

        // Tạo label hiển thị "Loading..."
        loadingLabel = new JLabel("Loading...");
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);

        // Tạo progress bar
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true); // Đặt progress bar thành kiểu không xác định

        // Thêm label và progress bar vào frame
        setLayout(new BorderLayout());
        add(loadingLabel, BorderLayout.NORTH);
        add(progressBar, BorderLayout.CENTER);

        // Simulate data loading
        simulateDataLoading();

        setVisible(true);
    }

    private void simulateDataLoading() {
        // Simulate data loading process (e.g., loading from a database or a file)
        // Đây là nơi bạn có thể thực hiện các công việc cần thiết để tải dữ liệu

        // Ví dụ: chờ 3 giây để mô phỏng việc tải dữ liệu
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Sau khi dữ liệu được tải, đóng frame hiện tại và hiển thị ứng dụng chính
        dispose();
        // Ví dụ: Mở một frame mới
        JFrame mainFrame = new JFrame("Main Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);
        mainFrame.setLocationRelativeTo(null); // Hiển thị frame ở giữa màn hình
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoadingFrame();
            }
        });
    }
}
