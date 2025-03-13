package br.monsterssheet.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.monsterssheet.model.entity.Monster;

public class MonsterListTable extends AbstractTableModel{

	private static final String[] columns = {"Name", "Hit Points", "Armor Class", "Challenge Rating", "Type", "Alignment"};
	
	private List<Monster> monsters;
	
	public MonsterListTable(List<Monster> monsters) {
		super();
		this.monsters = monsters;
	}

	@Override
	public int getRowCount() {
		return monsters.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Monster monster = monsters.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return monster.getName();
		case 1:
			return monster.getHitPoints();
		case 2:
			return monster.getArmorClass();
		case 3:
			return monster.getChallenge();
		case 4:
			return monster.getType();
		case 5:
			return monster.getAlignment();

		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	
	public void updateData(List<Monster> monsters) {
		this.monsters = monsters;
		fireTableDataChanged();
	}
}
