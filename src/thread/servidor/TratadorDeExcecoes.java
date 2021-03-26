package thread.servidor;

public class TratadorDeExcecoes implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Ocorreu um erro na thread " + t.getName() + " mensagem: " + e.getMessage())
        ;
    }
}
