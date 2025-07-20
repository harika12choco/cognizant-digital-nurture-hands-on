package BuilderPatternExample;

public class Computer 
{
    private String ram;
    private String cpu;
    private String storage;
    
    
    private Computer(Builder builder)
    {
        this.cpu = builder.cpu;
        this.ram =builder. ram;
        this.storage = builder.storage;
    }
      public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
    public static class Builder
    {
        private String ram;
        private String cpu;
        private String storage;
        
        public Builder setCpu(String cpu)
        {
            this.cpu = cpu;
            return this;
        }
        public Builder setRam(String ram)
        {
            this.ram = ram;
            return this;
        }
        public Builder setStorage(String storage)
        {
            this.storage = storage;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
      
        
    }
}
class Test {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                                .setCpu("Intel i9")
                                .setRam("32GB")
                                .setStorage("1TB SSD")
                                .build();
                                
        Computer officePC = new Computer.Builder()
                                .setCpu("Intel i5")
                                .setRam("16GB")
                                .setStorage("512GB SSD")
                                .build();
                                gamingPC.showConfig();
                                officePC.showConfig();
      
    }
}

