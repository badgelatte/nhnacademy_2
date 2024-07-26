package department;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentManagement{
    private String path = "/Users/nox/IdeaProjects/nhnacademy6week_season2/nhnacademy_2/JavaClassicClass/secondWeekHomework/Student.csv";

    private File file = new File(path);

    private List<List<String>> csvfile;

    private List<Department> departments;

    public DepartmentManagement(){
        departments = new ArrayList<>();
    }

    public void readFile(){
        csvfile = new ArrayList<List<String>>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine())!= null) {
                String[] students = line.split(", ");
                csvfile.add(Arrays.asList(students));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public Department createDepartment(int departmentNo) {
        boolean flag = false;
        Department result = null;
        readFile();
        for(List<String> s :csvfile) {
            int dno = Integer.parseInt(s.get(3));
            if(dno == departmentNo) {
                for (Department d : departments) {
                    if(d.getDepartmentNo() == dno) {
                        d.addStudent(new Student(Integer.parseInt(s.get(0)), s.get(1)));
                        flag = true;
                        result = d;
                    }
                }
                if(flag == false) {
                    result = new Department(dno, s.get(2));
                    result.addStudent(new Student(Integer.parseInt(s.get(0)), s.get(1)));
                    departments.add(result);
                }
            }
        }
        return result;
    }
}