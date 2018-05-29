package cn.sn.collection2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws Exception{
        Employee e=new Employee(0301,"沈宁",3000,"项目部","2007-10");
        Employee e2=new Employee(0302,"余一",3500,"项目部","2007-10");
        Employee e3=new Employee(0303,"黄雷达",3000,"项目部","2007-10");
        /*e.setId(0301);
        e.setName("沈宁");
        e.setDepartment("项目部");
        e.setSalary(3000);
        String strDate="2007-10";
        DateFormat format=new SimpleDateFormat("yyyy-MM");
        e.setHireDate(format.parse(strDate));*/

        List<Employee> list=new ArrayList<Employee>();

        list.add(e);
        list.add(e2);
        list.add(e3);

        printEmpName(list);


    }
    public static void printEmpName(List<Employee> list){
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
    }
}
