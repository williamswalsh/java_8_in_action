package ie.williamswalsh.work_testing;

import java.util.Arrays;
import java.util.List;

public class WorkTesting {

    public static void main(String[] args) {
        Colour myFavorite = Colour.RED;

        List<Colour> currentColours = Arrays.asList(Colour.BLUE, null);
        System.out.println(currentColours.contains(myFavorite));

        Role aRole = Role.Administrator;
        Role anotherRole = Role.Administrator;

        List<Role> specialRoles = Arrays.asList(aRole, Role.ExternalUser);
        System.out.println(specialRoles.contains(anotherRole));

    }
}

enum Colour{ RED, GREEN, BLUE}

enum Role{
    DocumentHolder,
    RelyingParty,
    RelyingPartyAdmin,
    Administrator,
    ExternalUser;

    public String getName() {
        return name();
    }
}
