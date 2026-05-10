package lambdasinaction.chap3.mauPractice_executeAround;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExecuteAroundMauVersion {

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

		System.out.println("Mau version: ---");

		String mauLine = processFileMauVersion(FILE_PATH, BufferedReader::readLine);

		System.out.println(mauLine);

		System.out.println("Mau version: ---");

		String mauLine02 = processFileMauVersion(FILE_PATH, new BufferedReaderProcessor() {
			@Override
			public String process(BufferedReader b) throws IOException {

				String line;
				while ((line = b.readLine()) != null){

					System.out.println(line);
				}
				return "Returning from program";
			}
		});

		System.out.println("Mau version 2: ---");

		processFileMauVersion(FILE_PATH, (BufferedReader br) -> {

			Stream<String> lines = br.lines();
			lines.forEach((System.out::println));

			return "Returning from program mauline03";
		});





	}



	// The utility methods

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


	/** Probably later you can create other implementations of this app method, that return
	 * void or an ArrayList, etc.
	 */
	public static String processFileMauVersion(String pathFile, BufferedReaderProcessor p) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(pathFile))){
			return p.process(br);
		}
    }


	// The common interface

	public interface BufferedReaderProcessor{
		public String process(BufferedReader b) throws IOException;

	}



}
