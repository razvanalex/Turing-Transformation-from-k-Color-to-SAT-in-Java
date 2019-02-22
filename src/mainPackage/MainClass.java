package mainPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import formulas.Formulas;
import graph.UndirectedGraph;

/**
 * MainClass represents the class where the entry point in the program may be
 * found. 
 * 
 * @author razvan
 *
 */
public class MainClass {

	/**
	 * Create a new read stream form an input file.
	 * 
	 * @param inputFile
	 *            the name of the file
	 * @return the reader
	 * @throws FileNotFoundException
	 *             if the file is not found
	 */
	public static BufferedReader initReadStream(String inputFile)
			throws FileNotFoundException {
		FileInputStream fileStream = new FileInputStream(inputFile);
		InputStreamReader streamReader = new InputStreamReader(fileStream);
		BufferedReader fileReader = new BufferedReader(streamReader);

		return fileReader;
	}

	/**
	 * Create a new writer stream in an output file.
	 * 
	 * @param outputFile
	 *            new name of the file
	 * @return the writer
	 * @throws FileNotFoundException
	 *             if the file is not found
	 */
	public static BufferedWriter initWriteStream(String outputFile)
			throws FileNotFoundException {
		FileOutputStream fileOutStream = new FileOutputStream(outputFile);
		OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutStream);
		BufferedWriter fileWriter = new BufferedWriter(streamWriter);

		return fileWriter;
	}

	/**
	 * The entry point of the program. It gets the input from file, creates the
	 * graph, computes the transformation and then it puts the result into
	 * output file.
	 * 
	 * @param args
	 *            the arguments given as parameters to the program, in terminal
	 */
	public static void main(String[] args) {
		String inputFile = "test.in";
		String outputFile = "test.out";

		try {
			BufferedReader fileReader = initReadStream(inputFile);

			String firstLine = fileReader.readLine();
			String[] tokens = firstLine.split(" ");

			int numNodes = Integer.parseInt(tokens[0]);
			int numEdges = Integer.parseInt(tokens[1]);
			int k = Integer.parseInt(tokens[2]);

			UndirectedGraph G = new UndirectedGraph(numNodes);

			for (int i = 0; i < numEdges; i++) {
				String line = fileReader.readLine();
				String[] vertices = line.split(" ");

				G.addEdge(Integer.parseInt(vertices[0]),
						Integer.parseInt(vertices[1]));
			}

			fileReader.close();

			Transformation t = Transformation.getInstance();
			Formulas fi = t.kColorToSAT(G, k);

			BufferedWriter fileWriter = initWriteStream(outputFile);
			fileWriter.write(fi.toString());
			fileWriter.close();

		} catch (IOException e) {
			System.out.println("Error: No such file or directory");
		}
	}

}