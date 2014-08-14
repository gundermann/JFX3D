package graphiceditor.gui.controller;

import graphiceditor.PaintingListenerFactory;
import graphiceditor.business.CommonObject3D;
import graphiceditor.business.Painting;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.gui.GUIPaintingArea;
import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.components.GUIComponentsMenu;

import java.util.ArrayList;
import java.util.List;

import preferencemenu.gui.GUIManipulatingMenu;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PaintingAreaController extends DimensionAreaController implements
		PaintingArea {

	private Painting paintingMode = Painting.None;

	final private String name;

	private EventHandler<MouseEvent> mouseMoveHandler;

	private EventHandler<MouseEvent> mouseClickHandler;

	public PaintingAreaController(String name) {
		this.name = name;
	}

	public void setMouseMoveHandler(EventHandler<MouseEvent> listener) {
		getUI().addEventHandler(MouseEvent.MOUSE_MOVED, listener);
		mouseMoveHandler = listener;
	}

	public void setMouseClickHandler(EventHandler<MouseEvent> listener) {
		if (mouseClickHandler != null)
			getUI().removeEventHandler(MouseEvent.MOUSE_CLICKED,
					mouseClickHandler);
		getUI().addEventHandler(MouseEvent.MOUSE_CLICKED, listener);
		mouseClickHandler = listener;
	}

	@Override
	public void finishPainting() {
		paintingMode = Painting.None;
		getUI().resetActualPainting();
		getUI().removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMoveHandler);
		getUI().removeEventHandler(MouseEvent.MOUSE_CLICKED, mouseClickHandler);
		GUIComponentsMenu.getInstance().updateComponents();
	}

	@Override
	public void startPainting() {
//		getUI().toFront();
		setMouseClickHandler(PaintingListenerFactory.getInstance()
				.createPaintingFinishListener(this));
		setMouseMoveHandler(PaintingListenerFactory.getInstance()
				.createPaintingListener(this));
	}

	@Override
	public Painting getPaintingMode() {
		return paintingMode;
	}

	@Override
	public CommonObject3D getActualPainting() {
		return getUI().getActualPainting();
	}

	@Override
	public void setActualPainting(CommonObject3D painting) {
		if(getActualPainting() != null)
			getActualPainting().setSelected(false);
		painting.setSelected(true);
		getUI().setActualPainting(painting);
	}

	@Override
	public void initPainting(Painting painting) {
		paintingMode = painting;
		setMouseClickHandler(PaintingListenerFactory.getInstance()
				.createPaintingStartListener(this));
	}

	@Override
	public GUIPaintingArea getUI() {
		return (GUIPaintingArea) super.getUI();
	}

	@Override
	protected GUIDimensionArea getNewGUIInstance() {
		return new GUIPaintingArea();
	}

	@Override
	public void setActualPaintingById(int selectedIndex) {
		if (getActualPainting() != null)
			getActualPainting().setSelected(false);
		setActualPainting(getUI().getAllGraphicObjects().get(selectedIndex));
		GUIManipulatingMenu.getInstance()
				.setActualPainting(getActualPainting());
	}

	@Override
	public List<String> getAllGraphicObjectsAsString() {
		List<String> graphicObjectStrings = new ArrayList<String>();
		for (CommonObject3D graphicObject : getUI().getAllGraphicObjects()) {
			graphicObjectStrings.add(graphicObject.toString());
		}
		return graphicObjectStrings;
	}

	@Override
	public void addAll(List<CommonObject3D> objects) {
		//FIXME Workaround for lost gos in z direction
		getYRotationProperty().setValue(getYRotationProperty().getValue().doubleValue() + 25);
		for (CommonObject3D object3D : objects) {
			add(object3D);
		}
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public List<CommonObject3D> getAllGraphicObjects() {
		return getUI().getAllGraphicObjects();
	}


	@Override
	public void removeByIndex(List<Integer> list) {
		List<CommonObject3D> objectsToRemove = new ArrayList<CommonObject3D>();
		for(Integer i : list){
			objectsToRemove.add(getAllGraphicObjects().get(i));
		}
		getUI().removeAll(objectsToRemove);
		
	}

}