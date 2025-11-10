package CompositeDesignPatternLLD.FileSystemComposite;

public class Main {
    public static void main(String[] args) {
        Directory movieDirecotry = new Directory("Movies");
        File m1 = new File("Welcome");
        movieDirecotry.add(m1);
        Directory actionMovieDirectory = new Directory("Action Movies");
        movieDirecotry.add(actionMovieDirectory);
        File m2 = new File("Sholay");
        File m3 = new File("Coolie");
        actionMovieDirectory.add(m2);
        actionMovieDirectory.add(m3);

        movieDirecotry.ls();
    }
}
