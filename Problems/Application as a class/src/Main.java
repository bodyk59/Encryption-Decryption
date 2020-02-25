
class Application {

    String name;

    public void run(String[] info) {
        System.out.println(this.name);

        for (int i = 0; i < info.length; i++) {
            System.out.println(info[i]);
        }
    }
}