import dao.PersonDaoImpl;
import entities.Person;

public class App {
    public static void main(String[] args) {
        PersonDaoImpl pdi = new PersonDaoImpl();
        pdi.createPersonTable();
        Person andrew = new Person("Andrew", "Smith");
        pdi.insert(andrew);


//        Connection connection = null;
//
//        try{
//            connection = ConnectionConfiguration.getConnection();
//            if (connection != null){
//                System.out.println("Connectino established!");
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally{
//            if(connection != null){
//                try{
//                    connection.close();
//                } catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//
//        }
    }
}
