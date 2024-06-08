public class Main {
    public static void main(String[] args) {
//        pattern2(4);
        patternz(5);
    }

    public static void pattern1(int n) {
        //        1.  *****
//                    *****
//                    *****
//                    *****
//                    *****
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern2(int n) {
//        2.  *
//            **
//            ***
//            ****
//            *****
        for (int row = 0; row < n; row++) {
            //for every row run the column
            for (int i = 0; i <= row; i++) {
                System.out.print("* ");
            }
            //now when one row is printed we need to add a new line
            System.out.println();
        }
    }
    public static void pattern3(int n)
    {
//        3.  *****
//            ****
//            ***
//            **
//            *
        for (int row = 0; row <= n; row++)
        {
            //for every row run the column
            for (int i = 0; i < n-row; i++) {
                System.out.print("*\t");
            }
            //now when one row is printed we need to add a new line
            System.out.println();
        }
    }
    public static void pattern4(int n)
    {
//        1
//        1 2
//        1 2 3
//        1 2 3 4
//        1 2 3 4 5

        for (int row = 0; row <= n; row++)
        {
            //for every row run the column
            for (int i = 1; i <= row; i++) {
                System.out.printf("%d\t",i);
            }
            //now when one row is printed we need to add a new line
            System.out.println();
        }
    }

    public static void pattern5(int n)
    {
//        5.  *
//            **
//            ***
//            ****
//            *****
//            ****
//            ***
//            **
//            *

        for (int row = 0; row <= 2*n; row++ )
        {
            //for every row run the column
            if (row<=n)
            {
                for (int i = 0; i <= row ; i++) {
                    System.out.print("*\t");

                }
            }
            else
            {
                for (int i = 0; i <= (2*n-row) ; i++) {
                    System.out.print("*\t");

                }
            }
            //now when one row is printed we need to add a new line
            System.out.println();
        }

    }
    public static void pattern10(int n)
    {
//         *
//        * *
//       * * *
//      * * * *
//     * * * * *
        for (int i = 0; i < n; i++)
        {
//            int count  = 0;
//            if (count==0)
//            {
//
//                count++;
//            }
            for (int k = 0; k < n-i; k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++)
            {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern9(int n)
    {
//       * * * * *
//        * * * *
//         * * *
//          * *
//           *
        for (int i = 0; i < n; i++)
        {
//            int count  = 0;
//            if (count==0)
//            {
//
//                count++;
//            }
            for (int k = 0; k < i; k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < n-i; j++)
            {

                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern28(int n)
    {
//         *
//        * *
//       * * *
//      * * * *
//     * * * * *
//      * * * *
//       * * *
//        * *
//         *
        for (int i = 0; i <= 2*n; i++)
        {
            int row_space = i<=n ? n - i : i-n;
                for (int k = 0; k < row_space; k++)
                {
                    System.out.print(" ");
                }
//            else
//            {
//                for (int k = 0; k < i-n; k++)
//                {
//                    System.out.print(" ");
//                }
//            }
                //for every row run the column
            int col_print = i<=n ? i : 2*n-i;
                    for (int gh = 0; gh <= col_print ; gh++) {
                        System.out.print("* ");
                    }

//                else
//                {
//                    for (int fj = 0; fj <= (2*n-i) ; fj++) {
//                        System.out.print("* ");
//                    }
//                }
                //now when one row is printed we need to add a new line
                System.out.println();
        }
    }
    public static void patternz(int n)
    {
        //Currently not done
//                   1
//                 1 2 1
//               1 2 3 2 1
        //     1 2 3 4 3 2 1\
        for (int i = 0; i < 2*n-2; i++)
        {
            if (i%2==0)
            {
                for (int k = 0; k < 2*n-i; k++)
                {
                    System.out.print(" ");
                }
                int f =1;
                for (int j = 0; j <= i; j++)
                {
                    if (f<i/2) {
                        System.out.print(f);
                    }
                    f++;
//                    if (f>i/2 && f<i){
//                        System.out.print(f-i);
//                        f++;
//                    }
//                    while(j>i/2 && j<i)
//                    {
//                        System.out.print(j-i);
//                        j++;
//                    }
                }






                System.out.println();
            }
        }
    }
    public static void pattern13(int n)
    {
//         *
//        * *
//       *   *
//      *     *
//     *********
        for (int i = 0; i < n; i++)
        {
/*
            int count  = 0;
            if (count==0)
            {
                count++;
            }
*/
            for (int k = 0; k < n-i; k++)
            {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++)
            {
                System.out.print("* ");
            }

            System.out.println();
        }


    }

//
//    String s1 = "masti";
//    String s2 = "Dance";
//
//    String s3 = s1.concat(s2);










}