package graphiceditor.util;

import graphiceditor.business.CommonObject3D;
import graphiceditor.business.Object3D;

public class Cloner {

	private static Cloner _instance;

	public static Cloner getInstance() {
		if (_instance == null) {
			_instance = new Cloner();
		}
		return _instance;
	}

	public CommonObject3D createCopy(CommonObject3D commonObject3D) {
		return commonObject3D.getFactory().fromOther(commonObject3D);
	}

}
