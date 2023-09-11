import java.io.*;

public class FileManager {
	// Метод для чтения файла
	public vaid read(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("File not found: " + filePath);
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Метод для записи файла
	public void write(String filePath, String content) throws FileNotFoundException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("File not found:" + filePath);
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Метод для копирования файла
	public void copy(String sourcePath, String destinationPath) throws FileNotFoundException {
		File sourceFile = new File(sourcePath);
		if (!sourceFile.exists()) {
			throw new FileNotFoundException("File not found:" + sourcePath);
		}
		File destinationFile = newFile(destinationPath);
		try (InputStream input = new FileInputStream(sourceFile);
				OutputStream output = new FileOutputStream(destinationFile)) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
