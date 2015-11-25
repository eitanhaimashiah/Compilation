package ast;

/**
 * An AST node for an array creation.
 */
public class NewArrayExpr extends NewExpr {
	private Type type;
	private Expr size;

	/**
	 * Constructs a new array creation expression node.
	 * 
	 * @param type  Data type of new array.
	 * @param size  Size of new array.
	 */
	public NewArrayExpr(Type type, Expr size) {
		super(type.getLine());
		this.type = type;
		this.size = size;
	}

	public Type getType() {
		return type;
	}

	public Expr getSize() {
		return size;
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
