import java.io.Serializable;
import java.util.Arrays;

public class Block implements Serializable {

	private final String extention;
	private final byte[] blockData;
	private final int previousHash;
	private final int blockHash;

	public Block next = null;
	public Block previous = null;

	public Block(String extention, byte[] blockData, int previousHash) {
		this.extention = extention;
		this.blockData = blockData;
		this.previousHash = previousHash;

		Object[] contents = { Arrays.hashCode(blockData), previousHash };
		this.blockHash = Arrays.hashCode(contents);
	}

	public void display() {
		System.out.printf("File Extention: %s\n", this.extention);
		System.out.printf("Previous Hash: %d\n", this.previousHash);
		System.out.printf("Block Hash: %d\n", this.blockHash);
		System.out.printf("Block address: %s\n", this.toString());
		System.out.printf("Next Block: %s\n", this.next);
		System.out.printf("Previous Block: %s\n\n", this.previous);
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public int getBlockHash() {
		return blockHash;
	}

	public byte[] getBlockData() {
		return blockData;
	}

	public String getExtention() {
		return extention;
	}
}
