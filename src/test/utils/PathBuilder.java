public class PathBuilder {
    private static final String FACULTY_PAGE_ADDRESS = "https://www.math.uni.lodz.pl/";

    public static String createPath(String subPage) {
        return FACULTY_PAGE_ADDRESS + subPage;
    }
}
