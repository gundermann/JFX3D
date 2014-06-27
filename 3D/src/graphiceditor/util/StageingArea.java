package graphiceditor.util;

import graphiceditor.shapes.CommonObject3D;

import java.util.ArrayList;
import java.util.List;

public class StageingArea {
	
	public static List<CommonObject3D> stagedObjects;
	
	public static StageingArea _instance;
	
	public static StageingArea getInstance(){
		if(_instance == null){
			_instance = new StageingArea();
		}
		return _instance;
	}

	public void copy(List<CommonObject3D> objectList,
			List<Integer> list) {
		stagedObjects = new ArrayList<CommonObject3D>();
		for(int i = 0; i< list.size();i++){
			stagedObjects.add(Cloner.getInstance().createCopy(objectList.get(i)));
		}
	}

	public boolean hasStagedObject() {
		return stagedObjects != null;
	}

	public List<CommonObject3D> paste() {
			return stagedObjects;
	}

}
