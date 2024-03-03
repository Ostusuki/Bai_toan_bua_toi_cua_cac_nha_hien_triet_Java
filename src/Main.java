import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    private static final int SO_LUONG_NHA_HIEN_TRIET = 5;

    public static void main(String[] args) {
        Nha_Hien_Triet[] nhaHienTriets = new Nha_Hien_Triet[SO_LUONG_NHA_HIEN_TRIET];
        Object[] chopStick = new Object[SO_LUONG_NHA_HIEN_TRIET];
        for (int i = 0; i < SO_LUONG_NHA_HIEN_TRIET; i++) {
            chopStick[i] = new Object();
        }
        ExecutorService executor = Executors.newFixedThreadPool(SO_LUONG_NHA_HIEN_TRIET);

        executor.submit(() -> {
            for (int i = 0; i < SO_LUONG_NHA_HIEN_TRIET; i++) {
                Object leftChopStick = chopStick[i];
                Object rightChopStick = chopStick[(i + 1) % SO_LUONG_NHA_HIEN_TRIET];
                nhaHienTriets[i] = i == SO_LUONG_NHA_HIEN_TRIET - 1
                        ? new Nha_Hien_Triet(rightChopStick, leftChopStick, (i + 1))
                        : new Nha_Hien_Triet(leftChopStick, rightChopStick, (i + 1));
                nhaHienTriets[i].start();
            }
        });
    }
}