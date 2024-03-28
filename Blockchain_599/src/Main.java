import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

public class Main {

	public static Chain blockchain;

	private static byte[] compress(byte[] data) {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				DeflaterOutputStream deflater = new DeflaterOutputStream(out)) {

			deflater.write(data);
			deflater.finish();

			return out.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] decompress(byte[] data) {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				InflaterOutputStream Inflater = new InflaterOutputStream(out)) {

			Inflater.write(data);
			Inflater.finish();

			return out.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void addToBlockchain(String filepath) throws IOException {
		Path path = Paths.get(filepath);
		String fileExtention = "." + path.getFileName().toString().split("\\.")[1];

		byte[] data = compress(Files.readAllBytes(path));

		if (blockchain.isEmpty())
			blockchain.add(new Block(fileExtention, data, 0));
		else
			blockchain.add(new Block(fileExtention, data, blockchain.tail.getBlockHash()));
	}

	public static void main(String[] args) throws IOException {
		blockchain = new Chain();

		addToBlockchain("HelloBlockchain.jpg");
		addToBlockchain("test-png.png");
		addToBlockchain("bmp-test.bmp");

		blockchain.printList();
	}
}
