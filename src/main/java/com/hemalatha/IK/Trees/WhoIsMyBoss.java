package com.hemalatha.IK.Trees;


import java.util.ArrayList;
import java.util.List;

public class WhoIsMyBoss {
    public static void main(String[] args) {
        Company.Employee ceo = new Company.Employee(1,"Bill");
        Company.Employee dom = new Company.Employee(1,"Dom");
        Company.Employee samir = new Company.Employee(1,"Samir");
        Company.Employee michael = new Company.Employee(1,"Michael");
        Company.Employee bob = new Company.Employee(1,"Bob");
        Company.Employee peter = new Company.Employee(1,"Peter");
        Company.Employee porter = new Company.Employee(1,"Porter");
        Company.Employee milton = new Company.Employee(1,"Milton");
        Company.Employee nina = new Company.Employee(1,"Nina");

        ceo.addReport(dom);
        ceo.addReport(samir);
        ceo.addReport(michael);

        dom.addReport(bob);
        dom.addReport(peter);
        dom.addReport(porter);

        peter.addReport(milton);
        peter.addReport(nina);

        Company.Employee cmanager = Company.closestCommonManager(ceo,milton,nina);
        System.out.println(cmanager.getName()); //Peter

        cmanager = Company.closestCommonManager(ceo,nina,porter);
        System.out.println(cmanager.getName());//Dom

        cmanager = Company.closestCommonManager(ceo,nina,samir);
        System.out.println(cmanager.getName());//Bill

        cmanager = Company.closestCommonManager(ceo,peter,nina);
        System.out.println(cmanager.getName());//peter

        cmanager = Company.closestCommonManager(ceo,peter,michael);
        System.out.println(cmanager.getName());//bill

        cmanager = Company.closestCommonManager(ceo,milton,porter);
        System.out.println(cmanager.getName());//Dom

    }
}


class Company {

    // IMPORTANT: DO NOT MODIFY THIS CLASS
    public static class Employee {

        private final int id;
        private final String name;
        private List<Employee> reports;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Employee> getReports() {
            return reports;
        }

        public void addReport(Employee employee) {
            reports.add(employee);
        }

        @Override
        public boolean equals(Object obj) {
          if(obj==null){
              return false;
          }
          if(this==obj){
              return true;
          }
          if(!(obj instanceof Employee)){
              return false;
          }
          Employee other = (Employee)obj;
          if(this.id==other.id){
              if(this.name.equals(other.name)){
                  return true;
              }
          }
          return false;

        }
    }

    /*
     * Read the attached PDF for more explanation about the problem
     * Note: Don't modify the signature of this function
     * @param ceo
     *
     * @param firstEmployee
     *
     * @param secondEmployee
     *
     * @return common manager for both employees that is closest to them.
     */
    //similar to LCA in non BST,binary tree
    public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
        if(ceo==null){
            return null;
        }

        if(ceo.equals(firstEmployee) || ceo.equals(secondEmployee)){
            return ceo;
        }

        Employee first=null;
        Employee second = null;
        for(int i=0;i<ceo.getReports().size();i++){
            Employee temp = closestCommonManager(ceo.getReports().get(i),firstEmployee,secondEmployee);
            if(temp!=null){
                if(first==null){
                    first = temp;
                }else if(second == null){
                    second = temp;
                }
            }
            if(first!=null && second!=null){
                return ceo;
            }
        }

        return first==null?second:first;
    }
};
