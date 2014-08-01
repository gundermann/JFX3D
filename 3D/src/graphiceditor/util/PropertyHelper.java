package graphiceditor.util;

import graphiceditor.business.CommonObject3D;
import graphiceditor.domainspecific.Property;
import graphiceditor.domainspecific.PropertyChange;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.DoubleProperty;

public class PropertyHelper {

	private static PropertyHelper _instance;

	public static PropertyHelper getInstance() {
		if (_instance == null) {
			_instance = new PropertyHelper();
		}
		return _instance;
	}

	public List<String> getPropertyNames(Object actualPainting) {
		List<String> propertyNames = new ArrayList<String>();
		Method[] annotations = actualPainting.getClass().getMethods();
		for (Method method : annotations) {
			Property annotation = method.getAnnotation(Property.class);
			if (annotation != null) {
				if (annotation.hasChildren()) {
					propertyNames.addAll(extractChildren(annotation, method,
							actualPainting));
				} else {
					propertyNames.add(annotation.name().toUpperCase());
				}
			}
		}
		return propertyNames;
	}
	
	private List<String> extractChildren(Property annotation, Method method,
			Object object) {
		List<String> names = new ArrayList<String>();
		try {
			Class<? extends Object> parentPropertyClass = method.invoke(object,
					null).getClass();
			names = getPropertyNames(parentPropertyClass.newInstance());
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
		return names;
	}

	public DoubleProperty getProperty(String name, Object actualPainting) {
		Method[] methods = actualPainting.getClass().getMethods();
		for (Method method : methods) {
			Property annotation = method.getAnnotation(Property.class);
			if (annotation != null) {
				if (annotation.name().equals(name.toLowerCase())) {
					try {
						return ((DoubleProperty) method.invoke(actualPainting,
								null));
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				else if (annotation.hasChildren()) {
					try {
						DoubleProperty property = getProperty(name, method.invoke(actualPainting, null));
						if (property != null) {
							return property;
						}
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	public void invokeChangingMethod(String name, double newValue, CommonObject3D actualPainting) {
		Method[] methods = actualPainting.getClass().getMethods();
		for (Method method : methods) {
			PropertyChange annotation = method.getAnnotation(PropertyChange.class);
			if(annotation != null && annotation.name().equals(name.toLowerCase())){
				try {
					method.invoke(actualPainting, newValue);
					return;
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
