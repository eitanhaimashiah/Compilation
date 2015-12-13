package type_table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ast.Formal;
import ast.ICClass;
import ast.Method;
import ast.PrimitiveType;
import ast.UserType;
import ic.DataType;
import ic.LiteralType;

/**
 * Data structure representing a Type Table
 */
public class TypeTable {

	private String id;
	
	private Map<Type, Integer> values;
	// Maps element types to array types
	private Map<Type,ArrayType> uniqueArrayTypes;
	private Map<String,ClassType> uniqueClassTypes;
	private Map<String,MethodType> uniqueMethodTypes;
	
	private Type intType;
	private Type boolType;
	private Type nullType;
	private Type stringType;
	private Type voidType;
	
	private int idCounter;
	
	/**
	 * main constructor
	 * @param tableId name of table
	 */
	public TypeTable(String tableId) {
		this.id = tableId;
		this.idCounter = 0;
		this.uniqueArrayTypes = new HashMap<Type, ArrayType>();
		this.uniqueClassTypes = new HashMap<String,ClassType>();
		this.uniqueMethodTypes = new HashMap<String,MethodType>();
		
		this.values = new HashMap<Type, Integer>();
	}
	
	/**
	 * converts IC.AST.Type to IC.Types.Type
	 * @param typeNode IC.AST.Type to convert
	 * @return the correct IC.Types.Type format
	 */
	public Type getTypeFromASTTypeNode(ast.Type typeNode) {
		if (typeNode instanceof PrimitiveType) {
			PrimitiveType pt = (PrimitiveType)typeNode;
			Type primitive = getPrimitiveType(typeNode.getName());
			if (pt.getDimension() == 0) 
				return primitive;
			else
				return getArrayFromType(primitive, pt.getDimension());
		}
		else {
			UserType ut = (UserType)typeNode;
			Type clsType = uniqueClassTypes.get(ut.getName());
			if (ut.getDimension() == 0)
				return clsType;
			else 
				return getArrayFromType(clsType, ut.getDimension());
		}
	}
	
	/**
	 * Prints the table to System.out
	 */
	public void printTable() {
		System.out.println("Type Table: " + id);
		System.out.println("    " + values.get(intType) + ": Primitive type: " + intType.toString());
		System.out.println("    " + values.get(boolType) + ": Primitive type: " + boolType.toString());
		System.out.println("    " + values.get(nullType) + ": Primitive type: " + nullType.toString());
		System.out.println("    " + values.get(stringType) + ": Primitive type: " + stringType.toString());
		System.out.println("    " + values.get(voidType) + ": Primitive type: " + voidType.toString());
		
		List<Map.Entry<String,ClassType>> sorted_uniqueClassTypes =
	            new ArrayList<Map.Entry<String,ClassType>>( uniqueClassTypes.entrySet() );
		Collections.sort(sorted_uniqueClassTypes, new Comparator<Map.Entry<String,ClassType>>() {
	           public int compare( Map.Entry<String,ClassType> o1, Map.Entry<String,ClassType> o2 ) {
	                return Integer.compare(values.get(o1.getValue()), values.get(o2.getValue()));
	            }
		});
		for (Map.Entry<String,ClassType> entry : sorted_uniqueClassTypes) {
			System.out.print("    " + values.get(entry.getValue()) + ": Class: " + entry.getValue().toString());
			if (entry.getValue().hasSuperClass())
				System.out.print(", Superclass ID: " + values.get(uniqueClassTypes.get(
						entry.getValue().getSuperClassType().getClassName())));
			System.out.println();
		}
		
		List<Map.Entry<Type,ArrayType>> sorted_uniqueArrayTypes =
	            new ArrayList<Map.Entry<Type,ArrayType>>( uniqueArrayTypes.entrySet() );
		Collections.sort(sorted_uniqueArrayTypes, new Comparator<Map.Entry<Type,ArrayType>>() {
	           public int compare( Map.Entry<Type,ArrayType> o1, Map.Entry<Type,ArrayType> o2 ) {
	                return Integer.compare(values.get(o1.getValue()), values.get(o2.getValue()));
	            }
		});
		
		for (Map.Entry<Type,ArrayType> entry : sorted_uniqueArrayTypes) 
			System.out.println("    " + values.get(entry.getValue()) + ": Array type: " + entry.getValue().toString());
		
		List<Map.Entry<String,MethodType>> sorted_uniqueMethodTypes =
	            new ArrayList<Map.Entry<String,MethodType>>( uniqueMethodTypes.entrySet() );
		Collections.sort(sorted_uniqueMethodTypes, new Comparator<Map.Entry<String,MethodType>>() {
	           public int compare( Map.Entry<String,MethodType> o1, Map.Entry<String,MethodType> o2 ) {
	                return Integer.compare(values.get(o1.getValue()), values.get(o2.getValue()));
	            }
		});
		
		for (Map.Entry<String,MethodType> entry : sorted_uniqueMethodTypes) 
			System.out.println("    " + values.get(entry.getValue()) + ": Method type: {" + entry.getValue().toString() + "}");
	}
	
