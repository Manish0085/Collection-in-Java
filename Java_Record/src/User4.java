public record User4(String name, int age) implements Runnable{
    @Override
    public void run() {
        // task assigned to thread
    }
}
