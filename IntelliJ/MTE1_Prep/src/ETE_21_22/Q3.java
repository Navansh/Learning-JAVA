package ETE_21_22;

import java.util.concurrent.TimeUnit;

class InvalidInitialTemperatureException extends Exception {
    private int temp;

    InvalidInitialTemperatureException(int temp) {
        this.temp = temp;
    }
    public String toString()
    {
        return "InvalidInitialTemperatureException : "+this.temp;
    }
}
class HighTemperatureException extends Exception
{
    HighTemperatureException() {}
    public String toString()
    {
        return "\n High Temperature Exception: Cooling down\n";
    }
}
class LowTemperatureException extends Exception
{
    LowTemperatureException() {}
    public String toString()
    {
        return "\nLow Temperature Exception : Heating\n";
    }
}
class Thermostat
{
    private int temperature;
    static final int LOWER_LIM = 50;
    static final int UPPER_LIM = 100;

    Thermostat(int initTemp) throws HighTemperatureException,LowTemperatureException {
        //constructor
        if((initTemp>=LOWER_LIM)&&(initTemp<=UPPER_LIM))
        {
            this.temperature=initTemp;
            System.out.println("Thermostat Starting. With Initial Temperature :"+temperature);
        }
        else {
            if (initTemp<LOWER_LIM)
            {
                startThermostat();
            }
            stopThermostat();
        }
    }
    public void startThermostat() throws HighTemperatureException {
        System.out.println("*****************Thermostat Started*************************");
        while(temperature<UPPER_LIM)
        {
            temperature = temperature + 1;
        }
        if (temperature==UPPER_LIM){
            throw new HighTemperatureException();
        }
    }
    public void stopThermostat() throws LowTemperatureException{
        System.out.println("*****************Thermostat Stopping*************************");
        while (temperature>LOWER_LIM){
            temperature = temperature - 1;
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (temperature==LOWER_LIM){
            throw new LowTemperatureException();
        }

    }
}
class ThermostatDriver{
    public static void main(String[] args) throws HighTemperatureException,LowTemperatureException,InvalidInitialTemperatureException{
        Thermostat t=new Thermostat(55);

        while(true){
            try {
                t.startThermostat();
            }catch (HighTemperatureException e)
            {
                System.out.println(e);
            }
            try {
                t.stopThermostat();
            }catch (LowTemperatureException g)
            {
                System.out.println(g);
            }
        }
    }

}