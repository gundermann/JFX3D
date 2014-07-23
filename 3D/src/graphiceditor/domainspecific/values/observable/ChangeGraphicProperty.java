package graphiceditor.domainspecific.values.observable;

public class ChangeGraphicProperty {

	private String propertyName;
	
	private Double value;

	public ChangeGraphicProperty(String name, Double value) {
		this.propertyName = name;
		this.value = value;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public Double getValue() {
		return value;
	}

	
}
