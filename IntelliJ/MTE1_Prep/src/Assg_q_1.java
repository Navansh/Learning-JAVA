class Mytimer
{
    int hours;
    int minutes;
    int seconds;
    static int nTimes = 0;

    Mytimer()
    {
        hours = minutes = seconds = 0;
        nTimes++;
    }
    Mytimer(int hours)
    {
        this.hours = hours;
        minutes = seconds = 0;
        nTimes++;
    }
    Mytimer(int hours, int minutes)
    {
        this.hours = hours;
        this.minutes = minutes;
        seconds = 0;
        nTimes++;
    }
    Mytimer(int hours, int minutes, int seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        nTimes++;
    }

}
