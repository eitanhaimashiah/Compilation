package ast;

/**
 * An AST node for this expression AST node.
 */
public class ThisExpr extends Expr {
	/**
	 * Constructs a this expression node.
	 * 
	 * @param line  Line number of this expression.
	 */
	public ThisExpr(int line) {
		super(line);
	}

	@Override
	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public <DownType, UpType> UpType accept(
			PropagatingVisitor<DownType, UpType> visitor, DownType context) throws Exception {
		return visitor.visit(this, context);
	}
}