	/**
	 * Initializes primitive types in the table.
	 */
	public void addPrimitiveTypes() {
		this.intType = new IntType();
		this.boolType = new BoolType();
		this.nullType = new NullType();
		this.stringType = new StringType();
		this.voidType = new VoidType();
		values.put(intType, 1);
		values.put(boolType, 2);
		values.put(nullType, 3);
		values.put(stringType, 4);
		values.put(voidType, 5);
		this.idCounter = 6;
	}
	
	/**
	 * Adds array type to the table
	 * @param typeNode adds all of the array types concluded from this type to table
	 */
	public void addArrayType(ast.Type typeNode) {
		Type currArrType;
		if (typeNode instanceof PrimitiveType) 
			currArrType = getPrimitiveType(typeNode.getName()); 
		else
			currArrType = uniqueClassTypes.get(typeNode.getName());
		
		for (int i = 0; i < typeNode.getDimension(); i++) 
			currArrType = addAndReturnArraySingleType(currArrType);
	}
	
	/**
	 * 
	 * @param classAST
	 * @return false if and only if the class is extending a class which dosen't exist
	 */
	public Boolean addClassType(ICClass classAST) {
		if (uniqueClassTypes.containsKey(classAST.getName()))
			return true;
		ClassType superClassType = null;
		if (classAST.hasSuperClass()) {
			if (!uniqueClassTypes.containsKey(classAST.getSuperClassName()))
				return false;
			superClassType = uniqueClassTypes.get(classAST.getSuperClassName());
		}
		ClassType clst = new ClassType(classAST.getName(), superClassType);

		uniqueClassTypes.put(classAST.getName(), clst);
		values.put(clst, idCounter);
		idCounter++;
		
		return true;
	}
	
	/**
	 * 
	 * @param clsName
	 * @return ClassType with name clsName
	 */
	public ClassType getClassType(String clsName) {
		return uniqueClassTypes.get(clsName);
	}
	
	/**
	 * Adds method type to the table
	 * @param method method to add
	 */
	public void addMethodType(Method method) {
		MethodType methodType = generateMethodType(method);
		if (uniqueMethodTypes.containsKey(methodType.toString()))
			return;
		uniqueMethodTypes.put(methodType.toString(), methodType);
		values.put(methodType, idCounter);
		idCounter++;
	}
	
	/**
	 * Generates a method type for this Method
	 * @param method source method
	 * @return MethodType for this Method
	 */
	public MethodType getMethodType(Method method) {
		MethodType methodType = generateMethodType(method);
		return uniqueMethodTypes.get(methodType.toString());
	}
	
	/**
	 * @param type
	 * @return the method type's return type
	 */
	public Type getReturnTypeFromMethodType(Type type) {
		MethodType methodType = (MethodType)type;
		return methodType.getReturnType();
	}
	
	/**
	 * Returns a primitive type instance matching dataTypeName
	 * @param dataTypeName name of the primitive type requested
	 * @return primitive Type corresponding to dataTypeName, or null if not found
	 */
	public Type getPrimitiveType(String dataTypeName) {
		if (dataTypeName == DataType.INT.getDescription())
			return intType;
		if (dataTypeName == DataType.STRING.getDescription())
			return stringType;
		if (dataTypeName == DataType.VOID.getDescription())
			return voidType;
		if (dataTypeName == DataType.BOOLEAN.getDescription())
			return boolType;
		
		return null;
	}
	
	/**
	 * Returns a literal type instance matching literalTypeName
	 * @param literalTypeName name of the literal type requested
	 * @return literal Type corresponding to literalTypeName, or null if not found
	 */
	public Type getLiteralType(String literalTypeName) {
		if (literalTypeName == LiteralType.INTEGER.getDescription())
			return intType;
		if (literalTypeName == LiteralType.STRING.getDescription())
			return stringType;
		if ((literalTypeName == LiteralType.TRUE.getDescription()) || (literalTypeName == LiteralType.FALSE.getDescription()))
			return boolType;
		if (literalTypeName == LiteralType.NULL.getDescription())
			return nullType;
		
		return null;

	}
	
	/**
	 * 
	 * @param original
	 * @param dimention
	 * @return the type of this array
	 */
	public ArrayType getArrayFromType(Type original, int dimention) {
		Type currArrType = original;
		for (int i = 0; i < dimention; i++) 
			currArrType = uniqueArrayTypes.get(currArrType);
		
		return (ArrayType)currArrType;
	}
	
	/**
	 * 
	 * @param type array type to be evaluated
	 * @return the base type of the array
	 */
	public Type getTypeFromArray(Type type) {
		ArrayType arrayType = (ArrayType)type;
		return arrayType.getElemType();
	}
	
	private ArrayType addAndReturnArraySingleType(Type elemType) {
		if (uniqueArrayTypes.containsKey(elemType))
			return uniqueArrayTypes.get(elemType);
		
		ArrayType arrt = new ArrayType(elemType);
		uniqueArrayTypes.put(elemType, arrt);
		values.put(arrt, idCounter);
		idCounter++;
		return arrt;
	}
	
	private MethodType generateMethodType(Method method) {
		Type[] params = new Type[method.getFormals().size()];
		List<Formal> formals = method.getFormals(); 
		for (int i = 0; i < params.length; i++)
			params[i] = getTypeFromASTTypeNode(formals.get(i).getType());
		MethodType methodType = new MethodType(params, getTypeFromASTTypeNode(method.getType()));
		return methodType;
	}
}
