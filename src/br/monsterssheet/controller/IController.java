package br.monsterssheet.controller;

import java.awt.Component;

import javax.swing.JPanel;

public interface IController {
    public boolean execute(Object view);
    public static Component findComponentByName(String name, JPanel contentPane) {
		for(Component comp : contentPane.getComponents()) {
			if(name.equals(comp.getName())) {
				return comp;
			}
		}
		return null;
	}
}
