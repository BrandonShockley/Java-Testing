public class Animal {
	
	public int height=0;
	public int color=0;
	private int type;
	
	public Animal(int type, int color, int height)
	{
		this.height = height;
		this.color = color;
		this.type = type;
	}
	public Animal(int type)
	{
		this.type = type;
	}
}