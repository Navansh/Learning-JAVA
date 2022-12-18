package ETE_2_21_22;

import java.util.Comparator;

class Emlpotee {
    Comparator<Employee> cE1 = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }
    };
//    Comparator<Employee> cE2 = new Comparator<Employee>() {
//        @Override
////        public int compare(Employee e1, Employee e2) {
////            return e1.getCity().compareTo(e2.getCity());
////        }
//    };

}