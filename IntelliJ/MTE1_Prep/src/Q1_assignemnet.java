
    class Mytime
    {
        int hours;
        int minutes;
        int seconds;
        static int nTimes = 0;

        Mytime()
        {
            hours = minutes = seconds = 0;
            nTimes++;
        }

        Mytime(int hours)
        {
            this.hours = hours;
            this.minutes = this.seconds = 0;
            nTimes++;
        }

        Mytime(int hours, int minutes)
        {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = 0;
            nTimes++;
        }

        Mytime(int hours, int minutes, int seconds)
        {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            nTimes++;
        }

        public int CompareTo(Mytime other)
        {
            if (this.hours > other.hours)
            {
                return 1;
            }
            else if (this.hours < other.hours)
            {
                return -1;
            }
            else
            {
                if (this.minutes > other.minutes)
                {
                    return 1;
                }
                if (this.minutes < other.minutes) {
                    return -1;
                } else {
                    return Integer.compare(this.seconds, other.seconds);

                }
            }

        }

        public static int CompareTo(Mytime other, Mytime other2)
        {
            if(other.hours > other2.hours)
            {
                return 1;
            }

            else if(other.hours < other2.hours)
            {
                return -1;
            }

            else
            {
                if(other.minutes > other2.minutes)
                {
                    return 1;

                }
                else if(other.minutes<other2.minutes)
                {
                    return -1;
                }
                else
                {
                    if(other.seconds > other2.seconds)
                    {
                        return 1;

                    }
                    else if(other.seconds<other2.seconds)
                    {
                        return -1;
                    }

                    return 0;


                }

            }
        }



        public void displayTime()
        {

            if(this.hours<=11)
            {
                System.out.println("Time is " + (this.hours) + ":" + (this.minutes)  + ":"+ (this.seconds) +" AM" );
            }
            else
                System.out.println("Time is " + (this.hours) + ":" + (this.minutes)  + ":"+ (this.seconds) +" PM" );
        }
        // accessor method
        public int getValuesHours()
        {
            return this.hours;
        }
        public int getValuesMinutes()
        {
            return this.minutes;
        }
        public int getValuesSeconds()
        {
            return this.seconds;
        }


    }
    class Driver
    {
        public static void main(String[] args)
        {
            Mytime t1 = new Mytime(1,32,44);
            Mytime t2 = new Mytime(12,33,44);
            Mytime t3 = new Mytime(3);
            System.out.println(Mytime.CompareTo(t1,t2));
            System.out.println(t3.minutes);
            t2.displayTime();
            int x = Mytime.nTimes;

        }
    }


