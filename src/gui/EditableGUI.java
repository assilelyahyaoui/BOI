package gui;

/**
 * Interface to reduce coupling between the GUI and the façade.
 */
public interface EditableGUI {
	
	/**
	 * Method to update the GUI.
	 * @param msg
	 */
	public void updateGUI(Object msg);
}
