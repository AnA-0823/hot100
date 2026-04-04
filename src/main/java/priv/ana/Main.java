package priv.ana;

public class Main {
    static void main() {
        method1();
    }

    public static void method1() {
        for (int i = 0; i < 100000; i++) {
            Bean bean = new Bean("", new Object[]{});
            String s = new String("abc");
        }
    }

    public static class Bean {
        String info;
        Object[] data;

        public Bean(String info, Object[] data) {
            this.info = info;
            this.data = data;
        }
    }
}
