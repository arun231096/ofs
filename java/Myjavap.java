import java.lang.reflect.*;
import java.lang.annotation.*;

public class Myjavap {

	public static void main(String[] args)throws ClassNotFoundException  {

			Myjavap javap = new Myjavap();
			javap.findJavap(args[0]);
		}	
	private void findJavap(String arg)throws ClassNotFoundException {

		Class classname = Class.forName(arg);
			System.out.println(classname+" {");
			Field[] fields = classname.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(field);
			}
			Constructor[] constructors = classname.getConstructors();
			for(Constructor constructor : constructors) {
				//System.out.println(method);
				int modifiers = constructor.getModifiers();
				System.out.print(""+Modifier.toString(modifiers));
				System.out.print(" "+constructor.getName()+"(");
				Type[] types = constructor.getGenericParameterTypes();
				for (Type type : types) {
					System.out.print(type.getTypeName()+" ");
				}
				System.out.println(")");
			}
			Method[] methods = classname.getDeclaredMethods();
			for(Method method : methods) {
				int modifiers = method.getModifiers();
				System.out.print(""+Modifier.toString(modifiers));
				Type returntype = method.getGenericReturnType();
				System.out.print(" "+returntype.getTypeName());
				System.out.print(" "+method.getName()+"(");
				Type[] types = method.getGenericParameterTypes();
				for (Type type : types) {
					System.out.print(type.getTypeName()+" ");
				}
				System.out.println(")");
			}
			System.out.println("}");
	}
}