package ast;

/**
 * An AST node for a class instance creation.
 */
public class NewClassExpr extends NewExpr {
	private String name;

	/**
	 * Constructs a new class instance creation expression node.
	 * 
	 * @param line  Line number of expression.
	 * @param name  Name of class.
	 */
	public NewClassExpr(int line, String name) {
		super(line);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) {
		return visitor.visit(this, context);
	}
}
