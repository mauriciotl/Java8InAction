package lambdasinaction.chap3.bookExample;

import java.io.*;
public class ExecuteAround {

	private static final String FILE_PATH = "/Users/mauriciotorres/Documents" +
			"/IntelliJ_2024_projects/Java8InAction/data.txt";

	public static void main(String ...args) throws IOException{

		System.out.println("--- Program starting ...");
		System.out.println("Working dir = " + System.getProperty("user.dir"));

		// Method we want to refactor to make more flexible
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		System.out.println("---");

		String twoLines = processFile((BufferedReader b) -> b.readLine() + "\n" +  b.readLine());
		System.out.println(twoLines);

	}

    public static String processFileLimited() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH)))
		{
            return br.readLine();
        }
    }


	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
			return p.process(br);
		}

	}

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}
}
