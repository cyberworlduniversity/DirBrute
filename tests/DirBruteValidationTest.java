import com.dirbrute.DirBrute;

public class DirBruteValidationTest {
    private static void expectInvalid(Runnable action, String description) {
        try {
            action.run();
            throw new AssertionError("Expected invalid configuration: " + description);
        } catch (IllegalArgumentException expected) {
            // Expected validation failure.
        }
    }

    public static void main(String[] args) {
        new DirBrute("example.com", "words.txt", 1, 1);
        new DirBrute("https://example.com/path", "words.txt", 200, 60000);

        expectInvalid(() -> new DirBrute("", "words.txt", 10, 1000), "empty target");
        expectInvalid(() -> new DirBrute("ftp://example.com", "words.txt", 10, 1000), "unsupported scheme");
        expectInvalid(() -> new DirBrute("https://user:pass@example.com", "words.txt", 10, 1000), "URL credentials");
        expectInvalid(() -> new DirBrute("http://example.com:0", "words.txt", 10, 1000), "invalid port");
        expectInvalid(() -> new DirBrute("example.com", "words.txt", 0, 1000), "zero threads");
        expectInvalid(() -> new DirBrute("example.com", "words.txt", 201, 1000), "excessive threads");
        expectInvalid(() -> new DirBrute("example.com", "words.txt", 10, 0), "zero timeout");
        expectInvalid(() -> new DirBrute("example.com", "words.txt", 10, 60001), "excessive timeout");

        System.out.println("DirBrute validation tests passed.");
    }
}
