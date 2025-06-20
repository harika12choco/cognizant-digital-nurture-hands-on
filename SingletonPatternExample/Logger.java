class Logger
{
    private static Logger instance;

    private Logger()
    {

    }
    public static Logger getinstance()
    {
        if(instance == null)
        {
            instance = new Logger();
        }
        return instance;
    }
    public void printmessage(String message)
    {
        System.out.println("log:"+message);
    }
}
class Testlog
{
    public static void testinglog()
    {
    Logger l1 =Logger.getinstance();
    Logger l2= Logger.getinstance();

    l1.printmessage("first log");
    l2.printmessage("second log");

    if(l1==l2)
    {
        System.out.println("used same instance for logging");
    }
    else
    {
        System.out.println("didnt use the same instance for logging");
    }
}
}
class Main {
    public static void main(String[] args) {
       Testlog.testinglog(); 
    }
}