
public static void createArmy() {
    for (int i = 0; i < 5; i++) {
        new Unit("Unit " + (i + 1));
    }

    for (int i = 0; i < 3; i++) {
        new Knight("Knight " + (i + 1));
    }

    new General("Genereal");
    new Doctor("Doctor");
}