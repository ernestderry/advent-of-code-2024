/*
 * This source file was generated by the Gradle 'init' task
 */
package advent.of.code;

public class App {

    public static void main(String[] args) throws Exception {
        solve(new Day1a());
        solve(new Day1b());
        solve(new Day2a());
    }

    public static void solve(Solution solution) throws Exception {
        System.out.println(solution.getTitle() + " : " + solution.solve());
    }
}
