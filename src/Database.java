import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

public class Database
{
    //make connection
    public void open()
	{
        database = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), fileName);
    }

	//close connection
	public void close()
	{
		database.close();
	}

	//insert degree program to database
    public void addDegreeProgram(BufferedReader reader) throws IOException
    {
        System.out.println("Degree Name:");
        String Name = reader.readLine();
        System.out.println("Department:");
        String dept = reader.readLine();
        System.out.println("Faculty:");
        String faculty = reader.readLine();
        DegreeProgram deg = new DegreeProgram(Name, dept, faculty);
        database.store(deg);
        System.out.println(Name + " inserted");
    }

    // does inserting a degree as part of a student create a related record for degreeProgram?
    // according to docs it makes no difference to DB
    public void addUndergraduate(BufferedReader reader) throws IOException
    {
        DegreeProgram deg = null;
        System.out.println("Add a degree prorgram? (y/n)");
        String inp = reader.readLine();
        if(inp.equals("y")) {
            System.out.println("Degree Name:");
            String Name = reader.readLine();
            System.out.println("Department:");
            String dept = reader.readLine();
            System.out.println("Faculty:");
            String faculty = reader.readLine();
            deg = new DegreeProgram(Name, dept, faculty);
        }

        System.out.println("Student Name:");
        String Sname = reader.readLine();
        System.out.println("Student Surname:");
        String Surname = reader.readLine();
        System.out.println("Student Number:");
        String Sno = reader.readLine();
        System.out.println("Year of Study:");
        String Year = reader.readLine();
        System.out.println("Average Mark:");
        String Mark = reader.readLine();

        Undergraduate stud = new Undergraduate(deg, Sno, Sname, Surname, Integer.parseInt(Year), Double.parseDouble(Mark));
        database.store(stud);
        System.out.println(Sno + "  as Undergrad inserted");
    }
    public void addPostgraduate(BufferedReader reader) throws IOException
    {
        DegreeProgram deg = null;
        System.out.println("Add a degree prorgram? (y/n)");
        String inp = reader.readLine();
        if(inp.equals("y")) {
            System.out.println("Degree Name:");
            String Name = reader.readLine();
            System.out.println("Department:");
            String dept = reader.readLine();
            System.out.println("Faculty:");
            String faculty = reader.readLine();
            deg = new DegreeProgram(Name, dept, faculty);
        }

        System.out.println("Student Name:");
        String Sname = reader.readLine();
        System.out.println("Student Surname:");
        String Surname = reader.readLine();
        System.out.println("Student Number:");
        String Sno = reader.readLine();
        System.out.println("Supervisor Initials:");
        String SupIn = reader.readLine();
        System.out.println("Supervisor Surname:");
        String SupSurn = reader.readLine();
        System.out.println("Research topic:");
        String ResTop = reader.readLine();

        Postgraduate stud = new Postgraduate(deg, Sno, Sname, Surname, SupIn, SupSurn, ResTop);
        database.store(stud);
        System.out.println(Sno + "  as Postgraduate inserted");
    }
    public void listStudents()
    {
        ObjectSet undergrads = database.queryByExample(Undergraduate.class);
        System.out.println("Undergrads:");
        output(undergrads);
        ObjectSet postgrads = database.queryByExample(Postgraduate.class);
        System.out.println("Postgrads:");
        output(postgrads);
    }
    public void output(List set)
    {
	    System.out.println(set.size());
	    for(Object o: set) {
	        System.out.println(o.toString());
        }
    }
    public void findPostgraduate(BufferedReader reader) throws IOException
    {
        System.out.println("Student Name:");
        String Sname = reader.readLine();
        Postgraduate post = new Postgraduate(null, Sname, null,
                null, null, null, null);
        ObjectSet result = database.queryByExample(post);
        output(result);
    }
    public void findUndergraduate(BufferedReader reader) throws IOException
    {
        System.out.println("Student Name:");
        String Sname = reader.readLine();
        Query query = database.query();
        query.descend("name").constrain(Sname);
        ObjectSet result = query.execute();
        output(result);
    }
    public void updateStudent(BufferedReader reader) throws IOException
    {
        System.out.println("Student Name:");
        String Sname = reader.readLine();
        Query query = database.query();
        query.descend("name").constrain(Sname);
        ObjectSet result = query.execute();
        if(result.size()!=1) {
            System.out.println("No students found");
            return;
        }
        System.out.println("Update information:");
        Object obj = ((List) result).get(0);
        if(obj.getClass() == Undergraduate.class) {
            System.out.println("Year of Study:");
            String Year = reader.readLine();
            System.out.println("Average Mark:");
            String Mark = reader.readLine();
            ((Undergraduate) obj).setAverageMark(Double.parseDouble(Mark));
            ((Undergraduate) obj).setYearOfStudy(Integer.parseInt(Year));
        }
        else if(obj.getClass() == Postgraduate.class) {
            System.out.println("Supervisor Initials:");
            String SupIn = reader.readLine();
            System.out.println("Supervisor Surname:");
            String SupSurn = reader.readLine();
            System.out.println("Research topic:");
            String ResTop = reader.readLine();
            ((Postgraduate) obj).setResearchTopic(ResTop);
            ((Postgraduate) obj).setSupervisorInitials(SupIn);
            ((Postgraduate) obj).setSupervisorSurname(SupSurn);
        }
        else {
            System.out.println("Class not recognized");
            return;
        }
        database.store(obj);
        System.out.println("Student Updated\n");
        listStudents();
    }
	private ObjectContainer database;
	private final String fileName = "database.db4o";
}