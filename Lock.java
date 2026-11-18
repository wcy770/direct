class Lock {
    static final Object A = new Object(), B = new Object(), C = new Object();
    public static void main(String[] s) {
        new Thread(()->{synchronized(A){System.out.println("拿到A");synchronized(B){}}}).start();
        new Thread(()->{synchronized(B){System.out.println("拿到B");synchronized(C){}}}).start();
        new Thread(()->{synchronized(C){System.out.println("拿到C");synchronized(A){}}}).start();
    }
}