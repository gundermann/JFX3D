package graphiceditor.gui.controller;

import graphiceditor.PaintingListenerFactory;
import graphiceditor.business.Object3D;
import graphiceditor.business.Painting;
import graphiceditor.gui.GUIDimensionArea;
import graphiceditor.gui.GUIPaintingArea;
import graphiceditor.gui.PaintingArea;
import graphiceditor.menu.painting.GUIPaintingMenu;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class PaintingAreaController extends DimensionAreaController implements
		PaintingArea {

	private Painting paintingMode = Painting.None;

	private EventHandler<MouseEvent> mouseMoveHandler;

	private EventHandler<MouseEvent> mouseClickHandler;

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
		getUI().saveActualPaintingIntoGraphicObjects();
		getUI().removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMoveHandler);
		getUI().removeEventHandler(MouseEvent.MOUSE_CLICKED, mouseClickHandler);
		GUIPaintingMenu.getInstance().updateComponents();
	}

	@Override
	public void startPainting() {
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
	public Object3D getActualPainting() {
		return getUI().getActualPainting();
	}

	@Override
	public void setActualPainting(Object3D painting) {
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
		setActualPainting(getUI().getAllGraphicObjects().get(selectedIndex));
	}

	@Override
	public List<String> getAllGraphicObjects() {
		List<String> graphicObjectStrings = new ArrayList<String>();
		for (Object3D graphicObject : getUI().getAllGraphicObjects()) {
			graphicObjectStrings.add(graphicObject.toString());
		}
		return graphicObjectStrings;
	}

}