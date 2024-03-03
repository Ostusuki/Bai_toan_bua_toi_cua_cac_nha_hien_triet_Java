import java.lang.String;
public class Nha_Hien_Triet extends Thread{
    private final Object left;
    private final Object right;

    Nha_Hien_Triet(Object left, Object right, int number) {
        this.left = left;
        this.right = right;
        this.setName("Nhà hiền triết " + number);
    }

    @Override
    public void run() {
        try {
            while (true) {
                act(" đang suy nghĩ");
                synchronized (left) {
                    act(" lấy chiếc đũa bên trái");
                    synchronized (right) {
                        act(" lấy chiếc đũa bên phải và ăn");
                    }
                    act(" đặt cả 2 chiếc đũa xuống, dừng ăn và bắt đầu suy nghĩ");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private void act (String message) throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + message);
        Thread.sleep(((int) (Math.random() * 200)));
    }
}
