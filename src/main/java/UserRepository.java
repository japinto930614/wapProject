import models.Type;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private  List<User>users=new ArrayList<>();

    public UserRepository(){
        users.add(new User("1","User1","password1", Type.Student));
        users.add(new User("2","User2","password2", Type.Student));
        users.add(new User("3","User3","password3", Type.Student));
        users.add(new User("4","User4","password4", Type.Student));
        users.add(new User("5","User5","password5", Type.Student));
        users.add(new User("6","User6","password6", Type.Student));
        users.add(new User("7","User7","password7", Type.Student));
        users.add(new User("8","User8","password8", Type.Student));
        users.add(new User("9","User9","password9", Type.Student));
        users.add(new User("10","User10","password10", Type.Student));

        users.add(new User("11","User11","password11", Type.Staff));
        users.add(new User("12","User12","password12", Type.Staff));
        users.add(new User("13","User13","password13", Type.Staff));
        users.add(new User("14","User14","password14", Type.Staff));
        users.add(new User("15","User15","password15", Type.Staff));
        users.add(new User("16","User16","password16", Type.Staff));
        users.add(new User("17","User17","password17", Type.Staff));
        users.add(new User("18","User18","password18", Type.Staff));
        users.add(new User("19","User19","password19", Type.Staff));
        users.add(new User("20","User20","password20", Type.Staff));

        users.add(new User("21","User21","password21", Type.Faculty));
        users.add(new User("22","User22","password22", Type.Faculty));
        users.add(new User("23","User23","password23", Type.Faculty));
        users.add(new User("24","User24","password24", Type.Faculty));
        users.add(new User("25","User25","password25", Type.Faculty));
        users.add(new User("26","User26","password26", Type.Faculty));
        users.add(new User("27","User27","password27", Type.Faculty));
        users.add(new User("28","User28","password28", Type.Faculty));
        users.add(new User("29","User29","password29", Type.Faculty));
        users.add(new User("30","User30","password30", Type.Faculty));

        users.add(new User("31","Admin","admin", Type.Admin));
    }
    public  List<User> getUsers() {
        return users;
    }
}
