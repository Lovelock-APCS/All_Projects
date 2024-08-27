
public class Jewel {
	public static enum JewelType{
		Orange,Red,Green,White,Yellow,Magenta,Blue;
	}
	private JewelType jewelType;
	
	public Jewel(JewelType type) {
		this.jewelType = type;
	}
	// override this so that it works. Should be easy!
	public boolean equals(Object obj) {
		return false;
		
	}
}
